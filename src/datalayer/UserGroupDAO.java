package datalayer;

/**
 * The UserGroupDAO interface provides methods to access and manage user group data in the database.
 */
public interface UserGroupDAO {

    /**
     * Retrieves the group ID for a given group name.
     *
     * @param groupName The name of the user group.
     * @return The group ID associated with the given group name.
     */
    int getGroupIdForGroupName(String groupName);
}
