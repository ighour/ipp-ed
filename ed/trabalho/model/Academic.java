package ed.trabalho.model;

/**
 * Academic model. Represent a academic information of a Person.
 */
public class Academic {

    /**
     * Year of academic activity.
     */
    private int year;

    /**
     * Description of activity.
     */
    private String description;

    /**
     * Instantiate with parameters.
     *
     * @param year year
     * @param description description
     */
    public Academic(int year, String description) {
        this.year = year;
        this.description = description;
    }

    /**
     * Get year of academic activity.
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Get description of academic activity.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set year.
     *
     * @param year year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Set description.
     *
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a string representation of a Academic
     *
     * @return a string representation of a Academic
     */
    @Override
    public String toString() {
        return this.description + " / " + this.year;
    }
}
