package com.zhonghaijun.ssj.common;

import org.springframework.web.multipart.MultipartFile;

public class UserImage {

    private String imgpath;
    private String imgType;

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }
}
