/**
 * @ClassName Paper
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/15 15:41
 * @Version 1.0
 */
package com.starzyn.entity;

import java.time.LocalTime;

public class Paper {
    private String paperSubject;//varchar(50) NULL论文科目
    private String paperTitle;//varchar(50) NULL论文题目
    private String author;//varchar(50) NULL论文作者
    private String paperPath;//varchar(50) NULL论文存放路径
    private String paperType;//varchar(50) NULL论文类型
    private int paperId;//int(11) NOT NULL
    private LocalTime submitTime;//timestamp NULL论文提交时间

    @Override
    public String toString() {
        return "Paper{" +
                "paperSubject='" + paperSubject + '\'' +
                ", paperTitle='" + paperTitle + '\'' +
                ", author='" + author + '\'' +
                ", paperPath='" + paperPath + '\'' +
                ", paperType='" + paperType + '\'' +
                ", paperId=" + paperId +
                ", submitTime=" + submitTime +
                '}';
    }

    public String getPaperSubject() {
        return paperSubject;
    }

    public void setPaperSubject(String paperSubject) {
        this.paperSubject = paperSubject;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPaperPath() {
        return paperPath;
    }

    public void setPaperPath(String paperPath) {
        this.paperPath = paperPath;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public LocalTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalTime submitTime) {
        this.submitTime = submitTime;
    }
}
