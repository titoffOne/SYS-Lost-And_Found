<%@page import="datalayer.data.Finding"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="datalayer.data.FinalQuestion"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
		<style>
			<jsp:include page="./styles.css"/>
		</style>
		<title>Контрольные вопросы</title>
</head>

<body>
	
	<jsp:include page="/jsp/interface/receiver_interface/header.jsp" />
	
	<h1>Просмотр контрольных вопросов</h1>
	
	<form id="addFinalQuestion" name="addFinalQuestion" method="POST" action="/Lost-And-Found/findings/finalquestions/addfinalquestion" accept-charset="UTF-8">
        <input type="hidden" name="command" value="addFinalQuestion" />
        <input type="hidden" name="findingId" value="<%= request.getAttribute("findingId") %>" />
		<button id="addFinalQuestion" type="submit" name="action" value="addfinalquestion">Добавить контрольный вопрос</button>
	</form>


	<% List<FinalQuestion> foundItems = (List<FinalQuestion>) request.getAttribute("foundItems");
     for (FinalQuestion finalQuestion : foundItems) { %>


		<table id="finalquestion" width="50%">
			<tr>
				<td id="question"><%=finalQuestion.getQuestion()%></td>


			</tr>
			<tr>
				<td id="rightanswer"><%=finalQuestion.getRightAnswer()%></td>
			</tr>
			<tr>
				<td id="alternativeanswer"><%=finalQuestion.getAlternativeAnswer1()%></td>

			</tr>
			<tr>
				<td id="alternativeanswer"><%=finalQuestion.getAlternativeAnswer2()%></td>

			</tr>
			<tr >
				<td>
				<div style="display: flex;">
					<div style="text-align: center;">
						<form name="ChangeButton" method="POST" action=finalquestions/changefinalquestion>
							<input type="hidden" name="command" value="changefinalquestion" /> 
							<input type="hidden" name="finalquestionid" value="<%= finalQuestion.getId()%>" />
							<button id="changeFinalQuestion" type="submit" name="action"
							value="changefinding">Изменить</button>
						</form>
					</div>
					<button id="openModalDeleteFinalQuestion" onclick="openModal('<%= finalQuestion.getId() %>', '<%= finalQuestion.getFindingId() %>', 
				 '<%= finalQuestion.getQuestion() %>')" type="submit" >Удалить</button>
				</div>
				</td>
			</tr>
		</table>

		<% } %>


	


<!-- Модальное окно -->
<div id="deleteFinalQuestionModal" class="modal">
  	<!-- Модальное содержание -->
  	<div class="modal-content">
    <h1 id="deleteFinalQuestion">Удаление контрольного вопроса</h1>
    <p>Вы действительно хотите удалить вопрос <span id="deleteFinalQuestionText"></span>?</p>
	    <table>
		    <tr>
		        <td>
					<form id="deleteFinalQuestionForm" method="POST" action="finalquestions">
							<input type="hidden" name="command" value="RefreshFinalQuestion" />
							<input type="hidden" name="actiontype" value="delete" />
							<input id="finalQuestionIdForDelete" type="hidden" name="finalquestionid" value="" />
							<input id="findingIdForDelete" type="hidden" name="findingId" value="" />
							<button id="deleteFinalQuestion" type="submit">Да</button>
					</form>
		        </td>
		        <td>
					<button id="exit" type="submit">Нет</button>
				</td>
		    </tr>
		</table> 
	</div>
</div>
  
<script>
	//Получить модальное окно
	var modal = document.getElementById("deleteFinalQuestionModal");
	// Получить кнопку, которая открывает модальное окно
	var btn = document.getElementById("openModalDeleteFinalQuestion");
	// Получить кнопку, которая закрывает модальное окно
	var btnExit = document.getElementById("exit");

	// Обработчик нажатия события, когда открывается модальное окно
    function openModal(questionId, findingId, question) {
    	var questionIdElem = document.getElementById('finalQuestionIdForDelete');
    	questionIdElem.value = questionId;
    	var findingIdElem = document.getElementById('findingIdForDelete');
    	findingIdElem.value = findingId;
    	var resultText = document.getElementById("deleteFinalQuestionText");
    	resultText.innerHTML = "«" + question + "»";
	  	modal.style.display = "block";
		// Чтобы пользователь не смог вернуться на предыдущую странницу отменяем это
		history.pushState(null, null, location.href);
		window.onpopstate = function () {
		    history.go(1);
		}
    }

	// Когда пользователь нажимает на кнопку, закрывается модальное окно
	btnExit.onclick = function() {
	  modal.style.display = "none";
	}
	
</script>
</body>
</html>