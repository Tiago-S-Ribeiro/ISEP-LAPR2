package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.ClientRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ApplianceRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.CategoryRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProvisionRequestRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProviderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceRecord;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class CompanyTest {
    
    public CompanyTest() {
    }

    /**
     * Test of getNIF method, of class Company.
     */
    @Test
    public void testGetNIF() {
        System.out.println("getNIF");
        Company instance = new Company();
        String expResult = "Without NIF";
        String result = instance.getNIF();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDesignation method, of class Company.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation");
        Company instance = new Company();
        String expResult = "Without Designation";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeographicAreasRecord method, of class Company.
     */
    @Test
    public void testGetGeographicAreasRecord() {
        System.out.println("getGeographicAreasRecord");
        Company instance = new Company();
        GeographicAreaRecord expResult = instance.getGeographicAreasRecord();
        GeographicAreaRecord result = Company.getGeographicAreasRecord();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getClientRecord method, of class Company.
     */
    @Test
    public void testGetClientRecord() {
        System.out.println("getClientRecord");
        Company instance = new Company();
        ClientRecord expResult = instance.getClientRecord();
        ClientRecord result = Company.getClientRecord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getApplianceRecord method, of class Company.
     */
    @Test
    public void testGetApplianceRecord() {
        System.out.println("getApplianceRecord");
        Company instance = new Company();
        ApplianceRecord expResult = instance.getApplianceRecord();
        ApplianceRecord result = Company.getApplianceRecord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryRecord method, of class Company.
     */
    @Test
    public void testGetCategoryRecord() {
        System.out.println("getCategoryRecord");
        Company instance = new Company();
        CategoryRecord expResult = instance.getCategoryRecord();
        CategoryRecord result = Company.getCategoryRecord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequestRecord method, of class Company.
     */
    @Test
    public void testGetRequestRecord() {
        System.out.println("getRequestRecord");
        Company instance = new Company();
        ServiceProvisionRequestRecord expResult = instance.getRequestRecord();
        ServiceProvisionRequestRecord result = Company.getRequestRecord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRecord method, of class Company.
     */
    @Test
    public void testGetServiceRecord() {
        System.out.println("getServiceRecord");
        Company instance = new Company();
        ServiceRecord expResult = instance.getServiceRecord();
        ServiceRecord result = Company.getServiceRecord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceProviderRecord method, of class Company.
     */
    @Test
    public void testGetServiceProviderRecord() {
        System.out.println("getServiceProviderRecord");
        Company instance = new Company();
        ServiceProviderRecord expResult = instance.getServiceProviderRecord();
        ServiceProviderRecord result = Company.getServiceProviderRecord();
        assertEquals(expResult, result);
    }
    
}
