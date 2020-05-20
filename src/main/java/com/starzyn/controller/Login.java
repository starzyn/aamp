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
import com.starzyn.service.StudentService;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

@Controller
public class Login {
    @Autowired
    StudentService ss;



    @RequestMapping("/loginForm.action")
    public ModelAndView loginForm(HttpSession session, @RequestParam String username,@RequestParam String password,@RequestParam String inputCode, @RequestParam String role){
        String codeText = (String)session.getAttribute("code");
        ModelAndView mav = new ModelAndView("login");
        if(inputCode.equalsIgnoreCase(codeText)){//如果验证码正确
            Student s = ss.login(username,password);
            if(s!=null){
                System.out.println(s.toString());
                session.setAttribute("s",s);
                mav.setViewName("student/index");
                return mav;
            }
            mav.addObject("loginMess","用户名或密码不正确，请重新输入");
            return mav;
        }
        mav.addObject("codeMess","验证码输入错误，请重新输入");
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
        ValidateCodeFactory vcf = new ValidateCodeFactory(80,40,4);
        ValidateCode vc = vcf.getValidateCode();
        session.setAttribute("code",vc.getCodeText());
        vc.output(resp.getOutputStream());
    }
}
