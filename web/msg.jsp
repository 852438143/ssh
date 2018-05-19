<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{background:url("<%=basePath%>images/ErrrorBack.jpg");background-size: 100% auto;}

</style>
</head>
<body>
	
	<div style="/* border:1px solid red; */width:40%;height:40%;position:absolute;left:50%;margin-left:-160px;top:50%;margin-top:-120px;">
		<h1 style="text-align:center;color:green;">${msg}！</h1>
		
	</div>
</body>
</html>