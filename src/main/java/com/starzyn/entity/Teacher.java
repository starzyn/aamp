/**
 * @ClassName Teacher
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/15 15:40
 * @Version 1.0
 */
package com.starzyn.entity;

public class Teacher {
    private int teacherId;//int(11) NOT NULL
    private String teacherUsername;//varchar(50) NOT NULL用户名登录
    private String teacherPassword;//varchar(50) NOT NULL登录密码
    private String teacherSex;//varchar(10) NULL教师性别
    private String teacherName;//varchar(50) NULL教师姓名
    private String teacherAcdemic;//varchar(50) NULL教师所属学院

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherUsername='" + teacherUsername + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAcdemic='" + teacherAcdemic + '\'' +
                '}';
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAcdemic() {
        return teacherAcdemic;
    }

    public void setTeacherAcdemic(String teacherAcdemic) {
        this.teacherAcdemic = teacherAcdemic;
    }
}
