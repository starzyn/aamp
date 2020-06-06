<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/26
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/zhuce.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
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
        <div class="main_left">
            <img src="${pageContext.request.contextPath}/images/zhuce-over-3.png" class="theimg"/>
            <img src="${pageContext.request.contextPath}/images/zhuce-over-2.png" class="secimg"/>
            <img src="${pageContext.request.contextPath}/images/zhuce-over-1.png" class="firimg"/>
        </div>
        <div class="main_right">
            <div class="main_r_up">
                <img src="${pageContext.request.contextPath}/images/user.png" />
                <div class="pp">注册</div>
            </div>
            <div class="sub"><p>已经注册？<a href="${pageContext.request.contextPath}/login.jsp"><span class="blue">请登录</span></a></p></div>
            <div>
                <div class="font24"><span class="blue" style=" padding-right:20px">-^0^-</span>注册成功！</div>
            </div>
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

