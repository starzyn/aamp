<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>学生管理 - AAMP</title>
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
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="card">
                            <div class="card-header">
                                <h3>论文完成情况统计</h3>
                            </div>
                            <div class="card-body">
                                <canvas id="paper-submit"></canvas>
                            </div>
                        </div>

                        <div class="card">
                            <div class="card-header">
                                <h3>论文类别分布</h3>
                            </div>
                            <div class="card-body">
                                <canvas id="paper-category"></canvas>
                            </div>
                        </div>

                        <div class="card">
                            <div class="card-header">
                                <h3>逾期未提交论文</h3>
                            </div>
                            <div class="card-body">
                                <table class="table table-bordered" style="margin: 0 auto;">
                                    <thead>
                                    <th>#</th>
                                    <th>用户名</th>
                                    <th>姓名</th>
                                    <th>学号</th>
                                    <th>学院</th>
                                    <th>班级</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${stus}" var="s" varStatus="i">
                                        <tr>
                                            <th scope="row">${i.index + 1}</th>
                                            <td>${s.studentUsername}</td>
                                            <td>${s.studentName}</td>
                                            <td>${s.studentNum}</td>
                                            <td>${s.acdemic}</td>
                                            <td>${s.classNum}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
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
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
<script type="text/javascript">

    $(function () {
        $.ajax({
            url:"/aamp/teacher/querySubmit.action",
            type:"post",
            dataType:"json",
            contentType : "application/json;charset=utf-8",
            async:false,
            success:function(data){
                //获取日期数组
                var dayarr = new Array();
                for(var i=0;i<data.length;i++){
                    dayarr.push(data[i].day);
                }
                // alert(dayarr);
                //获取每个日期的次数
                var timesarr = new Array();
                for(var i=0;i<data.length;i++){
                    timesarr.push(data[i].submitTimes);
                }
                // alert(timesarr);
                new Chart($("#paper-submit"),{
                    type:'line',
                    data:{
                        labels:dayarr,
                        datasets: [
                            {
                                label: '提交次数',
                                fill: false,
                                borderWidth: 3,
                                pointRadius: 0,
                                data: timesarr
                            }
                        ]
                    },
                    options: {
                        legend: {
                            display: false
                        },
                    }
                });
            },
            error:function () {
                alert("网络异常！");
            }
        });

        $.ajax({
            url:"/aamp/teacher/queryType.action",
            type:"post",
            dataType:"json",
            contentType : "application/json;charset=utf-8",
            async:false,
            success:function(data){
                var types = new Array();
                var counts = new Array();
                for (var key in data) {
                    types.push(key);
                    counts.push(data[key]);
                }
                // alert(types);
                // alert(counts);

                new Chart($("#paper-category"),{
                    type:'bar',
                    data:{
                        labels:types,
                        datasets: [
                            {
                                label: '论文数量',
                                fill: false,
                                borderWidth: 3,
                                pointRadius: 0,
                                data: counts
                            }
                        ]
                    },
                    options: {
                        legend: {
                            display: false
                        },
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero:true
                                }
                            }]
                        }
                    }
                });
            },
            error:function () {
                alert("网络异常！");
            }
        });
    })
</script>
</body>
</html>
