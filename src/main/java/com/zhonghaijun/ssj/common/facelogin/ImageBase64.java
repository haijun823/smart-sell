package com.zhonghaijun.ssj.common.facelogin;

import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.InputStream;

public class ImageBase64 {

    //将图片进行base64编码
    public static String getBase64(String url, HttpServletRequest request) throws Exception {
        String realPath = request.getServletContext().getRealPath(url);
        //获取图片的字符流
        InputStream in = null;
        byte[] by = null;
        //读取图片的字节流
        in = new FileInputStream(realPath);
        by = new byte[in.available()];
        in.read(by);
        in.close();
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(by);
    }

}
