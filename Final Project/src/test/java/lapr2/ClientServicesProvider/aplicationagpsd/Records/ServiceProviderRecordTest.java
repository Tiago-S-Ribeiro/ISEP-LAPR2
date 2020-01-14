package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProviderRecord;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Availability;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ServiceProviderRecordTest {
    
    public ServiceProviderRecordTest() {
    }

    /**
     * Test of getServiceProvidersList method, of class ServiceProviderRecord.
     */
    @Test
    public void testGetServiceProvidersList() {
        System.out.println("getServiceProvidersList");
        ServiceProviderRecord instance = new ServiceProviderRecord();
        List<ServiceProvider> expResult = new ArrayList<ServiceProvider>();
        List<ServiceProvider> result = instance.getServiceProvidersList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setServiceProviderList method, of class ServiceProviderRecord.
     */
    @Test
    public void testSetServiceProviderList() {
        System.out.println("setServiceProviderList");
        List<ServiceProvider> serviceProviderList = new ArrayList<ServiceProvider>();
        ServiceProviderRecord instance = new ServiceProviderRecord();
        instance.setServiceProviderList(serviceProviderList);
        assertEquals(serviceProviderList, instance.getServiceProvidersList());
    }

    /**
     * Test of addServiceProvider method, of class ServiceProviderRecord.
     */
    @Test
    public void testAddServiceProvider() {
        System.out.println("addServiceProvider");
        ServiceProvider sp = new ServiceProvider("FullNameTest", "passTest", "emailTest", "name", "123",new PostalAddress());
        ServiceProviderRecord instance = new ServiceProviderRecord();
        instance.addServiceProvider(sp);
        assertEquals(sp, instance.getServiceProvidersList().get(0));
    }

    /**
     * Test of newServiceProvider method, of class ServiceProviderRecord.
     */
    @Test
    public void testNewServiceProvider() {
        System.out.println("newServiceProvider");
        String fullName = "nomeCompleto";
        String password = "pass";
        String institucionalEmail = "email";
        String abreviatedName = "nomeAbreviado";
        String companyNr = "123";
        PostalAddress pa = new PostalAddress();
        ServiceProviderRecord instance = new ServiceProviderRecord();
        ServiceProvider expResult = new ServiceProvider("nomeCompleto","pass","email","nomeAbreviado","123", new PostalAddress());
        ServiceProvider result = instance.newServiceProvider(fullName, password, institucionalEmail, abreviatedName, companyNr, pa);
        assertEquals(expResult, result);
    }

    /**
     * Test of newAvailability method, of class ServiceProviderRecord.
     */
    @Test
    public void testNewAvailability() {
        System.out.println("newAvailability");
        Date startDate = new Date(2019,8,8);
        Date endDate = new Date(2019,8,8);
        Time startTime = new Time(15,15);
        Time endTime = new Time(15,15);
        ServiceProviderRecord instance = new ServiceProviderRecord();
        Availability expResult = new Availability(startDate,endDate,startTime,endTime);
        Availability result = instance.newAvailability(startDate, endDate, startTime, endTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceProviderByEmail method, of class ServiceProviderRecord.
     */
    @Test
    public void testGetServiceProviderByEmail() {
        System.out.println("getServiceProviderByEmail");
        String email = "emailParaProcura";
        ServiceProviderRecord instance = new ServiceProviderRecord();
        ServiceProvider sp = new ServiceProvider("FullNameTest", "passTest", "emailParaProcura", "name", "123",new PostalAddress());
        instance.addServiceProvider(sp);
        ServiceProvider expResult = sp;
        ServiceProvider result = instance.getServiceProviderByEmail(email);
        assertEquals(expResult, result);
    }
    
}
