package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Availability;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class DecideAvailabilityControllerTest {
    
    public DecideAvailabilityControllerTest() {
    }

    /**
     * Test of initialize method, of class DecideAvailabilityController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        DecideAvailabilityController instance = new DecideAvailabilityController();
        instance.initialize(url, rb);
    }
    
    /**
     * Test of getAvailability method, of class DecideAvailabilityController.
     */
    @Test
    public void testGetAvailability() {
        System.out.println("getAvailability");
        DecideAvailabilityController instance = new DecideAvailabilityController();
        Availability expResult = new Availability();
        instance.setAvailability(expResult);
        Availability result = instance.getAvailability();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setAvailability method, of class DecideAvailabilityController.
     */
    @Test
    public void testSetAvailability() {
        System.out.println("setCli");
        Availability ava = new Availability();
        DecideAvailabilityController instance = new DecideAvailabilityController();
        instance.setAvailability(ava);
        assertEquals(ava, instance.getAvailability());
    }

    /**
     * Test of newAvailability method, of class DecideAvailabilityController.
     */
    @Test
    public void testNewAvailability() {
        System.out.println("newAvailability");
        Company c = new Company();
        Date startDate = new Date(2019,8,8);
        Date endDate = new Date(2019,8,8);
        Time startTime = new Time(15,15);
        Time endTime = new Time(16,16);
        Availability ava = new Availability(startDate, endDate, startTime, endTime);
        DecideAvailabilityController instance = new DecideAvailabilityController();
        instance.newAvailability(startDate, endDate, startTime, endTime);
        assertEquals(instance.getAvailability(), ava);
    }
}
