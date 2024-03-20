<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8">
<style>
	<jsp:include page="./styles.css"/>
</style>
<title>Добавить пользователя</title>
</head>
<body>

<h1 id="titleAddUserText">Добавление пользователя</h1>

<form id="addUserForm" name="addUserForm" method="POST" action="/Lost-And-Found/users" accept-charset="UTF-8">
	<input type="hidden" name="command" value="refreshUsers" />
	<input type="hidden" name="act" value="add" />  
    <!-- ФИО -->
    <label for="fullName">ФИО:</label>
    <input id="fullName" type="text" required name="fullName" value="" /><br />

    <!-- Email -->
    <label for="email">Email:</label>
    <input id="email" type="email" required name="email" value="" /><br />

    <!-- Логин -->
    <label for="login">Логин:</label>
    <input id="login" type="text" required name="login" value="" /><br />

    <!-- Пароль -->
    <label for="password">Пароль:</label>
    <input id="password" type="password" required name="password" value="" /><br />

    <!-- Статус -->
    <label for="status">Статус:</label>
    <select id="status" name="status">
        <option value="Активен">Активен</option>
        <option value="Заблокирован">Заблокирован</option>
    </select><br />

    <!-- Группа -->
    <label for="group">Группа:</label>
    <select id="group" name="group">
        <option value="Администратор">Администратор</option>
        <option value="Модератор">Модератор</option>
        <option value="Клиент">Клиент</option>
        <option value="Приемщик">Приемщик</option>
    </select><br />
	<button id="saveAndAddUser" type="submit">Добавить пользователя</button>
    <!-- <input id="loginbutton" type="submit" value="Добавить пользователя" /> -->
</form>


</body>
</html>