package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class that allows to create an academic qualification.
 *
 * @author Rafael Moreira 1180778.
 */
public class AcademicQualification implements Serializable{

    /**
     * The degree of the academic qualification.
     */
    private String degree;

    /**
     * The designation of the academic qualification.
     */
    private String designation;

    /**
     * The classification of the academic qualification.
     */
    private String classification;

    /**
     * Degree of the qualification by omission.
     */
    private static final String DEGREE_BY_OMISSION = "Without Degree";

    /**
     * Designation of the qualification by omission.
     */
    private static final String DESIGNATION_BY_OMISSION = "Without Designation";

    /**
     * Classification of the qualification by omission.
     */
    private static final String CLASSIFICATION_BY_OMISSION = "Without Classification";

    /**
     * Creates a professional qualification with all the parameters.
     *
     * @param degree         degree of the professional qualification.
     * @param designation    designation of the professional qualification.
     * @param classification classification of the professional qualification.
     */
    public AcademicQualification(String degree, String designation, String classification) {
        this.degree = degree;
        this.designation = designation;
        this.classification = classification;
    }

    /**
     * Creates a professional qualfication with all the parameters by omission.
     */
    public AcademicQualification() {
        this.degree = DEGREE_BY_OMISSION;
        this.designation = DESIGNATION_BY_OMISSION;
        this.classification = CLASSIFICATION_BY_OMISSION;
    }

    /**
     * Gets the degree of the Academic Qualification.
     *
     * @return the degree of the Academic Qualification.
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Gets the Designation of the Academic Qualification.
     *
     * @return the degignation of the Academic Qualification.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Gets the Classification of the Academic Qualification.
     *
     * @return the classification of the Academic Qualification.
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Sets the Degree of the Academic Qualification.
     *
     * @param degree the degree to be set.
     */
    public void setDegree(String degree) {
        if (degree == null)
            throw new IllegalArgumentException("Invalid Degree");
        this.degree = degree;
    }

    /**
     * Sets the Designation of the Academic Qualification.
     *
     * @param designation the designation to be set.
     */
    public void setDesignation(String designation) {
        if (designation == null)
            throw new IllegalArgumentException("Invalid Designation");
        this.designation = designation;
    }

    /**
     * Sets the Classification of the Academic Qualification.
     *
     * @param classification the classification to be set.
     */
    public void setClassification(String classification) {
        if (classification == null)
            throw new IllegalArgumentException("Invalid Classification");
        this.classification = classification;
    }

    /**
     * Checks if an Academic Qualification is equal to another.
     *
     * @return true if the academic qualification is equal or false if it is not.
     */
    @Override
    public boolean equals(Object otherAcademicQualification) {
        if (this == otherAcademicQualification) {
            return true;
        }
        if (otherAcademicQualification == null || otherAcademicQualification.getClass() != AcademicQualification.class) {
            return false;
        }

        AcademicQualification aq = (AcademicQualification) otherAcademicQualification;
        return this.degree.equalsIgnoreCase(aq.getDegree()) && this.designation.equalsIgnoreCase(aq.getDesignation()) && this.classification.equalsIgnoreCase(aq.getClassification());
    }

    /**
     * Hash Code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getDegree(), getDesignation(), getClassification());
    }

    /**
     * Prints an Academic Qualification.
     *
     * @return a string with the information of the academic qualification.
     */
    @Override
    public String toString() {
        return String.format("Degree: %s; Designation: %s; Classification: %s", this.degree, this.designation, this.classification);
    }
}
