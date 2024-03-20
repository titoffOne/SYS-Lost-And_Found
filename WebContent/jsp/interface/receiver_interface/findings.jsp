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
	<jsp:include page="/jsp/interface/receiver_interface/header.jsp" />
	
	<form name="ChangeButton" method="POST" action="findings/addfinding">
							<input type="hidden" name="command" value="addfinding" /> 
							<button id="addfinding" type="submit" name="action"
							value="addfinding">Добавить находку</button>
	</form>

	<% List<Finding> foundItems = (List<Finding>) request.getAttribute("foundItems");
     for (Finding finding : foundItems) { %>

	<table item="finding">
		<tr>
			<td item="category"><%= finding.getCategory() %></td>
			<td item="description" rowspan="4"><%= finding.getDescription() %></td>
			<td rowspan="4">
					<div style="display: flex;">
						<form name="ChangeButton" method="POST" action="findings/changefinding">
							<input type="hidden" name="command" value="changefinding" /> 
							<input type="hidden" name="findingid" value="<%= finding.getId()%>" />
							<button id="actionbutton" type="submit" name="action"
							value="changefinding">Изменить</button>
						</form>
						<form name="QuestionsButton" method="POST" action="findings/finalquestions">
							<input type="hidden" name="command" value="finalquestions" />
							<input type="hidden" name="findingId" value="<%= finding.getId() %>" />
							<button id="actionbutton" type="submit" name="action"
								value="show">Контрольные<br>вопросы</button>
						</form>
						<% String currentStatus = finding.getStatus().equals("Потеряно") ? "Снять с просмотра" : "Добавить к просмотру"; %>
						<button id="openModalChangeFindingStatus" type="submit"
							value="<%=finding.getId()%>"
							onclick="openModalChangeFindingStatus('<%=finding.getId()%>', '<%=currentStatus%>', 
							'<%=finding.getName()%>')">
							<%=currentStatus%>
						</button>
						
						<script>
						// изменение цвета при наведении в зависимости от надписи на кноке openModalChangeFindingStatus
						document.querySelector('#openModalChangeFindingStatus[value="<%=finding.getId()%>"]').addEventListener('mouseover', function() {
							var btnOpenModalChangeStatusText = this.innerText.trim();
							if (btnOpenModalChangeStatusText === "Снять с просмотра") {
								this.style.backgroundColor = 'red';
						  	} else if (btnOpenModalChangeStatusText === "Добавить к просмотру") {
						  		this.style.backgroundColor = 'green';
						  	}
							
						});

						document.querySelector('#openModalChangeFindingStatus[value="<%=finding.getId()%>"]').addEventListener('mouseout', function() {
						  this.style.backgroundColor = '#0085FF';
						});
						</script>
					</div>
				</td>
		</tr>
		<tr>
			<td item="date"><%= finding.getDate() %></td>
		</tr>
		<tr>
			<td item="name"><%= finding.getName() %></td>
		</tr>
		<tr>
			<td item="place"><%= finding.getPlace() %></td>
		</tr>
	</table>

	<% } %>

</body>

	<!-- Модальное окно -->
<div id="changeFindingStatusModal" class="modal">
  	<div class="modal-content">
    <h1 id="changeFindingStatus">Изменение статуса находки</h1>
    <p>Вы действительно хотите <span id="statusFindingText"></span> находку <span id="nameFindingText"></span>?</p>
	    <table>
		    <tr>
		        <td>
					<form name="Finds" method="POST" action="/Lost-And-Found/findings">
						<input type="hidden" name="command" value="changeFindingStatus" /> 
						<input id="findingIdForChangeStatus" type="hidden" name="findingId" value="" />
						<button id="changeFindingStatus" type="submit">Да</button>
					</form>
				</td>
		        <td>
					<button id="exitChangeFindingStatusModal" type="submit">Нет</button>
				</td>
		    </tr>
		</table> 
	</div>
</div>

<script>
	

	var modalChangeFindingStatus = document.getElementById("changeFindingStatusModal");
	var btnChangeFindingStatusExit = document.getElementById("exitChangeFindingStatusModal");
	

	function openModalChangeFindingStatus(id, status, name) {
		var findingId = document.getElementById('findingIdForChangeStatus');
		findingId.value = id;
    	var statusText = document.getElementById("statusFindingText");
    	statusText.innerHTML = status.toLowerCase();
    	var nameFindingText = document.getElementById("nameFindingText");
    	nameFindingText.innerHTML = name;
    	modalChangeFindingStatus.style.display = "block";
    	
    	
		// Чтобы пользователь не смог вернуться на предыдущую странницу отменяем это
		history.pushState(null, null, location.href);
		window.onpopstate = function () {
		    history.go(1);
		}
	}
	
	// Когда пользователь нажимает на кнопку, закрывается модальное окно
	btnChangeFindingStatusExit.onclick = function() {
		modalChangeFindingStatus.style.display = "none";
	}
</script>

</html>