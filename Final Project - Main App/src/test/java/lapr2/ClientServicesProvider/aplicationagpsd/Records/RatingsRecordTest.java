package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Model.*;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The RatingsRecod record test.
 *
 * @author Rafael Moreira 1180778
 */
class RatingsRecordTest {

    /**
     * Creates a company before each test starts in order to acess the Appliance Record.
     */
    @BeforeEach
    void setUp() {
        Company company = new Company();
    }

    /**
     * Gets list of ratings test.
     */
    @Test
    void getListOfRatings() {
        RatingsRecord instance = new RatingsRecord();
        List<Rating> actual = instance.getListOfRatings();
        List<Rating> expected = new ArrayList<Rating>();
        assertEquals(expected, actual);
    }

    /**
     * Gets population mean test.
     */
    @Test
    void getPopulationMean() {
        RatingsRecord instance = new RatingsRecord();
        double actual = instance.getPopulationMean();
        double expected = 0;
        assertEquals(expected, actual);
    }

    /**
     * New rating test.
     */
    @Test
    void newRating() {
        RatingsRecord instance = new RatingsRecord();
        Rating actual = instance.newRating("1", new CompleteWork());
        Rating expected = new Rating("1", new CompleteWork());
        assertEquals(expected, actual);
    }

    /**
     * Add rating test.
     */
    @Test
    void addRating() {
        RatingsRecord instance = new RatingsRecord();
        ServiceRecord sr = Company.getServiceRecord();
        PostCode postalCode = new PostCode("4000", "009", 2.2, -222.2);
        PostalAddress postalAddress = new PostalAddress("Rua das Amoreiras", "Maia", postalCode);
        ServiceProvider serviceProvider = new ServiceProvider("Tiago Ribeiro", "tiagopass", "tiago@gmail.com", "Tiago R.", "1181444", postalAddress);
        PostCode postalCode2 = new PostCode("4000", "009");
        PostalAddress postalAddress2 = new PostalAddress("Rua das Amoreiras", "Maia", postalCode2);
        Service service = sr.newLimitedService("1", "1", "limpeza", "colchões", "limpeza a seco", 5.5);
        Time duration = new Time(1);
        Date date = new Date(2019, 6, 21);
        Schedule schedule = new Schedule(1, date, duration);
        Time time = new Time(10, 00);
        Client client = new Client("Chris Cornell", "chris@gmail.com", "chrispass", "472549233", "923667234", postalAddress2);
        RequestedServiceDescription requestedServiceDescription = new RequestedServiceDescription(service, "limpeza a fundo", time);
        ExecutionOrder order = new ExecutionOrder(postalAddress2, serviceProvider, client, requestedServiceDescription, schedule, 34);
        CompleteWork completeWork = new CompleteWork("pintura de carro", order);
        Rating rating = new Rating("3", completeWork);
        instance.addRating(rating);
        List<Rating> actual = instance.getListOfRatings();
        List<Rating> expected = new ArrayList<Rating>();
        expected.add(rating);
        assertEquals(expected, actual);
    }

    /**
     * Sets rating label test.
     */
    @Test
    void setRatingLabel() {
        RatingsRecord instance = new RatingsRecord();
        ServiceProvider actual = new ServiceProvider();
        instance.setRatingLabel(actual, "test");
        ServiceProvider expected = new ServiceProvider();
        expected.setRatingLabel("test");
        assertEquals(expected, actual);
    }
}