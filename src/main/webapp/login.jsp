<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录</title>
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.png" type="image/x-ico">
    <link type="text/css" rel="stylesheet" href="css/login.css" />
    <link href="css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/reg-login.js" charset="UTF-8"></script>
</head>

<body>
<div class="main">
    <div class="main0">
        <div class="main_left">
            <img src="images/login-image-3.png" class="theimg"/>
            <img src="images/login-image-2.png" class="secimg"/>
            <img src="images/login-image-1.png" class="firimg"/>
        </div>
        <div class="main_right">
            <div class="main_r_up">
                <img src="images/user.png" />
                <div class="pp">登录</div>
            </div>
            <div class="sub"><p>还没有账号？<a href="register.jsp"><span class="blue">立即注册</span></a></p></div>
            <form action="${pageContext.request.contextPath}/loginForm.action" method="post" onsubmit="return checkLogin()">
                <div class="txt">
                    <span style="letter-spacing:8px;">用户名:</span>
                    <input id="username" name="username" type="text" class="txtphone" placeholder="请输入用户名" value="${cookie.nameCookie.value}"/>
                </div>
                <div class="txt">
                    <span style="letter-spacing:4px;">登录密码:</span>
                    <input id="password" name="password" type="password" class="txtphone" placeholder="请输入登录密码" value="${cookie.pwdCookie.value}"/>
                </div>
                <span class="text-danger" style="margin-left: 150px;">${loginMess}</span>
                <div class="txt">
                    <span style=" float:left;letter-spacing:8px;">验证码:</span>
                    <input id="inputCode" name="inputCode" type="text" class="txtyzm" placeholder="请输入页面验证码"/>
                    <img src="${pageContext.request.contextPath}/getValidateCode.action" class="yzmimg" id="validateCode" onclick="changeImg()"/>
                </div>
                <span class="text-danger" style="font-size: 5px; width: 50px;" id="codeMess"></span>
                <div class="xieyi">
                    <label class="role">
                        <input class="role-input" type="radio" name="roleName" value="student"/>
                        <span>我是学生</span>
                    </label>
                    <label class="role">
                        <input class="role-input" type="radio" name="roleName" value="teacher"/>
                        <span>我是教师</span>
                    </label>
                </div>
                <div class="xieyi">
                    <input name="rememberMe" type="checkbox" value="yes"/>记住我
                    <a href="password.html"><span class="blue" style=" padding-left:130px; cursor:pointer">忘记密码?</span></a>
                </div>
                <input id="login" class="xiayibu" type="submit" value="登录">
<%--                <input id="login" class="xiayibu" type="button" value="登录" onclick="checkCode('aaaa')">--%>
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

