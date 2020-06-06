package com.starzyn.entity;

/**
 * @author starzyn
 * @className:Check
 * @date : 2020/6/2
 * @description:
 */
public class Check {
    private int checkId;
    private String checkStatus;
    private String checkContent;

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    @Override
    public String toString() {
        return "Check{" +
                "checkId=" + checkId +
                ", checkStatus='" + checkStatus + '\'' +
                ", checkContent='" + checkContent + '\'' +
                '}';
    }
}
