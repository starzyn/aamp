package com.starzyn.dto;

import java.time.LocalDate;

/**
 * @author starzyn
 * @className:PaperDetail
 * @date : 2020/6/2
 * @description:
 */
public class PaperDetail {
    private String paperPath;//varchar(50) NULL论文存放路径
    private String paperTitle;//varchar(50) NULL论文题目
    private String paperType;//varchar(50) NULL论文类型
    private  String teacherName;
    private String checkStatus;
    private String checkContent;
    private LocalDate startTime;//date NULL开始时间
    private LocalDate endTime;//date NULL结束时间
    private String st;//开始时间
    private String et;//结束时间

    public String getPaperPath() {
        return paperPath;
    }

    public void setPaperPath(String paperPath) {
        this.paperPath = paperPath;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }
}
