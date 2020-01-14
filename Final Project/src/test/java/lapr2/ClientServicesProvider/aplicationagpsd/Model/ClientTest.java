package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ClientTest {
    
    public ClientTest() {
    }

    /**
     * Test of getName method, of class Client.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Client instance = new Client();
        String expResult = "no name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNIF method, of class Client.
     */
    @Test
    public void testGetNIF() {
        System.out.println("getNIF");
        Client instance = new Client();
        String expResult = "no fiscal number";
        String result = instance.getNIF();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhone method, of class Client.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Client instance = new Client();
        String expResult = "no phone number";
        String result = instance.getPhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddressList method, of class Client.
     */
    @Test
    public void testGetAddressList() {
        System.out.println("getAddressList");
        Client instance = new Client();
        List<PostalAddress> expResult = new ArrayList<PostalAddress>();
        List<PostalAddress> result = instance.getAddressList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Client.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "TIAGO";
        Client instance = new Client();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of setNIF method, of class Client.
     */
    @Test
    public void testSetNIF() {
        System.out.println("setNIF");
        String NIF = "123213123";
        Client instance = new Client();
        instance.setNIF(NIF);
        assertEquals(NIF, instance.getNIF());
    }

    /**
     * Test of setPhone method, of class Client.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "919919188";
        Client instance = new Client();
        instance.setPhone(phone);
        assertEquals(phone, instance.getPhone());
    }

    /**
     * Test of setAddressList method, of class Client.
     */
    @Test
    public void testSetAddressList() {
        System.out.println("setAddressList");
        String add = "addressTest";
        String local = "locality";
        String postalCod1 = "4000";
        String postalCod2 = "009";
        PostCode pc = new PostCode(postalCod1,postalCod2);
        PostalAddress p = new PostalAddress(add,local,pc);
        List<PostalAddress> addressList = new ArrayList<PostalAddress>();
        addressList.add(p);
        Client instance = new Client();
        instance.setAddressList(addressList);
        assertEquals(addressList, instance.getAddressList());
    }

    /**
     * Test of getPostalAddress method, of class Client.
     */
    @Test
    public void testGetPostalAddress() {
        System.out.println("getPostalAddress");
        String add = "addressTest";
        String local = "locality";
        String postalCod1 = "4000";
        String postalCod2 = "009";
        PostCode pc = new PostCode(postalCod1,postalCod2);
        PostalAddress p = new PostalAddress(add,local,pc);
        Client instance = new Client();
        instance.getAddressList().add(p);
        PostalAddress expResult = p;
        PostalAddress result = instance.getPostalAddress(add, local, postalCod1, postalCod2);
        assertEquals(expResult, result);
    }

    /**
     * Test of newPostalAddress method, of class Client.
     */
    @Test
    public void testNewPostalAddress() {
        System.out.println("newPostalAddress");
        String address = "addressTest";
        String locality = "localityTest";
        String pc1 = "4000";
        String pc2 = "010";
        PostCode pc = new PostCode(pc1,pc2);
        Client instance = new Client();
        PostalAddress expResult = new PostalAddress(address,locality,pc);
        PostalAddress result = instance.newPostalAddress(address, locality, pc);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPostalAddress method, of class Client.
     */
    @Test
    public void testAddPostalAddress() {
        System.out.println("addPostalAddress");
        Client cli = new Client();
        PostalAddress pa = new PostalAddress();
        cli.addPostalAddress(cli, pa);
        assertEquals(pa, cli.getAddressList().get(0));
    }

    /**
     * Test of equals method, of class Client.
     */
    @Test
    public void testEquals() {
        System.out.println("equals 1 : same reference");
        Object otherObject = new Client();
        Client instance = new Client();
        instance = (Client)otherObject;
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Client.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals 2 : null object");
        Object otherObject = null;
        Client instance = new Client();
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Client.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals 3 : objects of different classes");
        Object otherObject = new Object();
        Client instance = new Client();
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Client.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals 4 : objects are equal");
        Object otherObject = new Client();
        Client instance = new Client();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Client.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String add = "addressTest";
        String local = "locality";
        String postalCod1 = "4000";
        String postalCod2 = "009";
        PostCode pc = new PostCode(postalCod1,postalCod2);
        PostalAddress p = new PostalAddress(add,local,pc);
        Client instance = new Client("Tiago","tiagoEmail","tiagoPass","111111111","999999999",p);
        String expResult = "Client: Tiago , E-mail: tiagoEmail \nNIF nº 111111111\nPhone Number: 999999999";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
