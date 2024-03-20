<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Error Page</title>
<style>
body {
	background-color: #333;
	font-family: century gothic;
	font-size: 15px;
	color: #fff;
}

body#errorPage {
	background-color: #333;
	font-family: century gothic;
	font-size: 30px;
	color: #fff;
	margin-top: 10%;
	margin-left: 10%;
}

.requestName {
	color: red;
}


button#backToLogin {
	text-align: center;
	width: 300px;
	height: 60px;
	border: none;
	border-radius: 50px;
	color: #333;
	font-size: 25px;
	font-style: normal;
	transition: transform 0.5s;
	text-align: center;
	margin-top: 50px;
}

button#backToLogin:hover {
	color: #fff;
	background: #007BFF;
}

</style>
</head>

<body id="errorPage">
	<h1>Время ожидания превышено</h1>
	
	<form name="Back" method="POST" action="/Lost-And-Found/">
		<input type="hidden" name="command" value="login" /> 
		<button id="backToLogin" name="backToFinds" type="submit">Ок</button>
	</form>
</body>
</html>