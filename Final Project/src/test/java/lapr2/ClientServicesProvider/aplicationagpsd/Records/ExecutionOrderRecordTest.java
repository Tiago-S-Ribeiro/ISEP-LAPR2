/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExecutionOrder;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostCode;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.RequestedServiceDescription;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Schedule;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class ExecutionOrderRecordTest {

    PostalAddress postalAddress = new PostalAddress("Rua alberta", "lisboa", new PostCode("4000", "010", 100, -10));
    ServiceProvider serviceProvider = new ServiceProvider("Tiago Djiaz", "2345", "djiaz@email.com", "tiago", "123224",new PostalAddress());
    Client cli = new Client();
    RequestedServiceDescription description = new RequestedServiceDescription();
    Schedule schedule = new Schedule();

    /**
     * Test of getExecutionOrdersList method, of class ExecutionOrderRecord.
     */
    @Test
    public void testGetExecutionOrdersList() {
        System.out.println("getExecutionOrdersList");
        ExecutionOrderRecord instance = new ExecutionOrderRecord();
        List<ExecutionOrder> expResult = new ArrayList<ExecutionOrder>();
        List<ExecutionOrder> result = instance.getExecutionOrdersList();
        assertEquals(expResult, result);
    }

    /**
     * Test of registExecutionOrder method, of class ExecutionOrderRecord.
     */
    @Test
    public void testRegistExecutionOrder() {
        System.out.println("registExecutionOrder");
        ExecutionOrder eo = new ExecutionOrder(postalAddress, serviceProvider, cli, description, schedule, 0);
        ExecutionOrderRecord instance = new ExecutionOrderRecord();
        instance.registExecutionOrder(eo);
    }

    /**
     * Test of newExecutionOrder method, of class ExecutionOrderRecord.
     */
    @Test
    public void testNewExecutionOrder() {
        System.out.println("newExecutionOrder");
        PostalAddress postalAddress = new PostalAddress("Rua alberta", "lisboa", new PostCode("4000", "010", 100, -10));
        ServiceProvider serviceProvider = new ServiceProvider("Tiago Djiaz", "2345", "djiaz@email.com", "tiago", "123224", new PostalAddress());
        Client cli = new Client();
        RequestedServiceDescription description = new RequestedServiceDescription();
        Schedule schedule = new Schedule();
        double distance = 20;
        ExecutionOrderRecord instance = new ExecutionOrderRecord();
        ExecutionOrder expResult = instance.newExecutionOrder(postalAddress, distance, description, schedule, serviceProvider, cli);
        ExecutionOrder result = expResult;
        assertEquals(expResult, result);
    }

}
