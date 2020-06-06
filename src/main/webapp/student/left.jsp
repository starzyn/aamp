<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--左侧导航-->
<aside class="lyear-layout-sidebar">

    <!-- logo -->
    <div id="logo" class="sidebar-header">
        <a href="${pageContext.request.contextPath}/student/goToIndex.action"><img src="${pageContext.request.contextPath}/images/logo-sidebar.png" title="AAMP" alt="AAMP" /></a>
    </div>
    <div class="lyear-layout-sidebar-scroll">

        <nav class="sidebar-main">
            <ul class="nav nav-drawer">
                <li class="nav-item active nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-account"></i> 个人信息</a>
                    <ul class="nav nav-subnav">
                        <li><a href="${pageContext.request.contextPath}/student/studentInf.jsp"><i class="mdi mdi-account-card-details"></i> 我的资料</a></li>
                        <li><a href="${pageContext.request.contextPath}/next.action?username=${s.studentUsername}&target=password"><i class="mdi mdi-border-color"></i> 修改密码</a></li>
                    </ul>
                </li>

                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-file-document"></i> 我的论文</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="${pageContext.request.contextPath}/student/goToUpload.action"><i class="mdi mdi-upload"></i> 上传论文</a> </li>
<%--                        <li> <a href="paperDetails.html"><i class="mdi mdi-magnify"></i> 预览论文</a> </li>--%>
                        <li> <a href="${pageContext.request.contextPath}/student/goToIndex.action"><i class="mdi mdi-dropbox"></i> 查看论文审核情况</a> </li>
<%--                        <li> <a href="paperManager.html"><i class="mdi mdi-atom"></i> 论文管理</a> </li>--%>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/student/paperRequire.action"><i class="mdi mdi-eye"></i> 查看论文需求</a> </li>
                </li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/student/latexGuide.jsp"><i class="mdi mdi-file"></i> Latex指南</a></li>
            </ul>
        </nav>

        <div class="sidebar-footer" style="position: absolute;bottom: 5px;">
            <p class="copyright">Copyright &copy; 2020. All rights reserved. Powered By starzyn</p>
        </div>
    </div>

</aside>
<!--End 左侧导航-->
