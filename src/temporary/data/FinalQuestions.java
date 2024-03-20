package temporary.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import datalayer.data.FinalQuestion;
import datalayer.data.Finding;
import datalayer.data.QuestionAnswers;

public class FinalQuestions {
	public static List<FinalQuestion> finalQuestionsList = new ArrayList<FinalQuestion>();

	static {
		initializeFinalQuestions();
	}

	private static void initializeFinalQuestions() {
		finalQuestionsList.add(new FinalQuestion(1, 1, "Какого цвета?", "Желтая", "Синяя", "Красная"));
		finalQuestionsList.add(new FinalQuestion(2, 1, "Из какого материала?", "Медь", "Золото", "Сталь"));
		finalQuestionsList.add(new FinalQuestion(3, 1, "Кто на монете изображен?", "Петр 1", "Иван 2", "Григорий 1"));
		finalQuestionsList.add(new FinalQuestion(1, 2, "Это вопрос 1?", "Желтая", "Синяя", "Красная"));
		finalQuestionsList.add(new FinalQuestion(2, 2, "Это вопрос 2?", "Медь", "Золото", "Сталь"));
		finalQuestionsList.add(new FinalQuestion(3, 2, "Это вопрос 3?", "Петр 1", "Иван 2", "Григорий 1"));

	}

	public static int getFindingIdForQuestionId(int questionId) {
		for (FinalQuestion question : finalQuestionsList) {
			if (question.getId() == questionId) {
				return question.getFindingId();
			}
		}
		return questionId;

	}

	public static List<FinalQuestion> getQuestionsForFinding(int findingId) {
		List<FinalQuestion> questionsForFinding = new ArrayList<>();
		for (FinalQuestion question : finalQuestionsList) {
			if (question.getFindingId() == findingId) {
				questionsForFinding.add(question);
			}
		}
		return questionsForFinding;
	}

	public static List<QuestionAnswers> getQuestionsByFinding(int findingId) {
		QuestionAnswers questionAnswer;
		List<QuestionAnswers> questionsForFinding = new ArrayList<>();
		for (FinalQuestion question : finalQuestionsList) {
			if (question.getFindingId() == findingId) {
				questionAnswer = new QuestionAnswers(1, question.getQuestion());
				questionAnswer.addAnswer(question.getRightAnswer(), true);
				questionAnswer.addAnswer(question.getAlternativeAnswer1(), false);
				questionAnswer.addAnswer(question.getAlternativeAnswer2(), false);

				questionsForFinding.add(questionAnswer);
			}
		}
		FinalQuestions.shuffleAnswers(questionsForFinding);
		return questionsForFinding;
	}

	public static void shuffleAnswers(List<QuestionAnswers> quizQuestions) {
		for (QuestionAnswers question : quizQuestions) {
			List<QuestionAnswers.Answer> answers = question.getAnswers();
			Collections.shuffle(answers);
		}
	}

}
