<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../assets/css/animate.min.css" rel="stylesheet"/>
    <link href="../assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
    <link href="../assets/css/demo.css" rel="stylesheet"/>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
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
                    <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400"
                         alt="..."/>
                </div>
                <div class="content">
                    <div class="author">
                        <a href="#">
                            <img class="avatar border-gray" src="assets/img/faces/face-3.jpg" alt="..."/>
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
        <p style="margin-left:50px;font-size:30px; text-align:center;">课程考试成绩及排名</p>
        <table border=2 width=900 style="margin-left:100px;margin-top:30px; text-align:center;">
            <tr>
                <td>序号</td>
                <td>工号</td>
                <td>姓名</td>
                <td>成绩</td>
            </tr>
            <s:iterator value="#request.papers">
                <tr>
                    <td name="ranking"></td>
                    <td><s:property value="studentId"/></td>
                    <td><s:property value="field1"/></td>
                    <td><s:property value="score"/></td>
                </tr>
            </s:iterator>

        </table>
        <div style="width:500px">
            <a href="showComment.action?pageBean.currentPage=1&comment.courseId=${courseId}"
               target="iframe" id="co" onclick="co()">展开评论</a>
            <%-- 	<jsp:include page="comment.jsp?pageBean=<s:property value='pageBean'/>" />  --%>
            <div id="comment" style="display:none;">
                <iframe name="iframe" allowfullscreen="true" scrolling="no" id="iframe" src="../comment.jsp"
                        class="iframe"
                        onload="iframeHeight()">
                </iframe>
            </div>
        </div>
    </div>


</div>


<script type="text/javascript">
    window.onload = function () {
        var ranks = document.getElementsByName("ranking");
        for (var i = 0; i < ranks.length; i++) {
            ranks[i].innerHTML = "" + (i + 1);
        }
    };

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
    ;
    var i = 1;

    function co() {

        if (i == 1) {
            $("#co").text("隐藏评论");
            i = 0;
            $("#comment").css("display", "block");
        } else {
            $("#co").text("展开评论");
            i = 1;
            $("#comment").css("display", "none");
        }

    }


    //    $("#co").click(function () {
    //        alert("aaa");
    //        if (i == 1) {
    //            $("#co").text("隐藏评论");
    //            i = 0;
    //            $("#comment").css("display", "block");
    //        } else {
    //            $("#co").text("展开评论");
    //            i = 1;
    //            $("#comment").css("display", "none");
    //        }
    //
    //    });
</script>
</body>
</html>