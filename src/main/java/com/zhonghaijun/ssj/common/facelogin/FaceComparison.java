package com.zhonghaijun.ssj.common.facelogin;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.zhonghaijun.ssj.common.UserImage;
import org.json.JSONObject;

import java.util.ArrayList;

public class FaceComparison {

    public static JSONObject Facecomparison(AipFace client, UserImage imageU, UserImage imageC){

        MatchRequest req1 = new MatchRequest(imageU.getImgpath(), imageU.getImgType());
        MatchRequest req2 = new MatchRequest(imageC.getImgpath(), imageC.getImgType());
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);
        JSONObject res = client.match(requests);
        return res;
    }

}
