/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class InvoiceTest {
    
    Invoice i = new Invoice("tiago", "999999999", "limpeza", 0, new Date());
    

    /**
     * Test of getClientName method, of class Invoice.
     */
    @Test
    public void testGetClientName() {
        System.out.println("getClientName");
        String expResult = "tiago";
        String result = i.getClientName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientNif method, of class Invoice.
     */
    @Test
    public void testGetClientNif() {
        System.out.println("getClientNif");
        String expResult = "999999999";
        String result = i.getClientNif();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceExecuted method, of class Invoice.
     */
    @Test
    public void testGetServiceExecuted() {
        System.out.println("getServiceExecuted");
        String expResult = "limpeza";
        String result = i.getServiceExecuted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Invoice.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        double expResult = 0.0;
        double result = i.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDate method, of class Invoice.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Date expResult = new Date();
        Date result = i.getDate();
        assertEquals(expResult, result);
    }


    /**
     * Test of setInvoiceID method, of class Invoice.
     */
    @Test
    public void testSetInvoiceID() {
        System.out.println("setInvoiceID");
        String invoiceID = "coisas";
        i.setInvoiceID(invoiceID);
        assertEquals("coisas", i.getInvoiceID());
    }

    /**
     * Test of setClientName method, of class Invoice.
     */
    @Test
    public void testSetClientName() {
        System.out.println("setClientName");
        String clientName = "joao";
        i.setClientName(clientName);
        assertEquals("joao", i.getClientName());
    }

    /**
     * Test of setClientNif method, of class Invoice.
     */
    @Test
    public void testSetClientNif() {
        System.out.println("setClientNif");
        String clientNif = "123";
        i.setClientNif(clientNif);
        assertEquals("123", i.getClientNif());
    }

    /**
     * Test of setServiceExecuted method, of class Invoice.
     */
    @Test
    public void testSetServiceExecuted() {
        System.out.println("setServiceExecuted");
        String serviceExecuted = "arrumacao";
        i.setServiceExecuted(serviceExecuted);
        assertEquals("arrumacao", i.getServiceExecuted());
    }

    /**
     * Test of setPrice method, of class Invoice.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 3.0;
        i.setPrice(price);
        assertEquals(price, i.getPrice(),0.0);
    }

    /**
     * Test of setDate method, of class Invoice.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = new Date(1, 2, 2000);
        i.setDate(date);
        assertEquals(date, i.getDate());
    }
    
    /**
     * Test of equals method, of class Invoice.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals");
        Object obj = null;
        boolean expResult = false;
        boolean result = i.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Invoice.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        PostCode pcc = new PostCode();
        boolean expResult = false;
        boolean result = i.equals(pcc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Invoice.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        boolean expResult = true;
        boolean result = i.equals(i);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Invoice.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals");
        Invoice instance = new Invoice("clientName", "clientNif", "serviceExecuted", 0, new Date());
        boolean expResult = false;
        boolean result = i.equals(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Invoice.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = i.toString();
        String result = i.toString();
        assertEquals(expResult, result);
    }
    
}
