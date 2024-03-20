package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import coder.Coder;
import datalayer.data.FinalQuestion;
import datalayer.data.QuestionAnswers;
import temporary.data.FinalQuestions;

public class FinalQuestionsLogic {



	public static FinalQuestion getFinalQuestionById(int questionId) {
		return Logic.getFinalQuestion().getFinalQuestionById(questionId);
	}

	public static List<FinalQuestion> getFinalQuestionsByFindingId(int finfingId) {
		List<FinalQuestion> list = Logic.getFinalQuestion().getFinalQuestionByFindingsId(finfingId);
		return list;
	}

	public static List<QuestionAnswers> getQuestionsWithAnswersByFindingId(int finfingId) {
		List<FinalQuestion> finalQuestions = Logic.getFinalQuestion().getFinalQuestionByFindingsId(finfingId);
		List<QuestionAnswers> questionsWithAnswers = new ArrayList<>();
		QuestionAnswers questionAnswer;
		for (FinalQuestion question : finalQuestions) {
			questionAnswer = new QuestionAnswers(question.getQuestion());
			questionAnswer.addAnswer(question.getRightAnswer(), true);
			questionAnswer.addAnswer(question.getAlternativeAnswer1(), false);
			questionAnswer.addAnswer(question.getAlternativeAnswer2(), false);

			questionsWithAnswers.add(questionAnswer);
		}
		FinalQuestions.shuffleAnswers(questionsWithAnswers);
		return questionsWithAnswers;
	}

	public static void shuffleAnswers(List<QuestionAnswers> quizQuestions) {
		for (QuestionAnswers question : quizQuestions) {
			List<QuestionAnswers.Answer> answers = question.getAnswers();
			Collections.shuffle(answers);
		}
	}

	public static void refreshFinalQuestion(HttpServletRequest request) {
		int questionId = Integer.parseInt(request.getParameter("finalquestionid"));
		String question = Coder.toUTF8(request.getParameter("question"));
		String rightAnswer = Coder.toUTF8(request.getParameter("rightAnswer"));
		String alternativeAnswer1 = Coder.toUTF8(request.getParameter("alternativeAnswer1"));
		String alternativeAnswer2 = Coder.toUTF8(request.getParameter("alternativeAnswer2"));

		Logic.getFinalQuestion().refreshFinalQuestion(questionId, question, rightAnswer, alternativeAnswer1,
				alternativeAnswer2);
	}
	
	public static void addFinalQuestion(HttpServletRequest request) {
		int findingId = Integer.parseInt(request.getParameter("findingId"));
		String question = Coder.toUTF8(request.getParameter("question"));
		String rightAnswer = Coder.toUTF8(request.getParameter("rightAnswer"));
		String alternativeAnswer1 = Coder.toUTF8(request.getParameter("alternativeAnswer1"));
		String alternativeAnswer2 = Coder.toUTF8(request.getParameter("alternativeAnswer2"));
		
		Logic.getFinalQuestion().addFinalQuestion(findingId, question, rightAnswer, alternativeAnswer1,
				alternativeAnswer2);
	}

	public static void deleteFinalQuestion(HttpServletRequest request) {
		int questionId = Integer.parseInt(request.getParameter("finalquestionid"));
		Logic.getFinalQuestion().deleteFinalQuestion(questionId);
		
	}
}
