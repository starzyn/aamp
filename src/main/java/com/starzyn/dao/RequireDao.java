package com.starzyn.dao;

import com.starzyn.entity.Require;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author starzyn
 * @Description 论文需求的dao接口
 * @Date 9:16 2020/6/1
 **/
@Repository
@Mapper
public interface RequireDao {
    /**
     * @Author starzyn
     * @Description 添加论文需求对象，并且获取当前对象的id
     * @Date 22:21 2020/6/1
     * @Param [r]
     * @return int
     **/
    int addRequire(Require r);

    /**
     * @Author starzyn
     * @Description 更新论文需求
     * @Date 10:42 2020/6/1
     * @Param [r]
     * @return int
     **/
    int update(Require r);

    /**
     * @Author starzyn
     * @Description 通过论文需求id来查询论文需求
     * @Date 10:43 2020/6/1
     * @Param [id]
     * @return com.starzyn.entity.Require
     **/
    Require queryById(@Param("rid") int id);
}
