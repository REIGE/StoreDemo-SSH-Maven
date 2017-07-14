<%--
  Created by IntelliJ IDEA.
  User: REIGE
  Date: 2017/7/8
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
index.jsp
<%
    // 重定向到新地址
    StringBuffer site = request.getRequestURL();
    StringBuffer index = site.append("index");
    String s = index.toString();
    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", s);
%>
</body>
</html>
