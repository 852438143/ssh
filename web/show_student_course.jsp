<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hahhhre</title>
</head>
<body><center>
	<jsp:include page="header.jsp"></jsp:include>
	<table>
	<tr>
				<th>CourseName</th>
				<th>Content</th>
			</tr>
	<s:iterator value="#request.course">
		
			<tr>
				<td><a href="test.jsp?id=<s:property value='courseId'/>"><s:property value="courseName"/></a></td>
				<td><s:property value="introduction"/></td>
			</tr>
	</s:iterator>
	</table>
	当前是第${pageBean.currentPage}页,共有${pageBean.totalPage}页
 <a href="show.action?pageBean.currentPage=1" >首页</a>
 <s:if test="%{pageBean.currentPage>1}"><a href="show.action?pageBean.currentPage=${pageBean.currentPage-1}" >上一页</a>
 <a href="show.action?pageBean.currentPage=${pageBean.currentPage-1}" >${pageBean.currentPage-1}</a></s:if>
 <a href="show.action?pageBean.currentPage=${pageBean.currentPage}" >${pageBean.currentPage}</a>
 <s:if test="%{pageBean.totalPage>currentPage}"><a href="show.action?pageBean.currentPage=${cpageBean.urrentPage+1}" >${pageBean.currentPage+1}</a>
 <a href="show.action?pageBean.currentPage=${pageBean.currentPage+1}" >下一页</a></s:if>
 <a href="show.action?pageBean.currentPage=${pageBean.totalPage}" >尾页</a></center>
</body>
</html>