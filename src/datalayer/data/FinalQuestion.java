package datalayer.data;

/**
 * The FinalQuestion class represents a question related to a specific finding or discovery.
 */
public class FinalQuestion {

    private int questionId;
    private int findingId;
    private String question;
    private String rightAnswer;
    private String alternativeAnswer1;
    private String alternativeAnswer2;

    /**
     * Constructs a FinalQuestion object with specified attributes including finding ID.
     *
     * @param id                 The unique identifier of the question.
     * @param findingId          The associated finding's ID.
     * @param question           The text of the question.
     * @param rightAnswer        The correct answer to the question.
     * @param alternativeAnswer1 An alternative answer.
     * @param alternativeAnswer2 Another alternative answer.
     */
    public FinalQuestion(int id, int findingId, String question, String rightAnswer,
                         String alternativeAnswer1, String alternativeAnswer2) {
        this.questionId = id;
        this.findingId = findingId;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.alternativeAnswer1 = alternativeAnswer1;
        this.alternativeAnswer2 = alternativeAnswer2;
    }

    /**
     * Constructs a FinalQuestion object without finding ID.
     *
     * @param id                 The unique identifier of the question.
     * @param question           The text of the question.
     * @param rightAnswer        The correct answer to the question.
     * @param alternativeAnswer1 An alternative answer.
     * @param alternativeAnswer2 Another alternative answer.
     */
    public FinalQuestion(int id, String question, String rightAnswer,
                         String alternativeAnswer1, String alternativeAnswer2) {
        this.questionId = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.alternativeAnswer1 = alternativeAnswer1;
        this.alternativeAnswer2 = alternativeAnswer2;
    }

    /**
     * Retrieves the ID of the question.
     *
     * @return The ID of the question.
     */
    public int getId() {
        return questionId;
    }

    /**
     * Sets the ID of the question.
     *
     * @param id The ID to set for the question.
     */
    public void setId(int id) {
        this.questionId = id;
    }

    /**
     * Retrieves the finding ID associated with the question.
     *
     * @return The finding ID of the question.
     */
    public int getFindingId() {
        return findingId;
    }

    /**
     * Sets the finding ID associated with the question.
     *
     * @param findingId The finding ID to set for the question.
     */
    public void setFindingId(int findingId) {
        this.findingId = findingId;
    }

    /**
     * Retrieves the text of the question.
     *
     * @return The text of the question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the text of the question.
     *
     * @param question The text to set for the question.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retrieves the correct answer to the question.
     *
     * @return The correct answer.
     */
    public String getRightAnswer() {
        return rightAnswer;
    }

    /**
     * Sets the correct answer to the question.
     *
     * @param rightAnswer The correct answer to set.
     */
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    /**
     * Retrieves an alternative answer associated with the question.
     *
     * @return The first alternative answer.
     */
    public String getAlternativeAnswer1() {
        return alternativeAnswer1;
    }

    /**
     * Sets the first alternative answer associated with the question.
     *
     * @param alternativeAnswer1 The first alternative answer to set.
     */
    public void setAlternativeAnswer1(String alternativeAnswer1) {
        this.alternativeAnswer1 = alternativeAnswer1;
    }

    /**
     * Retrieves another alternative answer associated with the question.
     *
     * @return The second alternative answer.
     */
    public String getAlternativeAnswer2() {
        return alternativeAnswer2;
    }

    /**
     * Sets the second alternative answer associated with the question.
     *
     * @param alternativeAnswer2 The second alternative answer to set.
     */
    public void setAlternativeAnswer2(String alternativeAnswer2) {
        this.alternativeAnswer2 = alternativeAnswer2;
    }
}
