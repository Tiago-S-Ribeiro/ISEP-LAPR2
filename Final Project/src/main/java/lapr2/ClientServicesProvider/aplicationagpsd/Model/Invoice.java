package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;

/**
 *
 * @author Tiago
 */
public class Invoice implements Serializable{

    private String invoiceID;
    private String clientName;
    private String clientNif;
    private String serviceExecuted;
    private double price;
    private Date date;

    private static final String invoiceConstant = "INVOICE-";
    private static final String NAME_BY_OMISSION = "Sem Nome";
    private static final String CLIENT_NIF_BY_OMISSION = "000000000";
    private static final String SERVICE_EXECUTED_BY_OMISSION = "Nenhum";
    private static final Date DATE_BY_OMISSION = new Date();
    private static final double PRICE_BY_OMISSION = 0;
    private static int totalInvoices = 0;

    public Invoice(String clientName, String clientNif, String serviceExecuted, double price, Date date) {
        totalInvoices++;
        this.invoiceID = invoiceConstant + totalInvoices;
        this.clientName = clientName;
        this.clientNif = clientNif;
        this.serviceExecuted = serviceExecuted;
        this.price = price;
        this.date = date;
    }

    public Invoice() {
        this.invoiceID = invoiceConstant + totalInvoices;
        this.clientName = NAME_BY_OMISSION;
        this.clientNif = CLIENT_NIF_BY_OMISSION;
        this.serviceExecuted = SERVICE_EXECUTED_BY_OMISSION;
        this.price = PRICE_BY_OMISSION;
        this.date = DATE_BY_OMISSION;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientNif() {
        return clientNif;
    }

    public String getServiceExecuted() {
        return serviceExecuted;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
    
    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setClientName(String clientName) {
        if (clientName == null || clientName.isEmpty()) {
            throw new IllegalArgumentException("Invalid client name.");
        }
        this.clientName = clientName;
    }

    public void setClientNif(String clientNif) {
        if (clientNif.isEmpty() || clientNif == null) {
            throw new IllegalArgumentException("Invalid client nif");
        }
        this.clientNif = clientNif;
    }

    public void setServiceExecuted(String serviceExecuted) {
        if (serviceExecuted.isEmpty() || serviceExecuted == null) {
            throw new IllegalArgumentException("Invalid service executed");
        }
        this.serviceExecuted = serviceExecuted;
    }

    public void setPrice(double price) {
        if (price < 0){
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Invoice other = (Invoice) obj;
        
        return invoiceID.equals(other.invoiceID) && other.clientName.equals(clientName)
                && other.clientNif.equals(clientNif) && other.serviceExecuted.equals(serviceExecuted)
                && other.price == price && other.date.equals(date);
    }

    @Override
    public String toString() {
        return "Invoice " + "invoiceID=" + invoiceID + ", clientName=" + clientName + ", clientNif=" + clientNif + ", serviceExecuted=" + serviceExecuted + ", price=" + price + ", date=" + date;
    }

    
}
