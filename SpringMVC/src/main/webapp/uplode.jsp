<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<%--enctype:表单的属性是部分表单形式--%>
<form action="${pageContext.request.contextPath}/request/uplode" enctype="multipart/form-data" method="post">
    姓名：<input type="text" name="username"><br>
    选择文件：<input type="file" name="uplodeFile"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
