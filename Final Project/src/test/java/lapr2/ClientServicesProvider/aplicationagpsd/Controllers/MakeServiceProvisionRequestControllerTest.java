/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.FixService;
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
public class MakeServiceProvisionRequestControllerTest {
    
    public MakeServiceProvisionRequestControllerTest() {
    }

    /**
     * Test of initialize method, of class MakeServiceProvisionRequestController.
     */
    /*@Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle resources = null;
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        instance.initialize(url, resources);
    }*/

    /**
     * Test of getCli method, of class MakeServiceProvisionRequestController.
     */
    @Test
    public void testGetCli() {
        System.out.println("getCli");
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        Client expResult = null;
        Client result = instance.getCli();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCli method, of class MakeServiceProvisionRequestController.
     */
    @Test
    public void testSetCli() {
        System.out.println("setCli");
        Client result = new Client("Paulo Marco", "grandebro@hotmail.com", "praiabateforte", "269696996", "912000922", new PostalAddress("Rua do mister paulão", "Isep country", new PostCode("4000", "009")));
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        instance.setCli(result);
        Client expResult = instance.getCli();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSpr method, of class MakeServiceProvisionRequestController.
     */
    @Test
    public void testGetSpr() {
        System.out.println("getSpr");
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        ServiceProvisionRequest expResult = null;
        ServiceProvisionRequest result = instance.getSpr();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpr method, of class MakeServiceProvisionRequestController.
     */
    @Test
    public void testSetSpr() {
        System.out.println("setSpr");
        ServiceProvisionRequest expResult = new ServiceProvisionRequest(new Client("Paulo Marco", "grandebro@hotmail.com", "praiabateforte", "269696996", "912000922", new PostalAddress("Rua do mister paulão", "Isep country", new PostCode("4000", "009"))), new PostalAddress("Rua do mister paulão", "Isep country", new PostCode("4000", "009")));
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        instance.setSpr(expResult);
        ServiceProvisionRequest result = instance.getSpr();
        assertEquals(expResult, result);
    }

    /**
     * Test of newRequest method, of class MakeServiceProvisionRequestController.
     */
    /*@Test
    public void testNewRequest() {
        System.out.println("newRequest");
        Client cli = new Client("Paulo Marco", "grandebro@hotmail.com", "praiabateforte", "269696996", "912000922", new PostalAddress("Rua do mister paulão", "Isep country", new PostCode("4000", "009")));
        AuthorizationFacade af = new AuthorizationFacade();
        af.registUserWithRole("grandebro@hotmail.com", "praiabateforte", "CLIENT");
        af.doLogin("grandebro@hotmail.com", "praiabateforte");
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        List<PostalAddress> expResult = instance.newRequest();
        List<PostalAddress> result = instance.newRequest();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of getCategories method, of class MakeServiceProvisionRequestController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        Company c = new Company();
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        List<Category> expResult = Company.getCategoryRecord().getListOfCategories();
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryServices method, of class MakeServiceProvisionRequestController.
     */
    @Test
    public void testGetCategoryServices() {
        System.out.println("getCategoryServices");
        Company c = new Company();
        Company.getServiceRecord().addService(new Service("1", "1", "Limpeza", "sddfdf", "lol", 100.0));
        String catId = "1";
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        List<Service> expResult = Company.getServiceRecord().getServices();
        List<Service> result = instance.getCategoryServices(catId);
        assertEquals(expResult, result);
    }

    /**
     * Test of addRequestedServiceDescription method, of class MakeServiceProvisionRequestController.
     */
    /*@Test
    public void testAddRequestedServiceDescription() {
        System.out.println("addRequestedServiceDescription");
        Company c = new Company();
        Company.getCategoryRecord().addCategory(new Category("1", "Algo"));
        Service service = new Service("1", "1", "Limpeza", "lol", 0.0);
        Company.getServiceRecord().addService(service);
        ServiceProvisionRequest spr = new ServiceProvisionRequest(new Client("Paulo Marco", "grandebro@hotmail.com", "praiabateforte", "269696996", "912000922", new PostalAddress("Rua do mister paulão", "Isep country", new PostCode("4000", "009"))), new PostalAddress("Rua do mister paulão", "Isep country", new PostCode("4000", "009")));
        String idCat = "1";
        String idServ = "1";
        String description = "fazer tudo";
        Time duration = new Time(2, 2);
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        instance.setSpr(spr);
        instance.addRequestedServiceDescription(idCat, idServ, description, duration);
        RequestedServiceDescription expResult = new RequestedServiceDescription(service, description, duration);
        RequestedServiceDescription result = spr.getRequestedServicesDecriptionList().get(0);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of addSchedule method, of class MakeServiceProvisionRequestController.
     */
    /*@Test
    public void testAddSchedule() {
        System.out.println("addSchedule");
        Date day = null;
        Time beginingHour = null;
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        instance.addSchedule(day, beginingHour);
    }*/

    /**
     * Test of validate method, of class MakeServiceProvisionRequestController.
     */
    /*@Test
    public void testValidate() {
        System.out.println("validate");
        Company c = new Company();
        Schedule s = new Schedule(1, new Date(12, 12, 2019), new Time(2, 2));
        RequestedServiceDescription rsd = new RequestedServiceDescription(new FixService(), "jhk", new Time());
        ServiceProvisionRequest spr = new ServiceProvisionRequest(new Client("Paulo Marco", "grandebro@hotmail.com", "praiabateforte", "269696996", "912000922", new PostalAddress("Rua do mister paulão", "Isep country", new PostCode("4000", "009"))), new PostalAddress("Rua do mister paulão", "Isep country", new PostCode("4000", "009")), rsd, s, 100.0);
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        boolean expResult = false;
        boolean result = instance.validate(spr);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of registerRequest method, of class MakeServiceProvisionRequestController.
     */
    /*@Test
    public void testRegisterRequest() {
        System.out.println("registerRequest");
        ServiceProvisionRequest spreq = null;
        MakeServiceProvisionRequestController instance = new MakeServiceProvisionRequestController();
        int expResult = 0;
        int result = instance.registerRequest(spreq);
        assertEquals(expResult, result);
    }*/
    
}
