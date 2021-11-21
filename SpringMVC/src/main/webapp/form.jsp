<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>表单</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/request/demo4" method="post">
        姓名：<input type="text" name="userList[0].username"><br>
        性别：<input type="text" name="userList[0].gender" ><br>
        姓名：<input type="text" name="userList[1].username"><br>
        性别：<input type="text" name="userList[1].gender"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
