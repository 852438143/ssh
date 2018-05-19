<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en" style="overflow:scroll;">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Light Bootstrap Dashboard by Creative Tim</title>

    <meta
            content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
            name='viewport'/>
    <meta name="viewport" content="width=device-width"/>


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet"/>


    <!--     Fonts and icons     -->
    <link
            href="<%=basePath%>/css/font-awesome.min.css"
            rel="stylesheet">
    <link href='<%=basePath%>/googleapis.css?family=Roboto:400,700,300'
          rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet"/>

</head>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<div class="wrapper">
    <div class="sidebar">

        <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


        <div class="sidebar-wrapper">
            <%-- <div class="logo">
                <a href="#" class="simple-text"> <s:property value="#session.student.studentName"/> </a>
            </div> --%>
            <div class="card card-user">
                <div class="image">
                    <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400"
                         alt="..."/>
                </div>
                <div class="content">
                    <div class="author">
                        <a href="#">
                            <img class="avatar border-gray" src="assets/img/faces/face-1.jpg" alt="..."/>
                            <s:property value="#session.student.studentName"/>
                        </a>
                    </div>
                </div>
            </div>
            <ul class="nav">
                <li ><a href="getCoursesByStudent.action"> <i class="pe-7s-graph"></i>
                    <p>课堂</p>
                </a></li>
                <li><a href="userMessage.jsp"> <i class="pe-7s-user"></i>
                    <p>通知</p>
                </a></li>
                <li><a href="paper/getPapersByStudent.action"> <i class="pe-7s-note2"></i>
                    <p>我的考试</p>
                </a></li>
                <li class="active"><a href="showStudentInformation.jsp"> <i class="pe-7s-science"></i>
                    <p>我的信息</p>
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


        <div class="content">

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="content all-icons">
                            <h4><p style="margin-left:50px;">账号管理</p>
                            </h4>
                        </div>
                        <div>
                            <h5><a onclick="edit()">编辑资料</a></h5>
                        </div>
                        <div id="showInformationDiv1" style="display: block">
                            <ul>
                                <li>邮箱： <s:property value="#session.student.email"/></li>
                                <br>
                                <li>手机： <s:property value="#session.student.tel"/></li>
                                <br>
                                <li>姓名： <s:property value="#session.student.studentName"/></li>
                                <br>
                                <li>工号： <s:property value="#session.student.studentId"/></li>
                                <br>
                            </ul>
                        </div>
                        <div id="showInformationDiv2" style="display: none">
                            <form action="updateStudent" method="post">
                                <ul>
                                    <li>姓名： <input name="studentName" type="text" value="<s:property value="#session.student.studentName"/>"></li>
                                    <br>
                                    <li>工号： <input type="text" name="studentId" value="<s:property value="#session.student.studentId"/>"></li>
                                    <br>
                                    <li>邮箱： <input name="email" type="text" value="<s:property value="#session.student.email"/>"></li>
                                    <br>
                                    <li>手机： <input name="tel" type="text" value="<s:property value="#session.student.tel"/>"></li>
                                    <br>
                                    <li>职位： <input name="postion" type="text" value="<s:property value="#session.student.postion"/>"></li>
                                    <br>
                                    <li>密码： <input name="password" type="password" value="<s:property value="#session.student.password"/>"></li>
                                    <br>
                                    <li><input type="submit" value="确认修改"></li>


                                </ul>
                            </form>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <footer class="footer">

        </footer>


    </div>
</div>


</body>

<!--   Core JS Files   -->
<script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<%--<script type="text/javascript"--%>
        <%--src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>--%>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>


<script type="text/javascript">
    function edit(){
//        alert("bbbb");
        document.getElementById("showInformationDiv1").style.display="none";
//        alert("aaa");
        if(document.getElementById("showInformationDiv2").style.display=="none")
        document.getElementById("showInformationDiv2").style.display="block";

        return false;
    }
</script>
</html>
