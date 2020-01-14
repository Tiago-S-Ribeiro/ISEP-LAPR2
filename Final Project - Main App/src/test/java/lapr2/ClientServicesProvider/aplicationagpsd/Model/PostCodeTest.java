package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class PostCodeTest {
    
    /**
     * Test of getPostalCode1 method, of class PostCode.
     */
    @Test
    public void testGetPostalCode1() {
        System.out.println("getPostalCode1");
        PostCode instance = new PostCode();
        String expResult = "0000";
        String result = instance.getPostalCode1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostalCode2 method, of class PostCode.
     */
    @Test
    public void testGetPostalCode2() {
        System.out.println("getPostalCode2");
        PostCode instance = new PostCode();
        String expResult = "000";
        String result = instance.getPostalCode2();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getLongitude method, of class PostCode.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        PostCode instance = new PostCode();
        double expResult = 0.0;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLatitude method, of class PostCode.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        PostCode instance = new PostCode();
        double expResult = 0.0;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPostalCode1 method, of class PostCode.
     */
    @Test
    public void testSetPostalCode1() {
        System.out.println("setPostalCode1");
        String postalCode1 = "4000";
        PostCode instance = new PostCode();
        instance.setPostalCode1(postalCode1);
        assertEquals(postalCode1, instance.getPostalCode1());
    }

    /**
     * Test of setPostalCode2 method, of class PostCode.
     */
    @Test
    public void testSetPostalCode2() {
        System.out.println("setPostalCode2");
        String postalCode2 = "010";
        PostCode instance = new PostCode();
        instance.setPostalCode2(postalCode2);
        assertEquals(postalCode2, instance.getPostalCode2());
    }

    /**
     * Test of setLongitude method, of class PostCode.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = 10;
        PostCode instance = new PostCode();
        instance.setLongitude(longitude);
        assertEquals(longitude, instance.getLongitude(), longitude);
    }

    /**
     * Test of setLatitude method, of class PostCode.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = -8;
        PostCode instance = new PostCode();
        instance.setLatitude(latitude);
        assertEquals(latitude, instance.getLatitude(), latitude);
    }

    /**
     * Test of toString method, of class PostCode.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PostCode instance = new PostCode("4000","010");
        String expResult = instance.getPostalCode1() + "-" + instance.getPostalCode2();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class PostCode.
     */
    @Test
    public void testEqualsIf1() {
        System.out.println("equals");
        Object obj = null;
        PostCode instance = new PostCode();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method, of class PostCode.
     */
    @Test
    public void testEqualsIf2() {
        System.out.println("equals");
        PostCode instance = new PostCode();
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class PostCode.
     */
    @Test
    public void testEqualsIf3() {
        System.out.println("equals");
        GeographicArea ga = new GeographicArea();
        PostCode instance = new PostCode();
        boolean expResult = false;
        boolean result = instance.equals(ga);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class PostCode.
     */
    @Test
    public void testEqualsIf4() {
        System.out.println("equals");
        Object obj = new PostCode("4000", "010");
        PostCode instance = new PostCode("4000","010");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of obtainLongitude method, of class PostCode.
     */
    @Test
    public void testObtainLongitude() {
        System.out.println("obtainLongitude");
        String postalCode1 = "4000";
        String postalCode2 = "010";
        PostCode instance = new PostCode("4000","010");
        double expResult = -8.5980302;
        double result = instance.obtainLongitude(postalCode1, postalCode2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of obtainLatitude method, of class PostCode.
     */
    @org.junit.Test
    public void testObtainLatitude() {
        System.out.println("obtainLatitude");
        String postalCode1 = "4000";
        String postalCode2 = "010";
        PostCode instance = new PostCode("4000","010");
        double expResult = 41.1531991;
        double result = instance.obtainLatitude(postalCode1, postalCode2);
        assertEquals(expResult, result, 0.0);
    }
    
}
