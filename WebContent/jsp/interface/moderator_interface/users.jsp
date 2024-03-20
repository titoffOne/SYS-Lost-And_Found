<%@page import="datalayer.data.Finding"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="datalayer.data.SystemUser"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
		<style>
			<jsp:include page="./styles.css"/>
		</style>
		<title>Пользователи</title>
</head>

<body>
	<jsp:include page="/jsp/interface/moderator_interface/header.jsp" />

    <!-- Другой контент страницы здесь -->

 
		<%
			List<SystemUser> systemUsers = (List<SystemUser>) request.getAttribute("foundUsers");
			for (SystemUser user : systemUsers) {
		%>
	
	

    <table id="users">
        <tr>
            <td><img src="<%= request.getContextPath() %>/images/user.png" alt="Фото пользователя"></td>
            <td id="itemusers"><%= user.getFullName() %> 
            <img id="statusImage<%= user.getUserID() %>" src="<%= user.getStatus().equals("Активен") ? request.getContextPath() + "/images/unlock.png" : request.getContextPath() + "/images/lock.png" %>" alt="Статус"></td>
            <td id="itemusers">Логин</td>
            <td id="itemusers">Пароль
                <button id="activity" type="button" onclick="togglePassword(this, '<%= user.getPassword() %>')">
                    <img src="<%= request.getContextPath() %>/images/seem.png" alt="На главную">
                </button>
            </td>
        </tr>
        <tr>
            <td></td>
            <td id="role"><%= user.getGroup() %></td>
            <td><%= user.getLogin() %></td>
            <td>
                <span class="passwordField"><%= new String(new char[user.getPassword().length()]).replace('\0', '*') %></span>
            </td>
        </tr>
        <tr>
            <td></td>
            <td id="itemusers2"><%= user.getEmail() %></td>
        </tr>
			<tr>
				<td></td>
				<td colspan="1">
					<div style="display: flex;">
						<% String currentStatus =  user.getStatus().equals("Активен") ? "Заблокировать" : "Разблокировать";%>
						<button id="openModalBlockUser" type="submit" onclick="openModal('<%=user.getUserID()%>', '<%=currentStatus %>', '<%= user.getFullName() %>')">
							<%=currentStatus %>
						</button>
					</div>
				</td>
			</tr>
		</table>
		
	<script>
    function togglePassword(button, password) {
        var passwordField = button.closest('table').querySelector('.passwordField');
        var passwordImage = button.querySelector('img');
        var isPasswordVisible = passwordField.innerText === password;

        if (isPasswordVisible) {
            // Переключаем на звездочки
            passwordField.innerText = '*'.repeat(password.length);
            passwordImage.src = '<%= request.getContextPath() %>/images/notseem.png';
        } else {
            // Переключаем на исходный пароль
            passwordField.innerText = password;
            passwordImage.src = '<%= request.getContextPath() %>/images/seem.png';
        }
    }  
  
    </script>

<% } %>		
		<!-- Модальное окно -->
	<div id="blockUserModal" class="modal">
	  	<!-- Модальное содержание -->
	  	<div class="modal-content">
	    <h1 id="blockUser">Действие над пользователем</h1>
	    <p>Вы действительно хотите <span id="statusUser"></span> пользователя <span id="nameUser"></span>?</p>
		    <table>
			    <tr>
			        <td>
			        	<form name="BlockButton" method="POST" action="users">
							<input type="hidden" name="command" value="blockuser" /> 
							<input id="userIdForBlock" type="hidden" name="userid" value="" />
							<button id="blockUser" type="submit">Да</button>
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
	// Получить модальное окно
	var modal = document.getElementById("blockUserModal");
	// Получить кнопку, которая закрывает модальное окно
	var btnExit = document.getElementById("exit");
	
	// Обработчик нажатия события, когда открывается модальное окно
	function openModal(id, status, name) {
		var userId = document.getElementById('userIdForBlock');
		userId.value = id;
    	var statusText = document.getElementById("statusUser");
    	statusText.innerHTML = status.toLowerCase();
    	var userNameText = document.getElementById("nameUser");
    	userNameText.innerHTML = name;
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
	
	// Когда пользователь щелкает в любом месте за пределами модального, все блокируется
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "block";
	  }
	}
</script>





</body>
</html>