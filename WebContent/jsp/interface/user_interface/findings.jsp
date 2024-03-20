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
		<jsp:include page="../styles.css"/>
	</style>
	<title>Находки</title>
</head>

<body>
	<jsp:include page="/jsp/interface/user_interface/header.jsp" />

	<% List<Finding> foundItems = (List<Finding>) request.getAttribute("foundItems");
     for (Finding finding : foundItems) { %>

	<table id="finding">
		<tr>
			<td id="category"><%= finding.getCategory() %></td>
			<td id="description" rowspan="4"><%= finding.getDescription() %></td>

			<td rowspan="4">
				<form name="FinalQuestions" method="POST" action="findings/finalquestions">
					<input type="hidden" name="command" value="finalquestions" /> 
					<input type="hidden" name="findingId" value="<%= finding.getId()%>" />
					<button id="ownership" type="submit">Это моё</button>
				</form>
			</td>
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

</body>
</html>