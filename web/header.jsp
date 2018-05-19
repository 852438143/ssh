<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" style="overflow:scroll;">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Light Bootstrap Dashboard by Creative Tim</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>


    <style type="text/css">
        .logo1 {
            background: rgba(0, 0, 0, 0) url("<%=basePath%>assets/img/ArcSoftLogo.png") no-repeat scroll left center;
            width: 180px;
            float: left;
            height: 47px;
            margin-top: 0px;
            margin-left: 50px;
        }

        .title1 {
            width: 100px;
            float: left;
            height: 47px;
            margin-top: 20px;

        }
    </style>
</head>
<body>

<%--<h1><%=basePath%></h1>--%>

<nav class="navbar navbar-default navbar-fixed" style="height:auto;">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#navigation-example-2">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
        </div>
        <a class="logo1" title="虹软科技" href="index.jsp" style="margin:10px;"></a>
        <div class="collapse navbar-collapse">
            <br>
            <form method="post" action="getByKeywordOrName.action" id="form3">
                <ul class="nav navbar-nav navbar-left">
                    <li><input type="text" class="form-control nav navbar-nav navbar-left " style="width:220px;"
                               name="keyword"></li>
                    <li><a href="#" onclick="searchs()"> <i class="fa fa-search"></i>
                    </a></li>
                </ul>
            </form>
                <ul class="nav navbar-nav navbar-right">

                    <li><a class="title1" href="getByKeyword.action?keyword=前端开发">线上</a></li>
                    <li><a class="title1" href="xianxiaCourse.jsp">线下</a></li>
                    <%--<li><a class="title1" href="paper/getPapers.action">考试</a></li>--%>
                    <s:if test="#session.student !=null">
                        <li><a class="title1" href="userMessage.jsp"> <s:property
                                value="#session.student.studentName"/> </a></li>
                    </s:if>
                    <s:else>
                        <li><a class="title1" href="login.jsp"> Log in </a></li>
                    </s:else>
                    <li><a class="title1" href="logout.action"> Log out </a></li>
                </ul>
        </div>

        <%--<s:debug></s:debug>--%>
    </div>
</nav>


</body>

<script type="text/javascript">


    function searchs() {
//        alert("aaaaa");
//        alert("used");
//        alert(document.getElementById("form3").getAttribute("action"));
        document.getElementById("form3").submit();
//        alert("aaaaaaa");
    }

</script>

</html>
