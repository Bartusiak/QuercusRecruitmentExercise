<%--
  Created by IntelliJ IDEA.
  User: Bart
  Date: 28.04.2020
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista pracowników</title>
</head>
<body>
<form action="workerList" method="POST">
    <input type="submit" value="Wyświetl listę"/>
</form>
<table border="1px">
    <tr><td>Id</td><td>Imie</td><td>Nazwisko</td><td>Adres</td><td>Email</td></tr>
        <%
            if(session.getAttribute("string")!=null){
                out.println(session.getAttribute("string"));
                session.removeAttribute("string");
            }
        %>
</table>
</body>
</html>
