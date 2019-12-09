package com.zhonghaijun.ssj.common.facelogin;

import com.baidu.aip.face.AipFace;
import com.zhonghaijun.ssj.common.UserImage;
import org.json.JSONObject;

import java.util.HashMap;

public class FaceUser {
    public static String   Faceuser(AipFace client, UserImage imageU){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("max_user_num", "1");

        String groupIdList = "user,1";

        // 人脸搜索
        JSONObject res = client.search(imageU.getImgpath(), imageU.getImgType(), groupIdList, options);
        return res.toString(2);
    }
}
