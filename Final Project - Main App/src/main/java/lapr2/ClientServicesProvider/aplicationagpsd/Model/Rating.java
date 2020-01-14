package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.RatingsRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations;

/**
 * @author Rafael Moreira
 * @author Tiago Ribeiro
 */
public class Rating implements Serializable{

    /**
     * The rating of the service.
     */
    private String rating;

    /**
     * The complete work associated with the rating.
     */
    private CompleteWork completeWork;

    /**
     * The client that rates the execution order.
     */
    private Client client;

    /**
     * The label for the worst providers.
     */
    public final static String WORST_PROVIDER = "Worst Providers";

    /**
     * The label for the regular providers.
     */
    public final static String REGULAR_PROVIDER = "Regular Providers";

    /**
     * the label for the outstanding providers.
     */
    public final static String OUTSTANDING_PROVIDER = "Outstanding Providers";

    /**
     * The rating of the rating by omission.
     */
    private final static String RATING_BY_OMISSION = "Without rating";

    /**
     * The execution order by omission for the rating.
     */
    private final static CompleteWork COMPLETEWORK_BY_OMISSION = new CompleteWork();

    /**
     * The client of the rating by omission.
     */
    private final static Client CLIENT_BY_OMISSION = new Client();

    /**
     * Creates a rating with all the parameters.
     *
     * @param rating       the rating given by the client.
     * @param completeWork the execution order that is being evaluated.
     */
    public Rating(String rating, CompleteWork completeWork) {
        this.setRating(rating);
        this.setClient(completeWork.getExecutionOrder().getCli());
        this.setCompleteWork(completeWork);
    }

    /**
     * Creates an instance with the parameters by omission.
     */
    public Rating() {
        this.rating = RATING_BY_OMISSION;
        this.client = CLIENT_BY_OMISSION;
        this.completeWork = COMPLETEWORK_BY_OMISSION;
    }

    /**
     * @return the rating of the instance.
     */
    public String getRating() {
        return rating;
    }

    /**
     * @return the execution order associated to the rating.
     */
    public CompleteWork getCompleteWork() {
        return completeWork;
    }

    /**
     * @return the client that rates the order.
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param rating Sets the rating.
     */
    public void setRating(String rating) {
        if (!Validations.isNumeric(rating)) {
            throw new IllegalArgumentException("The given rating is not a number.");
        }
        if (Integer.parseInt(rating) < 1 || Integer.parseInt(rating) > 5) {
            throw new IllegalArgumentException("The rating is not valid");
        }
        this.rating = rating;
    }

    /**
     * @param completeWork sets the complete work.
     */
    public void setCompleteWork(CompleteWork completeWork) {
        if (completeWork == null) {
            throw new IllegalArgumentException("The execution order is null");
        }
        this.completeWork = completeWork;
    }

    /**
     * @param client sets the client.
     */
    public void setClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("The client is null");
        }
        this.client = client;
    }

    /**
     * Compares two instance of ratings.
     *
     * @param otherRating other rating to compare to.
     * @return true if the ratings are equal, false if not.
     */
    @Override
    public boolean equals(Object otherRating) {
        if (this == otherRating) return true;
        if (!(otherRating instanceof Rating)) return false;
        Rating rating1 = (Rating) otherRating;
        return getRating().equals(rating1.getRating()) && getCompleteWork().equals(rating1.getCompleteWork()) && getClient().equals(rating1.getClient());
    }

    /**
     * Prints the instance of the rating.
     *
     * @return the information of the rating.
     */
    @Override
    public String toString() {
        return String.format("Rating: %s; Execution Order: %s; Client: %s", this.rating, this.completeWork.getExecutionOrder().getSequencialIdentifier(), this.client.getName());
    }

    /**
     * Sets the rating label of the service provider.
     */
    public void generateRatingLabel(ServiceProvider serviceProvider) {
        RatingsRecord rr = Company.getRatingsRecord();
        double labelCriteria = rr.getPopulationMean() - serviceProvider.getStandardDeviation();
        if (Double.parseDouble(this.rating) < labelCriteria) {
            this.getCompleteWork().getExecutionOrder().getServiceProvider().setRatingLabel(WORST_PROVIDER);
        } else if (Double.parseDouble(this.rating) > labelCriteria) {
            this.getCompleteWork().getExecutionOrder().getServiceProvider().setRatingLabel(OUTSTANDING_PROVIDER);
        } else {
            this.getCompleteWork().getExecutionOrder().getServiceProvider().setRatingLabel(REGULAR_PROVIDER);
        }
    }
}
