package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ServiceProviderTest {
    

    /**
     * Test of getInstitucionalEmail method, of class ServiceProvider.
     */
    @Test
    public void testGetInstitucionalEmail() {
        System.out.println("getInstitucionalEmail");
        ServiceProvider instance = new ServiceProvider();
        String expResult = "no institucional e-mail";
        String result = instance.getInstitucionalEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFullName method, of class ServiceProvider.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        ServiceProvider instance = new ServiceProvider();
        String expResult = "no full name";
        String result = instance.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAbreviatedName method, of class ServiceProvider.
     */
    @Test
    public void testGetAbreviatedName() {
        System.out.println("getAbreviatedName");
        ServiceProvider instance = new ServiceProvider();
        String expResult = "no abreviated name";
        String result = instance.getAbreviatedName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompanyNumber method, of class ServiceProvider.
     */
    @Test
    public void testGetCompanyNumber() {
        System.out.println("getCompanyNumber");
        ServiceProvider instance = new ServiceProvider();
        String expResult = "0000";
        String result = instance.getCompanyNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvailabilitiesList method, of class ServiceProvider.
     */
    @Test
    public void testGetAvailabilitiesList() {
        System.out.println("getAvailabilitiesList");
        ServiceProvider instance = new ServiceProvider();
        List<Availability> expResult = new ArrayList<Availability>();
        List<Availability> result = instance.getAvailabilitiesList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeographicAreasList method, of class ServiceProvider.
     */
    @Test
    public void testGetGeographicAreasList() {
        System.out.println("getGeographicAreasList");
        ServiceProvider instance = new ServiceProvider();
        List<GeographicArea> expResult = new ArrayList<GeographicArea>();
        List<GeographicArea> result = instance.getGeographicAreasList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInstitucionalEmail method, of class ServiceProvider.
     */
    @Test
    public void testSetInstitucionalEmail() {
        System.out.println("setInstitucionalEmail");
        String institucionalEmail = "EMAIL";
        ServiceProvider instance = new ServiceProvider();
        instance.setInstitucionalEmail(institucionalEmail);
        assertEquals(institucionalEmail,instance.getInstitucionalEmail());
    }

    /**
     * Test of setAbreviatedName method, of class ServiceProvider.
     */
    @Test
    public void testSetAbreviatedName() {
        System.out.println("setAbreviatedName");
        String abreviatedName = "abc";
        ServiceProvider instance = new ServiceProvider();
        instance.setAbreviatedName(abreviatedName);
        assertEquals(abreviatedName, instance.getAbreviatedName());
    }

    /**
     * Test of setFullName method, of class ServiceProvider.
     */
    @Test
    public void testSetFullName() {
        System.out.println("setFullName");
        String fullName = "Abc Def";
        ServiceProvider instance = new ServiceProvider();
        instance.setFullName(fullName);
        assertEquals(fullName, instance.getFullName());
    }

    /**
     * Test of setCompanyNr method, of class ServiceProvider.
     */
    @Test
    public void testSetCompanyNr() {
        System.out.println("setCompanyNr");
        String companyNr = "1181444";
        ServiceProvider instance = new ServiceProvider();
        instance.setCompanyNr(companyNr);
        assertEquals(companyNr, instance.getCompanyNumber());
    }

    /**
     * Test of setAvailabilitiesList method, of class ServiceProvider.
     */
    @Test
    public void testSetAvailabilitiesList() {
        System.out.println("setAvailabilitiesList");
        Date date1 = new Date(2019, 6, 9);
        Date date2 = new Date(2019,6,10);
        Time time1 = new Time(14,30);
        Time time2 = new Time(17,30);
        Availability newAvailability = new Availability(date1, date2, time1, time2);
        List<Availability> availabilitiesList = new ArrayList<>();
        availabilitiesList.add(newAvailability);
        ServiceProvider instance = new ServiceProvider();
        instance.setAvailabilitiesList(availabilitiesList);
        assertEquals(availabilitiesList, instance.getAvailabilitiesList());
    }

    /**
     * Test of setGeographicAreasList method, of class ServiceProvider.
     */
    @Test
    public void testSetGeographicAreasList() {
        System.out.println("setGeographicAreasList");
        List<GeographicArea> geographicAreasList = new ArrayList<>();
        ServiceProvider instance = new ServiceProvider();
        instance.setGeographicAreasList(geographicAreasList);
        assertEquals(geographicAreasList, instance.getGeographicAreasList());
    }

    /**
     * Test of addAvailability method, of class ServiceProvider.
     */
    @Test
    public void testAddAvailability() {
        System.out.println("addAvailability");
        Date date1 = new Date(2019, 6, 9);
        Date date2 = new Date(2019,6,10);
        Time time1 = new Time(14,30);
        Time time2 = new Time(17,30);
        Availability newAvailability = new Availability(date1, date2, time1, time2);
        ServiceProvider instance = new ServiceProvider();
        instance.addAvailability(newAvailability);
        assertEquals(newAvailability, instance.getAvailabilitiesList().get(0));
    }

    /**
     * Test of addGeographicArea method, of class ServiceProvider.
     */
    @Test
    public void testAdicionarAreaGeografica() {
        System.out.println("addGeographicArea");
        GeographicArea area = new GeographicArea();
        ServiceProvider instance = new ServiceProvider();
        instance.addGeographicArea(area);
        assertEquals(area, instance.getGeographicAreasList().get(0));
    }

    /**
     * Test of equals method, of class ServiceProvider.
     * Tests the first if. If both objects point at the same reference, meaning they're equal.
     */
    @Test
    public void testEquals() {
        System.out.println("equals 1 : same reference");
        Object otherObject = new ServiceProvider();
        ServiceProvider instance = new ServiceProvider();
        instance = (ServiceProvider)otherObject;
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class ServiceProvider.
     * Tests the second IF. If object is null, meaning they're not equal
     */
    @Test
    public void testEquals2() {
        System.out.println("equals 2 : null object");
        Object otherObject = null;
        ServiceProvider instance = new ServiceProvider();
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class ServiceProvider.
     * Tests the second IF, second condition. If objects are from different classes, meaning they're not equal
     */
    @Test
    public void testEquals3() {
        System.out.println("equals 3 : objects of different classes");
        Object otherObject = new Object();
        ServiceProvider instance = new ServiceProvider();
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }  
    
    /**
     * Test of equals method, of class ServiceProvider.
     * Tests the final condition, if all attributes of the objects are the same, they're considered equals
     */
    @Test
    public void testEquals4() {
        System.out.println("equals 4 : objects are equal");
        Object otherObject = new ServiceProvider("FullNameTest", "passTest", "emailTest", "abreviatedNameTest", "CompanyNrTest", new PostalAddress());
        ServiceProvider instance = new ServiceProvider("FullNameTest", "passTest", "emailTest", "abreviatedNameTest", "CompanyNrTest", new PostalAddress());
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    } 

    /**
     * Test of toString method, of class ServiceProvider.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ServiceProvider instance = new ServiceProvider("FullNameTest", "passTest", "emailTest", "name", "123", new PostalAddress());
        String expResult = "Colaborador: name , Nº Mecanográfico: 123";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
