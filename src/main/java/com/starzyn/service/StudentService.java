package com.starzyn.service;

import com.starzyn.entity.Student;

public interface StudentService {
    /**
     * @Author starzyn
     * @Description 通过用户名（邮箱）和密码来进行登录
     * @Date 23:31 2020/5/19
     * @Param [username, password]
     * @return boolean
     **/
    Student login(String username, String password);
    
    /**
     * @Author starzyn
     * @Description 通过用户名和密码来进行注册
     * @Date 23:32 2020/5/19
     * @Param [username, password]
     * @return boolean
     **/
    boolean regist (String username,String password);
}
