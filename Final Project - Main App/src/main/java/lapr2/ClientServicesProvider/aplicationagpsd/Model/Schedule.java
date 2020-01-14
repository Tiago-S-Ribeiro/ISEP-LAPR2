package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import java.util.Objects;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

/**
 *
 * @author berna
 */
public class Schedule implements Serializable{
    
    private int order;
    
    private Date day;
    
    private Time beginingHour;
    
    private static final int ORDER_BY_OMISSION = -1;
    
    private static final Date DAY_BY_OMISSION = new Date();
    
    private static final Time BEGINING_HOUR_BY_OMISSION = new Time();
    
    public Schedule(int order, Date day, Time beginingHour){
        this.setOrder(order);
        this.setDay(day);
        this.setBeginingHour(beginingHour);
    }
    
    public Schedule(Schedule schedule){
        this.setOrder(schedule.order);
        this.setDay(schedule.day);
        this.setBeginingHour(schedule.beginingHour);
    }
    
    public Schedule(){
        order = ORDER_BY_OMISSION;
        day = DAY_BY_OMISSION;
        beginingHour = BEGINING_HOUR_BY_OMISSION;
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @return the day
     */
    public Date getDay() {
        return day;
    }
    
    /**
     * @return the beginingHour
     */
    public Time getBeginingHour() {
        return beginingHour;
    }
    
    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * @param day the day to set
     */
    public void setDay(Date day) {
        this.day = new Date(day);
    }

    /**
     * @param beginingHour the beginingHour to set
     */
    public void setBeginingHour(Time beginingHour) {
        this.beginingHour = new Time(beginingHour);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Schedule other = (Schedule) obj;
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        if (!Objects.equals(this.beginingHour, other.beginingHour)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order=" + order + ", day=" + day + ", beginingHour=" + beginingHour + ".";
    }
    
    
    
}
