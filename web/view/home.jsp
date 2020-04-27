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
<h>Dane do wprowadzenia:</h>
<br><br>
<form action="addWorker" method="GET">
    <input type="text" name="workerName" placeholder="Imię pracownika..." required/>
    <br><br>
    <input type="text" name="workerSurname" placeholder="Nazwisko pracownika..." required/>
    <br><br>
    <input type="text" name="workerAddress" placeholder="Adres pracownika..." required/>
    <br><br>
    <input type="text" name="workerEmail" placeholder="Adres email pracownika..." required/>
    <br><br>
    <input type="submit">
</form>
</body>
</html>