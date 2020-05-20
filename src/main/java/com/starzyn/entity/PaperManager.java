/**
 * @ClassName PaperManager
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/15 15:41
 * @Version 1.0
 */
package com.starzyn.entity;

public class PaperManager {
    private int studentId;
    private int paperId;
    private int teacherId;

    @Override
    public String toString() {
        return "PaperManager{" +
                "studentId=" + studentId +
                ", paperId=" + paperId +
                ", teacherId=" + teacherId +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
