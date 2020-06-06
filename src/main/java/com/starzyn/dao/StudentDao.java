package com.starzyn.dao;

import com.starzyn.dto.PaperCheck;
import com.starzyn.dto.PaperDetail;
import com.starzyn.dto.SubjectList;
import com.starzyn.entity.Check;
import com.starzyn.entity.Paper;
import com.starzyn.entity.Require;
import com.starzyn.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author starzyn
 * @Description 学生类的Dao层
 * @Date 17:49 2020/5/15
 **/
@Repository
@Mapper
public interface StudentDao {

    /**
     * @Author starzyn
     * @Description 查询该学生的论文需求
     * @Date 16:04 2020/6/2
     * @Param [sid]
     * @return java.util.List<com.starzyn.entity.Require>
     **/
    List<Require> queryRequire(int sid);

    PaperDetail queryPaperDetail(@Param("sid") int sid,@Param("pid") int ppid);

    /**
     * @Author starzyn
     * @Description 根据学生id来查询论文审核状态
     * @Date 13:33 2020/6/2
     * @Param [sid]
     * @return java.util.List<com.starzyn.dto.PaperCheck>
     **/
    List<PaperCheck> queryPaperCheck(int sid);

    /**
     * @Author starzyn
     * @Description 插入评语管理表
     * @Date 8:58 2020/6/2
     * @Param [sid, tid, cid]
     * @return int
     **/
    int addCheckManager(@Param("sid")int sid,@Param("tid")int tid,@Param("cid") int cid);

    /**
     * @Author starzyn
     * @Description 添加评语
     * @Date 8:57 2020/6/2
     * @Param [c]
     * @return int
     **/
    int addCheck(Check c);

    int addStuPaper(@Param("tid")int tid,@Param("sid")int sid,@Param("pid")int ppid);
    /**
     * @Author starzyn
     * @Description 插入论文数据
     * @Date 1:04 2020/6/2
     * @Param 
     * @return 
     **/
    int addPaper(Paper p);

    /**
     * @Author starzyn
     * @Description 更新论文
     * @Date 1:00 2020/6/2
     * @Param [pp]
     * @return int
     **/
    int updatePaper(Paper pp);

    /**
     * @Author starzyn
     * @Description 根据论文id来查询论文
     * @Date 0:53 2020/6/2
     * @Param []
     * @return com.starzyn.entity.Paper
     **/
    Paper queryPaperById(int pid);

    /**
     * @Author starzyn
     * @Description 查询论文id
     * @Date 0:50 2020/6/2
     * @Param [tid, sid]
     * @return java.lang.Integer
     **/
    Integer queryPaperId(@Param("tid") int tid,@Param("sid") int sid);

    /**
     * @Author starzyn
     * @Description 根据学生id来查询学科科目
     * @Date 23:24 2020/6/1
     * @Param [sid]
     * @return java.util.List<com.starzyn.dto.SubjectList>
     **/
    List<SubjectList> querySubjects(int sid);

    /**
     * @Author starzyn
     * @Description 通过传入的学生对象来更改学生信息
     * @Date 15:45 2020/5/28
     * @Param [s]
     * @return int
     **/
    int updateStudentById(Student s);
    
    /**
     * @Author starzyn
     * @Description 根据用户名进行修改密码
     * @Date 15:53 2020/5/27
     * @Param [s]
     * @return int
     **/
    int updatePwd(Student s);

    /**
     * @Author starzyn
     * @Description 往数据库里添加学生信息
     * @Date 13:03 2020/5/26
     * @Param [s]
     * @return int
     **/
    int addStudent(Student s);

    /**
     * @Author starzyn
     * @Description 根据学生id来查询学生信息
     * @Date 17:50 2020/5/15
     * @Param [id]
     * @return com.starzyn.entity.Student
     **/
    Student queryById(@Param("id") int id);

    /**
     * @Author starzyn
     * @Description 通过用户名和密码进行查询获取学生信息，主要用在登录功能上
     * @Date 17:54 2020/5/15
     * @Param [username, pwd]
     * @return com.starzyn.entity.Student
     **/
    Student queryByUsernameAndPwd(@Param("username") String username,@Param("password") String pwd);

    /**
     * @Author starzyn
     * @Description 通过用户名来查询用户，主要用来注册时的检查用户名
     * @Date 8:56 2020/5/20
     * @Param [username]
     * @return com.starzyn.entity.Student[]
     **/
    Student[] queryByUsername(String username);

}
