package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Availability;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ServiceProviderRecord implements Serializable {

    /**
     * List of service providers in the record
     */
    private List<ServiceProvider> serviceProvidersList;

    /**
     * Builds an instance of service provider record with an empty list
     */
    public ServiceProviderRecord() {
        this.serviceProvidersList = new ArrayList<ServiceProvider>();
    }

    public List<ServiceProvider> getServiceProvidersList() {
        return serviceProvidersList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProvidersList = serviceProviderList;
    }

    /**
     * Adds a service provider to the company's record of service providers
     *
     * @param sp service provider to be added
     */
    public void addServiceProvider(ServiceProvider sp) {
        serviceProvidersList.add(sp);
        System.out.println("Service Provider added with success.");
    }

    /**
     * Validates the service provider by confirming its existence in the record
     *
     * @param sp service provider to be validated
     */
    private void validateServiceProvider(ServiceProvider sp) {
        ServiceProviderRecord spr = Company.getServiceProviderRecord();
        for (ServiceProvider servP : spr.serviceProvidersList) {
            if (sp.equals(servP)) {
                throw new IllegalArgumentException("Client already exists.");
            }
        }
    }

    /**
     * @param sp service provider to be registered
     * @param password his password
     */
    public void registServiceProvider(ServiceProvider sp) {
        validateServiceProvider(sp);
        serviceProvidersList.add(sp);
        System.out.println("Service Provider registered with success.");
    }

    /**
     *
     * @param fullName
     * @param password
     * @param institucionalEmail
     * @param abreviatedName
     * @param companyNr
     * @return
     */
    public ServiceProvider newServiceProvider(String fullName, String password, String institucionalEmail, String abreviatedName, String companyNr, PostalAddress postalAddress) {
        return new ServiceProvider(fullName, password, institucionalEmail, abreviatedName, companyNr, postalAddress);
    }

    public Availability newAvailability(Date startDate, Date endDate, Time startTime, Time endTime) {
        return new Availability(startDate, endDate, startTime, endTime);
    }

    /**
     * @param email e-mail of the service provider
     * @return the service provider by his e-mail
     */
    public ServiceProvider getServiceProviderByEmail(String email) {
        for (ServiceProvider sp : serviceProvidersList) {
            if (sp.getEmail().equalsIgnoreCase(email)) {
                return sp;
            }
        }
        return null;
    }
}
