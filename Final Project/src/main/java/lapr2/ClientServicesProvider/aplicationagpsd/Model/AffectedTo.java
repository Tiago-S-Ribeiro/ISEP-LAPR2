package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;

/**
 * @author berna
 */
public class AffectedTo implements Serializable{

    private ServiceProvider serviceProvider;

    private RequestedServiceDescription requestedservicedescription;

    private Schedule schedule;

    private PostalAddress postalAddress;

    private static final ServiceProvider SERVICE_PROVIDER_BY_OMISSION = new ServiceProvider();

    private static final RequestedServiceDescription REQUESTED_SERVICE_DESCRIPTION_BY_OMISSION = new RequestedServiceDescription();

    private static final Schedule SCHEDULE_BY_OMISSION = new Schedule();

    private static final PostalAddress POSTAL_ADDRESS_BY_OMISSION = new PostalAddress();

    public AffectedTo(ServiceProvider serviceProvider, RequestedServiceDescription requestedservicedescription, Schedule schedule, PostalAddress postalAddress) {
        this.serviceProvider = serviceProvider;
        this.requestedservicedescription = requestedservicedescription;
        this.schedule = schedule;
        this.postalAddress = postalAddress;
    }

    public AffectedTo() {
        serviceProvider = SERVICE_PROVIDER_BY_OMISSION;
        requestedservicedescription = REQUESTED_SERVICE_DESCRIPTION_BY_OMISSION;
        schedule = SCHEDULE_BY_OMISSION;
        postalAddress = POSTAL_ADDRESS_BY_OMISSION;
    }

    /**
     * @return the serviceprovider
     */
    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    /**
     * @return the requestedservicedescription
     */
    public RequestedServiceDescription getRequestedservicedescription() {
        return requestedservicedescription;
    }

    /**
     * @return the schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * @return the postalAddress
     */
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param serviceProvider the serviceprovider to set
     */
    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    /**
     * @param requestedservicedescription the requestedservicedescription to set
     */
    public void setRequestedservicedescription(RequestedServiceDescription requestedservicedescription) {
        this.requestedservicedescription = requestedservicedescription;
    }

    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * @param postalAddress the postalAddress to set
     */
    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Override
    public String toString() {
        return "AffectedTo{" + "serviceProvider=" + serviceProvider.toString() + ", requestedservicedescription=" + requestedservicedescription.toString() + ", schedule=" + schedule.toString() + ", postalAddress=" + postalAddress.toString() + '}';
    }

}
