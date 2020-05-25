<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册</title>
    <link type="text/css" rel="stylesheet" href="css/zhuce.css" />
    <link type="text/css" rel="stylesheet" href="css/style.min.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/reg-login.js" charset="UTF-8"></script>
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
            <img src="images/zhuce-image-3.png" class="theimg"/>
            <img src="images/zhuce-image-2.png" class="secimg"/>
            <img src="images/zhuce-image-1.png" class="firimg"/>
        </div>
        <div class="main_right">
            <div class="main_r_up">
                <img src="images/user.png" />
                <div class="pp">注册</div>
            </div>
            <div class="sub"><p>已经注册？<a href="login.jsp"><span class="blue">请登录</span></a></p></div>
            <form action="${pageContext.request.contextPath}/sentEmail.action" method="post" onsubmit="return checkReg()">
                <div class="txt">
                    <span style="letter-spacing:10px;">邮箱账号:</span>
                    <input id="username" name="username" type="text" class="txtphone" placeholder="请输入邮箱账号" onblur="checkEmail()"/>
                </div>
                <span class="text-danger" style="font-size: 5px; width: 50px;" id="emailMess"></span>
                <div class="txt">
                    <span style=" float:left;letter-spacing:10px;">验证码:</span>
                    <input id="inputCode" name="inputCode" type="text" class="txtyzm" placeholder="请输入验证码"/>
                    <img id="validateCode" src="${pageContext.request.contextPath}/getValidateCode.action" class="yzmimg" onclick="changeImg()"/>
                </div>
                <span class="text-danger" style="font-size: 5px; width: 50px;" id="codeMess"></span>
                <div class="xieyi">
                    <input id="xieyi" name="xieyi" type="checkbox" value="yes" checked="checked"/>
                    我已经阅读并遵守 <span class="blue" style="cursor:pointer">《高系学术成果平台服务协议》</span>
                </div>
                <input type="submit"  value="下一步 > " class="xiayibu"/>
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

