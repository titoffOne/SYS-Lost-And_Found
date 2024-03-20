<%@page import="datalayer.data.Finding"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="datalayer.data.Finding"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
		<style>
			<jsp:include page="./styles.css"/>
		</style>
		<title>Находки</title>
</head>

<body>
	<jsp:include page="/jsp/interface/moderator_interface/header.jsp" />


	<% List<Finding> foundItems = (List<Finding>) request.getAttribute("foundItems");
     for (Finding finding : foundItems) { %>


	<table id="finding">
		<tr>
			<td id="category"><%= finding.getCategory() %></td>
			<td id="description" rowspan="4"><%= finding.getDescription() %></td>
			<td rowspan="4">
					<div style="display: flex;">
						<form name="ChangeButton" method="POST" action="findings/changefinding">
							<input type="hidden" name="command" value="changefinding" /> 
							<input type="hidden" name="findingid" value="<%= finding.getId()%>" />
							<button id="edit" type="submit">Изменить</button>
						</form>
						<button id="openModalDeleteFinding" onclick="openModal('<%= finding.getId() %>', '<%= finding.getName() %>')" type="submit" >Удалить</button>
						<form name="QuestionsButton" method="POST" action="findings/finalquestions">
							<input type="hidden" name="command" value="finalquestions" />
							<input type="hidden" name="findingId" value="<%= finding.getId() %>" />
							<button id="finalquestion" type="submit">Контрольные<br>вопросы</button>
						</form>
					</div>
				</td>
			<td>
		</tr>
		<tr>
			<td id="date"><%= finding.getDate() %></td>
		</tr>
		<tr>
			<td id="name"><%= finding.getName() %></td>
		</tr>
		<tr>
			<td id="place"><%= finding.getPlace() %></td>
		</tr>
	</table>

	<% } %>



<!-- Модальное окно -->
<div id="deleteFindingModal" class="modal">
  	<!-- Модальное содержание -->
  	<div class="modal-content">
    <h1 id="deleteFinding">Удаление находки</h1>
    <p>Вы действительно хотите удалить находку <span id="deleteFindingText"></span>?</p>
	    <table>
		    <tr>
		        <td>
		        	<form id="deleteFindingForm" method="POST" action="findings">
							<input type="hidden" name="command" value="refreshfindings" />
							<input type="hidden" name="client" value="moderator" />
							<input type="hidden" name="act" value="delete" />
							<input id="findingIdForDelete" type="hidden" name="findingId" value="" />
							<button id="deleteFinding" type="submit">Да</button>
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
	var modal = document.getElementById("deleteFindingModal");
	// Получить кнопку, которая открывает модальное окно
	var btn = document.getElementById("openModalDeleteFinding");
	// Получить кнопку, которая закрывает модальное окно
	var btnExit = document.getElementById("exit");

	// Обработчик нажатия события, когда открывается модальное окно
    function openModal(id, name) {
    	var findingId = document.getElementById('findingIdForDelete');
    	findingId.value = id;
    	var resultText = document.getElementById("deleteFindingText");
    	resultText.innerHTML = "«" + name + "»";
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