/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Invoice;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class InvoicesRecordTest {

    /**
     * Test of getLstInvoices method, of class InvoicesRecord.
     */
    @Test
    public void testGetLstInvoices() {
        System.out.println("getLstInvoices");
        InvoicesRecord instance = new InvoicesRecord();
        List<Invoice> expResult = new ArrayList<Invoice>();
        List<Invoice> result = instance.getLstInvoices();
        assertEquals(expResult, result);
    }

    /**
     * Test of newInvoice method, of class InvoicesRecord.
     */
    @Test
    public void testNewInvoice() {
        System.out.println("newInvoice");
        String clientName = "Sem Nome";
        String clientNif = "000000000";
        String serviceExecuted = "Nenhum";
        double price = 0;
        Date date = new Date();
        InvoicesRecord instance = new InvoicesRecord();
        Invoice result = instance.newInvoice(clientName, clientNif, serviceExecuted, price, date);
        Invoice expResult = new Invoice();
        assertEquals(expResult, result);
    }

    /**
     * Test of registInvoice method, of class InvoicesRecord.
     */
    @Test
    public void testRegistInvoice() {
        System.out.println("registInvoice");
        Invoice invoice = new Invoice("abc", "0", "x", 0, new Date());
        InvoicesRecord instance = new InvoicesRecord();
        instance.registInvoice(invoice);
        ArrayList list = new ArrayList<Invoice>();
        list.add(invoice);
        assertEquals(list, instance.getLstInvoices());
    }

}
