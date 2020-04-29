<%--
  Created by IntelliJ IDEA.
  User: Bart
  Date: 26.04.2020
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadanie rekrutacyjne - dodaj pracownika</title>
</head>
<body>
    <a href="add-worker.jsp">Dodaj pracownika</a>
    <br><br>
    <a href="worker-list.jsp">Lista pracowników</a>
    <br><br>
    <%
        if(session.getAttribute("message")!=null) {
            out.println(session.getAttribute("message"));
            session.removeAttribute("message");
        }
    %>
</body>
</html>