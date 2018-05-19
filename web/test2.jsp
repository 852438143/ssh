<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
org.springframework.context.ApplicationContext,org.springframework.context.support.ClassPathXmlApplicationContext" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<link rel="stylesheet" type="text/css" href="css/menu-css.css">
<link rel="stylesheet" type="text/css" href="css/mstyle.css" />
<link rel="stylesheet" type="text/css" href="css/style.css"> 
<script  type="text/javascript" src="js/jquery.min.js"></script>

<style>

.iframe{
	background:white;
	border:1px solid #dfdfdf;	
	float:right;

}


</style>
<body>
<div class="body">
	<%
		
	%>
	<div id="content" style="float:left;">
		<div class="menu">
			<ul>
				<s:iterator value="#session.courses">
				<li><a class="active" href="${pageContext.request.contextPath}/show_content.action?content.courseId=<s:property value='courseId'/>"><s:property value="courseName"/></a>
					<ul style="display: block;">
						<s:iterator value="#request.contents">
						<li><a href="test.jsp?content_id=<s:property value='contentId'/>"><s:property value="contentName"/></a>
						</li>
						</s:iterator>
						<%
							request.setAttribute("contents", new ArrayList());
						%>
					</ul>				
				</li>
			</s:iterator>
			</ul>
		</div>
		
	</div>
	<div>
		<iframe name="iframe" allowfullscreen="true"  scrolling="no" id="iframe" src="test.jsp" class="iframe" onload="iframeHeight()">
		
		</iframe>
	
	</div>
	
	<!-- <div style="clear:both;height:0px;" ></div>
</div> -->
<script type="text/javascript" src="js/menu_min.js"></script>
<script type="text/javascript">
	$(document).ready(function (){ 
	  
	 	$(".menu ul li").menu();


	}); 
	 window.onresize = function(){
		iframeHeight();
     };
	 function iframeHeight(){   
     	var ifm= document.getElementById("iframe");   
     	/* var subWeb = document.frames ? document.frames["iframe"].document : ifm.contentDocument;   
     	if(ifm != null && subWeb != null) {
     	   ifm.height = subWeb.body.scrollHeight;
     	   
     	}    */
     	 var _height = $(window).height()-34;
         var _width=$(window).width()-$("#content").width()-70;
         
        ifm.height=_height;
        ifm.width=_width;
     	
     }   

</script> 
</body>
</html>