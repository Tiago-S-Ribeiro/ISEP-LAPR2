package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

/**
 * SuperClass that allows to create a complete service.
 *
 * @author Rafael Moreira
 * @author Bernardo
 */
public class Service implements Serializable{
    /**
     * Category Id
     */
    private String catID;
    /**
     * Service Id
     */
    private String servID;
    /**
     * Service Type
     */
    private String serviceType;
    /**
     * Description of the service
     */
    private String briefDescription;
    /**
     * The complete description of the service.
     */
    private String completeDescription;
    /**
     * Service cost per hour
     */
    private double hourCost;
    /**
     * Service Id by omission
     */
    private static final String OMISSION_CATEGORY_ID = "no Id";
    /**
     * Service Id by omission
     */
    private static final String OMISSION_SERVICE_ID = "no Id";
    /**
     * Service type by omission
     */
    private static final String OMISSION_SERVICE_TYPE = "no type";
    /**
     * Service brief description by omission
     */
    private static final String OMISSION_SERVICE_BRIEFDESCRIPTION = "no brief description";
    /**
     * Service complete description by omission
     */
    private static final String OMISSION_SERVICE_COMPLETEDESCRIPTION = "no complete description";
    /**
     * Service cost per hour by omission
     */
    private static final double OMISSION_COST = 0;

    /**
     * Creates an instance of Service that receives Id, service type, description and cost per hour
     *
     * @param catID               Category Id
     * @param servID              Service Id
     * @param serviceType         Service type
     * @param briefDescription    brief description
     * @param completeDescription complete description
     * @param hourCost            Service cost per hour
     */
    public Service(String catID, String servID, String serviceType, String briefDescription, String completeDescription, double hourCost) {
        this.setCatID(catID);
        this.setServID(servID);
        this.setServiceType(serviceType);
        this.setBriefDescription(briefDescription);
        this.setCompleteDescription(completeDescription);
        this.setHourCost(hourCost);
    }

    /**
     * Creates an instance of Service that receives Id, service type, briefDescription and cost per hour
     *
     * @param servID           Service Id
     * @param serviceType      Service type
     * @param briefDescription Service briefDescription
     * @param hourCost         Service cost per hour
     */
    public Service(String servID, String serviceType, String briefDescription, String completeDescription, double hourCost) {
        this.setServID(servID);
        this.setServiceType(serviceType);
        this.setBriefDescription(briefDescription);
        this.setCompleteDescription(completeDescription);
        this.setHourCost(hourCost);
    }

    /**
     * Creates an instance of Service that is a copy of other Service
     *
     * @param service service being copied.
     */
    public Service(Service service) {
        this.catID = service.catID;
        this.servID = service.servID;
        this.serviceType = service.serviceType;
        this.briefDescription = service.briefDescription;
        this.completeDescription = service.completeDescription;
        this.hourCost = service.hourCost;
    }

    /**
     * Creates an instance of Service with the omiision values
     */
    public Service() {
        catID = OMISSION_CATEGORY_ID;
        servID = OMISSION_SERVICE_ID;
        serviceType = OMISSION_SERVICE_TYPE;
        briefDescription = OMISSION_SERVICE_BRIEFDESCRIPTION;
        completeDescription = OMISSION_SERVICE_COMPLETEDESCRIPTION;
        hourCost = OMISSION_COST;
    }

    /**
     * Returns a catgory id
     * Used to confirm the services of a certain category
     *
     * @return Category Id
     */
    public String getCatID() {
        return catID;
    }

    /**
     * @return service id
     */
    public String getServID() {
        return servID;
    }

    /**
     * @return service type
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @return service brief description
     */
    public String getBriefDescription() {
        return briefDescription;
    }

    /**
     * @return service complete description
     */
    public String getCompleteDescription() {
        return completeDescription;
    }

    /**
     * @return cost per hour of the service
     */
    public double getHourCost() {
        return hourCost;
    }

    /**
     * @param catID the catID to set
     */
    public void setCatID(String catID) {
        this.catID = catID;
    }

    /**
     * Modifica o ID único do serviço
     *
     * @param servID ID único do serviço
     */
    public void setServID(String servID) {
        if (servID == null || servID.isEmpty())
            throw new IllegalArgumentException("O argumento 'ID de serviço' não deve estar vazio ou ser nulo.");
        this.servID = servID;
    }

    /**
     * Changes the service type
     *
     * @param serviceType service type
     */
    public void setServiceType(String serviceType) {
        if (serviceType == null || serviceType.isEmpty())
            throw new IllegalArgumentException("The argument 'service type' shouldn't be empty or null.");
        this.serviceType = serviceType;
    }

    /**
     * Changes the service brief description
     *
     * @param briefDescription service description
     */
    public void setBriefDescription(String briefDescription) {
        if (briefDescription == null || briefDescription.isEmpty())
            throw new IllegalArgumentException("The argument 'brief description' shouldn't be empty or null.");
        this.briefDescription = briefDescription;
    }

    /**
     * Changes the service complete description
     *
     * @param completeDescription service description
     */
    public void setCompleteDescription(String completeDescription) {
        if (completeDescription == null || completeDescription.isEmpty())
            throw new IllegalArgumentException("The argument 'complete description' shouldn't be empty or null.");
        this.completeDescription = completeDescription;
    }

    /**
     * Changes the service cost per hour
     *
     * @param hourCost service cost per hour
     */
    public void setHourCost(double hourCost) {
        if (hourCost == 0)
            throw new IllegalArgumentException("The argument 'cost per hour' shouldn't be empty or null.");
        this.hourCost = hourCost;
    }

    /**
     * Compares two service objects by their id
     * The two are only considered equal when this characteristic is equal
     *
     * @param otherObject object to be compared to the object that calls the method
     * @return true, if the references of the objects to be compared point to the same object
     * false, if the compared object is null or the classes of the two objects are different
     * true, if the ID of the two objects are equal
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Service otherService = (Service) otherObject;

        return this.catID.equalsIgnoreCase(otherService.catID)
                && this.servID.equalsIgnoreCase(otherService.servID)
                && this.serviceType.equalsIgnoreCase(otherService.serviceType);
    }

    /**
     * @return característics of Service (service type and cost per hour)
     */
    @Override
    public String toString() {
        return String.format("Service: %s\nCost per hour: %.2f", serviceType, hourCost);
    }

    public double getDurationCost(Time duration) {
        return (duration.getHours() + (duration.getMinutes() / 60)) * this.getHourCost();
    }
}