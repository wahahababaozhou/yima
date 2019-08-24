package com.jiema.yima.manager;

public interface YiMaManager {
    /**
     * 登录接口
     */
    String login(String username, String password);

    /**
     * 获取账户信息接口
     */
    void getaccountinfo(String token);

    /**
     * 获取手机号码接口
     */
     String getmobile(String token, String itemid);

    /**
     * 获取短信接口
     */
     String getsms(String token, String itemid, String mobile, String timestamp);

    /**
     * 发送短信接口
     */
     String sendsms(String token, String itemid, String mobile, String sms);

    /**
     * 获取发短信结果接口
     */
    String getsendsmsstate(String token, String itemid, String mobile, String timestamp);

    /**
     * 释放手机号码接口
     */
     String release(String token, String itemid, String mobile);

    /**
     * 拉黑手机号码接口
     */
     String addignore(String token, String itemid, String mobile);
}
