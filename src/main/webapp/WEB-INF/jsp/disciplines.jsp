<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <title>Discipline Page</title>
</head>
<body>
<span>
        <h1>Система управления студентами и их успеваемостью</h1>
        <a class="Logout" href="">Logout</a>
    </span>
<div class="navP">
    <nav>
        <a href="/">На главную</a>
    </nav>
    <p class="p2">Список дисциплин</p>
</div>

<div class="tableButton">
    <div class="Table3">
        <table class="table3" border="1">
            <tr>
                <th></th>
                <th>Наименование дисциплины</th>
            </tr>
            <c:forEach items="${disciplines}" var="d">
            <tr>
                <form>
                    <label>
                        <td><input type="checkbox"></td>
                        <td>${d.name}</td>
                    </label>
                </form>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div class="button3">
        <div class="button31"><a class="button311" href="disciplineCreating.html"><button class="button3111">Создать дисциплину...</button></a></div>
        <div class="button32"><a class="button322" href="disciplineModifying.html"><button class="button3222">Модифицировать выбранную дисциплину...</button></a></div>
        <div class="button33"><a class="button333" href=""><button class="button3333">Удалить выбранную дисциплину...</button></a></div>
    </div>
</div>
</body>
</html>