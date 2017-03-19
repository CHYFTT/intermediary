package com.henrrycheng.chyftt.intermediary.controller;

/**
 * Created by zhanghu02 on 2016/9/7.
 */
public class JsonResult {

    /**
     * 状态码的约定
     * 0：成功，表示业务逻辑到达预想期待的结果。
     * 100～199：参数传递错误，请求数据错误，业务流程失败。
     * 200～299：UC权限错误，服务器未知的错误。
     * 300～399：UC登录超时，前端会新开登录页提醒重新登录。
     * 999：未知错误
     */
    protected int status = 0;

    /**
     * 状态信息,默认为"OK"
     */
    protected String statusInfo = "ok";

    /**
     * 业务返回数据
     */
    protected Object data;

    public JsonResult() {
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }
}
