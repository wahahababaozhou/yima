package com.jiema.yima.manager.impl;

import com.jiema.yima.manager.YiMaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.retry.annotation.Retryable;

@Service
@Retryable(value = {HttpClientErrorException.class, RuntimeException.class},
        backoff = @Backoff(value = 1000))
public class YiMaManagerImpl implements YiMaManager {

    private final YiMaInvoke yiMaInvoke;

    @Autowired
    public YiMaManagerImpl(YiMaInvoke yiMaInvoke) {
        this.yiMaInvoke = yiMaInvoke;
    }

    public String login(String username, String password) {
        String result = yiMaInvoke.login(username, password);
        String bodySign = result.substring(0, result.indexOf("|"));
        System.out.println("|之前的:" + bodySign);
        if ("success".equals(bodySign)) {
            return result.substring(result.indexOf("|") + 1);
        } else {
            return "获取token失败";
        }
    }


    public void getaccountinfo(String token) {
        yiMaInvoke.getaccountinfo("");
    }

    /**
     * 获取手机号码接口
     */
    public String getmobile(String token, String itemid) {
        String result = yiMaInvoke.getmobile(token, itemid);
        String bodySign = result.substring(0, result.indexOf("|"));
        System.out.println("|之前的:" + bodySign);
        if ("success".equals(bodySign)) {
            return result.substring(result.indexOf("|") + 1);
        } else {
            return "获取手机号失败";
        }
    }

    /**
     * 获取短信接口
     */
    public String getsms(String token, String itemid, String mobile, String timestamp) {
        try {


        String result = yiMaInvoke.getsms(token, itemid, mobile, timestamp);
        String bodySign = result.substring(0, result.indexOf("|"));
        System.out.println("|之前的:" + bodySign);
        if ("success".equals(bodySign)) {
            return result.substring(result.indexOf("|") + 1);
        } else if ("3001".equals(bodySign)){
            return "短信尚未到达";
        }else {
            return "获取短信异常";
        }
        }catch (Exception e){
            return "获取短信异常";
        }

    }

    /**
     * 发送短信接口
     */
    public String sendsms(String token, String itemid, String mobile, String sms) {
        return yiMaInvoke.sendsms(token, itemid, mobile, sms);
    }

    /**
     * 获取发短信结果接口
     */
    public String getsendsmsstate(String token, String itemid, String mobile, String timestamp) {
        return yiMaInvoke.getsendsmsstate(token, itemid, mobile, timestamp);
    }

    /**
     * 释放手机号码接口
     */
    public String release(String token, String itemid, String mobile) {
        return yiMaInvoke.release(token, itemid, mobile);
    }

    /**
     * 拉黑手机号码接口
     */
    public String addignore(String token, String itemid, String mobile) {
        return yiMaInvoke.addignore(token, itemid, mobile);
    }
}
