<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/zhuce.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/reg-login.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var height=$(document).height();
            $('.main').css('height',height);
            $('[data-toggle="tooltip"]').tooltip();
        })

    </script>
</head>

<body>
<div class="main">
    <div class="main0">
        <div class="main_left">
            <img src="${pageContext.request.contextPath}/images/zhuce-image-3.png" class="theimg"/>
            <img src="${pageContext.request.contextPath}/images/zhuce-image-2.png" class="secimg"/>
            <img src="${pageContext.request.contextPath}/images/zhuce-image-1.png" class="firimg"/>
        </div>
        <div class="main_right">
            <div class="main_r_up">
                <img src="images/user.png" />
                <div class="pp">注册</div>
            </div>
            <div class="sub"><p>已经注册？<a href="${pageContext.request.contextPath}/login.jsp"><span class="blue">请登录</span></a></p></div>
            <form action="${pageContext.request.contextPath}/register.action" method="post" onsubmit="return checkLastReg()">
                <input type="hidden" name="username" id="username" value="${username}"/>
                <div class="txt txt0">
                    <span style="float:left">邮箱验证码:</span>
                    <input name="code" id="code" type="text" placeholder="请输入邮箱验证码" class="txtyzmdx"/>
                    <button class="tipTimer" onclick="settime(this)">获取到邮箱验证码</button>
                </div>
                <div class="txt txt0">
                    <span style="letter-spacing:4px;">登录密码:</span>
                    <input name="password" id="password" type="password" class="txtphone" placeholder="请输入密码" onblur="checkPwd()"/>
                    <span style="font-size: 5px;color: red;" id="pwdMess"></span>
                    <div style="font-size: 5px;color: gray;">6-12个字符，数字，字母和!@#$%^&*至少包含两种</div>
                </div>
                <div class="txt txt0">
                    <span style="letter-spacing:4px;">重复密码:</span>
                    <input name="repassword" id="repassword" type="password" class="txtphone" placeholder="请再次输入密码" onblur="reCheckPwd()"/>
                    <!-- <span style="font-size: 5px;color: red;">两次密码不一致！</span> -->
                    <div style="font-size: 5px;color: red;" id="rePwdMess"></div>
                </div>
                <div class="txt txt0">
                    <a href="register.jsp"><span style=" float:left;color:#31acfb">返回上一步</span></a>
                    <input type="submit" value="确认注册" class="zhucebtn"/>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="footer">
    <div class="footer0">
        <div class="footer_l">使用条款 | 隐私保护</div>
        <div class="footer_r">© 2020 powered by starzyn</div>
    </div>
</div>
</body>
</html>

