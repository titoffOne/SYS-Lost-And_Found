<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		<jsp:include page="./styles.css"/>
	</style>
<title>Добавление контрольного вопроса</title>
</head>
<body>



<h1 id="addFinalQuestion">Добавление контрольного вопроса</h1>

	<form id="addFinalQuestionForm" method="POST" action="" accept-charset="UTF-8">
		<input id="commandField" type="hidden" name="command" value="" />
		<input type="hidden" name="addFinalQuestion" value="true" />
		<input type="hidden" name="findingId" value="<%= request.getAttribute("findingId") %>">
		
		<label for="question">Вопрос:</label>
		<input id="question" type="text" required name="question" value="" /><br />
		
		<label for="alternativeAnswer1">Правильный ответ:</label>
		<input id="rightAnswer" type="text" required name="rightAnswer" value="" /><br />
		
		<!-- Альтернативный ответ 1 -->
		<label for="alternativeAnswer1">Альтернативный ответ 1:</label>
		<input id="alternativeAnswer1" type="text" required name="alternativeAnswer1" value="" /><br />
		
		<!-- Альтернативный ответ 2 -->
		<label for="alternativeAnswer2">Альтернативный ответ 2:</label>	
		<input id="alternativeAnswer2" type="text" required name="alternativeAnswer2" value="" /><br />  
		
		<button id="saveFinalQuestion" type="submit" onclick="setAction('Save')">Сохранить</button>   
		<button id="saveAndAddNextFinalQuestion" type="submit" onclick="setAction('SaveAndAddNext')">Добавить ещё</button>   
	</form>
 	
	<script>
	  function setAction(actionType) {
	    var form = document.getElementById('addFinalQuestionForm');
	    var commandField = document.getElementById('commandField');
	    
	    switch (actionType) {
	      case 'Save':
	        form.setAttribute('action', '/Lost-And-Found/findings/finalquestions');
	        commandField.value = 'finalquestions';
	        break;
	      case 'SaveAndAddNext':
	        form.setAttribute('action', '/Lost-And-Found/findings/finalquestions/addfinalquestion');
	        commandField.value = 'addFinalQuestion';
	        break;
	      // Добавьте другие варианты действий по мере необходимости
	    }
	  }
	</script>

</body>
</html>