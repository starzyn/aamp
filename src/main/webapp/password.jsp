<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/26
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>忘记密码</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/password.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.min.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/password.js" charset="UTF-8"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var height=$(document).height();
            $('.main').css('height',height);
        })
    </script>
</head>

<body>
<div class="main">
    <div class="main0">
        <div class="formBox">
            <h3>登录密码重置</h3>
            <ul>
                <li class="mainCol firLi">&gt;身份验证</li>
                <li>&gt;&gt;登录密码重置</li>
                <li class="lastLi">&gt;&gt;&gt;重置完成</li>
            </ul>
            <img src="images/line.png" />
            <form action="${pageContext.request.contextPath}/next.action" method="POST" onsubmit="return checkPwd()">
                <input type="hidden" name="target" value="password"/>
                <div class="itembox">
                    <label>邮箱账号&nbsp;:</label>
                    <input type="text" name="username" id="username" placeholder="请输入注册邮箱账号"></span>
                </div>
                <span class="text-danger" style="font-size: 5px; width: 50px;" id="emailMess"></span>
                <div class="btnBox">
                    <input type="submit" value="下一步" class="xiayibu"/>
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

