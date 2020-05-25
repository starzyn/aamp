/**
 * @ClassName StudentServiceImp
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/19 23:34
 * @Version 1.0
 */
package com.starzyn.service.imp;

import com.starzyn.dao.StudentDao;
import com.starzyn.entity.Student;
import com.starzyn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao sd;

    @Override
    public Student[] checkEmail(String username) {
        Student[] s = sd.queryByUsername(username);
        //如果查询到结果
        if(s!=null) return s;
        //如果没有查询到结果
        return null;
    }

    @Override
    public Student login(String username, String password) {
        Student s = sd.queryByUsernameAndPwd(username,password);
        //如果查询到结果
        if(s!=null) return s;
        //如果没有查询到结果
        return null;
    }

    @Override
    public Student regist(String username, String password) {
        return null;
    }

}
