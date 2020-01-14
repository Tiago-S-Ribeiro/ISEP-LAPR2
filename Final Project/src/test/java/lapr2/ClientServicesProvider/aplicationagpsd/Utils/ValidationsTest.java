package lapr2.ClientServicesProvider.aplicationagpsd.Utils;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ValidationsTest {
    
    public ValidationsTest() {
    }

    /**
     * Test of isNumeric method, of class Validations.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric : string being a number");
        String strNum = "3";
        boolean expResult = true;
        boolean result = Validations.isNumeric(strNum);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isNumeric method, of class Validations.
     */
    @Test
    public void testIsNumeric2() {
        System.out.println("isNumeric : string being a letter");
        String strNum = "K";
        boolean expResult = false;
        boolean result = Validations.isNumeric(strNum);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNumDouble method, of class Validations.
     */
    @Test
    public void testIsNumDouble() {
        System.out.println("isNumDouble : string being a double");
        String strNum = "3.7";
        boolean expResult = true;
        boolean result = Validations.isNumDouble(strNum);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isNumDouble method, of class Validations.
     */
    @Test
    public void testIsNumDouble2() {
        System.out.println("isNumDouble : string being a letter");
        String strNum = "K";
        boolean expResult = false;
        boolean result = Validations.isNumDouble(strNum);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNumFloat method, of class Validations.
     */
    @Test
    public void testIsNumFloat() {
        System.out.println("isNumFloat : string being a float");
        String strNum = "3.6f";
        boolean expResult = true;
        boolean result = Validations.isNumFloat(strNum);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isNumFloat method, of class Validations.
     */
    @Test
    public void testIsNumFloat2() {
        System.out.println("isNumFloat : string being a letter");
        String strNum = "K";
        boolean expResult = false;
        boolean result = Validations.isNumFloat(strNum);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of isEmailValid method, of class Validations.
     */
    @Test
    public void testIsEmailValid() {
        System.out.println("isEmailValid : valid");
        String email = "tiago@gmail.com";
        boolean expResult = true;
        boolean result = Validations.isEmailValid(email);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmailValid method, of class Validations.
     */
    @Test
    public void testIsEmailValid2() {
        System.out.println("isEmailValid : not valid");
        String email = "fcxdvhbjnkjvhgf";
        boolean expResult = false;
        boolean result = Validations.isEmailValid(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPhoneValid method, of class Validations.
     */
    @Test
    public void testIsPhoneValid() {
        System.out.println("isPhoneValid : not valid (letters instead of numbers)");
        String phone = "hrtg";
        boolean expResult = false;
        boolean result = Validations.isPhoneValid(phone);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isPhoneValid method, of class Validations.
     */
    @Test
    public void testIsPhoneValid2() {
        System.out.println("isPhoneValid : not valid (not having 9 didgits)");
        String phone = "1994";
        boolean expResult = false;
        boolean result = Validations.isPhoneValid(phone);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isPhoneValid method, of class Validations.
     */
    @Test
    public void testIsPhoneValid3() {
        System.out.println("isPhoneValid : not valid (not starting by '2' or '9')");
        String phone = "010719940";
        boolean expResult = false;
        boolean result = Validations.isPhoneValid(phone);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isPhoneValid method, of class Validations.
     */
    @Test
    public void testIsPhoneValid4() {
        System.out.println("isPhoneValid : valid ");
        String phone = "987654321";
        boolean expResult = true;
        boolean result = Validations.isPhoneValid(phone);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isPhoneValid method, of class Validations.
     */
    @Test
    public void testIsPhoneValid5() {
        System.out.println("isPhoneValid : not valid (null string)");
        String phone = null;
        boolean expResult = false;
        boolean result = Validations.isPhoneValid(phone);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isNIFValid method, of class Validations.
     */
    @Test
    public void testIsNIFValid() {
        System.out.println("isNIFValid : not valid (letters instead of numbers)");
        String NIF = "K";
        boolean expResult = false;
        boolean result = Validations.isNIFValid(NIF);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isNIFValid method, of class Validations.
     */
    @Test
    public void testIsNIFValid2() {
        System.out.println("isNIFValid : not valid (not having 9 digits)");
        String NIF = "1994";
        boolean expResult = false;
        boolean result = Validations.isNIFValid(NIF);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isNIFValid method, of class Validations.
     */
    @Test
    public void testIsNIFValid3() {
        System.out.println("isNIFValid : not valid (null string)");
        String NIF = null;
        boolean expResult = false;
        boolean result = Validations.isNIFValid(NIF);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isNIFValid method, of class Validations.
     */
    @Test
    public void testIsNIFValid4() {
        System.out.println("isNIFValid : valid");
        String NIF = "123123123";
        boolean expResult = true;
        boolean result = Validations.isNIFValid(NIF);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNameValid method, of class Validations.
     */
    @Test
    public void testIsNameValid() {
        System.out.println("isNameValid : valid");
        String name = "Tiago Ribeiro";
        boolean expResult = true;
        boolean result = Validations.isNameValid(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isNameValid method, of class Validations.
     */
    @Test
    public void testIsNameValid2() {
        System.out.println("isNameValid : not valid (numbers, letters and random chars)");
        String name = "768hb %$fdew .*";
        boolean expResult = false;
        boolean result = Validations.isNameValid(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of isAddressValid method, of class Validations.
     */
    @Test
    public void testIsAddressValid() {
        System.out.println("isAddressValid : not valid (numbers)");
        String address = "4324";
        boolean expResult = false;
        boolean result = Validations.isAddressValid(address);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isAddressValid method, of class Validations.
     */
    @Test
    public void testIsAddressValid2() {
        System.out.println("isAddressValid : not valid (null)");
        String address = null;
        boolean expResult = false;
        boolean result = Validations.isAddressValid(address);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isAddressValid method, of class Validations.
     */
    @Test
    public void testIsAddressValid3() {
        System.out.println("isAddressValid : valid");
        String address = "Rua do ISEP";
        boolean expResult = true;
        boolean result = Validations.isAddressValid(address);
        assertEquals(expResult, result);
    }

    /**
     * Test of isLocalityValid method, of class Validations.
     */
    @Test
    public void testIsLocalityValid() {
        System.out.println("isLocalityValid : not valid (null)");
        String locality = null;
        boolean expResult = false;
        boolean result = Validations.isLocalityValid(locality);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isLocalityValid method, of class Validations.
     */
    @Test
    public void testIsLocalityValid2() {
        System.out.println("isLocalityValid : valid");
        String locality = "localidade do ISEP";
        boolean expResult = true;
        boolean result = Validations.isLocalityValid(locality);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStartDateValid method, of class Validations.
     */
    @Test
    public void testIsStartDateValid() {
        System.out.println("isStartDateValid : not valid (year prior to atual year)");
        int year = 2018;
        int month = 7;
        int day = 19;
        boolean expResult = false;
        boolean result = Validations.isStartDateValid(year, month, day);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStartDateValid method, of class Validations.
     */
    @Test
    public void testIsStartDateValid2() {
        System.out.println("isStartDateValid : not valid (same year,month prior to atual month)");
        int year = 2019;
        int month = 2;
        int day = 6;
        boolean expResult = false;
        boolean result = Validations.isStartDateValid(year, month, day);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStartDateValid method, of class Validations.
     */
    @Test
    public void testIsStartDateValid3() {
        System.out.println("isStartDateValid : not valid (same year and month,day prior to atual day)");
        int year = 2019;
        int month = 6;
        int day = 2;
        boolean expResult = false;
        boolean result = Validations.isStartDateValid(year, month, day);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStartDateValid method, of class Validations.
     */
    @Test
    public void testIsStartDateValid4() {
        System.out.println("isStartDateValid : valid");
        int year = 2019;
        int month = 9;
        int day = 15;
        boolean expResult = true;
        boolean result = Validations.isStartDateValid(year, month, day);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEndDateValid method, of class Validations.
     */
    @Test
    public void testIsEndDateValid() {
        System.out.println("isEndDateValid : not valid (year prior to Start Year)");
        int year = 2018;
        int month = 8;
        int day = 8;
        Date startDate = new Date(2019,8,8);
        boolean expResult = false;
        boolean result = Validations.isEndDateValid(year, month, day, startDate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEndDateValid method, of class Validations.
     */
    @Test
    public void testIsEndDateValid2() {
        System.out.println("isEndDateValid : not valid (same year , month prior to Start Month)");
        int year = 2019;
        int month = 2;
        int day = 8;
        Date startDate = new Date(2019,8,8);
        boolean expResult = false;
        boolean result = Validations.isEndDateValid(year, month, day, startDate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEndDateValid method, of class Validations.
     */
    @Test
    public void testIsEndDateValid3() {
        System.out.println("isEndDateValid : not valid (same year and month, day prior to Start Day)");
        int year = 2019;
        int month = 8;
        int day = 4;
        Date startDate = new Date(2019,8,8);
        boolean expResult = false;
        boolean result = Validations.isEndDateValid(year, month, day, startDate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEndDateValid method, of class Validations.
     */
    @Test
    public void testIsEndDateValid4() {
        System.out.println("isEndDateValid : valid");
        int year = 2019;
        int month = 9;
        int day = 9;
        Date startDate = new Date(2019,8,8);
        boolean expResult = true;
        boolean result = Validations.isEndDateValid(year, month, day, startDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStartTimeValid method, of class Validations.
     */
    @Test
    public void testIsStartTimeValid() {
        System.out.println("isStartTimeValid : not valid (letters instead of numbers)");
        String hour = "rgt";
        String minute = "egs";
        boolean expResult = false;
        boolean result = Validations.isStartTimeValid(hour, minute);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStartTimeValid method, of class Validations.
     */
    @Test
    public void testIsStartTimeValid2() {
        System.out.println("isStartTimeValid : not valid (hour superior to 24h)");
        String hour = "50";
        String minute = "10";
        boolean expResult = false;
        boolean result = Validations.isStartTimeValid(hour, minute);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStartTimeValid method, of class Validations.
     */
    @Test
    public void testIsStartTimeValid3() {
        System.out.println("isStartTimeValid : not valid (hour inferior to 6h)");
        String hour = "2";
        String minute = "10";
        boolean expResult = false;
        boolean result = Validations.isStartTimeValid(hour, minute);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStartTimeValid method, of class Validations.
     */
    @Test
    public void testIsStartTimeValid4() {
        System.out.println("isStartTimeValid : not valid (minute inferior to 0)");
        String hour = "10";
        String minute = "-6";
        boolean expResult = false;
        boolean result = Validations.isStartTimeValid(hour, minute);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStartTimeValid method, of class Validations.
     */
    @Test
    public void testIsStartTimeValid5() {
        System.out.println("isStartTimeValid : not valid (minute superior to 59)");
        String hour = "10";
        String minute = "70";
        boolean expResult = false;
        boolean result = Validations.isStartTimeValid(hour, minute);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStartTimeValid method, of class Validations.
     */
    @Test
    public void testIsStartTimeValid6() {
        System.out.println("isStartTimeValid : valid");
        String hour = "10";
        String minute = "15";
        boolean expResult = true;
        boolean result = Validations.isStartTimeValid(hour, minute);
        assertEquals(expResult, result);
    }
// isNumeric(hour)==false || isNumeric(minute)==false || Integer.parseInt(hour)>24 || Integer.parseInt(hour)<6 
// Integer.parseInt(minute)<0 || Integer.parseInt(minute)>59
//(Integer.parseInt(hour)<time.getHours()) || ((Integer.parseInt(hour)==time.getHours() && Integer.parseInt(minute)<=time.getMinutes()))
    

    /**
     * Test of isEndTimeValid method, of class Validations.
     */
    @Test
    public void testIsEndTimeValid() {
        System.out.println("isEndTimeValid : not valid (hour inferior to start Hour)");
        String hour = "13";
        String minute = "13";
        Time time = new Time(15,15);
        boolean expResult = false;
        boolean result = Validations.isEndTimeValid(hour, minute, time);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEndTimeValid method, of class Validations.
     */
    @Test
    public void testIsEndTimeValid2() {
        System.out.println("isEndTimeValid : not valid (same hour, minutes equal or inferior to start minutes)");
        String hour = "13";
        String minute = "13";
        Time time = new Time(15,15);
        boolean expResult = false;
        boolean result = Validations.isEndTimeValid(hour, minute, time);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEndTimeValid method, of class Validations.
     */
    @Test
    public void testIsEndTimeValid3() {
        System.out.println("isEndTimeValid : valid");
        String hour = "16";
        String minute = "16";
        Time time = new Time(15,15);
        boolean expResult = true;
        boolean result = Validations.isEndTimeValid(hour, minute, time);
        assertEquals(expResult, result);
    }
}
