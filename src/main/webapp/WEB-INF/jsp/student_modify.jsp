<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <title>Students Modify</title>
    <script src="../../resources/js/functions.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
</head>
<body>
<span>
        <h1>Система управления студентами и их успеваемостью</h1>
        <c:choose>
            <c:when test="${isAuthorised eq true}">
                <p>Привет, ${login}</p>
                a class="Logout" href="/logout">Logout</a>
            </c:when>
            <c:otherwise>
                a class="Logout" href="/login">Login</a>
            </c:otherwise>
        </c:choose>
    </span>
<div class="navP">
    <nav>
        <a href="/">На главную</a>
        <a href="/students">Назад</a>
    </nav>
    <p class="p1">Для модификации, введите новые значения и нажмите кнопку "Применить".</p>
</div>
<form action="/student_modify" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <div class="input1"><label>Фамилия <input type="text" name="surname" value="${student.surname}"></label></div>
    <div class="input2"><label>Имя <input type="text" name="name" value="${student.name}"></label></div>
    <div class="input3"><label>Группа <input type="text" name="group" value="${student.group.name}"></label></div>
    <f:formatDate var="formattedDate" value = "${student.date}" pattern="MM/dd/yyyy"/>
    <div class="input4"><label>Дата поступления <input id="datepicker" type="text" name="date" value="${formattedDate}"></label></div>
    <div class="button2"><button>Применить</button></div>
</form>
<c:if test="${error eq 1}">
    <h4 class="p4">Поля не должны быть пустыми!</h4>
</c:if>
</body>
</html>

