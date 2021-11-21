<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>ajax</title>
    <script src = "${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        let userList = new Array();
        userList.push({username:"zhangsan",gender:"男"});
        userList.push({username:"lisi",gender:"女"});
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/request/demo5",
            data:JSON.stringify(userList),
            contentType:"Application/json;charset=utf-8"
        })
    </script>
</head>
<body>

</body>
</html>
