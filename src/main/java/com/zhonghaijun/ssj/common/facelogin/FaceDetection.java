package com.zhonghaijun.ssj.common.facelogin;

import com.baidu.aip.face.AipFace;
import com.zhonghaijun.ssj.common.UserImage;
import org.json.JSONObject;

import java.util.HashMap;

public class FaceDetection {

    public static JSONObject Facedetection(AipFace client, UserImage image){
        HashMap<String, String> options= new HashMap<String, String>();
        options.put("face_field", "age");//返回的人脸信息
        options.put("max_face_num", "1");//最大人脸识别数1
        options.put("face_type", "LIVE");//照骗类型 生活照
        JSONObject res=client.detect(image.getImgpath(),image.getImgType(), options);
        return res;
    }

}
