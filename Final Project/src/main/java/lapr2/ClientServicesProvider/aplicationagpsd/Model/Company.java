package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.ExecutionOrderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.*;

import java.io.Serializable;

/**
 * @author Tiago Ribeiro (1181444)
 * @author Rafael Moreira (1180778)
 * @author Tiago Dias (1180939)
 * @author Pedro Água (1180809)
 * @author Bernardo Carvalho (1170691)
 */
public class Company implements Serializable {

    /**
     * NIF da Company
     */
    private String NIF;

    /**
     * Designacao da Company
     */
    private String designation;

    /**
     * The NIF of the company by omission.
     */
    private static final String NIF_BY_OMISSION = "Without NIF";

    /**
     * The designation of the company by omission.
     */
    private static final String DESIGNATION_BY_OMISSION = "Without Designation";

    /**
     * The geographic area record of the company.
     */
    private static GeographicAreaRecord geographicAreaRecord;

    /**
     * The client record of the company.
     */
    private static ClientRecord clientRecord;

    /**
     * The candidature record of the company.
     */
    private static ApplianceRecord applianceRecord;

    /**
     * The category record of the company.
     */
    private static CategoryRecord categoryRecord;

    /**
     * The service provision request record of the company.
     */
    private static ServiceProvisionRequestRecord requestRecord;

    /**
     * The service record of the company.
     */
    private static ServiceRecord serviceRecord;

    /**
     * The service provider record of the company.
     */
    private static ServiceProviderRecord serviceProviderRecord;

    /**
     * The execution order record.
     */
    private static ExecutionOrderRecord executionOrderRecord;

    /**
     * The affected to record.
     */
    private static AffectedToRecord affectedToRecord;

    /**
     * The completed works record.
     */
    private static CompleteWorkRecord completeWorkRecord;

    /**
     * The invoices record.
     */
    private static InvoicesRecord invoicesRecord;

    /**
     * The ratings record.
     */
    private static RatingsRecord ratingsRecord;
    /**
     * The user's record
     */
    private static UsersRecord userRecord;

    /**
     * Company with all complete parameters.
     *
     * @param nif         NIF of the company.
     * @param designation Designation of the company.
     */
    public Company(String nif, String designation) {
        this.NIF = nif;
        this.designation = designation;
        geographicAreaRecord = new GeographicAreaRecord();
        clientRecord = new ClientRecord();
        applianceRecord = new ApplianceRecord();
        categoryRecord = new CategoryRecord();
        requestRecord = new ServiceProvisionRequestRecord();
        serviceRecord = new ServiceRecord();
        serviceProviderRecord = new ServiceProviderRecord();
        affectedToRecord = new AffectedToRecord();
        executionOrderRecord = new ExecutionOrderRecord();
        ratingsRecord = new RatingsRecord();
        completeWorkRecord = new CompleteWorkRecord();
        invoicesRecord = new InvoicesRecord();
        ratingsRecord = new RatingsRecord();
        userRecord = new UsersRecord();
    }

    /**
     * Company with the parameters by omission.
     */
    public Company() {
        this.NIF = NIF_BY_OMISSION;
        this.designation = DESIGNATION_BY_OMISSION;
        geographicAreaRecord = new GeographicAreaRecord();
        clientRecord = new ClientRecord();
        applianceRecord = new ApplianceRecord();
        categoryRecord = new CategoryRecord();
        requestRecord = new ServiceProvisionRequestRecord();
        serviceRecord = new ServiceRecord();
        serviceProviderRecord = new ServiceProviderRecord();
        affectedToRecord = new AffectedToRecord();
        executionOrderRecord = new ExecutionOrderRecord();
        completeWorkRecord = new CompleteWorkRecord();
        invoicesRecord = new InvoicesRecord();
        userRecord = new UsersRecord();
    }

    /**
     * Gets the NIF of the company.
     *
     * @return the NIF.
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Gets the designation of the company.
     *
     * @return the designation of the company.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Gets the geographic area record for the company.
     *
     * @return the list of the instance of the client record.
     */
    public static GeographicAreaRecord getGeographicAreasRecord() {
        return geographicAreaRecord;
    }

    /**
     * Gets the client record for the company.
     *
     * @return the instance of the client record.
     */
    public static ClientRecord getClientRecord() {
        return clientRecord;
    }

    /**
     * Gets the candidature record for the company.
     *
     * @return the instance of candidature record.
     */
    public static ApplianceRecord getApplianceRecord() {
        return applianceRecord;
    }

    /**
     * Gets the category record for the company.
     *
     * @return the instance of category record.
     */
    public static CategoryRecord getCategoryRecord() {
        return categoryRecord;
    }

    /**
     * @return the requestRecord
     */
    public static ServiceProvisionRequestRecord getRequestRecord() {
        return requestRecord;
    }

    /**
     * @return the serviceRecord
     */
    public static ServiceRecord getServiceRecord() {
        return serviceRecord;
    }

    /**
     * @return the serviceProviderRecord
     */
    public static ServiceProviderRecord getServiceProviderRecord() {
        return serviceProviderRecord;
    }

    /**
     * @return gets the affected to record.
     */
    public static AffectedToRecord getAffectedToRecord() {
        return affectedToRecord;
    }

    /**
     * @return gets the execution order record.
     */
    public static ExecutionOrderRecord getExecutionOrderRecord() {
        return executionOrderRecord;
    }

    /**
     * @return gets the complete work record.
     */
    public static CompleteWorkRecord getCompleteWorkRecord() {
        return completeWorkRecord;
    }

    /**
     * @return gets the invoice record.
     */
    public static InvoicesRecord getInvoiceRecord() {
        return invoicesRecord;
    }

    /**
     * @return gets the rating record.
     */
    public static RatingsRecord getRatingsRecord() {
        return ratingsRecord;
    }
    
    public static UsersRecord getUserRecord(){
        return userRecord;
    }
}
