<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Light Bootstrap Dashboard by Creative Tim</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
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
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet"/>
</head>
<body>

<div class="wrapper">


    <div class="main-panel" style="width:100%;">
        <nav class="navbar navbar-default navbar-fixed" style="height:200px; background: url(courseImg/timg.jpg);">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span> <span
                            class="icon-bar"></span> <span class="icon-bar"></span> <span
                            class="icon-bar"></span>
                    </button>

                </div>
                <div>
                    <ul class="nav navbar-nav navbar-right">
                        <
                        <li><a href="userMessage.jsp">Welcome <s:property value="#session.student.studentName"/> </a>
                        </li>
                        <li><a href="login.jsp"> Log out </a></li>
                        <!-- <li><a href="#"> Log out </a></li> -->
                    </ul>
                </div>
                <div class="collapse navbar-collapse   margin-top: 8px">
                    <br>

                    <ul class="nav navbar-nav navbar-left">
                        <p style="text-indent:2em;font-size:30px;color:#FFF"><s:property
                                value="#course.courseName"/></p><br>
                        <%--<form>--%>
                        <a href="saveStudentCourse.action?courseId=<s:property value="#course.courseId"/>&courseName=<s:property value="#course.courseName"/>">
                            <button type="submit" value="" class=" btn-info btn-fill" style="height:46px;">
                                &nbsp&nbsp添加课程&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp<i class="pe-7s-science"></i></button>
                        </a>
                        &nbsp
                        <table width="400" rules="cols" align="right" style="color:#fff">
                            <tr align="center">
                                <td>学习人数</td>
                                <td>课程时长</td>
                            </tr>
                            <tr align="center">
                                <%--这里需要查看debug中的Stack Context 和 Value Stack Contents--%>
                                <td><s:property value="#course.studentNum"/></td>
                                <td>1小时30分钟</td>
                            </tr>
                        </table>
                        <%--</form>--%>
                    </ul>


                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">课程目录</h4>
                            </div>

                        </div>


                        <div style="text-indent:2em;">
                            <s:iterator value="#request.contents">
                                <ul style="text-indent:2em;font-size:20px"><a
                                        href="class.action?content.contentId=<s:property value="contentId"/>"><s:property
                                        value="contentName"/></a><br>

                                </ul>
                            </s:iterator>
                            <ul style="text-indent:2em;font-size:20px">
                                <a href="paper/create.action?courseId=<s:property value="#course.courseId"/>">开始考试</a><br>
                                <%--<a href="paper/create.action?courseId=<s:property value="#course.courseId"/>">开始考试</a><br>--%>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="image">
                                <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400"
                                     alt="..."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                    <a href="#">
                                        <img class="avatar border-gray" src="assets/img/faces/face-1.jpg" alt="..."/>

                                        <h4 class="title">Mike Andrew<br/>
                                            <small>michael24</small>
                                        </h4>
                                    </a>
                                </div>
                                <p class="description text-center"> "Lamborghini Mercy <br>
                                    Your chick she so thirsty <br>
                                    I'm in that two seat Lambo"
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
                                <button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i>
                                </button>

                            </div>
                        </div>
                        <div>
                            <jsp:include page="comment.jsp"/>
                        </div>

                    </div>
                </div>
            </div>


        </div>
    </div>
    <%--<s:debug></s:debug>--%>
    <input type="hidden" id="msg" value="<s:property value="#request.msg"/>">
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
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>
<script type="text/javascript">
    //    showMsg();
    //    function showMsg(){
    //        var msg = document.getElementById("msg").getAttribute("value");
    //        alert(document.getElementById("msg").getAttribute("value"));
    //        if(msg!=""){
    //            alert(msg);
    //        }
    //    }
    window.onload = function () {
        var msg = document.getElementById("msg").getAttribute("value");
//        alert(document.getElementById("msg").getAttribute("value"));
        if (msg != "") {
            alert(msg);
        }
    }
</script>

</html>
