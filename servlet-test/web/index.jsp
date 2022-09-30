<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="true" %>
<!--
  contentType设置响应内容类型，同时也可以设置字符集；
-->
<%@ page session="false"%>
<!--
  没有设置默认true；
  true表示启用JSP内置对象session，没有session对象会创建；
  false表示不启动内置对象session，当前JSP页面中无法使用session内置对象；
-->

<%@ page pageEncoding="UTF-8" %>
<!--
  pageEncoding是JSP本身的字符编码
  JSP要经过两次的“编码”，第一阶段会用pageEncoding，第二阶段会用utf-8至utf-8，第三阶段就是由Tomcat出来的网页， 用的是contentType。
  第一阶段是JSP编译成Java：
      它会根据pageEncoding的设定读取jsp，结果是由指定的编码方案翻译成统一的UTF-8 JAVA源码（即.java），如果pageEncoding设定错了，或没有设定，出来的就是中文乱码。
  第二阶段是由Javac的Java编译成字节码文件：
      不论JSP编写时候用的是什么编码方案，经过这个阶段的结果全部是UTF-8的encoding的java源码。
      JAVAC用UTF-8的encoding读取java源码，编译成UTF-8 encoding的二进制码（即.class），这是JVM对常数字串在二进制码（java encoding）内表达的规范。
  第三阶段是Tomcat（或其的application container）载入和执行阶段二的来的JAVA二进制码：
      输出的结果，也就是在客户端见到的，这时隐藏在阶段一和阶段二的参数contentType就发挥了功效
-->

<%@page import="java.util.*" %>
<%@ page import="com.lyy.entity.User" %>
<%-- 导包 --%>

<%@page errorPage="index.jsp" %>
<!--
    当页面出现异常，跳转error.jsp，errorPage属性用来指定出错之后跳转位置
-->

<%@page isErrorPage="true" %>
<%-- 表示启用JSP九大内置对象之一 ：exception ，默认值是false--%>

<html>
  <head>
    <title>index.jsp</title>
  </head>
  <body>
  <%
      request.setAttribute("user","ice");
      User user = new User();
      user.setName("Ice");
      user.setPassword("123456");
      user.setAddress("hangzhou");
      user.setPhone("13312345678");
      request.setAttribute("userObj",user);
      request.setAttribute("s.a","adasda");

  %>
  JSP输出：<%=request.getAttribute("user")%> <%--ice--%>
  EL表达式输出：${user} <%--ice--%>
  EL表达式输出：${"user"} <%--错误写法，会当成字符串输出 user --%>
  <%=request.getAttribute("password")%> <%--null--%>
  <%="测试"%> <%--测试--%>
  <%out.print("测试");%> <%--测试--%>
  <br>
  <!--对象值输出-->
  JSP输出：<% User user1 = (User) request.getAttribute("userObj");
    out.print("name = " + user1.getName() + "<br>");
    out.print("password = " + user1.getPassword()+ "<br>");
    out.print("address = " + user1.getAddress()+ "<br>");
    out.print("phone = " + user1.getPhone()+ "<br>");
            %>
  EL表达式输出：<br>
  name:${userObj.name}<br>
  password:${userObj.password}<br>
  address:${userObj.address}<br>
  phone:${userObj.phone}<br>
  EL表达式输出s-a：<br>
  ${requestScope.s.a} <br>
  ${[s.a]}<br>
  ${requestScope["s.a"]}


  </body>
</html>
