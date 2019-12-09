package com.zhonghaijun.ssj.common;

public class AjaxResult {

    private String success = "succuss";
    private String msg;

    public AjaxResult() {
    }

    public AjaxResult(String success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
