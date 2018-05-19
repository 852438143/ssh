<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="../assets/css/animate.min.css" rel="stylesheet"/>
<link href="../assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>
 <link href="../assets/css/demo.css" rel="stylesheet" />
 <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="../assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
<style type="text/css">
.comments { 
width:95%;/*自动适应父布局宽度*/ 
overflow:auto; 
word-break:break-all; 
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div >
		<jsp:include page="./header.jsp" />
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
                     <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400" alt="..."/>
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
			
			<div class="card card-user">
			    <div class="card">
				    <div class="header">
				         <h4 class="title">课程评论</h4>
				    </div>                 
			    </div>
			    <hr>
			    <div class="content">
			        
			         <s:iterator value="#request.comments">
			         	<h6><s:property value="studentName"/></h6>
			         	&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="content"/><br>
			         	<div align="right">
			         	<s:property value="time"/>
			         	<hr>
			         	</div>
			         </s:iterator>
			         <br><br>
					当前是第${pageBean.currentPage}页,共有${pageBean.totalPage}页
					<a href="showComment.action?comment.contentId=<s:property value='#session.content.contentId' />&pageBean.currentPage=1">首页</a>
					<s:if test="%{pageBean.currentPage>1}">
						<a href="showComment.action?comment.contentId=<s:property value='#session.content.contentId' />&pageBean.currentPage=${pageBean.currentPage-1}">上一页</a>
						<a href="showComment.action?comment.contentId=<s:property value='#session.content.contentId' />&pageBean.currentPage=${pageBean.currentPage-1}">${pageBean.currentPage-1}</a>
					</s:if>
					<a href="showComment.action?comment.contentId=<s:property value='#session.content.contentId' />&pageBean.currentPage=${pageBean.currentPage}">${pageBean.currentPage}</a>
					<s:if test="%{pageBean.totalPage>pageBean.currentPage}">
						<a href="showComment.action?comment.contentId=<s:property value='#session.content.contentId' />&pageBean.currentPage=${pageBean.currentPage+1}">${pageBean.currentPage+1}</a>
						<a href="showComment.action?comment.contentId=<s:property value='#session.content.contentId' />&pageBean.currentPage=${pageBean.currentPage+1}">下一页</a>
					</s:if>
					<a href="showComment.action?comment.contentId=<s:property value='#session.content.contentId' />&pageBean.currentPage=${pageBean.totalPage}">尾页</a>
					</center>
					<%--<s:debug></s:debug>--%>
				</div>
			    <h5><p style="margin-left:30px;">我的评论：</p></h5>

			    	<form action="doComment.action" method="post" id="form1">
			    		<center>
			    		<textarea class="comments" style="height:expression((this.scrollHeight>150)?'150px':(this.scrollHeight+5)+'px');overflow:auto;" name="content"></textarea><br>
			    		</center>
			    		<input type="hidden" value="<s:property value='#session.course.courseId' />" name="courseId">
			    		<input type="hidden" value="<s:property value='#session.content.contentId' />" name="contentId">
			    		<input type="hidden" value="<s:property value='#session.student.studentId' />" name="studentId">
			    		<input type="hidden" value="<s:property value='#session.student.studentName' />" name="studentName">
			    		<input type="hidden" name="time" id="time">
			    		<input type="button" value="提交" onclick="getDate()" style="margin-left: 30px;margin-top: 20px;	">
			    	</form>
			    	
			    <hr>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	Date.prototype.format = function(fmt) { 
	     var o = { 
	        "M+" : this.getMonth()+1,                 //月份 
	        "d+" : this.getDate(),                    //日 
	        "h+" : this.getHours(),                   //小时 
	        "m+" : this.getMinutes(),                 //分 
	        "s+" : this.getSeconds(),                 //秒 
	        "q+" : Math.floor((this.getMonth()+3)/3), //季度 
	        "S"  : this.getMilliseconds()             //毫秒 
	    }; 
	    if(/(y+)/.test(fmt)) {
	            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	    }
	     for(var k in o) {
	        if(new RegExp("("+ k +")").test(fmt)){
	             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
	         }
	     }
	    return fmt; 
	}
	function getDate(){
		var time = new Date().format("yyyy-MM-dd hh:mm:ss");
		document.getElementById("time").value=time;
		document.getElementById("form1").submit();
	}
	</script>
</body>
</html>