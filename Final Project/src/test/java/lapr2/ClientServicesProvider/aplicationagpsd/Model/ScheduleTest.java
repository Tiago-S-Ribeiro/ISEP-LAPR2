/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author berna
 */
public class ScheduleTest {
    
    public ScheduleTest() {
    }

    /**
     * Test of getOrder method, of class Schedule.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        Schedule instance = new Schedule(1, new Date(2019, 12, 12), new Time(2, 3));
        int expResult = 1;
        int result = instance.getOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Schedule.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Schedule instance = new Schedule(1, new Date(2019, 12, 12), new Time(2, 3));
        Date expResult = new Date(2019, 12, 12);
        Date result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBeginingHour method, of class Schedule.
     */
    @Test
    public void testGetBeginingHour() {
        System.out.println("getBeginingHour");
        Schedule instance = new Schedule(1, new Date(2019, 12, 12), new Time(2, 3));
        Time expResult = new Time(2, 3);
        Time result = instance.getBeginingHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrder method, of class Schedule.
     */
    @Test
    public void testSetOrder() {
        System.out.println("setOrder");
        int order = 0;
        Schedule instance = new Schedule();
        instance.setOrder(order);
    }

    /**
     * Test of setDay method, of class Schedule.
     */
    @Test
    public void testSetDay() {
        System.out.println("setDay");
        Date day = new Date(2019, 12, 12);
        Schedule instance = new Schedule();
        instance.setDay(day);
    }

    /**
     * Test of setBeginingHour method, of class Schedule.
     */
    @Test
    public void testSetBeginingHour() {
        System.out.println("setBeginingHour");
        Time beginingHour = new Time(2, 3);
        Schedule instance = new Schedule();
        instance.setBeginingHour(beginingHour);
    }

    /**
     * Test of equals method, of class Schedule.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Schedule(1, new Date(2019, 12, 12), new Time(2, 3));
        Schedule instance = new Schedule(2, new Date(2019, 12, 13), new Time(4, 3));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Schedule.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Schedule instance = new Schedule();
        String expResult = "Order=" + instance.getOrder() + ", day=" + instance.getDay() + ", beginingHour=" + instance.getBeginingHour() + ".";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
