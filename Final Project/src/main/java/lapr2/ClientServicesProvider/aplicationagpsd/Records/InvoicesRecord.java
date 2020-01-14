package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Invoice;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;

/**
 *
 * @author Tiago
 */
public class InvoicesRecord implements Serializable{
    
    private List<Invoice> lstInvoices;

    public InvoicesRecord() {
        this.lstInvoices = new ArrayList<>();
    }

    public List<Invoice> getLstInvoices() {
        return lstInvoices;
    }
    
    public void setInvoiceList(List<Invoice> invoicesList){
        lstInvoices = invoicesList;
    }
    
    public Invoice newInvoice(String clientName, String clientNif, String serviceExecuted, double price, Date date){
        return new Invoice(clientName,clientNif,serviceExecuted,price,date);
    }
    
    public void registInvoice(Invoice invoice){
        lstInvoices.add(invoice);
    }
}
