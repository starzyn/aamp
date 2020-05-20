/**
 * @ClassName Student
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/15 15:40
 * @Version 1.0
 */
package com.starzyn.entity;

public class Student {
    private int studentId;//int(11) NOT NULL
    private String studentUsername;//varchar(50) NOT NULL用户名，邮箱格式
    private String studentPassword;//varchar(50) NOT NULL登录密码
    private String studentSex;//varchar(10) NULL学生性别
    private String remark;//varchar(150) NULL个性签名
    private String userImg;//varchar(200) NULL用户头像存放路径
    private String school;//varchar(50) NULL学校名称
    private String acdemic;//varchar(50) NULL学院名称
    private String major;//varchar(50) NULL专业名称
    private String classNum;//varchar(50) NULL班级
    private String studentNum;//varchar(50) NULL学号
    private String studentName;//varchar(50) NULL学生姓名

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentUsername='" + studentUsername + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", remark='" + remark + '\'' +
                ", userImg='" + userImg + '\'' +
                ", school='" + school + '\'' +
                ", acdemic='" + acdemic + '\'' +
                ", major='" + major + '\'' +
                ", classNum='" + classNum + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAcdemic() {
        return acdemic;
    }

    public void setAcdemic(String acdemic) {
        this.acdemic = acdemic;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
