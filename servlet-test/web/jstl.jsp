<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
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
<%--设置域属性值--%>
user:${requestScope["user"]}<br>
<c:set scope="request" var="user" value="Ice">
</c:set>
user:${requestScope["user"]}
<%--网页输出--%>
<c:out value="${name}" default="没找到" escapeXml="true">
</c:out>
<%--删除域范围的属性--%>
<c:remove var="user" scope="request"></c:remove>
user:${requestScope["user"]}<br>

<%--分支语句--%>
<c:set scope="request" var="kaka" value="Ice">
</c:set>
<c:if test="${user=='Ice'}">你好！Ice</c:if>

<%--choose标签--%>
<c:choose>
    <c:when test="${user=='Ice'}">你好！Ice</c:when>
    <c:when test="${user=='cmi'}">你好！cmi</c:when>
    <c:otherwise>你是谁？</c:otherwise>
</c:choose>
</body>
</html>
<%
    List<String> list = new ArrayList<>();
    list.add("腕豪");
    list.add("杰斯");
    list.add("永恩");
    list.add("格温");
    list.add("盖伦");
    session.setAttribute("list",list);

    Map<String,Object> map = new HashMap<>();
    map.put("color1","green");
    map.put("color2","red");
    map.put("color3","blue");
    map.put("color4","black");
    session.setAttribute("color",map);
%>

<c:forEach var="list" items="${list}" varStatus="varStatus" begin="1" end="2" step="2">
    ${list} 当前是第几个对象:${varStatus.index},已经遍历${varStatus.count}个对象，是否第一个：${varStatus.first}，是否最后一个：${varStatus.last}, 当前被迭代对象:${varStatus.current},最开始的位置：${varStatus.begin}，最后的位置：${varStatus.end}，步长：${varStatus.step}<br>
</c:forEach>
<c:forEach var="map" items="${color}">
    ${map.key} ${map.value}<br>
</c:forEach>