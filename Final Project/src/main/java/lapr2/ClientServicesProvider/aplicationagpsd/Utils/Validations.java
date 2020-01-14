package lapr2.ClientServicesProvider.aplicationagpsd.Utils;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 *
 * @author Tiago Dias(1180939)
 * @author Bernardo Carvalho(1170691)
 * @author Tiago Ribeiro(1181444)
 */
public class Validations {
    public static DecimalFormat round = new DecimalFormat(".##");
    public static boolean isNumeric(String strNum) {
        boolean ret = true;
        try {

            Integer.parseInt(strNum);

        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }
    
    public static boolean isNumDouble(String strNum) {
        boolean ret = true;
        try {

            Double.parseDouble(strNum);

        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }
    
    public static boolean isNumFloat(String strNum) {
        boolean ret = true;
        try {

            Float.parseFloat(strNum);

        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }
    
    public static boolean isEmailValid(String email) {
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        return email.matches(regex);
    }

    public static boolean isPhoneValid(String phone) {
        if (phone != null && !phone.isEmpty() && phone.length() == 9 && isNumeric(phone) == true && (Character.getNumericValue(phone.charAt(0)) == 2 || Character.getNumericValue(phone.charAt(0)) == 9)) {
            return true;
        }
        return false;
    }

    public static boolean isNIFValid(String NIF) {
        if (NIF != null && !NIF.isEmpty() && NIF.length() == 9 && isNumeric(NIF) == true && Integer.parseInt(NIF) > 0) {
            return true;
        }
        return false;
    }
    
    public static boolean isNameValid(String name) {
        String regex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
        return name.matches(regex);
    }
    
    public static boolean isAddressValid(String address){
        if(address != null && !address.isEmpty() && isNumeric(address) == false){
            return true;
        }
        return false;
    }
    
    public static boolean isLocalityValid(String locality){
        if(locality != null && !locality.isEmpty() && isNumeric(locality) == false){
            return true;
        }
        return false;
    }
    
    public static boolean isStartDateValid(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        if (year < calendar.get(Calendar.YEAR)  ||  ((year == calendar.get(Calendar.YEAR)) && (month<(calendar.get(Calendar.MONTH)+1)))  ||  ((year == calendar.get(Calendar.YEAR))&&(month==(calendar.get(Calendar.MONTH)+1))&&(day < calendar.get(Calendar.DAY_OF_MONTH))) ) {
            return false;
        }
        return true;
    }
    
    public static boolean isEndDateValid(int year, int month, int day, Date startDate) {
        if (year < startDate.getYear()  ||  ((year == startDate.getYear())) && (month<(startDate.getMonth()))  ||  ((year == startDate.getYear())&&(month==(startDate.getMonth()))&&(day < startDate.getDay())) ) {
            return false;
        }
        return true;
    }
    
    public static boolean isStartTimeValid(String hour, String minute){
        if(isNumeric(hour)==false || isNumeric(minute)==false || Integer.parseInt(hour)>24 || Integer.parseInt(hour)<6 || Integer.parseInt(minute)<0 || Integer.parseInt(minute)>59){
            return false;
        }
        return true;
    }
    
    public static boolean isEndTimeValid(String hour, String minute, Time time){
        if((isNumeric(hour)==false) || (isNumeric(minute)==false) || (Integer.parseInt(hour)>24) || (Integer.parseInt(hour)<6) || (Integer.parseInt(minute)<0) || (Integer.parseInt(minute)>59) || (Integer.parseInt(hour)<time.getHours()) || ((Integer.parseInt(hour)==time.getHours() && Integer.parseInt(minute)<=time.getMinutes())) ){
            return false;
        }
        return true;
    }
    public static boolean isPreferentialDateValid(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        if (year < calendar.get(Calendar.YEAR)  ||  ((year == calendar.get(Calendar.YEAR)) && (month<(calendar.get(Calendar.MONTH)+1)))  ||  ((year == calendar.get(Calendar.YEAR))&&(month==(calendar.get(Calendar.MONTH)+1))&&(day <= calendar.get(Calendar.DAY_OF_MONTH))) ) {
            return false;
        }
        return true;
    }
}
