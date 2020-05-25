/**
 * @ClassName Require
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/15 15:41
 * @Version 1.0
 */
package com.starzyn.entity;

import java.time.LocalDate;

public class Require {
    private int requireId;//int(11) NOT NULL
    private String requireSubject;//varchar(50) NULL所属科目
    private String requires;//varchar(3000) NULL论文要求
    private LocalDate startTime;//date NULL开始时间
    private LocalDate endTime;//date NULL结束时间
    private String modelPath;//varchar(50) NULL论文模板路径

    @Override
    public String toString() {
        return "Require{" +
                "requireId=" + requireId +
                ", requireSubject='" + requireSubject + '\'' +
                ", requires='" + requires + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", modelPath='" + modelPath + '\'' +
                '}';
    }

    public int getRequireId() {
        return requireId;
    }

    public void setRequireId(int requireId) {
        this.requireId = requireId;
    }

    public String getRequireSubject() {
        return requireSubject;
    }

    public void setRequireSubject(String requireSubject) {
        this.requireSubject = requireSubject;
    }

    public String getRequires() {
        return requires;
    }

    public void setRequires(String requires) {
        this.requires = requires;
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

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }
}
