package com.jiema.yima;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jiema.yima.manager.YiMaManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FowinTests {

    @Autowired
    private YiMaManager yiMaManager;
    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void contextLoads() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
            String itemid = "31082";
            String token = yiMaManager.login("yu1025894148", "yuqi12345");
            String mobile = yiMaManager.getmobile(token, itemid);
            System.out.println("手机号:" + mobile);
            //mobile = "17353626232";
            String urlYanzhengma = "https://www.fowin.app/api/web/sms/register";
            MultiValueMap<String, String> yanzheng = new LinkedMultiValueMap<String, String>();
            yanzheng.add("userName", mobile);
            String yanzhengmaRes = post(yanzheng, urlYanzhengma);
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
            String yanzhengma = m.replaceAll("").trim();
            System.out.println("验证码:" +yanzhengma);
            String zhuceUrl = "https://www.fowin.app/api/web/user/register";
          /*  JSONObject zhuce = new JSONObject();
            zhuce.put("login_name", "");
            zhuce.put("password", "qwer123456");
            zhuce.put("phone", mobile);
            zhuce.put("code", m.replaceAll("").trim());
            zhuce.put("invite_code", "20502298");*/

            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            params.add("userName", mobile);
            params.add("password", "Swq123456");
            params.add("sms_code", yanzhengma);
            params.add("invite_code", "393730F1");
            String zhuceResp = post(params, zhuceUrl);
            System.out.println("注册返回:" + zhuceResp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String post(MultiValueMap<String, String> params, String url) {
        HttpHeaders headers = new HttpHeaders();
        // MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        // headers.setContentType(type);
        headers.add("Accept", "application/json, text/plain, */*");
        headers.add("Origin", "https://www.fowin.app");
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("Referer", "https://www.fowin.app/web/register?invite_code=393730F1");
        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        JsonNode yanzhengmaResponse = restTemplate.postForObject(url, formEntity, ObjectNode.class);
        return yanzhengmaResponse.toString();
    }


}
