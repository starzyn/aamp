/**
 * @ClassName TeacherServiceImp
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/20 11:20
 * @Version 1.0
 */
package com.starzyn.service.imp;

import com.starzyn.dao.StudentDao;
import com.starzyn.dao.TeacherDao;
import com.starzyn.dto.CheckDetail;
import com.starzyn.dto.Submit;
import com.starzyn.entity.Check;
import com.starzyn.entity.Student;
import com.starzyn.entity.Teacher;
import com.starzyn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherDao td;

    @Autowired
    private StudentDao sd;

    @Override
    public Map<String, Object> getTypeDistribution(int tid) {
        List<Map<String, Object>> res = td.queryTypes(tid);
        Map<String,Object> map = new HashMap<>();
        String[] types = {"描述型论文","综述型论文","应用型论文","实验型论文","专题型论文"};
        for(int i=0;i<types.length;i++){
            map.put(types[i],0);
            for(Map<String, Object> m :res){
                String type = (String)m.get("paperType");
                Long counts = (Long)m.get("counts");
                if(type.equals(types[i])){
                    map.put(types[i],counts);
                }
            }
        }
        return map;
    }

    @Override
    public List<Student> getUnSubmit(int tid) {
        List<Student> stus = td.queryUnSubmitStudents(tid);
        return stus;
    }

    @Override
    public List<Submit> getSubmit(int tid) {
        List<Submit> m = td.querySubmit(tid);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM.dd");
        LocalDate start = m.get(0).getStart();
        LocalDate end = m.get(0).getEnd();
        long cap = start.until(end, ChronoUnit.DAYS);
        //接受结果的列表
        List<Submit> res = new ArrayList<>();
        for(int i=0;i<cap;i++){
            LocalDate noww = start.plusDays(i);
            Submit ss = new Submit();
            ss.setSubmitTime(noww);
            ss.setDay(noww.format(dtf));
            ss.setSubmitTimes(0);
            for(Submit s:m){//寻找日期相等的
                if(s.getSubmitTime().isEqual(noww)){//如果相等
                    ss.setSubmitTimes(s.getSubmitTimes());
                    break;
                }
            }
            res.add(ss);
        }
        return res;
    }

    @Override
    public int updateCheck(Check c) {
        int res = td.updateCheck(c);
        return res;
    }

    @Override
    public Check getCheck(int cid) {
        return td.queryCheck(cid);
    }

    @Override
    public Map<String,String> getPaperPath(int pid) {
        return td.queryPaperPath(pid);
    }

    @Override
    public List<CheckDetail> showCheck(int tid) {
        return td.queryCheckDetail(tid);
    }

    @Override
    public int delStudent(int sid, int tid) {
        return td.delStudent(sid,tid);
    }

    @Override
    public int addStudent(int sid, int tid) {
        return td.addStudent(sid,tid);
    }

    @Override
    public List<Student> showStudents(int tid) {
        return td.queryStudentsByTid(tid);
    }

    @Override
    public Teacher showInf(int id) {
        return td.queryById(id);
    }

    @Override
    public Teacher login(String username, String password) {
        return td.queryByUsernameAndPwd(username,password);
    }

    @Override
    public int updateInf(Teacher t) {
        return td.update(t);
    }
}
