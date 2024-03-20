<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="datalayer.data.SystemUser"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
	<style>
	<jsp:include page="./styles.css"/>
	</style>
	<title>Мой профиль</title>
</head>

<body id="new">
	<jsp:include page="/jsp/interface/moderator_interface/header.jsp" />

 	<% SystemUser systemUser = (SystemUser) request.getAttribute("profileData"); %>

	<h1 id="profile">Профиль модератора</h1>

	<form name="saveProfileData" method="POST" action="myprofile" accept-charset="UTF-8">
    <input type="hidden" name="command" value="myprofile" />
    <input type="hidden" name="data" value="refresh" />
    <input type="hidden" name="userid" value="<%=systemUser.getUserID()%>" />
  
        
		<table id="profile">
		<tr>
			<td><label id="profileTitle" for="profileDataName">ФИО</label></td>
			<td><input id="profileDataName" name="name" type="text" value="<%= systemUser.getFullName()%>"></td>
		</tr>
			<tr>
			<td><label id="profileTitle" for="profileDataPhone">Логин</label></td>
			<td><input id="profileDataPhone" name="login" type="text" value="<%= systemUser.getLogin() %>"></td>
		</tr>
		<tr>
			<td><label id="profileTitle" for="profileDataEmail">Email</label></td>
			<td><input id="profileDataEmail" name="email" type="text" value="<%= systemUser.getEmail() %>"></td>
		</tr>
		<tr>
			<td colspan="2"><button id="saveProfileData" type="submit">Сохранить изменения</button></td>
		</tr>
		<% if(request.getAttribute("saveMessage").equals("yes")) {%>
		<tr>
			<td colspan="2"><p id="saveMessage">Данные успешно сохранены!</p></td>
			<script>
		        // Скрываем сообщение через 2 секунды 
		        setTimeout(function(){
		            document.getElementById("saveMessage").style.display = "none";
		        }, 2000);
			</script>
		</tr>
		<%}%>
		</table>
	
	
	</form>
	
</body>
</html>