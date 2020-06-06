<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--左侧导航-->
<aside class="lyear-layout-sidebar">

    <!-- logo -->
    <div id="logo" class="sidebar-header">
        <a href="${pageContext.request.contextPath}/teacher/goToteacherInf.action"><img src="${pageContext.request.contextPath}/images/logo-sidebar.png" title="AAMP" alt="AAMP" /></a>
    </div>
    <div class="lyear-layout-sidebar-scroll">

        <nav class="sidebar-main">
            <ul class="nav nav-drawer">
                <li class="nav-item active">
                    <a href="${pageContext.request.contextPath}/teacher/goToteacherInf.action"><i class="mdi mdi-account"></i> 教师信息管理 </a>
                </li>
                <li class="nav-item active">
                    <a href="${pageContext.request.contextPath}/teacher/goToStudentManager.action"><i class="mdi mdi-account"></i> 学生管理 </a>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-file-document"></i> 论文 </a>
                    <ul class="nav nav-subnav">
                        <li> <a href="${pageContext.request.contextPath}/teacher/goToPaperStatistic.action"><i class="mdi mdi-trending-up"></i> 论文统计 </a> </li>
                        <li> <a href="${pageContext.request.contextPath}/teacher/goToPaperCheck.action"><i class="mdi mdi-magnify"></i> 批改论文 </a> </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/teacher/goToUploadRequire.action"><i class="mdi mdi-eye"></i> 上传论文要求 </a> </li>
                </li>
            </ul>
        </nav>

        <div class="sidebar-footer" style="position: absolute;bottom: 5px;">
            <p class="copyright">Copyright &copy; 2020. All rights reserved. Powered By starzyn</p>
        </div>
    </div>

</aside>
<!--End 左侧导航-->
