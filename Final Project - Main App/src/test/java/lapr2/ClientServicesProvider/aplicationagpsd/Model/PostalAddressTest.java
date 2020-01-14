package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class PostalAddressTest {
    
    public PostalAddressTest() {
    }

    /**
     * Test of getAddress method, of class PostalAddress.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        PostalAddress instance = new PostalAddress();
        String expResult = "no address";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocality method, of class PostalAddress.
     */
    @Test
    public void testGetLocality() {
        System.out.println("getLocality");
        PostalAddress instance = new PostalAddress();
        String expResult = "no locality";
        String result = instance.getLocality();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostCode method, of class PostalAddress.
     */
    @Test
    public void testGetPostCode() {
        System.out.println("getPostCode");
        String add = "addressTest";
        String local = "locality";
        String postalCod1 = "4000";
        String postalCod2 = "009";
        PostCode pc = new PostCode(postalCod1,postalCod2);
        PostalAddress instance = new PostalAddress(add,local,pc);
        PostCode expResult = pc;
        PostCode result = instance.getPostCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAddress method, of class PostalAddress.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "new address";
        PostalAddress instance = new PostalAddress();
        instance.setAddress(address);
        assertEquals(address, instance.getAddress());
    }

    /**
     * Test of setLocality method, of class PostalAddress.
     */
    @Test
    public void testSetLocality() {
        System.out.println("setLocality");
        String locality = "cfyvgubhinjm";
        PostalAddress instance = new PostalAddress();
        instance.setLocality(locality);
        assertEquals(locality, instance.getLocality());
    }

    /**
     * Test of equals method, of class PostalAddress.
     */
    @Test
    public void testEquals() {
        System.out.println("equals : same reference");
        String add = "addressTest";
        String local = "locality";
        String postalCod1 = "4000";
        String postalCod2 = "009";
        PostCode pc = new PostCode(postalCod1,postalCod2);
        Object otherObject = new PostalAddress(add,local,pc);
        PostalAddress instance = new PostalAddress();
        instance = (PostalAddress) otherObject;
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class PostalAddress.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals : null object");
        Object otherObject = null;
        String add = "addressTest";
        String local = "locality";
        String postalCod1 = "4000";
        String postalCod2 = "009";
        PostCode pc = new PostCode(postalCod1,postalCod2);
        PostalAddress instance = new PostalAddress(add,local,pc);
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class PostalAddress.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals : objects from different classes");
        Object otherObject = new Object();
        String add = "addressTest";
        String local = "locality";
        String postalCod1 = "4000";
        String postalCod2 = "009";
        PostCode pc = new PostCode(postalCod1,postalCod2);
        PostalAddress instance = new PostalAddress(add,local,pc);
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class PostalAddress.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals : objects are equal");
        String add = "addressTest";
        String local = "locality";
        String postalCod1 = "4000";
        String postalCod2 = "009";
        PostCode pc = new PostCode(postalCod1,postalCod2);
        Object otherObject = new PostalAddress(add,local,pc);
        PostalAddress instance = new PostalAddress(add,local,pc);
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of newPostCode method, of class PostalAddress.
     */
    @Test
    public void testNewPostCode() {
        System.out.println("newPostCode");
        String postal1 = "4000";
        String postal2 = "010";
        PostCode pc = new PostCode(postal1,postal2);
        PostalAddress instance = new PostalAddress("address","locality",pc);
        PostCode expResult = new PostCode(postal1,postal2);
        PostCode result = instance.newPostCode(postal1, postal2);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class PostalAddress.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String postal1 = "4000";
        String postal2 = "009";
        PostCode pc = new PostCode(postal1,postal2);
        PostalAddress instance = new PostalAddress("Rua Nova","Localidade Teste", pc);
        String expResult = "Rua Nova, Locality: Localidade Teste, PostCode: 4000 - 009";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}

