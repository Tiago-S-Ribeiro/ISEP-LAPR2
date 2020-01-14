/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author berna
 */
public class FixServiceTest {
    
    public FixServiceTest() {
    }

    /**
     * Test of getEstimatedDuration method, of class FixService.
     */
    @Test
    public void testGetEstimatedDuration() {
        System.out.println("getEstimatedDuration");
        FixService instance = new FixService("1", "1", "as", "s", "d", 20, new Time(1, 30));
        Time expResult = new Time(1, 30);
        Time result = instance.getEstimatedDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstimatedDuration method, of class FixService.
     */
    @Test
    public void testSetEstimatedDuration() {
        System.out.println("setEstimatedDuration");
        Time estimatedDuration = new Time(2, 0);
        FixService instance = new FixService();
        instance.setEstimatedDuration(estimatedDuration);
    }

    /**
     * Test of toString method, of class FixService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FixService instance = new FixService();
        String toString = String.format("Fix Service - Service: %s\nCost per hour: %.2f", instance.getServiceType(), instance.getHourCost());
        String expResult = toString + " ,duration " + instance.getEstimatedDuration();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCost method, of class FixService.
     */
    @Test
    public void testCalculaCusto() {
        System.out.println("calculateCost");
        FixService instance = new FixService("1", "1", "ds", "asdfb", "dsfv", 10, new Time(1, 30));
        double expResult = 15;
        double result = instance.calculateCost();
        assertEquals(expResult, result, 0.0);
    }
    
}
