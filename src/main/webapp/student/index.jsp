<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/20
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>首页 - AAMP</title>
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
        <jsp:include page="header.jsp" />

        <!--页面主要内容-->
        <main class="lyear-layout-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>论文信息</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>~</th>
                                            <th>所属科目</th>
                                            <th>论文名称</th>
                                            <th>论文类型</th>
                                            <th>指导老师</th>
                                            <th>开始日期</th>
                                            <th>截止日期</th>
                                            <th>审核状态</th>
                                            <th>批改进度</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${pcs}" var="pc">
                                            <tr>
                                                <td>#</td>
                                                <td>${pc.paperSubject}</td>
                                                <td><a href="${pageContext.request.contextPath}/student/paperDetails.action?pid=${pc.paperId}">${pc.paperTitle}</a></td>
                                                <td>${pc.paperType}</td>
                                                <td>${pc.teacherName}</td>
                                                <td>${pc.st}</td>
                                                <td>${pc.et}</td>
                                                <c:if test="${pc.checkStatus eq '未批改'}">
                                                    <td><span class="label label-danger">未开始</span></td>
                                                    <td>
                                                        <div class="progress progress-striped progress-sm">
                                                            <div class="progress-bar progress-bar-danger" style="width: 0%;"></div>
                                                        </div>
                                                    </td>
                                                </c:if>
                                                <c:if test="${pc.checkStatus eq '进行中'}">
                                                    <td><span class="label label-warning">进行中</span></td>
                                                    <td>
                                                        <div class="progress progress-striped progress-sm">
                                                            <div class="progress-bar progress-bar-warning" style="width: 30%;"></div>
                                                        </div>
                                                    </td>
                                                </c:if>
                                                <c:if test="${pc.checkStatus eq '批改完成'}">
                                                    <td><span class="label label-success">已完成</span></td>
                                                    <td>
                                                        <div class="progress progress-striped progress-sm">
                                                            <div class="progress-bar progress-bar-success" style="width: 100%;"></div>
                                                        </div>
                                                    </td>
                                                </c:if>
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

</body>
</html>
