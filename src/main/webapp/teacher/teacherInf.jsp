<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/27
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>个人中心 - AAMP</title>
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
        <jsp:include page="top.jsp" />

        <!--页面主要内容-->
        <main class="lyear-layout-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 col-lg-offset-3">
                        <div class="card">
                            <div class="card-body">
                                <form action="${pageContext.request.contextPath}/teacher/updateTeacherInfo.action" method="post" class="row">
                                    <div class="form-group col-lg-6 col-lg-offset-3">
                                        <label for="username">用户名</label>
                                        <input type="text" class="form-control" id="username" name="username" value="${t.teacherUsername}" readonly/>
                                    </div>
                                    <div class="form-group col-lg-6 col-lg-offset-3">
                                        <label for="studentName">姓 名</label>
                                        <input type="text" class="form-control" id="studentName" name="teacherName" value="${t.teacherName}"/>
                                    </div>
                                    <div class="form-group col-lg-6 col-lg-offset-3">
                                        <label for="sex">性别</label>
                                        <c:if test="${t.teacherSex eq 'male'}">
                                            <div class="clearfix" id="sex">
                                                <label class="lyear-radio radio-inline radio-primary">
                                                    <input type="radio" name="sex" value="male" checked><span>男</span>
                                                </label>
                                                <label class="lyear-radio radio-inline radio-primary">
                                                    <input type="radio" name="sex" value="female"><span>女</span>
                                                </label>
                                            </div>
                                        </c:if>
                                        <c:if test="${t.teacherSex eq 'female'}">
                                            <div class="clearfix" id="sex">
                                                <label class="lyear-radio radio-inline radio-primary">
                                                    <input type="radio" name="sex" value="male"><span>男</span>
                                                </label>
                                                <label class="lyear-radio radio-inline radio-primary">
                                                    <input type="radio" name="sex" value="female" checked><span>女</span>
                                                </label>
                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="form-group col-lg-6 col-lg-offset-3">
                                        <label for="acdemic">所属院系</label>
                                        <input type="text" class="form-control" id="acdemic" name="acdemic" value="${t.teacherAcdemic}"/>
                                    </div>
                                    <div class="form-group col-lg-6 col-lg-offset-3">
                                        <input type="submit" class="btn btn-primary" value="提 交"/>
                                        <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>
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

</body>
</html>
