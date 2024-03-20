package datalayer;

import java.util.HashMap;
import java.util.List;

import datalayer.data.SystemUser;

/**
 * The SystemUserDAO interface provides methods to access and manage SystemUser data in the database.
 */
public interface SystemUserDAO {

    /**
     * Retrieves a list of all system users.
     *
     * @return A list of SystemUser objects representing all system users.
     */
    List<SystemUser> getSystemUsers();

    /**
     * Retrieves a list of all clients.
     *
     * @return A list of SystemUser objects representing clients.
     */
    List<SystemUser> getClients();

    /**
     * Retrieves a HashMap containing logins as keys and passwords as values.
     *
     * @return A HashMap with logins as keys and passwords as values.
     */
    HashMap<String, String> getLoginsAndPasswds();

    /**
     * Retrieves the group ID associated with a given login.
     *
     * @param login The login for which the group ID is to be retrieved.
     * @return The group ID associated with the login.
     */
    int getGroupIdForLogin(String login);

    /**
     * Retrieves the user ID associated with a given login.
     *
     * @param login The login for which the user ID is to be retrieved.
     * @return The user ID associated with the login.
     */
    int getUserIDforLogin(String login);

    /**
     * Retrieves the SystemUser associated with a given user ID.
     *
     * @param userID The user ID for which the SystemUser object is to be retrieved.
     * @return The SystemUser object associated with the user ID.
     */
    SystemUser getSystemUserForUserID(int userID);

    /**
     * Updates the fullname, phone, and email for a given user ID.
     *
     * @param fullname The new fullname to set.
     * @param login    The login associated with the user.
     * @param email    The new email to set.
     * @param userId   The user ID for which details are to be updated.
     */
    void UpdateFullnamePhoneEmailForUserId(String fullname, String login, String email, int userId);

    /**
     * Updates the user status for a given user ID.
     *
     * @param userId The user ID for which the status is to be updated.
     */
    void UpdateUserStatusForUserId(int userId);

    /**
     * Deletes a user for a given user ID.
     *
     * @param userId The user ID of the user to be deleted.
     */
    void DeleteUserForUserId(int userId);

    /**
     * Retrieves the status ID for a given user ID.
     *
     * @param userId The user ID for which the status ID is to be retrieved.
     * @return The status ID associated with the user ID.
     */
    int getUserStatusID(int userId);

    /**
     * Adds a new user with the provided details.
     *
     * @param fullname The fullname of the new user.
     * @param email    The email of the new user.
     * @param login    The login of the new user.
     * @param password The password of the new user.
     * @param status   The status of the new user.
     * @param group    The group of the new user.
     */
    void addNewUser(String fullname, String email, String login, String password, int status, int group);

    /**
     * Changes user details for the given user ID.
     *
     * @param userID   The user ID of the user to be updated.
     * @param fullname The new fullname.
     * @param email    The new email.
     * @param login    The new login.
     * @param password The new password.
     * @param status   The new status.
     * @param group    The new group.
     */
    void changeUser(int userID, String fullname, String email, String login, String password, int status, int group);
}