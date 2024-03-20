package datalayer.data;

/**
 * The SystemUser class represents a user entity in the system.
 */
public class SystemUser {
    private int userID;
    private String fullName;
    private String email;
    private String login;
    private String password;
    private String status;
    private String group;

    /**
     * Represents a null system user instance.
     */
    public static final SystemUser NULL_SYSTEM_USER = new SystemUser() {};

    /**
     * Constructs a SystemUser object with provided attributes.
     *
     * @param userID   The ID of the user.
     * @param fullName The full name of the user.
     * @param email    The email address of the user.
     * @param login    The login username of the user.
     * @param password The password of the user.
     * @param status   The status of the user.
     * @param group    The group of the user.
     */
    public SystemUser(int userID, String fullName, String email, String login, String password, String status, String group) {
        this.userID = userID;
        this.fullName = fullName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.status = status;
        this.group = group;
    }

    private SystemUser() {
        // Private constructor for NULL_SYSTEM_USER
    }

    /**
     * Retrieves the ID of the user.
     *
     * @return The user ID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the ID of the user.
     *
     * @param userID The user ID to be set.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the full name of the user.
     *
     * @return The full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the user.
     *
     * @param fullName The full name to be set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the login username of the user.
     *
     * @return The login username.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login username of the user.
     *
     * @param login The login username to be set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the status of the user.
     *
     * @return The user status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the user.
     *
     * @param status The status to be set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retrieves the group of the user.
     *
     * @return The user group.
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the group of the user.
     *
     * @param group The group to be set.
     */
    public void setGroup(String group) {
        this.group = group;
    }
}
