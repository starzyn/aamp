package com.starzyn.service;

import com.starzyn.dto.CheckDetail;
import com.starzyn.dto.Submit;
import com.starzyn.entity.Check;
import com.starzyn.entity.Student;
import com.starzyn.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    /**
     * @Author starzyn
     * @Description 查询论文类型分布
     * @Date 21:14 2020/6/2
     * @Param [tid]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> getTypeDistribution(int tid);

    /**
     * @Author starzyn
     * @Description 获取未按时完成论文的学生
     * @Date 20:20 2020/6/2
     * @Param [tid]
     * @return java.util.List<com.starzyn.entity.Student>
     **/
    List<Student> getUnSubmit(int tid);

    /**
     * @Author starzyn
     * @Description 根据教师id来查询管理的学生的论文提交情况
     * @Date 18:32 2020/6/2
     * @Param [tid]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    List<Submit> getSubmit(int tid);

    /**
     * @Author starzyn
     * @Description 更新评论
     * @Date 12:32 2020/6/2
     * @Param [c]
     * @return int
     **/
    int updateCheck(Check c);
    /**
     * @Author starzyn
     * @Description 获取评论
     * @Date 10:48 2020/6/2
     * @Param [cid]
     * @return com.starzyn.entity.Check
     **/
    Check getCheck(int cid);

    /**
     * @Author starzyn
     * @Description 通过论文id来查询论文的路径，方便展示
     * @Date 10:43 2020/6/2
     * @Param [pid]
     * @return java.lang.String
     **/
    Map<String,String> getPaperPath(int pid);

    /**
     * @Author starzyn
     * @Description 根据教师id来展示批改论文页面的数据
     * @Date 8:33 2020/6/2
     * @Param [tid]
     * @return java.util.List<com.starzyn.dto.CheckDetail>
     **/
    List<CheckDetail> showCheck(int tid);

    /**
     * @Author starzyn
     * @Description 删除教师和学生的关系
     * @Date 21:10 2020/6/1
     * @Param [sid, tid]
     * @return int
     **/
    int delStudent(int sid,int tid);

    /**
     * @Author starzyn
     * @Description 根据学生的id来添加学生
     * @Date 20:46 2020/6/1
     * @Param [sid, tid]
     * @return int
     **/
    int addStudent(int sid,int tid);

    /**
     * @Author starzyn
     * @Description 通过教师id来查询管理的学生
     * @Date 18:54 2020/6/1
     * @Param [tid]
     * @return java.util.List<com.starzyn.entity.Student>
     **/
    List<Student> showStudents(int tid);

    /**
     * @Author starzyn
     * @Description 从数据库来查询教师全部信息
     * @Date 18:33 2020/5/31
     * @Param [int]
     * @return com.starzyn.entity.Teacher
     **/
    Teacher showInf(int id);

    /**
     * @Author starzyn
     * @Description 登录功能
     * @Date 18:31 2020/5/31
     * @Param [username, password]
     * @return com.starzyn.entity.Teacher
     **/
    Teacher login(String username, String password);

    /**
     * @Author starzyn
     * @Description 更新教师信息
     * @Date 18:31 2020/5/31
     * @Param [t]
     * @return int
     **/
    int updateInf(Teacher t);
}
