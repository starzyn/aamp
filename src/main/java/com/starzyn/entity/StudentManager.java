/**
 * @ClassName StudentManager
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/15 15:41
 * @Version 1.0
 */
package com.starzyn.entity;

public class StudentManager {
    private int teacherId;
    private int studentId;

    @Override
    public String toString() {
        return "StudentManager{" +
                "teacherId=" + teacherId +
                ", studentId=" + studentId +
                '}';
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
