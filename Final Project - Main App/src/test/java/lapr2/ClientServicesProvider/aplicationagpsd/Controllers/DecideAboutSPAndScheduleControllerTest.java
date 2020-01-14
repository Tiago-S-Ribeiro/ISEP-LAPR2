/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExecutionOrder;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ExecutionOrderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.RequestedServiceDescription;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Schedule;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Tiago
 */
public class DecideAboutSPAndScheduleControllerTest {
  

    /**
     * Test of calculateDistance method, of class DecideAboutSPAndScheduleController.
     */
    @Test
    public void testCalculateDistance() {
        System.out.println("calculateDistance");
        double lat1 = 0.0;
        double lon1 = 0.0;
        double lat2 = 0.0;
        double lon2 = 0.0;
        double expResult = 0.0;
        double result = DecideAboutSPAndScheduleController.calculateDistance(lat1, lon1, lat2, lon2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of newExecutionOrder method, of class DecideAboutSPAndScheduleController.
     */
    @Test
    public void testNewExecutionOrder() {
        System.out.println("newExecutionOrder");
        Company c = new Company();
        ExecutionOrderRecord eor = Company.getExecutionOrderRecord();
        PostalAddress postalAddress = new PostalAddress();
        double distance = 10;
        RequestedServiceDescription description = new RequestedServiceDescription();
        Schedule schedule = new Schedule();
        ServiceProvider sp = new ServiceProvider();
        Client cli = new Client();
        ExecutionOrder result = eor.newExecutionOrder(postalAddress, distance, description, schedule, sp, cli);
        ExecutionOrder expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of registExecutionOrder method, of class DecideAboutSPAndScheduleController.
     */
    @Test
    public void testRegistExecutionOrder() {
        System.out.println("registExecutionOrder");
        Company c = new Company();
        ExecutionOrderRecord eor = Company.getExecutionOrderRecord();
          PostalAddress postalAddress = new PostalAddress();
          double distance = 10;
          RequestedServiceDescription description = new RequestedServiceDescription();
          Schedule schedule = new Schedule();
          ServiceProvider sp = new ServiceProvider();
          Client cli = new Client();
        ExecutionOrder eo = new ExecutionOrder(postalAddress, sp, cli, description, schedule, distance);
        eor.registExecutionOrder(eo);
        assertEquals(true,eor.getExecutionOrdersList().contains(eo));
    }

}
