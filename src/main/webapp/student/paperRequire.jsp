<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>论文需求 - AAMP</title>
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.png" type="image/x-ico">
    <meta name="author" content="starzyn">
    <link href="${pageContext.request.contextPath}/css/paperRequire.css" rel="stylesheet">
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

                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="card">
                            <div class="card-header">
                                <h1>各科论文格式要求<p class="text-danger" style="font-size: 10px;">强烈建议在撰写论文前仔细阅读相关论文的格式要求，以免在论文后期造成不必要的麻烦</p></h1>
                                <br/>
                            </div>
                            <div class="card-body">
                                <ul class="nav nav-tabs nav-justified">
                                    <c:forEach items="${rs}" var="r">
                                        <li class="nav-item">
                                            <a data-toggle="tab" href="#${r.requireId}">${r.requireSubject}</a>
                                        </li>
                                    </c:forEach>
                                </ul>

                                <div class="tab-content">
                                    <div class="tab-pane fade active in content" id="${rs[0].requireId}">
                                        <p>
                                            ${rs[0].requires}
                                        </p>
                                        <a class="btn btn-label btn-info" href="${rs[0].modelPath}" download="论文模板.rar"><label><i class="mdi mdi-download"></i></label> 下载模板 </a>
                                    </div>
                                    <c:forEach begin="1" items="${rs}" var="r">
                                        <div class="tab-pane fade content" id="${r.requireId}">
                                            <p>
                                                ${r.requires}
                                            </p>
                                            <a class="btn btn-label btn-info" href="${r.modelPath}" download="论文模板.rar"><label><i class="mdi mdi-download"></i></label> 下载模板 </a>
                                        </div>
                                    </c:forEach>
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
