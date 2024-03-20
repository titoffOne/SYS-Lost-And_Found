<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="header">
 		<tr>
          <td id="buttonHome">
          <form name="Home" method="POST" action="/Lost-And-Found/home">
			<input type="hidden" name="command" value="home" /> 
			<button id="home" type="submit"><img src="<%= request.getContextPath() %>/images/home.png" alt="На главную"></button>
		</form></td>
			<td id="finds">
          <form name="Finds" method="POST" action="/Lost-And-Found/findings">
			<input type="hidden" name="command" value="findings" /> 
			<input type="hidden" name="isuserfinds" value="" />
			<button id="finds" type="submit">Каталог находок</button>
		</form>
          </td>
			<td id="myFindings">
          <form name="MyFinds" method="POST" action="/Lost-And-Found/myfindings">
			<input type="hidden" name="command" value="myfindings" /> 
			<button id="myFindings" type="submit">Мои находки</button>
		</form>
          </td>
			<td id="aboutProject">
              <form name="AboutProject" method="POST" action="/Lost-And-Found/aboutproject">
			<input type="hidden" name="command" value="aboutproject" /> 
			<button id="aboutProject" type="submit">О проекте</button>
		</form>
          </td>
			<td id="profile">
              <form name="MyProfile" method="POST" action="/Lost-And-Found/myprofile">
			<input type="hidden" name="command" value="myprofile" /> 
			<input type="hidden" name="data" value="" />
			<input type="hidden" name="userid" value="" />
			<button id="profile" type="submit">Мой профиль</button>
		</form>
          </td>
			<td id="logout">
              <form name="LogOut" method="POST" action="/Lost-And-Found/">
			<input type="hidden" name="command" value="logout" /> 
			<button id="logout" type="submit"><img src="<%= request.getContextPath() %>/images/logout.png" alt="Выйти"></button>
		</form>
          </td>
			
		</tr>
  </table>