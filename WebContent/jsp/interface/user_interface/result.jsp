<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- Модальное окно -->
<div id="myModal" class="modal">

  <!-- Модальное содержание -->
  <div class="modal-content">
    <h1 id="result">Результаты теста</h1>
    <p id="resultText"></p><br/>
    <table>
    <tr>
        <td>
        	<form name="Finds" method="POST" action="/Lost-And-Found/findings">
					<input type="hidden" name="command" value="findings" /> 
					<input type="hidden" name="client" value="user" />
					<input type="hidden" name="findingId" value="<%= request.getAttribute("findingId") %>" />
					<input type="hidden" name="setOwnershipForUser" value="true" />
					<button id="exit" name="backToFinds" type="submit">Назад</button>
			</form>
        </td>
        <td>
	        <form name="MyFinds" method="POST" action="/Lost-And-Found/myfindings">
				<input type="hidden" name="command" value="myfindings" /> 
				<input type="hidden" name="client" value="user" />
				<input type="hidden" name="findingId" value="<%= request.getAttribute("findingId") %>" />
				<input type="hidden" name="setOwnershipForUser" value="true" />
				<button id="toMyFindings" type="submit">К моим находкам</button>
			</form>
		</td>
		 <td>
	        <form name="Logout" method="POST" action="/Lost-And-Found/home">
				<input type="hidden" name="command" value="logout" /> 
				<input type="hidden" name="client" value="user" />
				<input type="hidden" name="blockUser" value="true" />
				<button id="logoutAndBlockUser" type="submit">Выйти из системы</button>
			</form>
		</td>
    </tr>
</table>
    
    
  </div>

</div>
  
<script>
	//Получить модальное окно
	var modal = document.getElementById("myModal");
	
	// Получить кнопку, которая открывает модальное окно
	var btn = document.getElementById("checkAnswer");
	
	// Получить кнопку, которая закрывает модальное окно
	var btnExit = document.getElementById("exit");


 	function checkAnswers() {
        var totalQuestions = 3; // Общее количество вопросов
        var countCorrectAnswers = 0;

        for (var i = 1; i <= totalQuestions; i++) {
        	var selectedAnswer = getSelectedAnswer("AnswerGroup" + i);
        	var correctAnswer = isCorrectAnswer(selectedAnswer);

    		if (correctAnswer === true) {
				countCorrectAnswers++;
			}
            
        }
        
        var resultText = document.getElementById("resultText");
        var btExit = document.getElementById('exit');
    	var btLogout = document.getElementById('logoutAndBlockUser');
    	var btToMyFindings = document.getElementById('toMyFindings');
    	
        if (countCorrectAnswers === totalQuestions) {
        	resultText.style.color = "#52ff33";
        	resultText.innerHTML = "Отлично! Вы ответили на все вопросы правильно!";
        	btLogout.style.display = 'none';
        } else {
        	resultText.style.color = "red";
        	resultText.innerHTML = "К сожалению, вы не справились с тестом. Ваш профиль будет заблокирован.";
        	var myButton = document.getElementById('toMyFindings');
        	btExit.style.display = 'none';
        	btToMyFindings.style.display = 'none';
        }
    }

    function getSelectedAnswer(groupName) {
        var selectedOption = document.querySelector('input[name="' + groupName + '"]:checked');
        return selectedOption ? selectedOption.id : null;
    }

    function isCorrectAnswer(answerId) {
        var answerElement = document.getElementById(answerId);
        return answerElement ? answerElement.value === 'true' : null;
    }

	
	// Когда пользователь нажимает на кнопку, открывается модальное окно
	btn.onclick = function() {
		checkAnswers();
	  	modal.style.display = "block";
		// Чтобы пользователь не смог вернуться на предыдущую странницу отменяем это
		history.pushState(null, null, location.href);
		window.onpopstate = function () {
		    history.go(1);
		};
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