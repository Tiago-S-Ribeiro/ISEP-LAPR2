package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class Availability implements Serializable{

    /**
     * Start date of the service provider availability
     */
    private Date startDate;
    /**
     * End date of the service provider availability
     */
    private Date endDate;
    /**
     * Start time of the service provider availability
     */
    private Time startTime;
    /**
     * End time of the service provider availability
     */
    private Time endTime;
    /**
     * Start date of the service provider availability by omission
     */
    private static final Date START_DATE_BY_OMISSION = new Date();
    /**
     * End date of the service provider availability by omission
     */
    private static final Date END_DATE_BY_OMISSION = new Date();
    /**
     * Start time of the service provider availability by omission
     */
    private static final Time START_TIME_BY_OMISSION = new Time();
    /**
     * End time of the service provider availability by omission
     */
    private static final Time END_TIME_BY_OMISSION = new Time();

    /**
     * Builds an instance of Availability that receives the start year, month, day, hours and minutes, and end year, month, day, hours and minutes
     *
     * @param startYear year of start of availability
     * @param startMonth month of start of availability
     * @param startDay day of start of availability
     * @param endYear year of end of availability
     * @param endMonth month of end of availability
     * @param endDay day of end of availability
     * @param startHour hour of start of availability
     * @param startMinutes minutes of start of availability
     * @param endHour hour of end of availability
     * @param endMinutes minutes of end of availability
     */
    public Availability(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay, int startHour, int startMinutes, int endHour, int endMinutes) {
        this.startDate = new Date(startYear, startMonth, startDay);
        this.endDate = new Date(endYear, endMonth, endDay);
        this.startTime = new Time(startHour, startMinutes);
        this.endTime = new Time(endHour, endMinutes);
    }

    /**
     * Builds an instance of Availability that receives the Date of start, Date of end, Time of start and Time of end
     *
     * @param startDate start year/month/year of availability
     * @param endDate end year/month/year of availability
     * @param startTime start hour:minute of availability
     * @param endTime end hour:minute of availability
     */
    public Availability(Date startDate, Date endDate, Time startTime, Time endTime) {
        this.startDate = new Date(startDate);
        this.endDate = new Date(endDate);
        this.startTime = new Time(startTime);
        this.endTime = new Time(endTime);
    }

    /**
     * Builds an instance of Availability that is copy of the one passed by parameter
     *
     * @param otherAvailability availability to be copied
     */
    public Availability(Availability otherAvailability) {
        this.startDate = otherAvailability.startDate;
        this.endDate = otherAvailability.endDate;
        this.startTime = otherAvailability.startTime;
        this.endTime = otherAvailability.endTime;
    }

    /**
     * Builds an instance of Availability with the values by omission
     */
    public Availability() {
        startDate = START_DATE_BY_OMISSION;
        endDate = END_DATE_BY_OMISSION;
        startTime = START_TIME_BY_OMISSION;
        endTime = END_TIME_BY_OMISSION;
    }

    /**
     * @return start date of availability
     */
    public Date getStartDate() {
        return new Date(startDate);
    }

    /**
     * @return end date of availability
     */
    public Date getEndDate() {
        return new Date(endDate);
    }

    /**
     * @return start time of availability
     */
    public Time getStartTime() {
        return new Time(startTime);
    }

    /**
     * @return end time of availability
     */
    public Time getEndTime() {
        return new Time(endTime);
    }

    /**
     * Modifies the start Date
     *
     * @param startDate start date of availability
     */
    public void setStartDate(Date startDate) {
        this.startDate.setDate(startDate.getYear(), startDate.getMonth(), startDate.getDay());
    }

    /**
     * Modifies the start Date
     *
     * @param year year of start of availability
     * @param month month of start of availability
     * @param day day of start of availability
     */
    public void setStartDate(int year, int month, int day) {
        this.startDate.setDate(year, month, day);
    }

    /**
     * Modifies the end Date
     *
     * @param endDate end date of availability
     */
    public void setEndDate(Date endDate) {
        this.endDate.setDate(endDate.getYear(), endDate.getMonth(), endDate.getDay());
    }

    /**
     * Modifies the end Date
     *
     * @param year year of end of availability
     * @param month month of end of availability
     * @param day day of end of availability
     */
    public void setEndDate(int year, int month, int day) {
        this.endDate.setDate(year, month, day);
    }

    /**
     * Modifies the start time of availability
     *
     * @param startTime time of start of availability
     */
    public void setStartTime(Time startTime) {
        this.startTime.setTime(startTime.getHours(), startTime.getMinutes());
    }

    /**
     * Modifies the start time of availability
     *
     * @param hour hour of start of availability
     * @param minutes minutes of start of availability
     */
    public void setStartTime(int hour, int minutes) {
        this.startTime.setTime(hour, minutes);
    }

    /**
     * Modifies the end time of availability
     *
     * @param endTime time of end of availability
     */
    public void setEndTime(Time endTime) {
        this.endTime.setTime(endTime.getHours(), endTime.getMinutes());
    }

    /**
     * Modifies the end time of availability
     *
     * @param hour hour of end of availability
     * @param minutes minutes of end of availability
     */
    public void setEndTime(int hour, int minutes) {
        this.endTime.setTime(hour, minutes);
    }
    
    public Availability newAvailability(Date start, Date end, Time startTime, Time endTime) {
        return new Availability(start,end,startTime,endTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Availability other = (Availability) obj;
        return this.startDate.equals(other.startDate)
                && this.endDate.equals(other.endDate)
                && this.startTime.equals(other.startTime)
                && this.endTime.equals(other.endTime);
    }
    
    /**
     * Date(start until end) e schedule(start until end)
     *
     * @return availability characteristics
     */
    @Override
    public String toString() {
        return String.format("Availability from : " + startDate + " until " + endDate + ".\nOn the time: " + startTime.getHours() + ":" + startTime.getMinutes() + " until " + endTime.getHours() + ":" + endTime.getMinutes() + ".");
    }
}
