<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/2
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>审批论文 - AAMP</title>
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.png" type="image/x-ico">
    <meta name="author" content="starzyn">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
    <style type="text/css">
        th,td{
            font-size: 16px;
            text-align: center;
            height: 20px;
            line-height: 20px;
        }
    </style>
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
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>学生姓名</th>
                                            <th>班级</th>
                                            <th>论文标题</th>
                                            <th>论文类型</th>
                                            <th>批改状态</th>
                                            <th>#</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${details}" var="detail">
                                            <tr>
                                                <td>${detail.studentName}</td>
                                                <td>${detail.classNum}</td>
                                                <td>${detail.paperTitle}</td>
                                                <td>${detail.paperType}</td>
                                                <c:if test="${detail.checkStatus eq '未批改'}">
                                                    <td><font class="text-warning">未批改</font></td>
                                                </c:if>
                                                <c:if test="${detail.checkStatus eq '进行中'}">
                                                    <td><font class="text-secondary">进行中</font></td>
                                                </c:if>
                                                <c:if test="${detail.checkStatus eq '批改完成'}">
                                                    <td><font class="text-success">批改完成</font></td>
                                                </c:if>
                                                <td class="ops">
                                                    <a class="btn btn-label btn-warning" href="${pageContext.request.contextPath}/teacher/check.action?cid=${detail.checkId}&pid=${detail.paperId}"><label><i class="mdi mdi-pencil"></i></label> 批改审阅 </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Chart.js"></script>
</body>
</html>