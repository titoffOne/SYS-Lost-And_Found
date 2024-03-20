<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>О проекте</title>
		<style>
			<jsp:include page="./styles.css"/>
		</style>
</head>
<body>
	<jsp:include page="/jsp/interface/receiver_interface/header.jsp" />

	<div class="about_project">
		
		<p>Система "Бюро
			находок" - проект, созданный с целью помочь людям находить утерянные
			вещи и возвращать их их законным владельцам. Мы стремимся сделать
			процесс поиска и возврата утерянных вещей максимально удобным и
			эффективным.</p>
		<p id="role">Вы - приёмщик.</p>
		<p>На Вас возложена задача обслуживать систему "Бюро находок" и взаимодейтсовать с находками. 
		Вот Ваши основные задачи:</p>

		<ul>
			<li>Добавлять находки</li>
			<li>Редактировать данные о находках</li>
			<li>Удалять находки</li>
			<li>Редактировать данные о контрольных вопросах</li>
		</ul>
	</div>

</body>
</html>