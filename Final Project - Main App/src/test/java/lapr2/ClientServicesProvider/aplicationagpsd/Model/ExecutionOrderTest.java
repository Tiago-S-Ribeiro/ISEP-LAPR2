/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostCode;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * @author Tiago
 */
public class ExecutionOrderTest {

    PostalAddress postalAddress = new PostalAddress("Rua alberta", "lisboa", new PostCode("4000", "010", 100, -10));
    ServiceProvider serviceProvider = new ServiceProvider("Tiago Djiaz", "2345", "djiaz@email.com", "tiago", "123224", new PostalAddress());
    Client cli = new Client();
    RequestedServiceDescription fixDescription = new RequestedServiceDescription(new FixService(), "abc", new Time());
    RequestedServiceDescription expandableDescription = new RequestedServiceDescription(new ExpansivelService(), "abc", new Time());
    RequestedServiceDescription limitedDescription = new RequestedServiceDescription(new LimitedService(), "abc", new Time());
    Schedule schedule = new Schedule();

    ExecutionOrder eo = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0);

    /**
     * Test of getEmissionDate method, of class ExecutionOrder.
     */
    @Test
    public void testGetEmissionDate() {
        System.out.println("getEmissionDate");
        Date expResult = Date.actualDate();
        Date result = eo.getEmissionDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceProvider method, of class ExecutionOrder.
     */
    @Test
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider");
        ServiceProvider expResult = serviceProvider;
        ServiceProvider result = eo.getServiceProvider();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCli method, of class ExecutionOrder.
     */
    @Test
    public void testGetCli() {
        System.out.println("getCli");
        Client expResult = cli;
        Client result = eo.getCli();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProvision method, of class ExecutionOrder.
     */
    @Test
    public void testGetProvision() {
        System.out.println("getProvision");
        RequestedServiceDescription expResult = fixDescription;
        RequestedServiceDescription result = eo.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSchedule method, of class ExecutionOrder.
     */
    @Test
    public void testGetSchedule() {
        System.out.println("getSchedule");
        Schedule expResult = schedule;
        Schedule result = eo.getSchedule();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class ExecutionOrder.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        double expResult = 0.0;
        double result = eo.getDistance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setServiceProvider method, of class ExecutionOrder.
     */
    @Test
    public void testSetServiceProvider() {
        System.out.println("setServiceProvider");
        ServiceProvider serviceP = new ServiceProvider();
        eo.setServiceProvider(serviceP);
        assertEquals(serviceP, eo.getServiceProvider());
    }

    /**
     * Test of setCli method, of class ExecutionOrder.
     */
    @Test
    public void testSetCli() {
        System.out.println("setCli");
        Client client = new Client();
        eo.setCli(client);
        assertEquals(client, eo.getCli());
    }

    /**
     * Test of setProvision method, of class ExecutionOrder.
     */
    @Test
    public void testSetProvision() {
        System.out.println("setDescription");
        RequestedServiceDescription d = new RequestedServiceDescription();
        eo.setDescription(d);
        assertEquals(d, eo.getDescription());
    }

    /**
     * Test of setSchedule method, of class ExecutionOrder.
     */
    @Test
    public void testSetSchedule() {
        System.out.println("setSchedule");
        Schedule s = new Schedule();
        eo.setSchedule(s);
        assertEquals(s, eo.getSchedule());
    }

    /**
     * Test of setDistance method, of class ExecutionOrder.
     */
    @Test
    public void testSetDistance() {
        System.out.println("setDistance");
        double d = 35.0;
        eo.setDistance(d);
        assertEquals(d, eo.getDistance(), 0.0);
    }

    /**
     * Test of setPostalAddress method, of class ExecutionOrder.
     */
    @Test
    public void testSetPostalAddress() {
        System.out.println("setPostalAddress");
        PostalAddress pa = new PostalAddress();
        eo.setPostalAddress(pa);
        assertEquals(pa, eo.getPostalAddress());
    }

    /**
     * Test of equals method, of class ExecutionOrder.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals");
        Object obj = null;
        boolean expResult = false;
        boolean result = eo.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ExecutionOrder.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        PostCode obj = new PostCode();
        boolean expResult = false;
        boolean result = eo.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ExecutionOrder.
     */
    @Test
    public void testEqualsFix() {
        System.out.println("equals");
        ExecutionOrder obj = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0);
        ExecutionOrder instance = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ExecutionOrder.
     */
    @Test
    public void testEqualsLimited() {
        System.out.println("equals");
        ExecutionOrder obj = new ExecutionOrder(postalAddress, serviceProvider, cli, limitedDescription, schedule, 0);
        ExecutionOrder instance = new ExecutionOrder(postalAddress, serviceProvider, cli, limitedDescription, schedule, 0);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ExecutionOrder.
     */
    @Test
    public void testEqualsExpandable() {
        System.out.println("equals");
        ExecutionOrder obj = new ExecutionOrder(postalAddress, serviceProvider, cli, expandableDescription, schedule, 0);
        ExecutionOrder instance = new ExecutionOrder(postalAddress, serviceProvider, cli, expandableDescription, schedule, 0);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ExecutionOrder.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals");
        ExecutionOrder instance = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0);
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ExecutionOrder.
     */
    @Test
    public void testEquals5() {
        System.out.println("equals");
        ExecutionOrder obj = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0);
        ExecutionOrder instance = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 2);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of toString method, of class ExecutionOrder.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        ExecutionOrder instance = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0);
//        String expResult = "ExecutionOrder: sequencialIdentifier=" + instance.getSequencialIdentifier()
//                + ", emissionDate=" + instance.getEmissionDate()
//                + ", serviceProvider=" + instance.getServiceProvider()
//                + ", cli=" + instance.getCli()
//                + ", provision=" + instance.getDescription()
//                + ", schedule=" + instance.getSchedule()
//                + ", distance=" + instance.getDistance();
//        String result = instance.toString();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getPostalAddress method, of class ExecutionOrder.
     */
    @Test
    public void testGetPostalAddress() {
        System.out.println("getPostalAddress");
        ExecutionOrder instance = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0);
        PostalAddress expResult = postalAddress;
        PostalAddress result = instance.getPostalAddress();
        assertEquals(expResult, result);
    }

}
