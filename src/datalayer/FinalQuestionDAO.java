package datalayer;

import java.util.List;

import datalayer.data.FinalQuestion;

/**
 * The FinalQuestionDAO interface provides methods to access and manage final question data in the database.
 */
public interface FinalQuestionDAO {

    /**
     * Retrieves a list of final questions based on a given finding ID.
     *
     * @param currentFindingId The ID of the finding.
     * @return A list of FinalQuestion objects associated with the finding ID.
     */
    List<FinalQuestion> getFinalQuestionByFindingsId(int currentFindingId);

    /**
     * Retrieves a specific final question for a given question ID.
     *
     * @param currentQuestionId The ID of the question.
     * @return The FinalQuestion object associated with the question ID.
     */
    FinalQuestion getFinalQuestionById(int currentQuestionId);

    /**
     * Updates details of a specific final question.
     *
     * @param questionId           The ID of the final question to update.
     * @param question             The updated question text.
     * @param rightAnswer          The updated correct answer.
     * @param alternativeAnswer1   The updated first alternative answer.
     * @param alternativeAnswer2   The updated second alternative answer.
     */
    void refreshFinalQuestion(int questionId, String question, String rightAnswer,
                              String alternativeAnswer1, String alternativeAnswer2);

    /**
     * Adds a new final question.
     *
     * @param findingId            The ID of the associated finding.
     * @param question             The question text.
     * @param rightAnswer          The correct answer.
     * @param alternativeAnswer1   The first alternative answer.
     * @param alternativeAnswer2   The second alternative answer.
     */
    void addFinalQuestion(int findingId, String question, String rightAnswer, String alternativeAnswer1,
                          String alternativeAnswer2);

    /**
     * Deletes final questions associated with a given finding ID.
     *
     * @param findingId The ID of the finding.
     */
    void deleteFinalQuestionsForFindingId(int findingId);

    /**
     * Deletes a specific final question for a given question ID.
     *
     * @param questionId The ID of the question to delete.
     */
    void deleteFinalQuestion(int questionId);
}
