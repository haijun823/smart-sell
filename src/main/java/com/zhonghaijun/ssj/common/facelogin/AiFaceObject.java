package com.zhonghaijun.ssj.common.facelogin;

import com.baidu.aip.face.AipFace;

//创建
public class AiFaceObject {
    //设置APPID/AK/SK
    public static final String APP_ID = "16158376";
    public static final String API_KEY = "y8QpW2hclon7WXSuOrY3rUaN";
    public static final String SECRET_KEY = "bNgZzTazp3ulHmaboCHjuYqHPXOPLLt7";

    //创建一个aipface对象
    //创建一个aipface对象
    private static AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    //创建单例的原因是避免多次获取sdk
    public static AipFace getClient(){
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }



}
