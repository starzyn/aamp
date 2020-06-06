<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        form label{
            margin-left: 15px;
        }

        .form-group h4{
            font-family: "楷体";
            margin-left: 15px;
        }

        .form-group{
            margin-top: 30px;
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
                    <div class="col-lg-5 col-lg-offset-1">
                        <embed src="${pdetail.paper_path}" type="application/pdf" width="595px" height="842px"></embed>
                    </div>
                    <div class="col-lg-5 col-lg-offset-1">
                        <div class="card">
                            <div class="card-header">
                                <h3>论文题目：${pdetail.paper_title}</h3>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" action="${pageContext.request.contextPath}/teacher/updateCheck.action?cid=${check.checkId}" method="post">
<%--                                    <input type="hidden" id="checkMess" value="${checkMess}"/>--%>
                                    <input type="hidden" id="cid" value="${check.checkId}" />
                                    <div class="form-group">
                                        <h4>设置评改状态</h4>
                                        <label class="lyear-radio radio-inline radio-warning">
                                            <input type="radio" name="status" class="form-control" value="未批改" <c:if test="${check.checkStatus eq '未批改'}">checked</c:if> ><span>未批改</span>
                                        </label>
                                        <label class="lyear-radio radio-inline radio-primary">
                                            <input type="radio" name="status" class="form-control" value="进行中" <c:if test="${check.checkStatus eq '进行中'}">checked</c:if> ><span>进行中</span>
                                        </label>
                                        <label class="lyear-radio radio-inline radio-success">
                                            <input type="radio" name="status" class="form-control" value="批改完成" <c:if test="${check.checkStatus eq '批改完成'}">checked</c:if> ><span>批改完成</span>
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <h4>论文评语</h4>
                                        <textarea style="width: 450px;height: 500px;margin: 0px auto;" class="form-control" id="comment" name="checkContent" rows="6" placeholder="评语内容..">${check.checkContent}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-6" style="text-align: center;">
                                            <button type="button" class="btn btn-primary" onclick="updateCheck()">提交</button>
                                        </div>
                                        <div class="col-lg-6" style="text-align: center;">
                                            <button type="reset" class="btn btn-secondary">重置</button>
                                        </div>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Chart.js"></script>
<script>
    $(function () {
        if($("#checkMess")=="ok") alert("批改成功！");
    });

    function updateCheck(){
        var saveData = JSON.stringify({"checkStatus":$("input[name='status']:checked").val(),"checkContent":$("#comment").val(),"cid":$("#cid").val()});
        // alert(saveData);
        $.ajax({
            url:"/aamp/teacher/updateCheck.action",
            type:"post",
            dataType:"json",
            contentType : "application/json;charset=utf-8",
            data:saveData,
            async:false,
            success:function(data){
                if(data.checkMess=="ok"){
                    alert("完成批改！");
                    location.reload();
                }else {
                    alert("批改失败！")
                }
            },
            error:function () {
                alert("网络出现问题，请重试");
            }
        });
    }
</script>
</body>
</html>
