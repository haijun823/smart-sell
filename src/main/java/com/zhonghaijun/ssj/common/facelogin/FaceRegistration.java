package com.zhonghaijun.ssj.common.facelogin;

import com.baidu.aip.face.AipFace;
import com.zhonghaijun.ssj.common.UserImage;
import org.json.JSONObject;

import java.util.HashMap;

public class FaceRegistration {


    public static String  Faceregistrtion(AipFace client, String groupId, String userId, UserImage image){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        // 人脸注册
        JSONObject res = client.addUser(image.getImgpath(), image.getImgType(), groupId, userId, options);
        return res.toString(2);
    }

}
