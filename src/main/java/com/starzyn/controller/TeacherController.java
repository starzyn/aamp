package com.starzyn.controller;

import com.starzyn.dao.TeacherDao;
import com.starzyn.dto.CheckDetail;
import com.starzyn.dto.Submit;
import com.starzyn.entity.Check;
import com.starzyn.entity.Require;
import com.starzyn.entity.Student;
import com.starzyn.entity.Teacher;
import com.starzyn.service.RequireService;
import com.starzyn.service.StudentService;
import com.starzyn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author starzyn
 * @className:TeacherController
 * @date : 2020/5/31
 * @description: 教师控制器
 */
@Controller
public class TeacherController {
    @Autowired
    private TeacherService ts;

    @Autowired
    private RequireService rs;

    @Autowired
    private StudentService ss;

    @RequestMapping("/teacher/goToPaperStatistic.action")
    public ModelAndView goToPaperStatistic(HttpSession session){
        Teacher t = (Teacher)session.getAttribute("t");
        int tid = t.getTeacherId();
        List<Student> stus = ts.getUnSubmit(tid);
        ModelAndView mav = new ModelAndView("/teacher/paperStatistic");
        mav.addObject("stus",stus);
        return mav;
    }

    @RequestMapping("/teacher/queryType.action")
    @ResponseBody
    public Map<String,Object> queryType(HttpSession session){
        Teacher t = (Teacher)session.getAttribute("t");
        int tid = t.getTeacherId();
        Map<String,Object> res = ts.getTypeDistribution(tid);
        return res;
    }

    /**
     * @Author starzyn
     * @Description 查询提交的人数
     * @Date 21:11 2020/6/2
     * @Param [session]
     * @return java.util.List<com.starzyn.dto.Submit>
     **/
    @RequestMapping("/teacher/querySubmit.action")
    @ResponseBody
    public List<Submit> querySubmit(HttpSession session){
        Teacher t = (Teacher)session.getAttribute("t");
        int tid = t.getTeacherId();
        List<Submit> res = ts.getSubmit(tid);
        return res;
    }
    
    /**
     * @Author starzyn
     * @Description 更新批改信息
     * @Date 18:29 2020/6/2
     * @Param [m]
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    @RequestMapping("/teacher/updateCheck.action")
    @ResponseBody
    public Map<String,String> updateCheck(@RequestBody Map<String,String> m){
        Check c = new Check();
        c.setCheckStatus(m.get("checkStatus"));
        c.setCheckContent(m.get("checkContent"));
        c.setCheckId(Integer.valueOf(m.get("cid")));
        int res = ts.updateCheck(c);
        Map<String,String> rm = new HashMap<>();
        if(res>0 )rm.put("checkMess","ok");
        else rm.put("checkMess","error");
        return rm;
    }

    /**
     * @Author starzyn
     * @Description 转去论文的批改页面
     * @Date 10:36 2020/6/2
     * @Param [cid, pid]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/teacher/check.action")
    public ModelAndView check(@RequestParam String cid,@RequestParam String pid){
        int paperId = Integer.valueOf(pid);
        int checkid= Integer.valueOf(cid);
        Map<String,String> pdetail = ts.getPaperPath(paperId);
        Check c = ts.getCheck(checkid);
        ModelAndView mav = new ModelAndView("/teacher/check");
        mav.addObject("pdetail",pdetail);
        mav.addObject("check",c);
        return mav;
    }

    
    /**
     * @Author starzyn
     * @Description 转向论文信息页面
     * @Date 10:35 2020/6/2
     * @Param [session]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/teacher/goToPaperCheck.action")
    public ModelAndView goToPaperCheck(HttpSession session){
        Teacher t = (Teacher)session.getAttribute("t");
        int tid = t.getTeacherId();
        List<CheckDetail> details = ts.showCheck(tid);
        ModelAndView mav = new ModelAndView("/teacher/paperCheck");
        mav.addObject("details",details);
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 删除学生的关联信息
     * @Date 21:59 2020/6/1
     * @Param [m, session]
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    @RequestMapping("/teacher/delStudent.action")
    @ResponseBody
    public Map<String,String> delStudent(@RequestBody Map<String,String> m,HttpSession session){
        Teacher t = (Teacher)session.getAttribute("t");
        int tid = t.getTeacherId();
        int stuid = Integer.valueOf(m.get("sid"));
        int res = ts.delStudent(stuid,tid);
        Map<String,String> rm = new HashMap<>();
        if(res>0){
            rm.put("delMess","ok");
        }else {
            rm.put("delMess","error");
        }
        return rm;
    }

    /**
     * @Author starzyn
     * @Description 添加学生到管理页面
     * @Date 21:04 2020/6/1
     * @Param [m, session]
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    @RequestMapping("/teacher/addStudent.action")
    @ResponseBody
    public Map<String,String> addStudent(@RequestBody Map<String,String> m,HttpSession session){
        Teacher t = (Teacher)session.getAttribute("t");
        int tid = t.getTeacherId();
        int sid = Integer.valueOf(m.get("stuId"));
        int res = ts.addStudent(sid,tid);
        Map<String,String> rm = new HashMap<>();
        if(res > 0){
            rm.put("addMess","ok");
        }else {
            rm.put("addMess","error");
        }
        return rm;
    }

    /**
     * @Author starzyn
     * @Description 转到学生管理页面
     * @Date 19:29 2020/6/1
     * @Param [s]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/teacher/goToStudentManager.action")
    public ModelAndView goToStudentManager(HttpSession s){
        Teacher t = (Teacher)s.getAttribute("t");
        int tid = t.getTeacherId();
        List<Student> stus = ts.showStudents(tid);
        ModelAndView mav = new ModelAndView("/teacher/studentManage");
        mav.addObject("stus",stus);
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 再新增学生的功能中查询学生信息
     * @Date 18:43 2020/6/1
     * @Param [m]
     * @return com.starzyn.entity.Student
     **/
    @ResponseBody
    @RequestMapping("/teacher/queryStudent.action")
    public Student queryStudent(@RequestBody Map<String,String> m){
        String stuUsername = m.get("stuUsername");
        return ss.queryByUsername(stuUsername);
    }

