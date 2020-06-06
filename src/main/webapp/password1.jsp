<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/26
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>忘记密码</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/password.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/password.js"></script>
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
                <li class="mainCol">&gt;登录密码重置</li>
                <li class="lastLi">&gt;重置完成</li>
            </ul>
            <img src="images/line2.png" />
            <form action="${pageContext.request.contextPath}/modifyPwd.action" method="post" onsubmit="return checkLastPwd()">
                <input type="hidden" name="username" id="username" value="${s.studentUsername}"/>
                <div class="itembox itembox_2">
                    <label>邮箱验证码 &nbsp;:</label>
                    <input name="code" id="code" type="text" placeholder="请输入邮箱验证码" class="yzm"></span>
                    <button class="yzmbox2" onclick="settime(this)">获取到邮箱验证码</button>
                    <span id="emailCodeMess" style="color: red"></span>
                </div>
                <div class="itembox itembox_2">
                    <label>登录密码&nbsp;:</label>
                    <input name="password" id="password" type="password" placeholder="请输入新登录密码" onblur="checkPwd()"></span>
                    <span style="font-size: 5px;color: red;" id="pwdMess"></span>
                    <div style="font-size: 5px;color: gray;">6-12个字符，数字，字母和!@#$%^&*至少包含两种</div>
                </div>
                <div class="itembox itembox_2">
                    <label>确认密码&nbsp;:</label>
                    <input name="repassword" id="repassword" type="password" placeholder="请再次输入新密码" onblur="reCheckPwd()"></span>
                    <div style="font-size: 5px;color: red;" id="rePwdMess"></div>
                </div>
                <div class="btnBox">
                    <input type="submit" value="确认修改" class="xiayibu"/>
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

