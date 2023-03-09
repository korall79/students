<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
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
        <a href="/disciplines">Назад</a>
    </nav>
    <p class="p1">Для того чтобы создать новую дисциплину заполните все поля и нажмите "Создать":</p>
</div>
<form action="/discipline_create" method="post">
<div>
    <div class="input11"><label class="label1">Название<input class="input111" type="text"></label></div>
    <div class="button4"><button>Создать</button></div>
</div>
</form>

</body>
</html>