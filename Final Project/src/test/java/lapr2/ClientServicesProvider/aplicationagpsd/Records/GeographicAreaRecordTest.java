/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.GeographicArea;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class GeographicAreaRecordTest {

    /**
     * Test of getLstGeographicAreas method, of class GeographicAreaRecord.
     */
    @Test
    public void testGetLstGeographicAreas() {
        System.out.println("getLstGeographicAreas");
        GeographicAreaRecord instance = new GeographicAreaRecord();
        List<GeographicArea> expResult = instance.getLstGeographicAreas();
        List<GeographicArea> result = instance.getLstGeographicAreas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLstGeographicAreas method, of class GeographicAreaRecord.
     */
    @Test
    public void testSetLstGeographicAreas() {
        System.out.println("setLstGeographicAreas");
        List<GeographicArea> lstGeographicAreas = new ArrayList<>();
        GeographicAreaRecord instance = new GeographicAreaRecord();
        instance.setLstGeographicAreas(lstGeographicAreas);
        assertEquals(lstGeographicAreas,instance.getLstGeographicAreas());
    }

    /**
     * Test of registGeographicArea method, of class GeographicAreaRecord.
     */
    @Test
    public void testRegistGeographicArea() {
        System.out.println("registGeographicArea");
        Company c = new Company();
        GeographicArea ga = new GeographicArea("abc", 20, 30, "4000", "010");
        GeographicAreaRecord instance = new GeographicAreaRecord();
        instance.registGeographicArea(ga);
        assertEquals(true,instance.getLstGeographicAreas().contains(ga));
    }

    /**
     * Test of newGeographicArea method, of class GeographicAreaRecord.
     */
    @Test
    public void testNewGeographicArea() {
        System.out.println("newGeographicArea");
        String designation = "abc";
        float cost = 30F;
        double radius = 5020;
        String postalCode1 = "4000";
        String postalCode2 = "010";
        GeographicAreaRecord instance = new GeographicAreaRecord();
        GeographicArea expResult = new GeographicArea(designation, cost, radius, postalCode1, postalCode2);
        GeographicArea result = instance.newGeographicArea(designation, cost, radius, postalCode1, postalCode2);
        assertEquals(expResult, result);
    }
    
}
