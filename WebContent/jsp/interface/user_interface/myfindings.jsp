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
		<title>Мои находки</title>
	</head>
	<body>
		<jsp:include page="/jsp/interface/user_interface/header.jsp" />
		
		<% List<Finding> foundItems = (List<Finding>) request.getAttribute("foundItems");
		if (foundItems.isEmpty()) { %>
			<h1 id="myfindings">Здесь будут отображаться находки, <br>на которые вы оформили право на собственность.</h1>
		<% } else {
	
     	for (Finding finding : foundItems) { %>


		<table id="finding" width="90%">
			<tr>
				<td id="category"><%= finding.getCategory() %></td>
				<td id="description" rowspan="4"><%= finding.getDescription() %></td>
	
				<td rowspan="4">
					<p id="ownership"p>Является вашей находкой</p>
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
	
		<% } 
		}%>


	</body>
</html>