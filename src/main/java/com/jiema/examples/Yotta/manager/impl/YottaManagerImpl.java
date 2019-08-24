package com.jiema.examples.Yotta.manager.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jiema.examples.Yotta.manager.YottaManager;
import com.jiema.yima.manager.YiMaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YottaManagerImpl implements YottaManager {

    @Autowired
    private YiMaManager yiMaManager;
    @Autowired
    private RestTemplate restTemplate;


    public String register(int cycleTimes) {
        String res = "未发送";
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
            String itemid = "38070";
            String token = yiMaManager.login("yu1025894148", "yuqi12345");
            for (int a = 0; a < cycleTimes; ) {

                String mobile = yiMaManager.getmobile(token, itemid);
                System.out.println("手机号:" + mobile);
                //mobile = "17353626232";
                String urlYanzhengma = "https://reg.ytl.yottachain.io/YTL/public/index.php/index/User/sendPhoneCode";
                JSONObject yanzhengma = new JSONObject();
                yanzhengma.put("phone", mobile);
                yanzhengma.put("type", "register");
                JsonNode yanzhengmaRes = post(yanzhengma, urlYanzhengma);
                System.out.println("请求验证码返回:" + yanzhengmaRes);
                String message = null;
                for (int i = 0; i < 24; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(5000); //设置暂停的时间，5000=5秒
                        message = yiMaManager.getsms(token, itemid, mobile, format.format(new Date()));
                        if (!"短信尚未到达".equals(message) && !"获取短信异常".equals(message)) {
                            break;  //直接结束for循环
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("获取到的短信:" + message);
                String regEx = "[^0-9]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(message);
                System.out.println("验证码:" + m.replaceAll("").trim());
                String zhuceUrl = "https://reg.ytl.yottachain.io/YTL/public/index.php/index/User/register";
                JSONObject zhuce = new JSONObject();
                zhuce.put("login_name", "");
                zhuce.put("password", "qwer123456");
                zhuce.put("phone", mobile);
                zhuce.put("code", m.replaceAll("").trim());
                zhuce.put("invite_code", "20502298");
                JsonNode zhuceRes = post(zhuce, zhuceUrl);
                System.out.println("注册返回:" + zhuceRes);
                if ("注册成功".equals(zhuceRes.get("msg"))) {
                    res = mobile + "注册成功";
                    a++;
                } else {
                    res = mobile + "注册失败";
                }
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    private JsonNode post(JSONObject jsonObject, String url) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        System.out.println(jsonObject.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObject.toString(), headers);
        return restTemplate.postForObject(url, formEntity, ObjectNode.class);
    }

}
