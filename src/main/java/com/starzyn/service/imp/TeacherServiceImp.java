/**
 * @ClassName TeacherServiceImp
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/20 11:20
 * @Version 1.0
 */
package com.starzyn.service.imp;

import com.starzyn.dao.TeacherDao;
import com.starzyn.entity.Teacher;
import com.starzyn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherDao td;

    @Override
    public Teacher login(String username, String password) {
        return null;
    }
}
