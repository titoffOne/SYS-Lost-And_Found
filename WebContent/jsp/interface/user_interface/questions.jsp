<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="datalayer.data.QuestionAnswers"%>
<%@ page import="datalayer.data.QuestionAnswers.Answer"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<style>
		<jsp:include page="../styles.css"/>
	</style>
	<title>Контрольные вопросы</title>
</head>
<body>

	<h1>Пожалуйста, ответьте на контрольные вопросы</h1>
	
	
	<%
				List<QuestionAnswers> foundItems = (List<QuestionAnswers>) request.getAttribute("foundQuestionAnswer");
					int count = 1;
					int group = 1;
					for (QuestionAnswers questionAnswer : foundItems) {
			%>


	<table>
		<tr>
			<td id="question" colspan="2"><%= questionAnswer.getQuestion()%></td>
		</tr>
		<tr id="answer">
			<td colspan="2">
			<% List<Answer> answers = questionAnswer.getAnswers();
			for (Answer answer : answers) { %>
			
					
					<input id="answer<%= count%>" name="AnswerGroup<%= group%>" type="radio" value="<%= answer.isCorrect()%>"/>
					<label id="answer" for="answer<%= count++%>"><%= answer.getText()%></label><br>
				
	
			<% } %>
			</td>	
		</tr>
		
		<% group++;
		} 
		%>

		<tr id="answer">
			<td>
				<form name="Finds" method="POST" action="/Lost-And-Found/findings">
					<input type="hidden" name="command" value="findings" /> 
					<button id="backToFinds" type="submit">Назад</button>
				</form>
			</td>
			<td>
				<button id="checkAnswer" type="submit">Проверить</button>
			</td>
		</tr>
	</table>
	
	<jsp:include page="/jsp/interface/user_interface/result.jsp" />
</body>


</html>