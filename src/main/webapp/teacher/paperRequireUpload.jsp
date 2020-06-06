<%@ page import="java.util.Date" %>
<%@ page import="com.starzyn.entity.Require" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/31
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>论文要求 - AAMP</title>
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.png" type="image/x-ico">
    <meta name="author" content="starzyn">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/paperManager.css" rel="stylesheet">
    <!--时间选择插件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css">
    <!--日期选择插件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap-datepicker/bootstrap-datepicker3.min.css">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <jsp:include page="left.jsp" />
        <jsp:include page="top.jsp" />

        <!--页面主要内容-->
        <main class="lyear-layout-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="card">
                            <div class="card-header" style="text-align: center;">
                                <h1>上传论文要求</h1>
                            </div>
                            <div class="card-body">
                                <form action="${pageContext.request.contextPath}/teacher/uploadPaperRequire.action" method="post" class="row" enctype="multipart/form-data">
                                    <input type="hidden" name="isNew" value="${isNew}">
                                    <input type="hidden" id="uploadStatus" value="${uploadStatus}" onchange="showStatus()">
                                    <div class="form-group col-lg-8 col-lg-offset-2" >
                                        <label for="subject">论文科目名称</label>
                                        <input type="text" class="form-control" id="subject" name="subject" placeholder="请输入科目名称" value="${require.requireSubject}"/>
                                    </div>
                                    <div class="form-group col-lg-8 col-lg-offset-2">
                                        <label for="startTime">论文开始时间</label>
                                        <input type="text" class="form-control js-datepicker" id="startTime" name="startTime" value="${start}" placeholder="请选择开始时间" />
                                    </div>
                                    <div class="form-group col-lg-8 col-lg-offset-2" >
                                        <label for="endTime">论文结束时间</label>
                                        <input type="text" class="form-control js-datepicker" id="endTime" name="endTime" value="${end}" placeholder="请选择结束时间" />
                                    </div>
                                    <div class="form-group col-lg-8 col-lg-offset-2" >
                                        <label for="requires">论文要求</label>
                                        <textarea style="height: 350px;" class="form-control" id="requires" name="requires" placeholder="要求1...">${require.requires}</textarea>
                                    </div>
                                    <div class="form-group col-lg-8 col-lg-offset-2">
                                        <label for="file">请选择模板压缩包 <br/>请上传以 *.zip 结尾的文件</label>
                                        <div class="lyear-uploads-pic" style="text-align: center;">
                                            <!-- <a href="javascript:;" onclick="upload()" style="display: block; width: 200px; height: 200px;text-align: center;line-height: 200px;" class="pic-add" id="pic-add">
                                            </a> -->
                                            <input id="showPath" name="path" class="form-control" readonly="true" style="width: 250px;margin-left: 80px;"/>
                                            <a href="javascript:;" class="btn-secondary" style="position:relative;margin-left: 60px;width: 100px;height: 35px;line-height: 38px;font-size: 15px;">浏览...
                                                <input id="file" name="paperRequireFile" type="file" style="opacity:0; filter:alpha(opacity=0); position:absolute; top:2px; right:0px" onchange="showPath1()"/>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-2 col-lg-offset-8" style="text-align: center;">
                                        <input class="btn btn-primary" type="submit" value="提交" style="height: 40px;width: 100px;margin-top: 15px;">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.min.js"></script>
<!--时间选择插件-->
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker/locale/zh-cn.js"></script>
<!--日期选择插件-->
<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>

<script type="text/javascript">
    function showPath1(){
        // alert("111");
        var path = document.getElementById("showPath");
        var file = document.getElementById("file");
        // alert(file.value);
        path.setAttribute("value",file.value);
    }
    
    $(function(){
        if($("#uploadStatus").val()=="ok"){
            alert("修改成功！");
        }
    })
</script>
</body>
</html>
