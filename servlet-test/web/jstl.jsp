<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 220725002
  Date: 2022/9/30
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
user:${requestScope["user"]}<br>
<c:set scope="request" var="user" value="Ice"></c:set>
user:${requestScope["user"]}
</body>
</html>
