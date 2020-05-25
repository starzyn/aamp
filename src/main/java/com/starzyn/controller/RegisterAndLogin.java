/**
 * @ClassName Login
 * @Description TODO
 * @Author Administrator
 * @Date 2020/5/16 22:56
 * @Version 1.0
 */
package com.starzyn.controller;

import com.starzyn.ValidateCode;
import com.starzyn.ValidateCodeFactory;
import com.starzyn.entity.Student;
import com.starzyn.entity.Teacher;
import com.starzyn.service.StudentService;
import com.starzyn.service.TeacherService;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Controller
public class RegisterAndLogin {
    @Autowired
    StudentService ss;

    @Autowired
    TeacherService ts;

    @Autowired
    ValidateCodeFactory vcf;

    /**
     * @author starzyn
     * @date 2020/5/22
     * @param [session, resp, username, password, inputCode, roleName, rememberMe]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/loginForm.action")
    public ModelAndView loginForm(HttpSession session,HttpServletResponse resp, @RequestParam String username, @RequestParam String password, @RequestParam String inputCode, @RequestParam String roleName, @RequestParam(required = false) String rememberMe){
        String codeText = (String)session.getAttribute("code");
        ModelAndView mav = new ModelAndView("login");
        if(inputCode.equalsIgnoreCase(codeText.trim())){//如果验证码正确
            if("student".equals(roleName)){//如果角色是学生
                Student s = ss.login(username.trim(),password.trim());
                if(s!=null){//登陆成功
//                    System.out.println(rememberMe);
                    if(rememberMe!=null) {
                        //记住我功能
                        Cookie cookie1 = new Cookie("nameCookie", username);
                        Cookie cookie2 = new Cookie("pwdCookie", password);
                        cookie1.setMaxAge(10 * 3600);
                        cookie2.setMaxAge(10 * 3600);
                        resp.addCookie(cookie1);
                        resp.addCookie(cookie2);
                    }
//                    System.out.println(s.toString());
                    session.setAttribute("s",s);
                    mav.addObject("pageTitle","论文审核情况");
                    mav.setViewName("student/index");
                    return mav;
                }
                mav.addObject("loginMess","用户名或密码不正确，请重新输入");
                return mav;
            }else{//如果角色是教师
                Teacher t = ts.login(username.trim(),password.trim());
                if(null!=t){
                    if(rememberMe!=null) {
                        //记住我功能
                        Cookie cookie1 = new Cookie("nameCookie", username);
                        Cookie cookie2 = new Cookie("pwdCookie", password);
                        cookie1.setMaxAge(10 * 3600);
                        cookie2.setMaxAge(10 * 3600);
                        resp.addCookie(cookie1);
                        resp.addCookie(cookie2);
                    }
                    session.setAttribute("t",t);
                    mav.setViewName("teacher/studentManage");
                    mav.addObject("pageTitle","学生信息管理");
                    return mav;
                }
                mav.addObject("loginMess","用户名或密码不正确，请重新输入");
                return mav;
            }
        }
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 获取验证码请求的处理器
     * @Date 22:30 2020/5/19
     * @Param [req, resp, pc]
     * @return void
     **/
    @RequestMapping("/getValidateCode.action")
    public void getValidateCode(HttpServletResponse resp,HttpSession session) throws IOException {
        ValidateCode vc = vcf.getValidateCode();
        session.setAttribute("code",vc.getCodeText());
        vc.output(resp.getOutputStream());
    }

    /**
     * @Author starzyn
     * @Description 验证登陆时输入的验证码是否正确，讲验证码结果来传递到前端
     * @Date 15:58 2020/5/25
     * @Param [m, session]
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    @RequestMapping("/checkCode.action")
    @ResponseBody
    public Map<String,String> checkCode(@RequestBody Map<String,String> m,HttpSession session){
//        System.out.println("++++++++++++");
//        System.out.println(m.get("code"));
        //获取Ajax发送过来的数据
        String inputCode = m.get("code");
        //获取session中的验证码
        String res = (String)session.getAttribute("code");

        Map map = new HashMap();
        if(res.equalsIgnoreCase(inputCode)){
            map.put("codeMess","1");
        }else {
            map.put("codeMess","0");
        }
        return map;
    }

    /**
     * @Author starzyn
     * @Description 用来异步检查注册时所输入的邮箱是否已经被注册过
     * @Date 15:59 2020/5/25
     * @Param [m, session]
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    @RequestMapping("/checkEmail.action")
    @ResponseBody
    public Map<String,String> checkEmail(@RequestBody Map<String,String> m,HttpSession session){
        String email = m.get("email");
        System.out.println("email ====" + email);
        Student[] s = ss.checkEmail(email);
        Map<String,String> map = new HashMap<>();
        if(s.length!=0){
            map.put("emailMess","0");
        }else{
            //把正确的邮箱存放在session中，方便后面的数据库写入
            session.setAttribute("email",email);
            map.put("emailMess","1");
        }
        return map;
    }

    /**
     * @Author starzyn
     * @Description 在注册的第一步中，点击下一步进行发送邮箱验证码,并且进入第二步的页面
     * @Date 16:09 2020/5/25
     * @Param [username]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/sentEmail.action")
    public ModelAndView sentEmail(@RequestParam String username){
        ModelAndView mav = new ModelAndView("register1");//设置注册的第二步的视图页面
        mav.addObject("username",username);
        String code = sentCode(username);
        mav.addObject("code",code);
        return mav;
    }

    /**
     * @Author starzyn
     * @Description 参数是注册用户的邮箱，用来发送验证码供第二步输入使用
     * @Date 16:11 2020/5/25
     * @Param [targetEmail]
     * @return java.lang.String
     **/
    public String sentCode(String targetEmail){
        String from = "starzyn@qq.com";//设置发信人的邮箱
        String host = "smtp.qq.com";//设置发送邮件的服务器，QQ:smtp.qq.com  网易：smtp.163.com

        Properties properties = System.getProperties();// 获取系统属性

        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证
        String code = null;//用户存放生成的验证码然后返回
        try {
            //QQ 邮箱才使用这一段代码，而其他邮箱未测试，不清楚是否需要加上
            MailSSLSocketFactory sf = new MailSSLSocketFactory();//创建SSL套接字对象
            sf.setTrustAllHosts(true);//信任所有的主机
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("starzyn@qq.com", "tfuvamejbtchddbg"); // 发件人邮箱账号、授权码
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(targetEmail));
            // 2.3设置邮件主题
            message.setSubject("注册验证码");
            //生成随机验证码
            ValidateCode vc = vcf.getValidateCode();
            //获取验证码对象中的验证码字符串
            code = vc.getCodeText();
            // 2.4设置邮件内容
            String content = "<h1>亲爱的用户： 您好！</h1>\n" +
                    "\t\t<h2>您正在注册高校学术成果管理平台(AAMP)的用户，请在邮箱验证码输入框中输入： <em style=\"color: red;\">" + code + "</em>，以完成操作。</h2>\n" +
                    "\t\t<hr>\n" +
                    "\t\t<p>注意：此操作可能会修改您的密码、登录邮箱或绑定手机。如非本人操作，请及时登录并修改密码以保证帐户安全</p>\n" +
                    "\t\t<small>（工作人员不会向你索取此验证码，请勿泄漏！)</small>";
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

}
