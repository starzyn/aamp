package com.starzyn.service;

import com.starzyn.entity.Student;

public interface StudentService {
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
     * @return boolean
     **/
    Student regist (String username,String password);

    /**
     * @description 通过用户名来检查邮箱是否被注册过
     * @author starzyn
     * @date 2020/5/24
     * @param [username]
     * @return com.starzyn.entity.Student[]
    */
    Student[] checkEmail(String username);
}
