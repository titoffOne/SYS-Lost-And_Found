package datalayer;

/**
 * The UserStatusDAO interface provides methods to access and manage user status data in the database.
 */
public interface UserStatusDAO {

    /**
     * Retrieves the status ID for a given status description.
     *
     * @param statusDescription The description of the user status.
     * @return The status ID associated with the given status description.
     */
    int getStatusIdForStatusDescription(String statusDescription);
}
