<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" style="overflow:scroll;">
<head>
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
            href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
            rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
          rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet"/>

</head>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<div class="wrapper">
    <div class="sidebar" data-color="purple"
         data-image="assets/img/sidebar-5.jpg">

        <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text"> 课程培训 </a>
            </div>
            <form>
                <input type="hidden" id="keyw" value="<s:property value='#request.Keywords'/>">
            </form>
            <ul class="nav">
                <li id="id1"><a href="getByKeyword.action?keyword=前端开发"> <i class="pe-7s-graph"></i>
                    <p>前端开发类课程</p>
                </a></li>
                <li id="id2"><a href="getByKeyword.action?keyword=后端开发"> <i class="pe-7s-user"></i>
                    <p>服务端开发类课程</p>
                </a></li>
                <li id="id3"><a href="getByKeyword.action?keyword=移动开发"> <i class="pe-7s-note2"></i>
                    <p>移动开发类课程</p>
                </a></li>
                <li id="id4"><a href="getByKeyword.action?keyword=数据库"> <i class="pe-7s-news-paper"></i>
                    <p>数据库系统课程</p>
                </a></li>
                <li id="id5"><a href="getByKeyword.action?keyword=云计算和大数据"> <i class="pe-7s-science"></i>
                    <p>机器学习类课程</p>
                </a></li>
                <li id="id6"><a href="getByKeyword.action?keyword=运维和测试"> <i class="pe-7s-map-marker"></i>
                    <p>运维&测试类课程</p>
                </a></li>


            </ul>
        </div>
    </div>

    <div class="main-panel">


        <div class="content">

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="content all-icons">
                            <h4><a href="userMessage.jsp" style="margin-left:50px;">通知</a>
                            </h4>
                        </div>
                        <div class="card">

                            <div class="content all-icons">
                                <div class="row">
                                    <div class="font-icon-detail"
                                         style="border:1px solid; height:100px;text-align:left;margin:20px;">
                                        <div style="margin-left:50px;">
                                                <h5><span>标题</span><span
                                                        style="margin-right:50px;float:right;">2017-5-10</span>
                                                </h5>
                                                <p>请在5-10前完成HTML课程报名！</p>
                                        </div>
                                    </div>
                                    <div class="font-icon-detail"
                                         style="border:1px solid; height:100px;text-align:left;margin:20px;">
                                        <div style="margin-left:50px;">
                                            <h5><span>标题</span><span
                                                    style="margin-right:50px;float:right;">2017-5-9</span>
                                            </h5>
                                            <p>请在5-09号前完成HTML报名！</p>
                                        </div>
                                    </div>
                                </div>


                            </div>
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
<script type="text/javascript"
        src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>


</html>
