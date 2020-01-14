package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;

/**
 * Class that allows to create a professional qualification.
 *
 * @author Rafael Moreira 1180778.
 */
public class ProfessionalQualification implements Serializable{

    /**
     * Description of the professional qualification.
     */
    private String description;

    /**
     * Description of the professional qualification by omission.
     */
    private static final String DESCRIPTION_BY_OMISSION = "Without professional qualification.";

    /**
     * Creates a professional qualification with all the parameters.
     *
     * @param description description of the professional qualification.
     */
    public ProfessionalQualification(String description) {
        this.setDescription(description);
    }

    /**
     * Creates a professional qualification with the parameters by omission.
     */
    public ProfessionalQualification() {
        this.description = DESCRIPTION_BY_OMISSION;
    }

    /**
     * Gets the description of a Professional Qualification.
     *
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of a Professional Qualification.
     *
     * @param description the description to be set.
     */
    public void setDescription(String description) {
        if (description.equals(null))
            throw new IllegalArgumentException("Invalid Description");
        this.description = description;
    }

    /**
     * Checks if a Professional Qualification is equal to another.
     *
     * @return true if the professional qualification is equal or false if it is not.
     */
    @Override
    public boolean equals(Object otherProfessionalQualification) {
        if (this == otherProfessionalQualification) {
            return true;
        }
        if (otherProfessionalQualification == null || otherProfessionalQualification.getClass() != ProfessionalQualification.class) {
            return false;
        }

        ProfessionalQualification pq = (ProfessionalQualification) otherProfessionalQualification;
        return this.description.equalsIgnoreCase(pq.getDescription());
    }

    /**
     * Prints a professional qualification.
     *
     * @return a string with the information of the professional qualification.
     */
    @Override
    public String toString() {
        return String.format("Professional Qualification: %s", this.description);
    }

}
