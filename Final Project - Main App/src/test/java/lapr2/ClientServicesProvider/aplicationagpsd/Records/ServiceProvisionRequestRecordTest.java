/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProvisionRequestRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.GeographicArea;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostCode;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.RequestedServiceDescription;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Schedule;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Service;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvisionRequest;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author berna
 */
public class ServiceProvisionRequestRecordTest {
    
    public ServiceProvisionRequestRecordTest() {
    }

    /**
     * Test of getServProvReqList method, of class ServiceProvisionRequestRecord.
     */
    @Test
    public void testGetServProvReqList() {
        System.out.println("getServProvReqList");
        ServiceProvisionRequestRecord instance = new ServiceProvisionRequestRecord();
        List<ServiceProvisionRequest> expResult = new ArrayList<ServiceProvisionRequest>();
        List<ServiceProvisionRequest> result = instance.getServProvReqList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setServProvReqList method, of class ServiceProvisionRequestRecord.
     */
    @Test
    public void testSetServProvReqList() {
        System.out.println("setServProvReqList");
        List<ServiceProvisionRequest> servProvReqList = new ArrayList<ServiceProvisionRequest>();
        servProvReqList.add(new ServiceProvisionRequest(new Client("d", "a@s.pt", "w", "123456789", "910987645", new PostalAddress("d", "e", new PostCode("4000", "010"))), new PostalAddress("d", "e", new PostCode("4000", "010")), new RequestedServiceDescription(new Service(), "s", new Time()), new Schedule(), 100.0));
        ServiceProvisionRequestRecord instance = new ServiceProvisionRequestRecord();
        instance.setServProvReqList(servProvReqList);
    }

    /**
     * Test of newRequest method, of class ServiceProvisionRequestRecord.
     */
    @Test
    public void testNewRequest() {
        System.out.println("newRequest");
        Client cli = new Client();
        PostalAddress pAdd = new PostalAddress();
        ServiceProvisionRequestRecord instance = new ServiceProvisionRequestRecord();
        ServiceProvisionRequest expResult = new ServiceProvisionRequest(new Client(), new PostalAddress());
        ServiceProvisionRequest result = instance.newRequest(cli, pAdd);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateRequest method, of class ServiceProvisionRequestRecord.
     */
    @Test
    public void testValidateRequest() {
        System.out.println("validateRequest");
        Company c = new Company();
        GeographicAreaRecord gar = Company.getGeographicAreasRecord();
        gar.getLstGeographicAreas().add(new GeographicArea("porto", 100, 30, "4000", "010"));
        gar.getLstGeographicAreas().add(new GeographicArea("maia", 200, 40, "4000", "009"));
        ServiceProvisionRequest spr = new ServiceProvisionRequest(new Client("d", "a@s.pt", "w", "123456789", "910987645", new PostalAddress("d", "e", new PostCode("4000", "010"))), new PostalAddress("d", "e", new PostCode("4000", "010")), new RequestedServiceDescription(new Service("1", "1", "kjh", "a", "w", 20), "s", new Time(2, 2)), new Schedule(2, new Date(2019, 12, 12), new Time(2, 3)), 100.0);
        ServiceProvisionRequestRecord instance = new ServiceProvisionRequestRecord();
        boolean expResult = true;
        boolean result = instance.validateRequest(spr);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerRequest method, of class ServiceProvisionRequestRecord.
     */
    @Test
    public void testRegisterRequest() {
        System.out.println("registerRequest");
        ServiceProvisionRequest spreq = new ServiceProvisionRequest(new Client("d", "a@s.pt", "w", "123456789", "910987645", new PostalAddress("d", "e", new PostCode("4000", "010"))), new PostalAddress("d", "e", new PostCode("4000", "010")), new RequestedServiceDescription(new Service("1", "1", "kjh", "a", "w", 20), "s", new Time(2, 2)), new Schedule(2, new Date(2019, 12, 12), new Time(2, 3)), 100.0);
        ServiceProvisionRequestRecord instance = new ServiceProvisionRequestRecord();
        int expResult = 0;
        int result = instance.registerRequest(spreq);
        assertEquals(expResult, result);
    }

    /**
     * Test of generateRequestNumber method, of class ServiceProvisionRequestRecord.
     */
    @Test
    public void testGenerateRequestNumber() {
        System.out.println("generateRequestNumber");
        ServiceProvisionRequestRecord instance = new ServiceProvisionRequestRecord();
        int expResult = 0;
        int result = instance.generateRequestNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of addRequest method, of class ServiceProvisionRequestRecord.
     */
    @Test
    public void testAddRequest() {
        System.out.println("addRequest");
        ServiceProvisionRequest spreq = new ServiceProvisionRequest(new Client("d", "a@s.pt", "w", "123456789", "910987645", new PostalAddress("d", "e", new PostCode("4000", "010"))), new PostalAddress("d", "e", new PostCode("4000", "010")), new RequestedServiceDescription(new Service(), "s", new Time()), new Schedule(), 100.0);
        ServiceProvisionRequestRecord instance = new ServiceProvisionRequestRecord();
        boolean expResult = true;
        boolean result = instance.addRequest(spreq);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceProvisionsListByClient method, of class ServiceProvisionRequestRecord.
     */
    @Test
    public void testGetServiceProvisionsListByClient() {
        System.out.println("getServiceProvisionsListByClient");
        Client cli = new Client("d", "a@l.pt", "as", "202929838", "912234008", new PostalAddress("s", "sw", new PostCode("4000", "009")));
        ServiceProvisionRequest spr = new ServiceProvisionRequest(cli, new PostalAddress("s", "sw", new PostCode("4000", "009")));
        ServiceProvisionRequestRecord instance = new ServiceProvisionRequestRecord();
        instance.addRequest(spr);
        List<ServiceProvisionRequest> expResult = instance.getServProvReqList();
        List<ServiceProvisionRequest> result = instance.getServiceProvisionsListByClient(cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceProvisionByNumberRequest method, of class ServiceProvisionRequestRecord.
     */
    /*@Test
    public void testGetServiceProvisionByNumberRequest() {
        System.out.println("getServiceProvisionByNumberRequest");
        String reqNumber = "4";
        ServiceProvisionRequestRecord instance = new ServiceProvisionRequestRecord();
        Client cli = new Client("d", "a@l.pt", "as", "202929838", "912234008", new PostalAddress("s", "sw", new PostCode("4000", "009")));
        ServiceProvisionRequest spr = new ServiceProvisionRequest(cli, new PostalAddress("s", "sw", new PostCode("4000", "009")));
        instance.addRequest(spr);
        ServiceProvisionRequest expResult = spr;
        ServiceProvisionRequest result = instance.getServiceProvisionByNumberRequest(reqNumber);
        assertEquals(expResult, result);
    }*/
    
}
