package com.starzyn.dto;

import java.time.LocalDate;

/**
 * @author starzyn
 * @className:Submit
 * @date : 2020/6/2
 * @description:
 */
public class Submit {
    private LocalDate start;
    private LocalDate end;
    private int submitTimes;
    private LocalDate submitTime;
    private String day;

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getSubmitTimes() {
        return submitTimes;
    }

    public void setSubmitTimes(int submitTimes) {
        this.submitTimes = submitTimes;
    }

    public LocalDate getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDate submitTime) {
        this.submitTime = submitTime;
    }
}
