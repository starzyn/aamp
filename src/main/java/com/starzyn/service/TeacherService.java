package com.starzyn.service;

import com.starzyn.entity.Teacher;

public interface TeacherService {
    Teacher login(String username, String password);
}