    /**
     * @Author starzyn
     * @Description 退出功能
     * @Date 22:00 2020/6/1
     * @Param [session]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/teacher/logout.action")
    public ModelAndView logout(HttpSession session){
        ModelAndView mav = new ModelAndView("/login");
        session.removeAttribute("t");
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 转到论文需求的页面
     * @Date 10:07 2020/6/1
     * @Param [session]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/teacher/goToUploadRequire.action")
    public ModelAndView goToUploadRequire(HttpSession session){
        ModelAndView mav = new ModelAndView("/teacher/paperRequireUpload");
        Teacher t = (Teacher)session.getAttribute("t");
        Require r = rs.showRequire(t.getTeacherId());
        if(r!=null) {//如果没有进行论文需求的上传，就需要新增
            mav.addObject("require", r);
            //添加开始日期
            LocalDate startTime = r.getStartTime();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
            String str1 = startTime.format(dtf);
            mav.addObject("start", str1);
            //添加结束日期
            LocalDate endTime = r.getEndTime();
            String str2 = endTime.format(dtf);
            mav.addObject("end", str2);
            mav.addObject("isNew","no");
        }else {
            mav.addObject("isNew","yes");
        }
        //添加页面标题
        mav.addObject("pageTitle","论文需求上传");
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 转到教师信息页面的请求
     * @Date 9:04 2020/6/1
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/teacher/goToteacherInf.action")
    public ModelAndView goToteacherInf(){
        ModelAndView mav = new ModelAndView("/teacher/teacherInf");
        mav.addObject("pageTitle","教师个人信息");
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 上传论文要求的控制器
     * @Date 9:02 2020/6/1
     * @Param [subject]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/teacher/uploadPaperRequire.action")
    public ModelAndView uploadPaperRequire(
            @RequestParam String isNew,
            @RequestParam(defaultValue = "论文学科科目") String subject,
            @RequestParam(defaultValue = "2020年01月01日") String startTime,
            @RequestParam(defaultValue = "2020年12月31日") String endTime,
            @RequestParam(defaultValue = "论文需求内容") String requires,
           MultipartFile paperRequireFile, HttpSession session) throws IOException {
        //获取会话中当前的教师账号
        Teacher t = (Teacher) session.getAttribute("t");
        Require r = new Require();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate start = LocalDate.parse(startTime,dtf);
        LocalDate end = LocalDate.parse(endTime,dtf);
        r.setRequireSubject(subject);
        r.setRequires(requires);
        r.setStartTime(start);
        r.setEndTime(end);

        //处理上传的文件
        //获取项目文件夹的路径
        String sqlPath =null;
        if(!paperRequireFile.isEmpty()) {
            String url = session.getServletContext().getRealPath("static" + File.separator + "zips");
            String fileName = t.getTeacherId() +"."+ paperRequireFile.getContentType().split("/")[1].split("-")[1];
            System.out.println(paperRequireFile.getContentType());
            String realPath = url + File.separator + fileName;
            sqlPath = File.separator +"aamp" + File.separator + "static" + File.separator + "zips" + File.separator + fileName;
            paperRequireFile.transferTo(new File(realPath));
            r.setModelPath(sqlPath);
        }

        if("yes".equals(isNew)){//如果是新增
            r = rs.addRequire(r,t.getTeacherId());
        }else {
            r = rs.updateRequire(r, t.getTeacherId());
        }
        ModelAndView mav = new ModelAndView("/teacher/paperRequireUpload");
        //添加开始日期
        LocalDate st = r.getStartTime();
        String str1 = st.format(dtf);
        mav.addObject("start",str1);
        //添加结束日期
        LocalDate et = r.getEndTime();
        String str2 = et.format(dtf);
        mav.addObject("end",str2);
        mav.addObject("uploadStatus","ok");
        mav.addObject("require",r);
        mav.addObject("pageTitle","论文需求上传");
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 修改教师个人信息的页面
     * @Date 18:26 2020/5/31
     * @Param [teacherName, sex, acdemic]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/teacher/updateTeacherInfo.action")
    public ModelAndView updateTeacherInfo(
            @RequestParam(required = false) String teacherName,
            @RequestParam(required = false) String sex,
            @RequestParam(required = false) String acdemic,
            HttpSession session){
        Teacher t = (Teacher)session.getAttribute("t");
        t.setTeacherName(teacherName);
        t.setTeacherSex(sex);
        t.setTeacherAcdemic(acdemic);
        ModelAndView mav = new ModelAndView("teacherInf");
        int res = ts.updateInf(t);
        if(res > 0){//如果修改成功
            t = ts.showInf(t.getTeacherId());
        }
        session.setAttribute("t",t);
        return mav;
    }
    
}
