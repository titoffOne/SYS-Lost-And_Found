package datalayer.data;

import java.util.ArrayList;
import java.util.List;

/**
 * The QuestionAnswers class represents a set of questions along with their respective answers.
 */
public class QuestionAnswers {

    private int findingId;
    private String question;
    private List<Answer> answers;

    /**
     * Constructs a QuestionAnswers object with a specific finding ID and question.
     *
     * @param findingId The unique ID associated with the question.
     * @param question  The question text.
     */
    public QuestionAnswers(int findingId, String question) {
        this.findingId = findingId;
        this.question = question;
        this.answers = new ArrayList<>();
    }

    /**
     * Constructs a QuestionAnswers object with a question.
     *
     * @param question The question text.
     */
    public QuestionAnswers(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    /**
     * Adds an answer with its correctness to the list of answers for this question.
     *
     * @param answer    The answer text.
     * @param isCorrect A boolean indicating if the answer is correct or not.
     */
    public void addAnswer(String answer, boolean isCorrect) {
        Answer newAnswer = new Answer(answer, isCorrect);
        answers.add(newAnswer);
    }

    /**
     * Retrieves the question text.
     *
     * @return The question text.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Retrieves the list of answers associated with this question.
     *
     * @return The list of answers.
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * Retrieves the finding ID associated with this question.
     *
     * @return The finding ID.
     */
    public int getFindingId() {
        return findingId;
    }

    /**
     * Sets the finding ID associated with this question.
     *
     * @param findingId The finding ID to be set.
     */
    public void setFindingId(int findingId) {
        this.findingId = findingId;
    }

    /**
     * The Answer class represents an answer to a question and its correctness.
     */
    public static class Answer {
        private String text;
        private boolean isCorrect;

        /**
         * Constructs an Answer object with text and correctness.
         *
         * @param text      The answer text.
         * @param isCorrect A boolean indicating if the answer is correct or not.
         */
        public Answer(String text, boolean isCorrect) {
            this.text = text;
            this.isCorrect = isCorrect;
        }

        /**
         * Retrieves the answer text.
         *
         * @return The answer text.
         */
        public String getText() {
            return text;
        }

        /**
         * Checks if the answer is correct.
         *
         * @return True if the answer is correct, otherwise false.
         */
        public boolean isCorrect() {
            return isCorrect;
        }
    }
}

