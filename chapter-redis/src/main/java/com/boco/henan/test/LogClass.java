package com.boco.henan.test;

/**
 * Created by zhonghua on 15/12/10.
 */
public final class LogClass {

    private String threadId;

    private String createTime;

    private String sheetCode;

    private String cityName;

    private String reqMsgBody;

    private String respMsgBody;

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSheetCode() {
        return sheetCode;
    }

    public void setSheetCode(String sheetCode) {
        this.sheetCode = sheetCode;
    }

    public String getCityName() {

        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getReqMsgBody() {
        return reqMsgBody;
    }

    public void setReqMsgBody(String reqMsgBody) {
        this.reqMsgBody = reqMsgBody;
    }

    public String getRespMsgBody() {
        return respMsgBody;
    }

    public void setRespMsgBody(String respMsgBody) {
        this.respMsgBody = respMsgBody;
    }
}