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
	</head>
	
	<body>
		<jsp:include page="/jsp/interface/admin_interface/header.jsp" />
			

	<form name="AddButton" method="POST" action="users/adduser">
		<input type="hidden" name="command" value="adduser" /> <input
			type="hidden" name="btn" value="block" /> <input type="hidden"
			name="client" value="admin" />
		<button id="addUser" type="submit" name="action">
			Добавить пользователя</button>
	</form>

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
	                    <img src="<%= request.getContextPath() %>/images/notseem.png" alt="На главную">
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
							<% String currentStatus = user.getStatus().equals("Активен") ? "Заблокировать" : "Разблокировать"; %>
							<button id="openModalBlockUser" type="submit"
								onclick="openModalBlock('<%=user.getUserID()%>', '<%=currentStatus%>', '<%=user.getFullName()%>')">
								<%=currentStatus%>
							</button>
							<button id="openModalDeleteUser"
									onclick="openModalDelete('<%=user.getUserID()%>', '<%=user.getFullName()%>')"
									type="submit">Удалить
							</button>
							<form name="ChangeButton" method="POST" action="users/changeuser">
								<input type="hidden" name="command" value="changeuser" />
								<input type="hidden" name="userid" value="<%=user.getUserID()%>" />
								<button id="editUser" type="submit">Изменить</button>
							</form>
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
<div id="deleteUserModal" class="modal">
  	<div class="modal-content">
    <h1 id="deleteUserTitle">Удаление пользователя</h1>
    <p>Вы действительно хотите удалить пользователя <span id="deleteUserNameText"></span>?</p>
	    <table>
		    <tr>
		        <td>
		        	<form name="deleteUserForm" method="POST" action="users">
						<input type="hidden" name="command" value="deleteuser" />
						<input id="userIdForDelete" type="hidden" name="userid" value="" />
						<button id="deleteUser" type="submit">Да</button>
					</form>
		        </td>
		        <td>
					<button id="exitDeleteUserModal" type="submit">Нет</button>
				</td>
		    </tr>
		</table> 
	</div>
</div>

	<!-- Модальное окно -->
<div id="blockUserModal" class="modal">
  	<div class="modal-content">
    <h1 id="blockUser">Действие над пользователем</h1>
    <p>Вы действительно хотите <span id="statusUserText"></span> пользователя <span id="nameUserText"></span>?</p>
	    <table>
		    <tr>
		        <td>
		        	<form id="myForm" name="BlockButton" method="POST" action="users">
						<input type="hidden" name="command" value="blockuser" /> 
						<input id="userIdForBlock" type="hidden" name="userid" value="" />
						<button id="blockUser" type="submit">Да</button>
					</form>
		        </td>
		        <td>
					<button id="exitBlockUserModal" type="submit">Нет</button>
				</td>
		    </tr>
		</table> 
	</div>
</div>

<script>
	var modalDeleteUser = document.getElementById("deleteUserModal");
	var btnDeleteUserExit = document.getElementById("exitDeleteUserModal");
	var modalBlockUser = document.getElementById("blockUserModal");
	var btnBlockUserExit = document.getElementById("exitBlockUserModal");
	
	// Обработчик нажатия события, когда открывается модальное окно
	function openModalDelete(id, name) {
		var userId = document.getElementById('userIdForDelete');
		userId.value = id;
    	var userNameText = document.getElementById("deleteUserNameText");
    	userNameText.innerHTML = name;
    	modalDeleteUser.style.display = "block";
		// Чтобы пользователь не смог вернуться на предыдущую странницу отменяем это
		history.pushState(null, null, location.href);
		window.onpopstate = function () {
		    history.go(1);
		}
	}
	function openModalBlock(id, status, name) {
		var userId = document.getElementById('userIdForBlock');
		userId.value = id;
    	var statusText = document.getElementById("statusUserText");
    	statusText.innerHTML = status.toLowerCase();
    	var userNameText = document.getElementById("nameUserText");
    	userNameText.innerHTML = name;
    	modalBlockUser.style.display = "block";
		// Чтобы пользователь не смог вернуться на предыдущую странницу отменяем это
		history.pushState(null, null, location.href);
		window.onpopstate = function () {
		    history.go(1);
		}
	}
	
	// Когда пользователь нажимает на кнопку, закрывается модальное окно
	btnDeleteUserExit.onclick = function() {
		modalDeleteUser.style.display = "none";
	}
	btnBlockUserExit.onclick = function() {
		modalBlockUser.style.display = "none";
	}
</script>

</body>
</html>