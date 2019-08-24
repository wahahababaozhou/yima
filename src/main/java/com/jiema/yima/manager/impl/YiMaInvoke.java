package com.jiema.yima.manager.impl;


import com.jiema.config.SystemConfig;
import com.jiema.utils.HttpUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YiMaInvoke {


    private final SystemConfig systemConfig;

    @Autowired
    public YiMaInvoke(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }

    public String token;

    /**
     * 登录获取token
     */
    public String login(String username, String password) {
        String url = systemConfig.getYimaUrl() + "?action=login&username=" + username + "&password=" + password;
        token = HttpUtile.sendGetRequest(url, null, null);
        return token;
    }

    /**
     * 获取账户信息接口
     */
    public String getaccountinfo(String token) {
        String url = systemConfig.getYimaUrl() + "?action=getaccountinfo&token=" + token;
        return HttpUtile.sendGetRequest(url, null, null);
    }

    /**
     * 获取手机号码接口
     */
    public String getmobile(String token, String itemid) {
        String url = systemConfig.getYimaUrl() + "?action=getmobile&token=" + token + "&itemid=" + itemid;
        return HttpUtile.sendGetRequest(url, null, null);
    }

    /**
     * 获取短信接口
     */
    public String getsms(String token, String itemid, String mobile, String timestamp) {
        String url = systemConfig.getYimaUrl() + "?action=getsms&token=" + token
                + "&itemid=" + itemid + "&mobile=" + mobile + "&release=1&timestamp=" + timestamp;
        return HttpUtile.sendGetRequest(url, null, null);
    }

    /**
     * 发送短信接口
     */
    public String sendsms(String token, String itemid, String mobile, String sms) {
        String url = systemConfig.getYimaUrl() + "?action=sendsms&token=" + token
                + "&itemid=" + itemid + "&mobile=" + mobile + "&sms=" + sms;
        return HttpUtile.sendGetRequest(url, null, null);
    }

    /**
     * 获取发短信结果接口
     */
    public String getsendsmsstate(String token, String itemid, String mobile, String timestamp) {
        String url = systemConfig.getYimaUrl() + "?action=getsendsmsstate&token=" + token +
                "&itemid=" + itemid + "&mobile=" + mobile + "&timestamp=" + timestamp;
        return HttpUtile.sendGetRequest(url, null, null);
    }

    /**
     * 释放手机号码接口
     */
    public String release(String token, String itemid, String mobile) {
        String url = systemConfig.getYimaUrl() + "?action=release&token=" + token +
                "&itemid=" + itemid + "&mobile=" + mobile;
        return HttpUtile.sendGetRequest(url, null, null);
    }

    /**
     * 拉黑手机号码接口
     */
    public String addignore(String token, String itemid, String mobile) {
        String url = systemConfig.getYimaUrl() + "?action=addignore&token=" + token +
                "&itemid="+itemid+"&mobile="+mobile;
        return HttpUtile.sendGetRequest(url, null, null);
    }
}
