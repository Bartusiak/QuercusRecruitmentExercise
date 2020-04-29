<%--
  Created by IntelliJ IDEA.
  User: Bart
  Date: 29.04.2020
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj pracownika</title>
</head>
<body>
<h>Dane pracownika do edycji</h>
<br><br>
<form action="setServlet" method="GET">
    ID: <input type="text" name="workerId" value="<%
        if(session.getAttribute("workerId")!=null){
            out.println(session.getAttribute("workerId"));
            session.removeAttribute("workerId");
        }
    %>" readonly/>
    <br><br>
    IMIĘ: <input type="text" name="workerName" value="<%
        if(session.getAttribute("workerName")!=null){
            out.println(session.getAttribute("workerName"));
            session.removeAttribute("workerName");
        }
    %>" required/>
    <br><br>
    NAZWISKO: <input type="text" name="workerSurname" value="<%
        if(session.getAttribute("workerSurname")!=null){
            out.println(session.getAttribute("workerSurname"));
            session.removeAttribute("workerSurname");
        }
    %>" required/>
    <br><br>
    ADRES: <input type="text" name="workerAddress" value="<%
        if(session.getAttribute("workerAddress")!=null){
            out.println(session.getAttribute("workerAddress"));
            session.removeAttribute("workerAddress");
        }
    %>" required/>
    <br><br>
    EMAIL: <input type="text" name="workerEmail" value="<%
        if(session.getAttribute("workerEmail")!=null){
            out.println(session.getAttribute("workerEmail"));
            session.removeAttribute("workerEmail");
        }
    %>" required/>
    <br><br>
    <input type="submit">
</form>
</body>
</html>
