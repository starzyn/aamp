package com.starzyn.dao;

import com.starzyn.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
