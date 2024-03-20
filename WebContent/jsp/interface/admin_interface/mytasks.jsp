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
	<jsp:include page="/jsp/interface/admin_interface/header.jsp" />

	<div class="mytasks">
		<p>Вы - администратор.</p>
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
			<li>Удалять клиентов</li>
		</ul>
	</div>

	<jsp:include page="/jsp/interface/admin_interface/footer.jsp" />
</body>
</html>