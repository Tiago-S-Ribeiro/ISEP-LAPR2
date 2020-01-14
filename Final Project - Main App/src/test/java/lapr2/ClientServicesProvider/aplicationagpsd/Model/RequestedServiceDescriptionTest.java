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
public class RequestedServiceDescriptionTest {
    
    public RequestedServiceDescriptionTest() {
    }

    /**
     * Test of getService method, of class RequestedServiceDescription.
     */
    @Test
    public void testGetService() {
        System.out.println("getService");
        RequestedServiceDescription instance = new RequestedServiceDescription();
        Service expResult = new Service();
        Service result = instance.getService();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class RequestedServiceDescription.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        RequestedServiceDescription instance = new RequestedServiceDescription();
        String expResult = "no description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDuration method, of class RequestedServiceDescription.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        RequestedServiceDescription instance = new RequestedServiceDescription();
        Time expResult = new Time();
        Time result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setService method, of class RequestedServiceDescription.
     */
    @Test
    public void testSetService() {
        System.out.println("setService");
        Service expResult = new Service("1", "1", "limpeza", "kijhk", "limpeza de quartos", 100);
        RequestedServiceDescription instance = new RequestedServiceDescription();
        instance.setService(expResult);
        Service result = instance.getService();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class RequestedServiceDescription.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String expResult = "description";
        RequestedServiceDescription instance = new RequestedServiceDescription();
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDuration method, of class RequestedServiceDescription.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        Time expResult = new Time(2, 2);
        RequestedServiceDescription instance = new RequestedServiceDescription();
        instance.setDuration(expResult);
        Time result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class RequestedServiceDescription.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RequestedServiceDescription instance = new RequestedServiceDescription();
        String expResult = "Requested service description: no description";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class RequestedServiceDescription.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        RequestedServiceDescription instance = new RequestedServiceDescription();
        RequestedServiceDescription instance2 = new RequestedServiceDescription(new Service(), "description", new Time());
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class RequestedServiceDescription.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        RequestedServiceDescription instance = new RequestedServiceDescription();
        RequestedServiceDescription instance2 = null;
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class RequestedServiceDescription.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        RequestedServiceDescription instance = new RequestedServiceDescription();
        Service instance2 = new Service("1", "1", "sdf", "wdfsv", "dfddddddd", 20);
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class RequestedServiceDescription.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals");
        RequestedServiceDescription instance = new RequestedServiceDescription(new FixService(), "description", new Time());
        RequestedServiceDescription instance2 = new RequestedServiceDescription(new FixService(), "description", new Time());
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class RequestedServiceDescription.
     */
    @Test
    public void testEquals5() {
        System.out.println("equals");
        RequestedServiceDescription instance = new RequestedServiceDescription(new FixService(), "description", new Time());
        RequestedServiceDescription instance2 = new RequestedServiceDescription(new FixService(), "descriptionppp", new Time());
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCost method, of class RequestedServiceDescription.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        RequestedServiceDescription instance = new RequestedServiceDescription();
        double expResult = 0.0;
        double result = instance.getCost();
        assertEquals(expResult, result, 0.0);
    }
    
}
