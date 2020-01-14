package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.*;

import java.util.ArrayList;

/**
 * @author Rafael Moreira
 * @author Tiago Ribeiro
 */
public class RatingsRecord implements Serializable{

    /**
     * The list of evaluations of the company.
     */
    private ArrayList<Rating> listOfRatings;

    /**
     * The mean for all the ratings for the company.
     */
    private double populationMean;

    /**
     * The total sum of all the ratings in the company.
     */
    private double totalSumRatings;

    /**
     * Creates an instance of the evaluation order.
     */
    public RatingsRecord() {
        this.listOfRatings = new ArrayList<Rating>();
    }

    /**
     * @return gets the list of evaluations of the company.
     */
    public ArrayList<Rating> getListOfRatings() {
        return listOfRatings;
    }
    
    public void setRatingList(ArrayList<Rating> ratingList){
        listOfRatings = ratingList;
    }

    /**
     * @return gets the population mean.
     */
    public double getPopulationMean() {
        return populationMean;
    }

    /**
     * Creates a rating.
     *
     * @param rating       the rating given by the client.
     * @param completeWork the complete work associatied to the rating.
     * @return the instance of the rating.
     */
    public Rating newRating(String rating, CompleteWork completeWork) {
        return new Rating(rating, completeWork);
    }

    /**
     * Adds a rating to the list of ratings for the company record.
     *
     * @param rating the rating to be added.
     */
    public void addRating(Rating rating) {
        this.listOfRatings.add(rating);
        rating.getCompleteWork().getExecutionOrder().getServiceProvider().addRating(rating);
        totalSumRatings += Double.parseDouble(rating.getRating());
        populationMean = totalSumRatings / (double) listOfRatings.size();
    }

    /**
     * Sets the label for a service provider.
     *
     * @param serviceProvider the service provider to set the label.
     * @param label           the label to set.
     */
    public void setRatingLabel(ServiceProvider serviceProvider, String label) {
        serviceProvider.setRatingLabel(label);
    }
}

