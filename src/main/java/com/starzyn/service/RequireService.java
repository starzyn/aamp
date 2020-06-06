package com.starzyn.service;

import com.starzyn.entity.Require;
import org.springframework.stereotype.Service;

/**
 * @Author starzyn
 * @Description 论文需求的服务接口
 * @Date 9:13 2020/6/1
 **/
public interface RequireService {

    /**
     * @Author starzyn
     * @Description 新增论文需求
     * @Date 22:08 2020/6/1
     * @Param [r, tid]
     * @return com.starzyn.entity.Require
     **/
    Require addRequire(Require r, int tid);

    /**
     * @Author starzyn
     * @Description 通过教师id来更新对应的论文需求
     * @Date 17:12 2020/6/1
     * @Param [r, teacherId]
     * @return com.starzyn.entity.Require
     **/
    Require updateRequire(Require r,int teacherId);
    
    /**
     * @Author starzyn
     * @Description 根据教师id来展示对应的论文需求
     * @Date 9:20 2020/6/1
     * @Param [teacherId]
     * @return com.starzyn.entity.Require
     **/
    Require showRequire(int teacherId);
}
