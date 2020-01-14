/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author berna
 */
public class LimitedServiceTest {
    
    public LimitedServiceTest() {
    }

    /**
     * Test of toString method, of class LimitedService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LimitedService instance = new LimitedService("1", "1", "LimitedService", "jhg", "jhgf", 20);
        String toString = String.format("Limited Service - Service: %s\nCost per hour: %.2f", instance.getServiceType(), instance.getHourCost());
        String expResult = toString;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCost method, of class LimitedService.
     */
    @Test
    public void testCalculateCost() {
        System.out.println("calculateCost");
        LimitedService instance = new LimitedService("1", "1", "LimitedService", "jhg", "jhgf", 20);
        double expResult = 20;
        double result = instance.calculateCost();
        assertEquals(expResult, result, 0.0);
    }
    
}
