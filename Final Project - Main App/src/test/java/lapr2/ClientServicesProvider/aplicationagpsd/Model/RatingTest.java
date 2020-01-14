package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.RatingsRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Rating test.
 *
 * @author Rafael Moreira 1180778
 */
class RatingTest {

    /**
     * Gets rating.
     */
    @Test
    void getRating() {
        Rating instance = new Rating();
        String actual = instance.getRating();
        String expected = "Without rating";
        assertEquals(expected, actual);
    }

    /**
     * Gets complete work.
     */
    @Test
    void getCompleteWork() {
        Rating instance = new Rating();
        CompleteWork actual = instance.getCompleteWork();
        CompleteWork expected = new CompleteWork();
        assertEquals(expected, actual);
    }

    /**
     * Gets client.
     */
    @Test
    void getClient() {
        Rating instance = new Rating();
        Client actual = instance.getClient();
        Client expected = new Client();
        assertEquals(expected, actual);
    }

    /**
     * Sets rating.
     */
    @Test
    void setRating() {
        Rating instance = new Rating();
        instance.setRating("2");
        String actual = instance.getRating();
        String expected = "2";
        assertEquals(expected, actual);
    }

    /**
     * Sets complete work.
     */
    @Test
    void setCompleteWork() {
        Rating instance = new Rating();
        instance.setCompleteWork(new CompleteWork());
        CompleteWork actual = instance.getCompleteWork();
        CompleteWork expected = new CompleteWork();
        assertEquals(expected, actual);
    }

    /**
     * Sets client.
     */
    @Test
    void setClient() {
        Rating instance = new Rating();
        instance.setClient(new Client());
        Client actual = instance.getClient();
        Client expected = new Client();
        assertEquals(expected, actual);
    }

    /**
     * Equals test Null.
     */
    @Test
    void equalsTestNull() {
        Rating instance = new Rating();
        boolean expected = false;
        boolean actual = instance.equals(null);
        assertEquals(expected, actual);
    }

    /**
     * Equals test same object.
     */
    @Test
    void equalsTestSameObject() {
        Rating instance = new Rating();
        boolean expected = true;
        boolean actual = instance.equals(instance);
        assertEquals(expected, actual);
    }

    /**
     * Equals test different class.
     */
    @Test
    void equalsTestDifferentClass() {
        Rating instance = new Rating();
        Client instance2 = new Client();
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Equals test parameters.
     */
    @Test
    void equalsTestParameters() {
        Rating instance = new Rating("2", new CompleteWork());
        Rating instance2 = new Rating("3", new CompleteWork());
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * To string test.
     */
    @Test
    void toStringTest() {
        Rating instance = new Rating();
        String actual = instance.toString();
        String expected = "Rating: Without rating; Execution Order: Without Sequential Number; Client: no name";
        assertEquals(expected, actual);
    }

    /**
     * Sets rating label.
     */
    /*
    TODO FINISH THIS TEST
    @Test
    void generateRatingLabel() {
        Rating instance = new Rating();
        ServiceProvider sp = new ServiceProvider();
        instance.generateRatingLabel(sp);
        String actual = sp.getRatingLabel();
        String expected = "Regular Providers";
        assertEquals(expected, actual);
    }
     */
}