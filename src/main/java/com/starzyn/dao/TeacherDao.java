package com.starzyn.dao;

import com.starzyn.dto.CheckDetail;
import com.starzyn.dto.Submit;
import com.starzyn.entity.Check;
import com.starzyn.entity.Student;
import com.starzyn.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author starzyn
 * @date 2020/5/23
 *教师类的dao层
 *
*/
@Repository
@Mapper
public interface TeacherDao {

    /**
     * @Author starzyn
     * @Description 查询论文类型分布
     * @Date 21:17 2020/6/2
     * @Param [tid]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    List<Map<String, Object>> queryTypes(int tid);

    /**
     * @Author starzyn
     * @Description 获取未按时完成论文的学生
     * @Date 20:22 2020/6/2
     * @Param [tid]
     * @return java.util.List<com.starzyn.entity.Student>
     **/
    List<Student> queryUnSubmitStudents(int tid);

    /**
     * @Author starzyn
     * @Description 查询提交人数按时间
     * @Date 18:41 2020/6/2
     * @Param [tid]
     * @return java.util.List<com.starzyn.dto.Submit>
     **/
    List<Submit> querySubmit(int tid);

    /**
     * @Author starzyn
     * @Description 更新评语
     * @Date 12:33 2020/6/2
     * @Param [c]
     * @return int
     **/
    int updateCheck(Check c);

    /**
     * @Author starzyn
     * @Description 获取评论
     * @Date 10:49 2020/6/2
     * @Param [cid]
     * @return com.starzyn.entity.Check
     **/
    Check queryCheck(int cid);

    /**
     * @Author starzyn
     * @Description 通过论文id来查询论文的路径，方便展示
     * @Date 10:47 2020/6/2
     * @Param [pid]
     * @return java.lang.String
     **/
    Map<String,String> queryPaperPath(int pid);

    /**
     * @Author starzyn
     * @Description 根绝提供的教师id查询管理学生的所有论文
     * @Date 8:35 2020/6/2
     * @Param [tid]
     * @return java.util.List<com.starzyn.dto.CheckDetail>
     **/
    List<CheckDetail> queryCheckDetail(int tid);

    /**
     * @Author starzyn
     * @Description 删除教师和学生的关系
     * @Date 21:12 2020/6/1
     * @Param [sid, tid]
     * @return int
     **/
    int delStudent(@Param("sid") int sid,@Param("tid")int tid);

    /**
     * @Author starzyn
     * @Description 通过学生的向学生管理表中插入数据
     * @Date 20:47 2020/6/1
     * @Param [sid, tid]
     * @return int
     **/
    int addStudent(@Param("sid") int sid, @Param("tid") int tid);

    /**
     * @Author starzyn
     * @Description 通过教师id来查询所管理的学生信息
     * @Date 19:21 2020/6/1
     * @Param 
     * @return 
     **/
    List<Student> queryStudentsByTid(int tid);

    /**
     * @Author starzyn
     * @Description 更新教师信息
     * @Date 18:32 2020/5/31
     * @Param [t]
     * @return int
     **/
    public int update(Teacher t);

    /**
     * @description 通过教师id来查询教师的信息，返回一个教师对象
     * @author starzyn
     * @date 2020/5/23
     * @param [id]
     * @return com.starzyn.entity.Teacher
    */
    Teacher queryById(int id);

    /**
     * @description 通过用户名和密码来查询教师信息，主要用来做登录功能
     * @author starzyn
     * @date 2020/5/23
     * @param [username, pwd]
     * @return com.starzyn.entity.Teacher
    */
    Teacher queryByUsernameAndPwd(String username,String pwd);
}
