<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <%--<base href="<%=basePath%>">--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../assets/css/animate.min.css" rel="stylesheet"/>
    <link href="../assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
    <link href="../assets/css/demo.css" rel="stylesheet"/>
    <link href="../css/font-awesome.min.css" rel="stylesheet">
    <link href='../css/googleapis.css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="../assets/css/pe-icon-7-stroke.css" rel="stylesheet"/>
    <style type="text/css">
        .comments {
            width: 95%; /*自动适应父布局宽度*/
            overflow: auto;
            word-break: break-all;
        }

        .tr .td {
            border: 1px solid red;
        }
    </style>
    <title>Insert title here</title>
</head>
<body>
<div>
    <jsp:include page="./header.jsp"/>
</div>
<div class="wrapper">
    <div class="sidebar" data-color="purple">

        <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


        <div class="sidebar-wrapper">
            <%-- <div class="logo">
                <a href="#" class="simple-text"> <s:property value="#session.student.studentName"/> </a>
            </div> --%>
            <div class="card card-user">
                <div class="image">
                    <img src="<%=basePath%>/assets/img/userBack.jpg"
                         alt="..."/>
                </div>
                <div class="content">
                    <div class="author">
                        <a href="#">
                            <img class="avatar border-gray" src="<%=basePath%>/assets/img/faces/face-0.jpg" alt="..."/>
                            <%--<s:property value="#session.student.studentName"/>--%>
                        </a>
                    </div>
                </div>
            </div>
            <ul class="nav">
                <li><a href="#">
                    <p>管理员编号:2014232001</p>
                </a></li>
                <li><a href="#">
                    <p>管理员姓名:杨立伟</p>
                </a></li>


            </ul>

            <%-- <s:iterator value="#request.courses">
            <li><a href="get_course.action?course.courseId=<s:property value='courseId' />"> <i class="pe-7s-graph"></i>
                    <p><s:property value="courseName"/></p>
            </a></li>
            </s:iterator> --%>

        </div>
    </div>
    <div class="main-panel">
        <p style="margin-left:50px;font-size:30px; text-align:center;">学生信息</p>
        <table border=2 width=900 style="margin-left:100px;margin-top:30px; text-align:center;">
            <tr>
                <td>工号</td>
                <td>姓名</td>
                <td>所属部门</td>
            </tr>
            <s:iterator value="#request.students">
                <%--<a href="admin/getStudentById.action?studentId=<s:property value="studentId"/>">--%>
                <%--打开一个新的页面--%>
                    <%--<tr onclick="window.open('admin/getStudentById.action?studentId=<s:property value="studentId"/>')">--%>
                <tr onclick="location.href='admin/getStudentById.action?studentId=<s:property value="studentId"/>'">
                        <td><s:property value="studentId"></s:property></td>
                        <td><s:property value="studentName"></s:property></td>
                        <td><s:property value="postion"></s:property></td>
                    </tr>
                </a>
            </s:iterator>

        </table>
    </div>
</div>
<%--<s:debug></s:debug>--%>
</body>
</html>