<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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

    <style type="text/css">

        .B {
            position: absolute;
            left: 35%;
        }

        .C {
            position: absolute;
            left: 50%;
        }

        .D {
            position: absolute;
            left: 65%;
        }
    </style>
</head>
<body>
<div>
    <%--<jsp:include page="header.jsp"></jsp:include>--%>
</div>
<div class="wrapper">
    <div class="sidebar" data-color="blue" data-image="assets/img/sidebar-5.jpg">
        <div>
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="#" class="simple-text"> <s:property value="#request.paper.field2"/>试卷</a>
                </div>

                <ul class="nav">

                    <li><a href="#">
                        <p>考生编号:<s:property value="#session.student.studentId"/></p>
                    </a></li>
                    <li><a href="#">
                        <p>考生姓名:<s:property value="#session.student.studentName"/></p>
                    </a></li>
                   <%-- <li><a href="#">
                        <p>考试时间:<s:property value="#request.paper.field3"/></p>
                    </a></li>--%>


                </ul>
            </div>
        </div>
    </div>
    <div style="margin-left: 20%;margin-right:20%;">
        <form action="paper/afterTestPaper.action" name="form1" id="form1" method="post">
            <input type="hidden" name="result" id="result"/>
            <input type="hidden" name="paperId" value="<s:property value="#request.paper.paperId"/>"/>
            <s:iterator value="#request.questions" status="st">
                <div style="margin-top:10px; font-size:18px;">
                    <p style="font-size:20px;"><s:property value="%{#st.index+1}"/>)<s:property value="content"/></p>
                    <input type="hidden" name="questionIds" value="<s:property value="questionId"/>">
                    &nbsp;&nbsp;&nbsp;<input type="radio" name="result<s:property value="questionId"/>"
                                             value="A"><s:property
                        value="field1"/><br>
                    &nbsp;&nbsp;&nbsp;<input type="radio" name="result<s:property value="questionId"/>"
                                             value="B"><s:property
                        value="field2"/><br>
                    <s:if test="field3!=null && field3 !=''.toString">
                        &nbsp;&nbsp;&nbsp;<input type="radio" name="result<s:property
                            value="questionId"/>" value="C"><s:property
                            value="field3"/><br>
                    </s:if>
                    <s:if test="field4!=null && field4 !=''.toString">
                        &nbsp;&nbsp;&nbsp;<input type="radio" name="result<s:property
                            value="questionId"/>" value="D"><s:property
                            value="field4"/>
                    </s:if>
                </div>
            </s:iterator>
            <li>
                <input type="submit" onclick="makeResult()" class=" btn-info btn-fill" value="交卷"
                       style="float:right;margin-top: 100px;">
            </li>
        </form>
        <%--<s:debug/>--%>
        <%--<div style="margin-top:10px; font-size:18px;">--%>
        <%--<p style="font-size:20px;">1)天是蓝的。</p>--%>
        <%--<input type="radio" name="T2">正确--%>
        <%--<input type="radio" name="T2" style="margin-left:10%;">错误--%>
        <%--</div>--%>
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
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

<script type="text/javascript">
    function makeResult() {
        var result = "";
//        alert($(":radio").size());
        $(":radio").each(function () {
//            alert($(this).val());
//            alert($(this).attr("checked")==true);
//            alert($(this).prop("checked"));
            if ($(this).prop("checked") == true) {
                result += $(this).val() + ",";
            }
//            alert(result);
        });
//        alert(result);
        $("#result").val(result);
//        alert($("#result").val())
//        alert($("#form1").attr("index.jsp","action"));
//        alert($("#form1").attr("action"));
//        alert($("#form1").action);
//        alert(document.getElementById("form1").hasAttribute("action"));
//        alert(document.getElementById("form1").getAttribute("action"));
        $("#form1").submit();
//        alert(document.form1.getAttribute("action"));


//        alert("aaa");
    }
</script>

</html>











