<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="datalayer.data.FinalQuestion" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <style>
        <jsp:include page="./styles.css"/>
    </style>
    <title>Изменение контрольного вопроса</title>
</head>
<body>

<h1 id="titleChangeFinalQuestionText">Редактировние контрольного вопроса</h1>

<% FinalQuestion finalQuestion = (FinalQuestion) request.getAttribute("finalQuestion"); %>

		<form id="changeFinalQuestionForm" name="changeFinalQuestionForm" method="POST" action="/Lost-And-Found/findings/finalquestions" accept-charset="UTF-8">
        <input type="hidden" name="command" value="RefreshFinalQuestion" />
        <input type="hidden" name="finalquestionid" value="<%= finalQuestion.getId() %>" />
        <input type="hidden" name="findingId" value="<%= finalQuestion.getFindingId() %>" />
        <input type="hidden" name="actiontype" value="saverefresh" />

        <!-- Вопрос -->
        <label for="question">Вопрос:</label>
        <input id="question" type="text" required name="question" value="<%= finalQuestion.getQuestion() %>" /><br />

        <!-- Правильный ответ -->
        <label for="alternativeAnswer1">Правильный ответ:</label>
        <input id="rightAnswer" type="text" required name="rightAnswer" value="<%= finalQuestion.getRightAnswer() %>" /><br />
 
        <!-- Альтернативный ответ 1 -->
        <label for="alternativeAnswer1">Альтернативный ответ 1:</label>
        <input id="alternativeAnswer1" type="text" required name="alternativeAnswer1" value="<%= finalQuestion.getAlternativeAnswer1() %>" /><br />

        <!-- Альтернативный ответ 2 -->
        <label for="alternativeAnswer2">Альтернативный ответ 2:</label>	
        <input id="alternativeAnswer2" type="text" required name="alternativeAnswer2" value="<%= finalQuestion.getAlternativeAnswer2() %>" /><br />

        <button id="saveFinalQuestionChanges" type="submit">Сохранить изменения</button>
    	</form>


</body>
</html>
