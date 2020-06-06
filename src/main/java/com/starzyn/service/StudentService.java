package com.starzyn.service;

import com.starzyn.dto.PaperCheck;
import com.starzyn.dto.PaperDetail;
import com.starzyn.dto.SubjectList;
import com.starzyn.entity.Paper;
import com.starzyn.entity.Require;
import com.starzyn.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     * @Author starzyn
     * @Description 根据学生id来查询论文需求
     * @Date 16:02 2020/6/2
     * @Param [sid]
     * @return java.util.List<com.starzyn.entity.Require>
     **/
    List<Require> queryRequire(int sid);

    /**
     * @Author starzyn
     * @Description 获取论文详情页的数据
     * @Date 15:13 2020/6/2
     * @Param [sid, ppid]
     * @return com.starzyn.dto.PaperDetail
     **/
    PaperDetail getPaperDetail(int sid,int ppid);

    /**
     * @Author starzyn
     * @Description 根据学生id来查询论文审核状态
     * @Date 13:32 2020/6/2
     * @Param [sid]
     * @return java.util.List<com.starzyn.dto.PaperCheck>
     **/
    List<PaperCheck> showPaperCheck(int sid);

    /**
     * @Author starzyn
     * @Description 上传论文
     * @Date 0:38 2020/6/2
     * @Param [tid, sid, p]
     * @return int
     **/
    int uploadPaper(int tid, int sid, Paper p);

    /**
     * @Author starzyn
     * @Description 根据学生id来查询学科科目
     * @Date 23:22 2020/6/1
     * @Param [sid]
     * @return java.util.List<com.starzyn.dto.SubjectList>
     **/
    List<SubjectList> querySubjects(int sid);

    /**
     * @Author starzyn
     * @Description 通过用户名来查询学生信息
     * @Date 18:31 2020/6/1
     * @Param [stuUsername]
     * @return com.starzyn.entity.Student
     **/
    Student queryByUsername(String stuUsername);

    /**
     * @Author starzyn
     * @Description
     * @Date 16:32 2020/5/28
     * @Param [id]
     * @return com.starzyn.entity.Student
     **/
    public Student showInfo(int id);

    /**
     * @Author starzyn
     * @Description 更新学生信息
     * @Date 15:41 2020/5/28
     * @Param [s]
     * @return int
     **/
    public int updateStudentInfo(Student s);


    /**
     * @Author starzyn
     * @Description 修改密码功能
     * @Date 15:48 2020/5/27
     * @Param [username, password]
     * @return int
     **/
    int modifyPassword(String username,String password);

    /**
     * @Author starzyn
     * @Description 通过用户名（邮箱）和密码来进行查询学生信息
     * @Date 23:31 2020/5/19
     * @Param [username, password]
     * @return boolean
     **/
    Student login(String username,String password);
    
    /**
     * @Author starzyn
     * @Description 通过用户名和密码来进行注册
     * @Date 23:32 2020/5/19
     * @Param [username, password]
     * @return int
     **/
    int regist (String username,String password);

    /**
     * @description 通过用户名来检查邮箱是否被注册过
     * @author starzyn
     * @date 2020/5/24
     * @param [username]
     * @return com.starzyn.entity.Student[]
    */
    Student[] checkEmail(String username);
}
