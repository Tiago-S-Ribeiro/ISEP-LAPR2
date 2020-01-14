/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author berna
 */
public class ServiceTest {
    
    public ServiceTest() {
    }

    /**
     * Test of getCatID method, of class Service.
     */
    @Test
    public void testGetCatID() {
        System.out.println("getCatID");
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        String expResult = "1";
        String result = instance.getCatID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServID method, of class Service.
     */
    @Test
    public void testGetServID() {
        System.out.println("getServID");
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        String expResult = "1";
        String result = instance.getServID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceType method, of class Service.
     */
    @Test
    public void testGetServiceType() {
        System.out.println("getServiceType");
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        String expResult = "fghj";
        String result = instance.getServiceType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBriefDescription method, of class Service.
     */
    @Test
    public void testGetBriefDescription() {
        System.out.println("getBriefDescription");
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        String expResult = "fghjaaaa";
        String result = instance.getBriefDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompleteDescription method, of class Service.
     */
    @Test
    public void testGetCompleteDescription() {
        System.out.println("getCompleteDescription");
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        String expResult = "lol";
        String result = instance.getCompleteDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHourCost method, of class Service.
     */
    @Test
    public void testGetHourCost() {
        System.out.println("getHourCost");
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        double expResult = 2;
        double result = instance.getHourCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCatID method, of class Service.
     */
    @Test
    public void testSetCatID() {
        System.out.println("setCatID");
        String catID = "2";
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        instance.setCatID(catID);
    }

    /**
     * Test of setServID method, of class Service.
     */
    @Test
    public void testSetServID() {
        System.out.println("setServID");
        String servID = "2";
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        instance.setServID(servID);
    }

    /**
     * Test of setServiceType method, of class Service.
     */
    @Test
    public void testSetServiceType() {
        System.out.println("setServiceType");
        String serviceType = "k";
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        instance.setServiceType(serviceType);
    }

    /**
     * Test of setBriefDescription method, of class Service.
     */
    @Test
    public void testSetBriefDescription() {
        System.out.println("setBriefDescription");
        String briefDescription = "l";
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        instance.setBriefDescription(briefDescription);
    }

    /**
     * Test of setCompleteDescription method, of class Service.
     */
    @Test
    public void testSetCompleteDescription() {
        System.out.println("setCompleteDescription");
        String completeDescription = "h";
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        instance.setCompleteDescription(completeDescription);
    }

    /**
     * Test of setHourCost method, of class Service.
     */
    @Test
    public void testSetHourCost() {
        System.out.println("setHourCost");
        double hourCost = 1000.0;
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        instance.setHourCost(hourCost);
    }

    /**
     * Test of equals method, of class Service.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new Service("1", "2", "popopo", "kjhgcfv", "lol", 20);;
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Service.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        String toString = String.format("Service: %s\nCost per hour: %.2f", instance.getServiceType(), instance.getHourCost());
        String expResult = toString;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDurationCost method, of class Service.
     */
    @Test
    public void testGetDurationCost() {
        System.out.println("getDurationCost");
        Time duration = new Time(2, 3);
        Service instance = new Service("1", "1", "fghj", "fghjaaaa", "lol", 2);
        double expResult = 4.0;
        double result = instance.getDurationCost(duration);
        assertEquals(expResult, result, 0.0);
    }
    
}
