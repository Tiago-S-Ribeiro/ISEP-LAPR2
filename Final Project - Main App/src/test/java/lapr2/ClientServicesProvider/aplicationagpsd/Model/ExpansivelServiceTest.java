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
public class ExpansivelServiceTest {
    
    public ExpansivelServiceTest() {
    }

    /**
     * Test of toString method, of class ExpansivelService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ExpansivelService instance = new ExpansivelService();
        String toString = String.format("Expansivel Service- Service: %s\nCost per hour: %.2f", instance.getServiceType(), instance.getHourCost());
        String expResult = toString;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCost method, of class ExpansivelService.
     */
    @Test
    public void testCalculaCusto() {
        System.out.println("calculateCost");
        ExpansivelService instance = new ExpansivelService("1", "1", "dsf", "fesd", "sdfsd", 20.0);
        double expResult = 20.0;
        double result = instance.calculaCusto();
        assertEquals(expResult, result, 0.0);
    }
    
}
