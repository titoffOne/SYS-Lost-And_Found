package datalayer.data;

import java.sql.Date;


/**
 * The Finding class represents an entity for a particular discovery or finding.
 */
public class Finding {
    private int id;
    private String name;
    private Date date;
    private String place;
    private String description;
    private String receiver;
    private String owner;
    private String status;
    private String category;

    /**
     * Default constructor for the Finding class.
     */
    public Finding() {
        // Default constructor
    }

    /**
     * Represents a null finding instance.
     */
    public static final Finding NULL_FINDING = new Finding() {};

    /**
     * Constructs a Finding object with specified attributes.
     *
     * @param id          The unique identifier of the finding.
     * @param name        The name or title of the finding.
     * @param date        The date when the finding occurred or was discovered.
     * @param place       The location or place where the finding was discovered.
     * @param description The description or details of the finding.
     * @param receiver    The recipient or receiver associated with the finding.
     * @param owner       The owner or person related to the finding.
     * @param status      The status of the finding.
     * @param category    The category or classification of the finding.
     */
    public Finding(int id, String name, Date date, String place, String description, String receiver, String owner,
                   String status, String category) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
        this.description = description;
        this.receiver = receiver;
        this.owner = owner;
        this.status = status;
        this.category = category;
    }

    /**
     * Retrieves the ID of the finding.
     *
     * @return The ID of the finding.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the finding.
     *
     * @param id The ID to set for the finding.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the finding.
     *
     * @return The name of the finding.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the finding.
     *
     * @param name The name to set for the finding.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the date of the finding.
     *
     * @return The date of the finding.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the finding.
     *
     * @param date The date to set for the finding.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Retrieves the place of the finding.
     *
     * @return The place of the finding.
     */
    public String getPlace() {
        return place;
    }

    /**
     * Sets the place of the finding.
     *
     * @param place The place to set for the finding.
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Retrieves the description of the finding.
     *
     * @return The description of the finding.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the finding.
     *
     * @param description The description to set for the finding.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the receiver associated with the finding.
     *
     * @return The receiver of the finding.
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Sets the receiver associated with the finding.
     *
     * @param receiver The receiver to set for the finding.
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * Retrieves the owner of the finding.
     *
     * @return The owner of the finding.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the finding.
     *
     * @param owner The owner to set for the finding.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Retrieves the status of the finding.
     *
     * @return The status of the finding.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the finding.
     *
     * @param status The status to set for the finding.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retrieves the category of the finding.
     *
     * @return The category of the finding.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the finding.
     *
     * @param category The category to set for the finding.
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
