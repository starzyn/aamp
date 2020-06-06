package com.starzyn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author starzyn
 * @Description 教师于论文需求之间的管理表dao
 * @Date 9:51 2020/6/1
 * @Param 
 * @return 
 **/
@Repository
@Mapper
public interface TeacherRequireDao {

    /**
     * @Author starzyn
     * @Description 添加教师和论文需求的关联
     * @Date 22:29 2020/6/1
     * @Param [rid, tid]
     * @return int
     **/
    int add(@Param("rid") int rid,@Param("tid") int tid);

    /**
     * @Author starzyn
     * @Description 通过教师id来查询论文需求id
     * @Date 10:11 2020/6/1
     * @Param [tid]
     * @return int
     **/
    Integer queryByTid(int tid);
}
