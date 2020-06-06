package com.starzyn.dto;

/**
 * @author starzyn
 * @className:SubjectList
 * @date : 2020/6/1
 * @description:
 */
public class SubjectList {
    private int teacherId;
    private String requireSubject;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getRequireSubject() {
        return requireSubject;
    }

    public void setRequireSubject(String requireSubject) {
        this.requireSubject = requireSubject;
    }

    @Override
    public String toString() {
        return "SubjectList{" +
                "teacherId=" + teacherId +
                ", requireSubject='" + requireSubject + '\'' +
                '}';
    }
}
