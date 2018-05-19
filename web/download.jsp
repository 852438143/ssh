<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<%@taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  type="text/javascript" src="js/jquery.min.js"></script>
<title>download</title>
</head>
<body>
	<div style="display:none;">
		<a href="${pageContext.request.contextPath}/show_attachment.action?attachment.cid=<s:property value='id'/>" class="show"></a>
	</div>
	<s:iterator value="#request.attachments">
		<a href="${pageContext.request.contextPath}/downFile.action?id=<s:property value='attachmentId' /> "><s:property value="attachmentName"/> </a>
	</s:iterator>
<script type="text/javascript">
	$(document).ready(function(){
		$(".show").trigger("onclick");	
		alert("hh");
	})
</script>
</body>
</html>