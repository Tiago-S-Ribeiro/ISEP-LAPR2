/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.CompleteWork;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.CompleteWorkRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExecutionOrder;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExpansivelService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.FixService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Invoice;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.LimitedService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostCode;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.RequestedServiceDescription;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Schedule;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class CompleteWorkRecordTest {
    
     PostalAddress postalAddress = new PostalAddress("Rua alberta", "lisboa", new PostCode("4000", "010", 100, -10));
    ServiceProvider serviceProvider = new ServiceProvider("Tiago Djiaz", "2345", "djiaz@email.com", "tiago", "123224", new PostalAddress());
    Client cli = new Client();
    RequestedServiceDescription fixDescription = new RequestedServiceDescription(new FixService(), "abc", new Time());
    RequestedServiceDescription expandableDescription = new RequestedServiceDescription(new ExpansivelService(), "abc", new Time());
    RequestedServiceDescription limitedDescription = new RequestedServiceDescription(new LimitedService(), "abc", new Time());
    Schedule schedule = new Schedule();
    Invoice i = new Invoice();
    
    /**
     * Test of getLstCompleteWorks method, of class CompleteWorkRecord.
     */
    @Test
    public void testGetLstCompleteWorks() {
        System.out.println("getLstCompleteWorks");
        CompleteWorkRecord instance = new CompleteWorkRecord();
        List<CompleteWork> expResult = new ArrayList<CompleteWork>();
        List<CompleteWork> result = instance.getLstCompleteWorks();
        assertEquals(expResult, result);
    }

    /**
     * Test of newCompleteWork method, of class CompleteWorkRecord.
     */
    @Test
    public void testNewCompleteWork() {
        System.out.println("newCompleteWork");
        String desc = "abc";
        ExecutionOrder e = new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0);
        CompleteWorkRecord instance = new CompleteWorkRecord();
        CompleteWork expResult = new CompleteWork("abc", e);
        CompleteWork result = instance.newCompleteWork(desc, e);
        assertEquals(expResult, result);
    }

    /**
     * Test of registCompleteWork method, of class CompleteWorkRecord.
     */
    @Test
    public void testRegistCompleteWork() {
        System.out.println("registCompleteWork");
        CompleteWork e = new CompleteWork("abc", new ExecutionOrder(postalAddress, serviceProvider, cli, fixDescription, schedule, 0));
        CompleteWorkRecord instance = new CompleteWorkRecord();
        instance.registCompleteWork(e);
        ArrayList<CompleteWork> lista = new ArrayList<CompleteWork>();
        lista.add(e);
        ArrayList<CompleteWork> expResult = lista;
        assertEquals(expResult, instance.getLstCompleteWorks());
    }
    
}
