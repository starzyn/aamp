package com.starzyn.service.imp;

import com.starzyn.dao.RequireDao;
import com.starzyn.dao.TeacherRequireDao;
import com.starzyn.entity.Require;
import com.starzyn.service.RequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author starzyn
 * @className:RequireServiceImp
 * @date : 2020/6/1
 * @description: 论文需求服务接口的实现类
 */
@Service
public class RequireServiceImp implements RequireService {

    @Autowired
    private RequireDao rd;

    @Autowired
    private TeacherRequireDao trd;

    @Override
    public Require addRequire(Require r, int tid) {
        //添加论文需求对象，并且获取当前对象的id
        rd.addRequire(r);
        int rid = r.getRequireId();
        int res = trd.add(rid,tid);
        if(res > 0) {
            int rrid = trd.queryByTid(tid);
            return rd.queryById(rrid);
        }else return null;
    }

    @Override
    public Require updateRequire(Require r, int teacherId) {
        int rid = trd.queryByTid(teacherId);
        Require res = rd.queryById(rid);
        res.setStartTime(r.getStartTime());
        res.setEndTime(r.getEndTime());
        res.setRequires(r.getRequires());
        res.setRequireSubject(r.getRequireSubject());
        if(r.getModelPath()!=null) res.setModelPath(r.getModelPath());
        rd.update(res);
        return rd.queryById(res.getRequireId());
    }

    @Override
    public Require showRequire(int teacherId) {
        Integer rid = trd.queryByTid(teacherId);
        if(rid==null) return null;
        Require r = rd.queryById(rid);
        return r;
    }
}
