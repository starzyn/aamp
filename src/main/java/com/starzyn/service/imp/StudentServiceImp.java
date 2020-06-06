/**
 * @ClassName StudentServiceImp
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/19 23:34
 * @Version 1.0
 */
package com.starzyn.service.imp;

import com.starzyn.dao.StudentDao;
import com.starzyn.dto.PaperCheck;
import com.starzyn.dto.PaperDetail;
import com.starzyn.dto.SubjectList;
import com.starzyn.entity.Check;
import com.starzyn.entity.Paper;
import com.starzyn.entity.Require;
import com.starzyn.entity.Student;
import com.starzyn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service("studentService")
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao sd;

    @Override
    public Student[] checkEmail(String username) {
        Student[] s = sd.queryByUsername(username);
        System.out.println("查询到的邮箱："+s.toString());
        return s;
    }

    @Override
    public List<Require> queryRequire(int sid) {
        List<Require> rs = sd.queryRequire(sid);
        return rs;
    }

    @Override
    public PaperDetail getPaperDetail(int sid, int ppid) {
        PaperDetail pd = sd.queryPaperDetail(sid,ppid);
        //处理时间
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        pd.setSt(pd.getStartTime().format(dtf));
        pd.setEt(pd.getEndTime().format(dtf));
        return pd;
    }

    @Override
    public List<PaperCheck> showPaperCheck(int sid) {
        List<PaperCheck> pcs = sd.queryPaperCheck(sid);
        //处理时间问题
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        for (PaperCheck p : pcs){
            p.setSt(p.getStartTime().format(dtf));
            p.setEt(p.getEndTime().format(dtf));
        }
        return pcs;
    }

    @Override
    public int uploadPaper(int tid, int sid, Paper p) {
        Integer pid = sd.queryPaperId(tid,sid);
        int res = 0;
        if(pid!=null){//是修改
            Paper pp = sd.queryPaperById(pid);
            if(p.getPaperTitle()!=null) pp.setPaperTitle(p.getPaperTitle());
            if(p.getPaperType()!=null) pp.setPaperType(p.getPaperType());
            if(p.getPaperPath()!=null) pp.setPaperPath(p.getPaperPath());
            res += sd.updatePaper(pp);
        }else{//是新增
            res += sd.addPaper(p);
            int ppid = p.getPaperId();
            res += sd.addStuPaper(tid,sid,ppid);
            //插入评语
            Check c = new Check();
            c.setCheckStatus("未批改");
            res += sd.addCheck(c);
            int cid = c.getCheckId();
            res += sd.addCheckManager(sid,tid,cid);
        }
        return res;
    }

    @Override
    public List<SubjectList> querySubjects(int sid) {
        return sd.querySubjects(sid);
    }

    @Override
    public Student queryByUsername(String stuUsername) {
        return sd.queryByUsername(stuUsername)[0];
    }

    @Override
    public Student showInfo(int id) {
        return sd.queryById(id);
    }

    @Override
    public int updateStudentInfo(Student s) {
        int res = sd.updateStudentById(s);
        return res;
    }

    @Override
    public int modifyPassword(String username, String password) {
        Student s = new Student();
        s.setStudentUsername(username);
        s.setStudentPassword(password);
        int res = sd.updatePwd(s);
        return res;
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
    public int regist(String username, String password) {
        Student s = new Student();
        //添加学生
        s.setStudentUsername(username);
        s.setStudentPassword(password);
        int res = sd.addStudent(s);
        return res;
    }

}
