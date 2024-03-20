<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
<style>
body {
	background-color: #333;
	font-family: century gothic;
	
	display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    
    padding: 0;
	margin: 0;
}

h1#lostandfound {
	margin-top: 10%;
	font-size: 60px;
	color: #fff;
}

form#loginform {
	width: 20%;
	background-color: #ffffff;
	padding: 20px;
	border-radius: 5px;
}

input#login, input#password {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

input#loginbutton {
	background-color: #333;
	color: #fff;
	border: none;
	padding: 10px 40px;
	border-radius: 3px;
	cursor: pointer;
	margin-left: 30%;
}

input#loginbutton:hover {
	background-color: #0085FF;
}

.error-message {
	font-size: 15px;
	text-align: center;
	color: red;
	font-weight: bold;
	margin-top: 10px;
	margin-bottom: 20px;
}

.invalidPassword {
	font-size: 15px;
	text-align: center;
	color: red;
	margin-top: 10px;
	margin-bottom: 20px;
}

#timeoutMessage {
	font-size: 40px;
    position: fixed;
    padding: 30px;
    margin-bottom: 25%;
    color: white; /* Белый цвет текста */
	border-radius: 50px;
	background: #FF5E5E;
    border: none; /* Убираем границу */
}
</style>
<title>Login - Бюро находок</title>
</head>

<body>
	<div id="timeoutMessage" style="display: none;" >
	    Время ожидания превышено
	</div>
	<% 
        if (session.getAttribute("showTimeoutMessage") != null && (Boolean) session.getAttribute("showTimeoutMessage")) {
            session.setAttribute("showTimeoutMessage", false);
    %>
    <script>
        // Закрываем окно с сообщением через 3 секунды
       setTimeout(function() {
    var timeoutMessage = document.getElementById('timeoutMessage');
    timeoutMessage.style.display = 'block'; // Изменяем стиль на 'block' для отображения элемента
    setTimeout(function() {
        timeoutMessage.style.display = 'none'; // Скрываем элемент после 3 секунд
    }, 3000);
}, 0);
    </script>
    <% } %>
	<h1 id="lostandfound">Бюро находок</h1>
	<form id="loginform" name="loginForm" method="POST" action="home">
		<input type="hidden" name="command" value="login" /> Login:<br /> <input
			id="login" type="text" required name="login" value="" /> <br />Password:<br />
		<input id="password" type="password" required name="password" value="" />
		<br><div class="invalidPassword"> ${errorLoginPassMessage} </div>
		<input id="loginbutton" type="submit"
			value="Войти" />
	</form>
</body>

</html>