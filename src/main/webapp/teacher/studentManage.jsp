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
    <link href="${pageContext.request.contextPath}/css/paperManager.css" rel="stylesheet">
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
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header"><button data-toggle="modal" data-target="#stuInf" type="button" class="btn btn-label btn-success" style="margin-right: 20px;float: right;" ><label><i class="mdi mdi-tab-plus"></i></label> 新增 </button></div>
                            <div class="modal fade" id="stuInf" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title">请输入学生用户名</h4>
                                        </div>
                                        <form>
                                            <div class="modal-body">
                                                <input type="text" id="stuUsername" name="stuUsername"/>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button id="submitt" data-toggle="modal" type="button" class="btn btn-success" data-dismiss="modal" onclick="query()">查询</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="modal fade" id="stuRes" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="">查询到学生信息：</h4>
                                        </div>
                                        <form>
                                            <input type="hidden" id="stuId" />
                                            <div class="modal-body">
                                                <table class="table-bordered">
                                                    <thead>
                                                    <th>姓名</th>
                                                    <th>学号</th>
                                                    <th>学院</th>
                                                    <th>班级</th>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td id="stuName"></td>
                                                        <td id="stuNum"></td>
                                                        <td id="stuAcdemic"></td>
                                                        <td id="stuClass"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-success" data-dismiss="modal" onclick="addStudent()">添加</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>学号</th>
                                            <th>姓名</th>
                                            <th>用户名</th>
                                            <th>所属学院</th>
                                            <th>班级</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${stus}" var="stu">
                                            <tr>
                                                <td>${stu.studentNum}</td>
                                                <td>${stu.studentName}</td>
                                                <td>${stu.studentUsername}</td>
                                                <td>${stu.acdemic}</td>
                                                <td>${stu.classNum}</td>
                                                <td class="ops">
                                                    <a class="btn btn-label btn-danger" href="javascript:void(0)" onclick="delStudent(${stu.studentId})"><label><i class="mdi mdi-delete"></i></label> 删除</a>
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
<script type="text/javascript">
    function query(){
        var flag = false;
        var saveData = JSON.stringify({"stuUsername":$("#stuUsername").val()});
        $.ajax({
            url:"/aamp/teacher/queryStudent.action",
            type:"post",
            dataType:"json",
            contentType : "application/json;charset=utf-8",
            data:saveData,
            async:false,
            success:function(data){
                if(data.studentId==undefined || data.studentId==""){
                    alert("查询不到该学生的信息！");
                    flag = false;
                }else {
                    $("#stuName").text(data.studentName);
                    $("#stuNum").text(data.studentNum);
                    $("#stuAcdemic").text(data.acdemic);
                    $("#stuClass").text(data.classNum);
                    $("#stuId").val(data.studentId);
                    flag = true;
                }
            },
            error:function () {
                alert("查询不到该学生的信息！");
                flag = false;
            }
        });
        if(flag){
            var inf = document.getElementById("submitt");
            inf.setAttribute("data-target","#stuRes");
        }
    }

    function addStudent(){
        //获取查询到的学生id
        var saveData = JSON.stringify({"stuId":$("#stuId").val()});
        $.ajax({
            url:"/aamp/teacher/addStudent.action",
            type:"post",
            dataType:"json",
            contentType : "application/json;charset=utf-8",
            data:saveData,
            async:false,
            success:function(data){
                if(data.addMess=="ok"){
                    alert("添加成功");
                    location.reload();
                }
            },
            error:function () {
                alert("添加失败！");
            }
        });
    }
    
    function delStudent(sid) {
        var saveData = JSON.stringify({"sid":sid});
        $.ajax({
            url:"/aamp/teacher/delStudent.action",
            type:"post",
            dataType:"json",
            contentType : "application/json;charset=utf-8",
            data:saveData,
            async:false,
            success:function(data){
                if(data.delMess=="ok"){
                    alert("删除成功");
                    location.reload();
                }
            },
            error:function () {
                alert("删除失败！");
            }
        });
    }
</script>
</body>
</html>