package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class ServiceProvider extends User implements Serializable {

    /**
     * Institucional e-mail of the service provider
     */
    private String institucionalEmail;
    /**
     * full name of the service provider
     */
    private String fullName;
    /**
     * abreviated name of the service provider
     */
    private String abreviatedName;
    /**
     * company number of the service provider
     */
    private String companyNr;
    /**
     * The postal adress of the service provider.
     */
    private PostalAddress postalAddress;
    /**
     * The label given by the HRO after evaluation.
     */
    private String ratingLabel;
    /**
     * The list of individual ratings.
     */
    private List<Rating> ratingsList = new ArrayList<Rating>();
    /**
     * Container that will aggregate the service provider's availabilities
     */
    private List<Availability> availabilitiesList = new ArrayList<Availability>();
    /**
     * Container that will aggregate the service provider's geographic areas
     */
    private List<GeographicArea> geographicAreasList = new ArrayList<GeographicArea>();
    private List<Category> categoriesList = new ArrayList<Category>();
    /**
     * Institucional e-mail of the service provider by omission
     */
    private static final String INSTITUCIONAL_EMAIL_BY_OMISSION = "no institucional e-mail";
    /**
     * full name of the service provider by omission
     */
    private static final String FULL_NAME_BY_OMISSION = "no full name";
    /**
     * abreviated name of the service provider by omission
     */
    private static final String ABREVIATED_NAME_BY_OMISSION = "no abreviated name";
    /**
     * company number of the service provider by omission
     */
    private static final String COMPANY_NUMBER_BY_OMISSION = "0000";

    /**
     * Builds an instance of ServiceProvider that receives his full name, email
     *
     * @param fullName
     * @param institucionalEmail
     * @param password
     * @param abreviatedName
     * @param companyNr
     */
    public ServiceProvider(String fullName, String password, String institucionalEmail, String abreviatedName, String companyNr, PostalAddress postalAddress) {
        super(institucionalEmail, password, "SERVICE PROVIDER");
        this.fullName = fullName;
        this.institucionalEmail = institucionalEmail;
        this.abreviatedName = abreviatedName;
        this.companyNr = companyNr;
        this.availabilitiesList = new ArrayList<Availability>();
        this.geographicAreasList = new ArrayList<GeographicArea>();
        this.postalAddress = postalAddress;
        this.categoriesList = new ArrayList<Category>();
    }

    /**
     * Builds an instance of service provider that is copy of the one passed by
     * parameter
     *
     * @param otherSP service provider to be copied
     */
    public ServiceProvider(ServiceProvider otherSP) {
        super(otherSP);
        this.fullName = otherSP.fullName;
        this.institucionalEmail = otherSP.institucionalEmail;
        this.abreviatedName = otherSP.abreviatedName;
        this.availabilitiesList = otherSP.availabilitiesList;
        this.geographicAreasList = otherSP.geographicAreasList;
        this.postalAddress = otherSP.postalAddress;
        this.categoriesList = otherSP.categoriesList;
    }

    /**
     * Builds an instance of service provider with the values by omission
     */
    public ServiceProvider() {
        super();
        institucionalEmail = INSTITUCIONAL_EMAIL_BY_OMISSION;
        fullName = FULL_NAME_BY_OMISSION;
        abreviatedName = ABREVIATED_NAME_BY_OMISSION;
        companyNr = COMPANY_NUMBER_BY_OMISSION;
        this.availabilitiesList = new ArrayList<Availability>();
        this.geographicAreasList = new ArrayList<GeographicArea>();
        this.postalAddress = new PostalAddress();
        this.categoriesList = new ArrayList<Category>();
    }

    /**
     * @return Institucional Email of the service provider
     */
    public String getInstitucionalEmail() {
        return institucionalEmail;
    }

    /**
     * @return full name of the service provider
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return abreviated name of the service provider
     */
    public String getAbreviatedName() {
        return abreviatedName;
    }

    /**
     * @return gets the rating label of the service provider.
     */
    public String getRatingLabel() {
        return ratingLabel;
    }

    /**
     * @return company number of the service provider
     */
    public String getCompanyNumber() {
        return companyNr;
    }

    /**
     * @return gets the postal address of the service provider.
     */
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    /**
     * @return availabilities list of the service provider
     */
    public List<Availability> getAvailabilitiesList() {
        return availabilitiesList;
    }

    /**
     * @return geographic areas list of the service provider
     */
    public List<GeographicArea> getGeographicAreasList() {
        return geographicAreasList;
    }
    
    /**
     * @return the categoriesList
     */
    public List<Category> getCategoriesList() {
        return categoriesList;
    }

    /**
     * Changes the institucional email of the service provider
     *
     * @param institucionalEmail institucional email of the service provider
     */
    public void setInstitucionalEmail(String institucionalEmail) {
        if (institucionalEmail == null || institucionalEmail.isEmpty()) {
            throw new IllegalArgumentException("The institucional e-mail should not null or empty.");
        }
        this.institucionalEmail = institucionalEmail;
    }

    /**
     * changes the abreviated name of the service provider
     *
     * @param abreviatedName abreviated name of the service provider
     */
    public void setAbreviatedName(String abreviatedName) {
        if (abreviatedName == null || abreviatedName.isEmpty()) {
            throw new IllegalArgumentException("The abreviated name should not be empty or null.");
        }
        this.abreviatedName = abreviatedName;
    }

    /**
     * changes the full name of the service provider
     *
     * @param fullName full name of the service provider
     */
    public void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("The full name should not be empty or null.");
        }
        this.fullName = fullName;
    }

    /**
     * changes the company number of the service provider
     *
     * @param companyNr company number of the service provider
     */
    public void setCompanyNr(String companyNr) {
        if (companyNr == null || companyNr.isEmpty()) {
            throw new IllegalArgumentException("The company number should not be empty or null.");
        }
        this.companyNr = companyNr;
    }

    /**
     * @param pa the postal addres to be set.
     */
    public void setPostalAddress(PostalAddress pa) {
        if (pa == null) {
            throw new IllegalArgumentException("The postal address is invalid.");
        }
        this.postalAddress = postalAddress;
    }

    /**
     * @param ratingLabel sets the rating label for the service provider.
     */
    public void setRatingLabel(String ratingLabel) {
        if (ratingLabel == null) {
            throw new IllegalArgumentException("The rating should not be null.");
        }
        this.ratingLabel = ratingLabel;
    }

    /**
     * changes the list of availabilities of the service provider
     *
     * @param availabilitiesList list of availabilities of the service provider
     */
    public void setAvailabilitiesList(List<Availability> availabilitiesList) {
        if (availabilitiesList == null || availabilitiesList.isEmpty()) {
            throw new IllegalArgumentException("The availabilities list should not be empty or null.");
        }
        this.availabilitiesList = availabilitiesList;
    }

    /**
     * changes the list of geographic areas of the service provider
     *
     * @param geographicAreasList list of geographic areas of the service
     *                            provider
     */
    public void setGeographicAreasList(List<GeographicArea> geographicAreasList) {
        this.geographicAreasList = geographicAreasList;
    }

    public void setCategoriesList(List<Category> lsrCategories) {
        this.categoriesList = lsrCategories;
    }

    /**
     * Adds an availability to the list of availabilities of the service
     * provider
     *
     * @param newAvailability new availability
     */
    public void addAvailability(Availability newAvailability) {
        if (newAvailability == null) {
            throw new IllegalArgumentException("The availability should not be null.");
        }
        availabilitiesList.add(newAvailability);
    }

    /**
     * Checks if two service providers are equal.
     *
     * @param otherObject the other service provider to compare to.
     * @return true if they are the same and false if it is not.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        ServiceProvider otherSP = (ServiceProvider) otherObject;
        return this.institucionalEmail.equalsIgnoreCase(otherSP.institucionalEmail)
                && this.abreviatedName.equalsIgnoreCase(otherSP.abreviatedName)
                && this.companyNr.equalsIgnoreCase(otherSP.companyNr)
                && this.fullName.equalsIgnoreCase(otherSP.fullName)
                && this.postalAddress.equals(otherSP.postalAddress);
    }

    /**
     * Prints the information of the service provider.
     *
     * @return a string with the information of the service provider.
     */
    @Override
    public String toString() {
        return String.format("Colaborador: %s , Nº Mecanográfico: %s", abreviatedName, companyNr);
    }

    /**
     * Adds a geographic area to the service provider.
     *
     * @param ga the geographic area to add.
     */
    public void addGeographicArea(GeographicArea ga) {
        if (ga == null) {
            throw new IllegalArgumentException("Geographic area should not be null.");
        }
        geographicAreasList.add(ga);
    }

    /**
     * Adds a rating to the individual rating list.
     *
     * @param rating the rating to be added.
     */
    public void addRating(Rating rating) {
        for (Rating value : this.ratingsList) {
            if (rating.getCompleteWork().equals(value.getCompleteWork())) {
                throw new IllegalArgumentException("This rating already exists in the service provider's list!");
            }
        }
        this.ratingsList.add(rating);
    }

    /**
     * Gets the individual mean for the service provider.
     *
     * @return the value of the mean.
     */
    public double getRatingsMean() {
        double totalRatingsSum = 0;
        for (Rating rating : this.ratingsList) {
            totalRatingsSum += Double.parseDouble(rating.getRating());
        }
        return (double) totalRatingsSum / this.ratingsList.size();
    }

    /**
     * Gets the standard deviation of each service provider.
     *
     * @return the standard deviation.
     */
    public double getStandardDeviation() {
        double sd = 0;
        for (int i = 0; i < ratingsList.size(); i++) {
            sd += Math.sqrt(this.getRatingsMean() - Company.getRatingsRecord().getPopulationMean() / ratingsList.size());
            //Company.getRatingsRecord().getListOfRatings().size()
        }
        return sd;
    }

    public static String obtainPassword() {
        int count = 7;
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();

    }
}
