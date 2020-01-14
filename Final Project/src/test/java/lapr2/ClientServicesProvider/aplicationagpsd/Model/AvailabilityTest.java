package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class AvailabilityTest {

    public AvailabilityTest() {
    }

    /**
     * Test of getStartDate method, of class Availability.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Availability instance = new Availability();
        Date expResult = new Date();
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndDate method, of class Availability.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        Availability instance = new Availability();
        Date expResult = new Date();
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartTime method, of class Availability.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Availability instance = new Availability();
        Time expResult = new Time();
        Time result = instance.getStartTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndTime method, of class Availability.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Availability instance = new Availability();
        Time expResult = new Time();
        Time result = instance.getEndTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartDate method, of class Availability.
     */
    @Test
    public void testSetStartDate_Date() {
        System.out.println("setStartDate");
        Date startDate = new Date();
        Availability instance = new Availability();
        instance.setStartDate(startDate);
        assertEquals(startDate, instance.getStartDate());
    }

    /**
     * Test of setStartDate method, of class Availability.
     */
    @Test
    public void testSetStartDate_3args() {
        System.out.println("setStartDate");
        int year = 2019;
        int month = 8;
        int day = 8;
        Date d = new Date(year, month, day);
        Availability instance = new Availability();
        instance.setStartDate(year, month, day);
        assertEquals(d, instance.getStartDate());
    }

    /**
     * Test of setEndDate method, of class Availability.
     */
    @Test
    public void testSetEndDate_Date() {
        System.out.println("setEndDate");
        Date endDate = new Date();
        Availability instance = new Availability();
        instance.setEndDate(endDate);
        assertEquals(endDate, instance.getEndDate());
    }

    /**
     * Test of setEndDate method, of class Availability.
     */
    @Test
    public void testSetEndDate_3args() {
        System.out.println("setEndDate");
        int year = 2019;
        int month = 8;
        int day = 8;
        Date de = new Date(year, month, day);
        Availability instance = new Availability();
        instance.setEndDate(year, month, day);
        assertEquals(de, instance.getEndDate());
    }

    /**
     * Test of setStartTime method, of class Availability.
     */
    @Test
    public void testSetStartTime_Time() {
        System.out.println("setStartTime");
        Time startTime = new Time();
        Availability instance = new Availability();
        instance.setStartTime(startTime);
        assertEquals(startTime, instance.getStartTime());
    }

    /**
     * Test of setStartTime method, of class Availability.
     */
    @Test
    public void testSetStartTime_int_int() {
        System.out.println("setStartTime");
        int hour = 15;
        int minutes = 30;
        Time t = new Time(hour, minutes);
        Availability instance = new Availability();
        instance.setStartTime(hour, minutes);
        assertEquals(t, instance.getStartTime());
    }

    /**
     * Test of setEndTime method, of class Availability.
     */
    @Test
    public void testSetEndTime_Time() {
        System.out.println("setEndTime");
        Time endTime = new Time();
        Availability instance = new Availability();
        instance.setEndTime(endTime);
        assertEquals(endTime, instance.getEndTime());
    }

    /**
     * Test of setEndTime method, of class Availability.
     */
    @Test
    public void testSetEndTime_int_int() {
        System.out.println("setEndTime");
        int hour = 15;
        int minutes = 15;
        Time end = new Time(15, 15);
        Availability instance = new Availability();
        instance.setEndTime(hour, minutes);
        assertEquals(end, instance.getEndTime());
    }

    /**
     * Test of newAvailability method, of class Availability.
     */
    @Test
    public void testNewAvailability() {
        System.out.println("newAvailability");
        Date start = new Date(2019, 8, 8);
        Date end = new Date(2019, 8, 8);
        Time startTime = new Time(15, 15);
        Time endTime = new Time(15, 15);
        Availability instance = new Availability();
        Availability expResult = instance.newAvailability(start, end, startTime, endTime);
        Availability result = instance.newAvailability(start, end, startTime, endTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Availability.
     */
    @Test
    public void testEquals() {
        System.out.println("equals 1 : same reference");
        Object obj = new Availability();
        Availability instance = new Availability();
        instance = (Availability)obj;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Availability.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals 2 : null object");
        Object obj = null;
        Availability instance = new Availability();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Availability.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals 3 : objects of different classes");
        Object obj = new Object();
        Availability instance = new Availability();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Availability.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals 4 : objects are equal");
        Date start = new Date(2019, 8, 8);
        Date end = new Date(2019, 8, 8);
        Time startTime = new Time(15, 15);
        Time endTime = new Time(15, 15);
        Object obj = new Availability(start,end,startTime,endTime);
        Availability instance = new Availability(start,end,startTime,endTime);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Availability.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Date start = new Date(2019, 6, 11);
        Date end = new Date(2019, 6, 11);
        Time startTime = new Time(15, 00);
        Time endTime = new Time(16, 00);
        Availability instance = new Availability(start,end,startTime,endTime);
        String expResult = "Availability from : Tuesday, 11 of June of 2019 until Tuesday, 11 of June of 2019.\nOn the time: 15:0 until 16:0.";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
