<%--
  Created by IntelliJ IDEA.
  User: 220725002
  Date: 2022/10/3
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comment</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/comment" method="post">
        <textarea name="message" cols="30" rows="10"></textarea>
        <input type="submit" value="提交">
    </form>
<p>${requestScope.get("name")}<span style="color: red">${requestScope.get("comment")}</span></p>
</body>
</html>
