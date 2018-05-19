<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" style="overflow:scroll;">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="../assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Light Bootstrap Dashboard by Creative Tim</title>

	<meta
			content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
			name='viewport' />
	<meta name="viewport" content="width=device-width" />


	<!-- Bootstrap core CSS     -->
	<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />

	<!-- Animation library for notifications   -->
	<link href="../assets/css/animate.min.css" rel="stylesheet" />

	<!--  Light Bootstrap Table core CSS    -->
	<link href="../assets/css/light-bootstrap-dashboard.css" rel="stylesheet" />


	<!--  CSS for Demo Purpose, don't include it in your project     -->
	<link href="../assets/css/demo.css" rel="stylesheet" />


	<!--     Fonts and icons     -->
	<link
			href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
			rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
		  rel='stylesheet' type='text/css'>
	<link href="../assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

</head>
<body>
<div>
	<jsp:include page="./header.jsp"></jsp:include>
</div>
<div style="background:url(images/background.jpg);background-size:100%;">
	<form action="uploadCourse.action" method="post" enctype="multipart/form-data">
		<table align="center" style="border-collapse:separate;border-spacing:15px;" id="formTable">
			<tr>
				<td>课程名称：
				</td>
				<td><input type="text" name="courseName">
				</td>
			</tr>
			<tr>
				<td>课程简介：
				</td>
				<td><input type="text" name="introduction">
				</td>
			</tr>
			<tr>
				<td>课程教师：
				</td>
				<td><input type="text" name="teacher" >
				</td>
			</tr>
			<tr>
				<td>课程难度：
				</td>
				<td> <input type="radio" name="level" value="简单">简单&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input type="radio" name="level" value="一般">一般&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input type="radio" name="level" value="困难">困难
				</td>
			</tr>
			<tr>
				<td>开始时间：
				</td>
				<td><input type="text" name="startTime" >
				</td>
			</tr>
			<tr>
				<td>课程分类：</td>
				<td>
					<select name="keyword">
						<option value="前端开发">前端开发类课程</option>
						<option value="后端开发">服务端开发类课程</option>
						<option value="移动开发">移动开发类课程</option>
						<option value="数据库">数据库系统课程</option>
						<option value="云计算和大数据">机器学习类课程</option>
						<option value="运维测试">运维测试类课程</option>
						<option value="线下">线下</option>
					</select>
				</td>
			</tr>


			<tr>
				<td>课程图片：
				</td>
				<td><input type="file" name="upload">
				</td>
			</tr>
			<tr  id="files">
				<td >课程目录：
				</td>

				<td >
					<input type="button" onclick="addComponent();" value="添加视频" style="border-radius:10px;height:30px;width:80px;"/>
				</td>
			</tr>
			<tr id="afterFiles" >
				<td >题目集：
				</td>

				<td >
					<input type="file" value="添加题目" style="border-radius:10px;height:30px;width:80px;"/>
				</td>
			</tr>
			<tr  >
				<td><input type="submit" value="添加" style="border-radius:10px;height:30px;width:80px;">
				</td>

			</tr>
		</table>
	</form>
</div>
</body>

<!--   Core JS Files   -->
<script src="../assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="../assets/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="../assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="../assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="../assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="../assets/js/demo.js"></script>


<script type="text/javascript">
	function a() {
		prompt("cbsk");
	}

	function addComponent()
	{
		var trElement = document.createElement("tr");
		var tdElement = document.createElement("td");
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		var inputElement  = document.createElement("input");
		inputElement.type="text";
		inputElement.name="contentName";
		tdElement.appendChild(inputElement);
		trElement.appendChild(tdElement);

		tdElement = document.createElement("td");
		inputElement = document.createElement("input");
		inputElement.type="file";
		inputElement.name="upload";
		tdElement.appendChild(inputElement);
		trElement.appendChild(tdElement);

		//向当前元素的前面添加一个元素,这个必需要先获取父元素 ，如果在后面可以使用nextSibling

		var files = document.getElementById("afterFiles");
//			alert(files);

		var parent = files.parentNode;
//			alert(parent);
		parent.insertBefore(trElement,files);
//			alert("success");


		/*			document.getElementById("courseContent").appendChild(blankInput1);
		 document.getElementById("contents").appendChild(blankInput2);
		 var uploadHTML = document.createElement("input");
		 uploadHTML.type="file";
		 uploadHTML.name="upload";
		 document.getElementById("files").appendChild(uploadHTML);*/
	}

</script>

</html>
