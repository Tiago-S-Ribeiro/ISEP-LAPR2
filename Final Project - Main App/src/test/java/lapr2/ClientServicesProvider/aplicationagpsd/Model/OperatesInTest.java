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
public class OperatesInTest {
    
    
    /**
     * Test of OperatesIn method, of class OperatesIn.
     */
    @Test
    public void testOperatesIn() {
        System.out.println("OperatesIn");
        PostCode pc = new PostCode("4000", "010");
        double radius = 1;
        List<PostCode> list = new ArrayList<>();
        list.add(pc);
        List<PostCode> expResult = list;
        List<PostCode> result = OperatesIn.OperatesIn(pc, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtainZonesOfOperation method, of class OperatesIn.
     */
    @Test
    public void testObtainZonesOfOperation() {
        System.out.println("obtainZonesOfOperation");
        PostCode pc = new PostCode("4000", "010");
        double latitude = pc.getLatitude();
        double longitude = pc.getLongitude();
        double radius = 1;
        List<PostCode> list = new ArrayList<PostCode>();
        list.add(pc);
        List<PostCode> expResult = list;
        List<PostCode> result = OperatesIn.obtainZonesOfOperation(latitude, longitude, radius);
        assertEquals(expResult, result);
    }
    
}
