package com.starzyn.controller;

import com.starzyn.dao.StudentDao;
import com.starzyn.dto.PaperCheck;
import com.starzyn.dto.PaperDetail;
import com.starzyn.dto.SubjectList;
import com.starzyn.entity.Paper;
import com.starzyn.entity.Require;
import com.starzyn.entity.Student;
import com.starzyn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author starzyn
 * @className:StudentInfoController
 * @date : 2020/5/27
 * @description: 学生管理信息页面的控制器
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService ss;

    @RequestMapping("/student/paperRequire.action")
    public ModelAndView paperRequire(HttpSession session){
        Student s = (Student)session.getAttribute("s");
        int sid = s.getStudentId();
        List<Require> rs = ss.queryRequire(sid);
        ModelAndView mav = new ModelAndView("/student/paperRequire");
        mav.addObject("rs",rs);
        mav.addObject("pageTitle","论文需求详情");
        return mav;
    }

    @RequestMapping("/student/paperDetails.action")
    public ModelAndView paperDetails(@RequestParam String pid,HttpSession session){
        Student s = (Student)session.getAttribute("s");
        int sid = s.getStudentId();
        int ppid = Integer.valueOf(pid);
        PaperDetail pd = ss.getPaperDetail(sid,ppid);
        ModelAndView mav = new ModelAndView("/student/paperDetails");
        mav.addObject("pd",pd);
        mav.addObject("pageTitle","论文详情页面");
        return mav;
    }

    @RequestMapping("/student/goToIndex.action")
    public ModelAndView goToIndex(HttpSession session){
        Student s = (Student)session.getAttribute("s");
        int sid = s.getStudentId();
        List<PaperCheck> pcs = ss.showPaperCheck(sid);
        ModelAndView mav = new ModelAndView("/student/index");
        mav.addObject("pcs",pcs);
        return mav;
    }

    @RequestMapping("/student/uploadPaper.action")
    public String uploadPaper(@RequestParam String subject,
                                    @RequestParam(required = false) String title,
                                    @RequestParam(required = false) String type,
                                    MultipartFile paperFile, HttpSession session, Model model) throws IOException {
        Paper p = new Paper();
        if(title!=null) p.setPaperTitle(title);
        if(type!=null) p.setPaperType(type);
        Student s = (Student)session.getAttribute("s");
        int sid = s.getStudentId();
        //处理复合字符串
        String sub = subject.split("-")[0];
        int tid = Integer.valueOf(subject.split("-")[1]);
        //处理上传的文件
        //获取项目文件夹的路径
        String sqlPath =null;
        if(!paperFile.isEmpty()) {
            String url = session.getServletContext().getRealPath("static" + File.separator + "pdfs");
            String fileName = sid + "-" + tid +"."+ paperFile.getContentType().split("/")[1];
            String realPath = url + File.separator + fileName;
            sqlPath = File.separator +"aamp" + File.separator + "static" + File.separator + "pdfs" + File.separator + fileName;
            paperFile.transferTo(new File(realPath));
            p.setPaperPath(sqlPath);
        }
        p.setPaperSubject(sub);
        p.setSubmitTime(LocalDate.now());
        p.setAuthor(s.getStudentName());
        int res = ss.uploadPaper(tid,sid,p);
        ModelAndView mav = new ModelAndView("/student/upload");
        if(res > 0){
            model.addAttribute("status","ok");
        }
        return "forward:/student/goToUpload.action";
    }

    /**
     * @Author starzyn
     * @Description 转去上传论文的页面
     * @Date 19:59 2020/5/29
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/student/goToUpload.action")
    public ModelAndView goToUpload(HttpSession session){
        Student s = (Student)session.getAttribute("s");
        //获取学生id
        int tid = s.getStudentId();
        List<SubjectList> subjects = ss.querySubjects(tid);
        ModelAndView mav = new ModelAndView("/student/upload");
        mav.addObject("subjects",subjects);
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 学生账号退出
     * @Date 21:31 2020/5/28
     * @Param [request, session]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/student/logout.action")
    public ModelAndView logout(HttpServletRequest request,HttpSession session){
        String loginPath = request.getContextPath();
        session.removeAttribute("s");
        ModelAndView mav = new ModelAndView("/login");
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 在个人信息页面更新个人信息数据
     * @Date 21:26 2020/5/28
     * @Param [remark, sex, school, acdemic, classNum, studentNum, major, studentName, headImg, session, request]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/student/updateStudentInfo.action")
    public ModelAndView updateStudentInfo(
            @RequestParam(defaultValue = "个性签名") String remark,
            @RequestParam(defaultValue = "male") String sex,
            @RequestParam(defaultValue = "学校名称") String school,
            @RequestParam(defaultValue = "学院名称") String acdemic,
            @RequestParam(defaultValue = "班级") String classNum,
            @RequestParam(defaultValue = "学号") String studentNum,
            @RequestParam(defaultValue = "专业名称")String major,
            @RequestParam(defaultValue = "姓名") String studentName,
            MultipartFile headImg,
            HttpSession session,HttpServletRequest request) throws IOException {
        //设置学生信息
        Student s = (Student)session.getAttribute("s");
//        s.setStudentUsername(username);
        s.setStudentName(studentName);
        s.setSchool(school);
        s.setStudentSex(sex);
        s.setAcdemic(acdemic);
        s.setStudentNum(studentNum);
        s.setClassNum(classNum);
        s.setMajor(major);
        s.setRemark(remark);
//        ss.updateStudentInfo(s);
        //处理上传的文件
        //获取项目文件夹的路径
        String sqlPath =null;
        if(!headImg.isEmpty()) {
            String url = request.getSession().getServletContext().getRealPath("static" + File.separator + "imgs");
            String fileName = s.getStudentId() +"."+ headImg.getContentType().split("/")[1];
            String realPath = url + File.separator + fileName;
            sqlPath = File.separator +"aamp" + File.separator + "static" + File.separator + "imgs" + File.separator + fileName;
            headImg.transferTo(new File(realPath));
            s.setUserImg(sqlPath);
        }
//        s.setUserImg(sqlPath);
        //数据库写入
        ss.updateStudentInfo(s);
        //把更新后的信息展示出来
        s = ss.showInfo(s.getStudentId());
        session.setAttribute("s",s);
        ModelAndView mav = new ModelAndView("studentInf");
        return mav;
    }
//    @RequestMapping("/uploadHeadImg.action")
//    public ModelAndView upload(@RequestParam String username, @RequestParam String password, @RequestParam(required = false)  MultipartFile headImg, HttpServletRequest request) throws IOException {
//        System.out.println("username" + username);
//        System.out.println("password" + password);
//        System.out.println("fileTyep" + headImg.getContentType().split("/")[1]);
//        String url = request.getSession().getServletContext().getRealPath("static"+File.separator+"imgs");
//        System.out.println(url);
//        String fileName = username+"."+headImg.getContentType().split("/")[1];
//        System.out.println("fileName" + fileName);
//        headImg.transferTo(new File(url+File.separator+fileName));
//        return null;
//    }
}
