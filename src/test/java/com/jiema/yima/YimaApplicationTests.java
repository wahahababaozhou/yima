package com.jiema.yima;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jiema.utils.HttpUtile;
import com.jiema.yima.manager.YiMaManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YimaApplicationTests {

    @Autowired
    private YiMaManager yiMaManager;
    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void contextLoads() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
            String itemid = "38070";
            String token = yiMaManager.login("yu1025894148", "yuqi12345");
            String mobile = yiMaManager.getmobile(token, itemid);
            System.out.println("手机号:" + mobile);
            //mobile = "17353626232";
            String urlYanzhengma = "https://reg.ytl.yottachain.io/YTL/public/index.php/index/User/sendPhoneCode";
            JSONObject yanzhengma = new JSONObject();
            yanzhengma.put("phone", mobile);
            yanzhengma.put("type", "register");
            String yanzhengmaRes =  post(yanzhengma,urlYanzhengma);
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
            String regEx="[^0-9]";
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
            String zhuceRes = post(zhuce, zhuceUrl);
            System.out.println("注册返回:" + zhuceRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String post(JSONObject jsonObject, String url) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        System.out.println(jsonObject.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObject.toString(), headers);
        JsonNode yanzhengmaResponse = restTemplate.postForObject(url, formEntity, ObjectNode.class);
        return yanzhengmaResponse.toString();
    }


}
