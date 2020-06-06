<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>论文管理 - AAMP</title>
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.png" type="image/x-ico">
    <meta name="author" content="starzyn">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
    <script type="text/javascript">
        function showPath1(){
            // alert("111");
            var path = document.getElementById("showPath");
            var file = document.getElementById("file");
            // alert(file.value);
            path.setAttribute("value",file.value);

        }
    </script>
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <jsp:include page="left.jsp"></jsp:include>
        <jsp:include page="header.jsp"></jsp:include>

        <!--页面主要内容-->
        <main class="lyear-layout-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2" style="margin-top: 120px;">
                        <div class="card">
                            <div class="card-header" style="text-align: center;">
                                <h1>论文基本信息</h1>
                            </div>
                            <div class="card-body">
                                <form action="${pageContext.request.contextPath}/student/uploadPaper.action" method="post" class="row" enctype="multipart/form-data">
                                    <input type="hidden" id="status" value="${status}"/>
                                    <div class="form-group col-lg-8 col-lg-offset-2" >
                                        <label for="subject">论文科目</label>
                                        <div class="form-controls">
                                            <select name="subject" class="form-control" id="subject">
                                                <c:forEach items="${subjects}" var="s">
                                                    <option value="${s.requireSubject}-${s.teacherId}">${s.requireSubject}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-8 col-lg-offset-2">
                                        <label for="title">论文标题</label>
                                        <input type="text" class="form-control" id="title" name="title" value="" placeholder="请输入标题" />
                                    </div>
                                    <div class="form-group col-lg-8 col-lg-offset-2" >
                                        <label for="type">论文类型</label>
                                        <div class="form-controls">
                                            <select name="type" class="form-control" id="type">
                                                <option value="描述型论文">描述型论文</option>
                                                <option value="综述型论文">综述型论文</option>
                                                <option value="应用型论文">应用型论文</option>
                                                <option value="实验型论文">实验型论文</option>
                                                <option value="专题型论文">专题型论文</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-8 col-lg-offset-2">
                                        <label for="file">请选择文件 <br/>请上传以 *.pdf 结尾的文件</label>
                                        <div class="lyear-uploads-pic" style="text-align: center;">
                                            <!-- <a href="javascript:;" onclick="upload()" style="display: block; width: 200px; height: 200px;text-align: center;line-height: 200px;" class="pic-add" id="pic-add">
                                            </a> -->
                                            <input id="showPath" name="path" class="form-control" readonly="true" style="width: 250px;margin-left: 80px;"/>
                                            <a href="javascript:;" class="btn-secondary" style="position:relative;margin-left: 60px;width: 100px;height: 35px;line-height: 38px;font-size: 15px;">浏览...
                                                <input id="file" name="paperFile" type="file" style="opacity:0; filter:alpha(opacity=0); position:absolute; top:2px; right:0px" onchange="showPath1()"/>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-8 col-lg-offset-2" style="text-align: center;">
                                        <input class="btn btn-primary" type="submit" value="提交论文" style="height: 40px;width: 100px;margin-top: 15px;">
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
<script>
    $(function () {
        if($("#status").val()=="ok") alert("修改成功！");
    })
</script>
</body>
</html>
