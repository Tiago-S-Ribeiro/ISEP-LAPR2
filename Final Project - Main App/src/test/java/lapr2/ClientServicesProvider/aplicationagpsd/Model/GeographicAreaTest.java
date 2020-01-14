/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class GeographicAreaTest {

    /**
     * Test of getDesignation method, of class GeographicArea.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation");
        GeographicArea instance = new GeographicArea();
        String expResult = "No Designation";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostOfTravel method, of class GeographicArea.
     */
    @Test
    public void testGetCostOfTravel() {
        System.out.println("getCostOfTravel");
        GeographicArea instance = new GeographicArea();
        float expResult = 0F;
        float result = instance.getCostOfTravel();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getRadius method, of class GeographicArea.
     */
    @Test
    public void testGetRadius() {
        System.out.println("getRadius");
        GeographicArea instance = new GeographicArea();
        double expResult = 0.0;
        double result = instance.getRadius();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPostalCode method, of class GeographicArea.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        GeographicArea instance = new GeographicArea();
        PostCode expResult = new PostCode();
        PostCode result = instance.getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getZonesOfOperation method, of class GeographicArea.
     */
    @Test
    public void testGetZonesOfOperation() {
        System.out.println("getZonesOfOperation");
        GeographicArea instance = new GeographicArea("abc", 2, 1, "4000", "010");
        List<PostCode> list = new ArrayList<PostCode>();
        list.add(new PostCode("4000", "010"));
        List<PostCode> expResult = list;
        List<PostCode> result = instance.getZonesOfOperation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDesignation method, of class GeographicArea.
     */
    @Test
    public void testSetDesignation() {
        System.out.println("setDesignation");
        String designation = "abc";
        GeographicArea instance = new GeographicArea();
        instance.setDesignation(designation);
        assertEquals(designation,instance.getDesignation());
    }

    /**
     * Test of setCostOfTravel method, of class GeographicArea.
     */
    @Test
    public void testSetCostOfTravel() {
        System.out.println("setCostOfTravel");
        float costOfTravel = 1.0F;
        GeographicArea instance = new GeographicArea();
        instance.setCostOfTravel(costOfTravel);
        assertEquals(costOfTravel, instance.getCostOfTravel(), 1);
    }

    /**
     * Test of setRadius method, of class GeographicArea.
     */
    @Test
    public void testSetRadius() {
        System.out.println("setRadius");
        double radius = 1.0;
        GeographicArea instance = new GeographicArea();
        instance.setRadius(radius);
        assertEquals(radius,instance.getRadius(),1);
    }

    /**
     * Test of setPostalCode method, of class GeographicArea.
     */
    @Test
    public void testSetPostalCode() {
        System.out.println("setPostalCode");
        PostCode postalCode = new PostCode("4000", "010");
        GeographicArea instance = new GeographicArea();
        instance.setPostalCode(postalCode);
        assertEquals(postalCode, instance.getPostalCode());
    }

    /**
     * Test of setZonesOfOperation method, of class GeographicArea.
     */
    @Test
    public void testSetZonesOfOperation() {
        System.out.println("setZonesOfOperation");
        List<PostCode> zonesOfOperation = new ArrayList<PostCode>();
        zonesOfOperation.add(new PostCode("4000", "009"));
        GeographicArea instance = new GeographicArea();
        instance.setZonesOfOperation(zonesOfOperation);
        assertEquals(zonesOfOperation, instance.getZonesOfOperation());
    }

    /**
     * Test of toString method, of class GeographicArea.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String abc = "abc";
        PostCode pc = new PostCode("4000", "010");
        GeographicArea instance = new GeographicArea("No Designation", 0, 0, "4000", "010");
        String expResult = "Area Geográfica: " + instance.getDesignation()
                + "\ncódigo postal: " + instance.getPostalCode().toString()
                + "\ncusto de deslocacao: " + instance.getCostOfTravel()
                + "\nraio de atuacao: " + instance.getRadius();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class GeographicArea.
     */
    @Test
    public void testEqualsIf1() {
        System.out.println("equals");
        GeographicArea instance = new GeographicArea();
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class GeographicArea.
     */
    @Test
    public void testEqualsIf2() {
        System.out.println("equals");
        Object obj = new PostCode();
        GeographicArea instance = new GeographicArea();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class GeographicArea.
     */
    @Test
    public void testEqualsIf3() {
        System.out.println("equals");
        Object obj = null;
        GeographicArea instance = new GeographicArea();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class GeographicArea.
     */
    @Test
    public void testEqualsIf4() {
        System.out.println("equals");
        Object obj = new GeographicArea();
        GeographicArea instance = new GeographicArea();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
