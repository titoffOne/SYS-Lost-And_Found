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
		<title>О проекте</title>
</head>
<body>
	<jsp:include page="/jsp/interface/moderator_interface/header.jsp" />

	<div class="mytasks">
		<p>Вы - модератор.</p>
		<p>Система "Бюро
			находок" - проект, созданный с целью помочь людям находить утерянные
			вещи и возвращать их их законным владельцам. Мы стремимся сделать
			процесс поиска и возврата утерянных вещей максимально удобным и
			эффективным.</p>
		<p>На Вас возложена задача обслуживать систему "Бюро находок" и следить за действиями
		всех наших клиентов. Вот Ваши основные задачи:</p>

		<ul>
			<li>Блокировать клиентов</li>
			<li>Разблокировать клиентов</li>
			<li>Редактировать данные о находках</li>
			<li>Редактировать данные о контрольных вопросах</li>
		</ul>
	</div>


</body>
</html>