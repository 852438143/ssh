<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 85243
  Date: 2017/4/25
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function addComponent()
        {
            var uploadHTML = document.createElement( "input");
            uploadHTML.type="file";
            uploadHTML.name="upload";
            alert("aa");
            document.getElementById("files").appendChild(uploadHTML);
            alert("aa");
            uploadHTML = document.createElement("br");
            document.getElementById("files").appendChild(uploadHTML);
            alert("aa");
        }
    </script>
</head>
<body>

    <%--<form action="uploadCourse.action" method="post" enctype="multipart/form-data">--%>
        <%--<input type="file" label="File(1)" name="upload"/>--%>
        <%--<input type="file" label="File(1)" name="upload"/>--%>
        <%--<input type="file" label="File(1)" name="upload"/>--%>
        <%--<input type="submit" value="提交">--%>
    <%--</form>--%>

    <input type="button" onclick="addComponent();" value="添加视屏" />
    <br />
    <form onsubmit="return true;" action="uploadCourse.action"
          method="post" enctype="multipart/form-data">
            <span id="files"> <input type='file' name='upload' />
                <br>
            </span>
        <input type="submit" value="上传" />
    </form>

</body>
</html>
