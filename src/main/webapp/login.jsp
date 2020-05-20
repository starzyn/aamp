<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/16
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录</title>
    <link type="text/css" rel="stylesheet" href="css/login.css" />
    <link href="css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var height=$(document).height();
            $('.main').css('height',height);
        })

        function changeImg(){
            //获取当前时间作为种子
            var time = Date.now().toString();
            <%--document.getElementById("validateCode").src = "${pageContext.request.contextPath}/getValidateCode.action?id="+time;--%>
            <%--alert("${pageContext.request.contextPath}/getValidateCode.action?id="+time);--%>
            //每次点击后
            $("#validateCode").attr("src","${pageContext.request.contextPath}/getValidateCode.action?id="+time);

        }
    </script>
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
            <div class="sub"><p>还没有账号？<a href="zhuce.html"><span class="blue">立即注册</span></a></p></div>
            <form action="${pageContext.request.contextPath}/loginForm.action" method="post">
                <div class="txt">
                    <span style="letter-spacing:8px;">用户名:</span>
                    <input name="username" type="text" class="txtphone" placeholder="请输入用户名"/>
                </div>
                <div class="txt">
                    <span style="letter-spacing:4px;">登录密码:</span>
                    <input name="password" type="password" class="txtphone" placeholder="请输入登录密码"/>
                </div>
                <span class="text-danger" style="margin-left: 150px;">${loginMess}</span>
                <div class="txt">
                    <span style=" float:left;letter-spacing:8px;">验证码:</span>
                    <input name="inputCode" type="text" class="txtyzm" placeholder="请输入页面验证码"/>
                    <img src="${pageContext.request.contextPath}/getValidateCode.action" class="yzmimg" id="validateCode" onclick="changeImg()"/>
                </div>
                <span class="text-danger" style="font-size: 5px; width: 50px;">${codeMess}</span>
                <div class="xieyi">
                    <label class="role">
                        <input type="radio" name="role" value="student"/>
                        <span>我是学生</span>
                    </label>
                    <label class="role">
                        <input type="radio" name="role" value="teacher"/>
                        <span>我是教师</span>
                    </label>
                </div>
                <div class="xieyi">
                    <input name="" type="checkbox" value="" checked="checked"/>记住我
                    <a href="password.html"><span class="blue" style=" padding-left:130px; cursor:pointer">忘记密码?</span></a>
                </div>
                <input id="login" class="xiayibu" type="submit" value="登录">
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

