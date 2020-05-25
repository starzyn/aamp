package com.starzyn.dao;

import com.starzyn.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
