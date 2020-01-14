package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import java.util.Objects;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

/**
 *
 * @author berna
 */
public class RequestedServiceDescription implements Serializable{
    
    private Service service;
    
    private String description;
    
    private Time duration;
    
    private static final Service SERVICE_BY_OMISSION = new Service();
    
    private static final String DESCRIPTION_BY_OMISSION = "no description";
    
    private static final Time DURATION_BY_OMISSION = new Time();
    
    /**
     * Contructor with all atributes
     * @param service
     * @param description
     * @param duration 
     */
    public RequestedServiceDescription(Service service, String description, Time duration){
        this.setService(service);
        this.setDescription(description);
        this.setDuration(duration);
    }
    
    /**
     * Contructor copy with all atributes
     * @param rsd
     */
    public RequestedServiceDescription(RequestedServiceDescription rsd){
        this.setService(rsd.service);
        this.setDescription(rsd.description);
        this.setDuration(rsd.duration);
    }
    
    /**
     * Contructor with all atributes by omission
     */
    public RequestedServiceDescription(){
        service = SERVICE_BY_OMISSION;
        description = DESCRIPTION_BY_OMISSION;
        duration = DURATION_BY_OMISSION;
    }

    /**
     * @return the service
     */
    public Service getService() {
        return service;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the duration
     */
    public Time getDuration() {
        return duration;
    }
    
    /**
     * @param service the service to set
     */
    public void setService(Service service) {
        this.service = new Service(service);
    }
    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        if(description == null || description.isEmpty()){
            throw new IllegalArgumentException("Description is empty!");
        }
        this.description = description;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Time duration) {
        this.duration = new Time(duration);
    }
    
    /**
     * @return característics of RequestedServiceDescription (description)
     */
    @Override
    public String toString(){
        return String.format("Requested service description: %s", description);
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
        final RequestedServiceDescription other = (RequestedServiceDescription) obj;
        
        if(this.service.getClass() == other.service.getClass()){
            if(other.service.getClass().equals(FixService.class)){
                FixService serv = (FixService) other.service;
                FixService tServ = (FixService) this.service;
            }
            else if(other.service.getClass().equals(LimitedService.class)){
                LimitedService serv = (LimitedService) other.service;
                LimitedService tServ = (LimitedService) this.service;
            }
            else if(other.service.getClass().equals(ExpansivelService.class)){
                ExpansivelService serv = (ExpansivelService) other.service;
                ExpansivelService tServ = (ExpansivelService) this.service;
            }
            return this.description.equalsIgnoreCase(other.description) &&
                this.service.equals(other.service) &&
                this.duration.equals(other.duration);
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.service);
        hash = 71 * hash + Objects.hashCode(this.description);
        hash = 71 * hash + Objects.hashCode(this.duration);
        return hash;
    }
    
    public double getCost(){
        return this.service.getDurationCost(this.duration);
    }
    
}
