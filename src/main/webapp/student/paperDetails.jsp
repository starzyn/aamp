<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/2
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>我的论文 - AAMP</title>
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.png" type="image/x-ico">
    <meta name="author" content="starzyn">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <jsp:include page="left.jsp" />
        <jsp:include page="header.jsp"/>

        <!--页面主要内容-->
        <main class="lyear-layout-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-5 col-lg-offset-1">
                        <embed src="${pd.paperPath}" type="application/pdf" width="595px" height="842px"></embed>
                    </div>
                    <div class="col-lg-4 col-lg-offset-1">
                        <div class="row">
                            <div class="card">
                                <div class="card-header bg-primary">
                                    <h1>${pd.paperTitle}</h1>
                                    <ul class="card-actions">
                                        <li>
                                            <button type="button"><i class="mdi mdi-more"></i></button>
                                        </li>
                                    </ul>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="card">
                                            <div class="card-header bg-gray">
                                                <h4>论文类型</h4>
                                            </div>
                                            <div class="card-body">
                                                <p>${pd.paperType}</p>
                                            </div>
                                        </div>
                                        <div class="card">
                                            <div class="card-header bg-gray">
                                                <h4>指导老师</h4>
                                            </div>
                                            <div class="card-body">
                                                <p>${pd.teacherName}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="card">
                                            <div class="card-header bg-gray">
                                                <h4>批改情况</h4>
                                            </div>
                                            <div class="card-body">
                                                <p>${pd.checkStatus}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="card">
                                            <div class="card-header bg-gray">
                                                <h4>指导意见</h4>
                                            </div>
                                            <div class="card-body">
                                                <p>${pd.checkContent}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="card">
                                            <div class="card-header bg-gray">
                                                <h4>开始日期</h4>
                                            </div>
                                            <div class="card-body">
                                                <p>${pd.st}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="card">
                                            <div class="card-header bg-gray">
                                                <h4>截止日期</h4>
                                            </div>
                                            <div class="card-body">
                                                <p>${pd.et}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" style="text-align: center;"><a href="${pd.paperPath}" class="btn-block btn-round btn-primary" download="1.pdf" style="font-size: 20px;">下载论文</a></div>
                                </div>
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
<script type="text/javascript">

</script>
</body>
</html>
