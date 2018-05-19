<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<script type="text/javascript" src="js/jquery.min.js"></script>
<head>
    <style>
        .iframe {
            background: white;
            border: 1px solid #dfdfdf;
            float: right;
        }
    </style>
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
                        <li><a href="userMessage.jsp">Welcome <s:property value="#session.student.studentName"/> </a>
                        </li>
                        <li><a href="login.jsp"> Log out </a></li>
                        <!-- <li><a href="#"> Log out </a></li> -->
                    </ul>
                </div>
                <div class="collapse navbar-collapse   margin-top: 8px">
                    <br>

                    <ul class="nav navbar-nav navbar-left">
                        <p style="text-indent:2em;font-size:30px;color:#FFF">大数据</p><br>
                        <form>
                            <button type="submit" value="" class=" btn-info btn-fill" style="height:46px;">
                                &nbsp&nbsp继续学习&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp<i class="pe-7s-science"></i></button>
                            &nbsp
                            <table width="400" rules="cols" align="right" style="color:#fff">
                                <tr align="center">
                                    <td>学习人数</td>
                                    <td>课程时长</td>
                                </tr>
                                <tr align="center">
                                    <td><s:property value="#session.course.studentNum"/></td>

                                    <td>
                                        <div id="time"></div>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </ul>


                </div>
            </div>
        </nav>


        <div>
            <br><br>
            <center>
            <%--<video id="video" controls="controls"> <source--%>
            <%--src="movie/aa.mp4" type="video/mp4"></video>--%>
            <%--</center>--%>
            <video src="<s:property value='#session.content.url'/>" width="100%" height="600" controls="controls">
            </video>
        </div>
        <br><br>
        <%--<s:debug></s:debug>--%>
        <div>
            <a href="showComment.action?pageBean.currentPage=1&comment.contentId=<s:property value='#session.content.contentId'/>"
               target="iframe" id="co">展开评论</a>
            <%-- 	<jsp:include page="comment.jsp?pageBean=<s:property value='pageBean'/>" />  --%>
            <div id="comment" style="display:none;">
                <iframe name="iframe" allowfullscreen="true" scrolling="no" id="iframe" src="comment.jsp" class="iframe"
                        onload="iframeHeight()">

                </iframe>
            </div>
        </div>


    </div>
</div>
<script type="text/javascript">
    var i = setInterval(function () {
        if (video.readyState > 0) {
            //alert("test");
            var minutes = parseInt(video.duration / 60, 10);
            var seconds = parseInt(video.duration % 60, 10);
            var hours = parseInt(minutes / 60, 10);
            minutes = minutes % 60;
            document.getElementById('time').innerHTML = hours + "小时" + minutes + "分钟" + seconds + "秒";
            clearInterval(i);
        }
    }, 200);
</script>
<script type="text/javascript">
    window.onresize = function () {
        iframeHeight();
    };
    function iframeHeight() {
        var ifm = document.getElementById("iframe");
        /* var subWeb = document.frames ? document.frames["iframe"].document : ifm.contentDocument;
         if(ifm != null && subWeb != null) {
         ifm.height = subWeb.body.scrollHeight;

         }    */
        var _height = $(window).height() - 34;
        var _width = $(window).width() - $("#content").width() - 70;

        ifm.height = _height;
        ifm.width = _width;

    }
    var i = 1;

    $("#co").click(function () {

        if (i == 1) {
            $("#co").text("隐藏评论");
            i = 0;
            $("#comment").css("display", "block");
        } else {
            $("#co").text("展开评论");
            i = 1;
            $("#comment").css("display", "none");
        }

    })
</script>
</body>
</html>