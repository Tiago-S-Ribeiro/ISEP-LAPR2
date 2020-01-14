/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class CompleteWorkTest {
    
    PostalAddress postalAddress = new PostalAddress("Rua alberta", "lisboa", new PostCode("4000", "010", 100, -10));
    ServiceProvider serviceProvider = new ServiceProvider("Tiago Djiaz", "2345", "djiaz@email.com", "tiago", "123224", new PostalAddress());
    Client cli = new Client();
    RequestedServiceDescription fixDescription = new RequestedServiceDescription(new FixService(), "abc", new Time());
    RequestedServiceDescription expandableDescription = new RequestedServiceDescription(new ExpansivelService(), "abc", new Time());
    RequestedServiceDescription limitedDescription = new RequestedServiceDescription(new LimitedService(), "abc", new Time());
    Schedule schedule = new Schedule();
    ExecutionOrder eo = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0);
    Invoice invoice = new Invoice("abc", "clientNif", "serviceExecuted", 0, new Date());
    CompleteWork cw = new CompleteWork("cenas", eo);
    
    /**
     * Test of getDescription method, of class CompleteWork.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "cenas";
        String result = cw.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class CompleteWork.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "coisas";
        CompleteWork instance = cw;
        instance.setDescription(description);
        assertEquals("coisas", cw.getDescription());
    }

    /**
     * Test of getExtraTime method, of class CompleteWork.
     */
    @Test
    public void testGetExtraTime() {
        System.out.println("getExtraTime");
        String expResult = "0";
        String result = cw.getExtraTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExtraTime method, of class CompleteWork.
     */
    @Test
    public void testSetExtraTime() {
        System.out.println("setExtraTime");
        String extraTime = "30";
        cw.setExtraTime(extraTime);
        assertEquals("30", cw.getExtraTime());
    }

    /**
     * Test of getExecutionOrder method, of class CompleteWork.
     */
    @Test
    public void testGetExecutionOrder() {
        System.out.println("getExecutionOrder");
        ExecutionOrder result = cw.getExecutionOrder();
        assertEquals(eo, result);
    }

    /**
     * Test of setExecutionOrder method, of class CompleteWork.
     */
    @Test
    public void testSetExecutionOrder() {
        System.out.println("setExecutionOrder");
        ExecutionOrder executionOrder = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 21);
        cw.setExecutionOrder(executionOrder);
        assertEquals(executionOrder, cw.getExecutionOrder());
    }

    /**
     * Test of equals method, of class CompleteWork.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals");
        Object obj = null;
        boolean expResult = false;
        boolean result = cw.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class CompleteWork.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        boolean expResult = true;
        boolean result = cw.equals(cw);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class CompleteWork.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        CompleteWork cww = new CompleteWork("cenas", eo);
        boolean expResult = true;
        boolean result = cww.equals(cw);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class CompleteWork.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals");
        PostCode pc = new PostCode();
        boolean expResult = false;
        boolean result = cw.equals(pc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class CompleteWork.
     */
    @Test
    public void testEquals5() {
        System.out.println("equals");
        CompleteWork instance = new CompleteWork("cabsc", eo);
        boolean expResult = false;
        boolean result = instance.equals(cw);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class CompleteWork.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CompleteWork instance = cw;
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
