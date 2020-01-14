/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author berna
 */
public class ServiceProvisionRequestTest {
    
    public ServiceProvisionRequestTest() {
    }

    /**
     * Test of getRequestNumber method, of class ServiceProvisionRequest.
     */
    @Test
    public void testGetRequestNumber() {
        System.out.println("getRequestNumber");
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        int expResult = ServiceProvisionRequest.getSequencialNumber();
        int result = instance.getRequestNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClient method, of class ServiceProvisionRequest.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        Client expResult = new Client();
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of getpAdd method, of class ServiceProvisionRequest.
     */
    @Test
    public void testGetpAdd() {
        System.out.println("getpAdd");
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        PostalAddress expResult = new PostalAddress();
        PostalAddress result = instance.getpAdd();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequestedServicesDecriptionList method, of class ServiceProvisionRequest.
     */
    @Test
    public void testGetRequestedServicesDecriptionList() {
        System.out.println("getRequestedServicesDecriptionList");
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        List<RequestedServiceDescription> expResult = new ArrayList<RequestedServiceDescription>();
        List<RequestedServiceDescription> result = instance.getRequestedServicesDecriptionList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSchedulesList method, of class ServiceProvisionRequest.
     */
    @Test
    public void testGetSchedulesList() {
        System.out.println("getSchedulesList");
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        List<Schedule> expResult = new ArrayList<Schedule>();
        List<Schedule> result = instance.getSchedulesList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalCost method, of class ServiceProvisionRequest.
     */
    @Test
    public void testGetTotalCost() {
        System.out.println("getTotalCost");
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        Double expResult = 0.0;
        Double result = instance.getTotalCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRequestNumber method, of class ServiceProvisionRequest.
     */
    @Test
    public void testSetRequestNumber() {
        System.out.println("setRequestNumber");
        int requestNumber = 0;
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        instance.setRequestNumber(requestNumber);
    }

    /**
     * Test of setClient method, of class ServiceProvisionRequest.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        Client client = null;
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        instance.setClient(client);
    }

    /**
     * Test of setpAdd method, of class ServiceProvisionRequest.
     */
    @Test
    public void testSetpAdd() {
        System.out.println("setpAdd");
        PostalAddress expResult = new PostalAddress("asd", "lol", new PostCode("4000", "010"));
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        instance.setpAdd(expResult);
        PostalAddress result = instance.getpAdd();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRequestedServicesDecriptionList method, of class ServiceProvisionRequest.
     */
    @Test
    public void testSetRequestedServicesDecriptionList() {
        System.out.println("setRequestedServicesDecriptionList");
        List<RequestedServiceDescription> expResult = new ArrayList<RequestedServiceDescription>();
        expResult.add(new RequestedServiceDescription(new LimitedService(), "dfss", new Time(2, 3)));
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        instance.setRequestedServicesDecriptionList(expResult);
        List<RequestedServiceDescription> result = instance.getRequestedServicesDecriptionList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSchedulesList method, of class ServiceProvisionRequest.
     */
    @Test
    public void testSetSchedulesList() {
        System.out.println("setSchedulesList");
        List<Schedule> schedulesList = null;
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        instance.setSchedulesList(schedulesList);
    }

    /**
     * Test of setTotalCost method, of class ServiceProvisionRequest.
     */
    @Test
    public void testSetTotalCost() {
        System.out.println("setTotalCost");
        Double totalCost = null;
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        instance.setTotalCost(totalCost);
    }

    /**
     * Test of addRequestedServiceDescription method, of class ServiceProvisionRequest.
     */
    @Test
    public void testAddRequestedServiceDescription_3args() {
        System.out.println("addRequestedServiceDescription");
        Service s = new FixService();
        String description = "lol";
        Time duration = new Time(2, 4);
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        RequestedServiceDescription expResult = new RequestedServiceDescription(s, description, duration);
        RequestedServiceDescription result = instance.addRequestedServiceDescription(s, description, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ServiceProvisionRequest.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        String expResult = "Request number=" + instance.getRequestNumber() + ", client=" + instance.getClient().toString() + ", postal address=" + instance.getpAdd().toString() + ", total cost=" + instance.getTotalCost() + ".";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateRequestedServiceDescription method, of class ServiceProvisionRequest.
     */
    @Test
    public void testValidateRequestedServiceDescription() {
        System.out.println("validateRequestedServiceDescription");
        RequestedServiceDescription description = new RequestedServiceDescription();
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        boolean expResult = true;
        boolean result = instance.validateRequestedServiceDescription(description);
        assertEquals(expResult, result);
    }

    /**
     * Test of addRequestedServiceDescription method, of class ServiceProvisionRequest.
     */
    @Test
    public void testAddRequestedServiceDescription_RequestedServiceDescription() {
        System.out.println("addRequestedServiceDescription");
        RequestedServiceDescription description = new RequestedServiceDescription();
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        boolean expResult = true;
        boolean result = instance.addRequestedServiceDescription(description);
        assertEquals(expResult, result);
    }

    /**
     * Test of countSchedules method, of class ServiceProvisionRequest.
     */
    @Test
    public void testCountSchedules() {
        System.out.println("countSchedules");
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        int expResult = instance.getSchedulesList().size() + 1;
        int result = instance.countSchedules();
        assertEquals(expResult, result);
    }

    /**
     * Test of addSchedule method, of class ServiceProvisionRequest.
     */
    @Test
    public void testAddSchedule_Date_Time() {
        System.out.println("addSchedule");
        Date day = new Date(2019, 12, 12);
        Time beginingHour = new Time(2, 4);
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        int order = instance.countSchedules();
        Schedule expResult = new Schedule(order, day, beginingHour);
        Schedule result = instance.addSchedule(day, beginingHour);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateSchedule method, of class ServiceProvisionRequest.
     */
    @Test
    public void testValidateSchedule() {
        System.out.println("validateSchedule");
        Schedule schedule = new Schedule();
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        boolean expResult = true;
        boolean result = instance.validateSchedule(schedule);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSchedule method, of class ServiceProvisionRequest.
     */
    @Test
    public void testAddSchedule_Schedule() {
        System.out.println("addSchedule");
        Schedule schedule = new Schedule(1, new Date(2019, 12, 12), new Time(2, 3));
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        boolean expResult = true;
        boolean result = instance.addSchedule(schedule);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCost method, of class ServiceProvisionRequest.
     */
    @Test
    public void testCalculateCost() {
        System.out.println("calculateCost");
        Company c = new Company();
        GeographicAreaRecord gar = Company.getGeographicAreasRecord();
        gar.getLstGeographicAreas().add(new GeographicArea("porto", 100, 30, "4000", "010"));
        gar.getLstGeographicAreas().add(new GeographicArea("maia", 200, 40, "4000", "009"));
        Client client = new Client("lol", "lol@gmail.com", "lol1", "260494333", "920912477", new PostalAddress("efrdg", "vffdsdfdsf", new PostCode("4000", "007")));
        PostalAddress pa = new PostalAddress("efrdg", "vffdsdfdsf", new PostCode("4000", "007"));
        RequestedServiceDescription rsd = new RequestedServiceDescription(new FixService("1", "1", "asd","fd", "alal", 1.1, new Time(2, 3)), "asd", new Time(2, 3));
        Schedule s = new Schedule(1, new Date(2019, 12, 12), new Time(2, 3));
        ServiceProvisionRequest instance = new ServiceProvisionRequest(client, pa, rsd, s, 0.0);
        double expResult = 202.2;
        double result = instance.calculateCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of equals method, of class ServiceProvisionRequest.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ServiceProvisionRequest instance = new ServiceProvisionRequest();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
