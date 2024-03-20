package datalayer;
import java.sql.Date;
import java.util.List;

import datalayer.data.Finding;

/**
 * The FindingDAO interface provides methods to access and manage finding data in the database.
 */
public interface FindingDAO {

    /**
     * Retrieves a list of all findings.
     *
     * @return A list of Finding objects representing all findings.
     */
    List<Finding> getFindings();

    /**
     * Retrieves a list of free findings (findings not assigned to any receiver).
     *
     * @return A list of Finding objects representing free findings.
     */
    List<Finding> getFreeFindings();

    /**
     * Retrieves findings associated with a receiver.
     *
     * @param receiverID The ID of the receiver.
     * @return A list of Finding objects associated with the receiver.
     */
    List<Finding> getFindingsForReceiver(int receiverID);

    /**
     * Retrieves findings associated with a user.
     *
     * @param userId The ID of the user.
     * @return A list of Finding objects associated with the user.
     */
    List<Finding> getFindingsForUser(int userId);

    /**
     * Retrieves a specific finding for a given finding ID.
     *
     * @param findingId The ID of the finding to retrieve.
     * @return The Finding object associated with the finding ID.
     */
    Finding getFindingForFindingID(int findingId);

    /**
     * Updates details of a specific finding.
     *
     * @param findingID          The ID of the finding to update.
     * @param findingName        The new name for the finding.
     * @param findingDate        The new date for the finding.
     * @param findingPlace       The new place for the finding.
     * @param findingDescription The new description for the finding.
     * @param category           The new category for the finding.
     */
    void changeFinding(int findingID, String findingName, Date findingDate, String findingPlace,
                       String findingDescription, int category);

    /**
     * Adds a new finding with provided details.
     *
     * @param findingName        The name of the new finding.
     * @param findingDate        The date of the new finding.
     * @param findingPlace       The place of the new finding.
     * @param findingDescription The description of the new finding.
     * @param receiver           The receiver associated with the new finding.
     * @param category           The category of the new finding.
     */
    void addNewFinding(String findingName, Date findingDate, String findingPlace, String findingDescription,
                       int receiver, int category);

    /**
     * Sets a user for a specific finding.
     *
     * @param findingId The ID of the finding.
     * @param userId    The ID of the user to set for the finding.
     */
    void setUserForFinding(int findingId, int userId);

    /**
     * Deletes a finding for a given finding ID.
     *
     * @param findingID The ID of the finding to delete.
     */
    void deleteFindingForId(int findingID);
}
