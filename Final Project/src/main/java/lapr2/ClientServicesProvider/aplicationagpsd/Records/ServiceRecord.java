/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExpansivelService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.FixService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.LimitedService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Service;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

import java.util.ArrayList;
import java.util.List;

/**
 * @author berna
 */
public class ServiceRecord {

    private List<Service> services;

    public ServiceRecord() {
        this.services = new ArrayList<Service>();
    }

    /**
     * @return the services
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Service> getCategoryServices(String catId) {
        List<Service> servList = new ArrayList<Service>();
        for (Service service : services) {
            if (service.getCatID().equalsIgnoreCase(catId)) {
                servList.add(service);
            }
        }
        return servList;
    }

    /**
     * It adds a service to the record of services.
     *
     * @param service
     */
    public void addService(Service service) {
        if (service instanceof FixService) {
            FixService newService = (FixService) service;
            services.add(newService);
        } else if (service instanceof LimitedService) {
            LimitedService newService = (LimitedService) service;
            services.add(newService);
        } else if (service instanceof ExpansivelService) {
            ExpansivelService newService = (ExpansivelService) service;
            services.add(newService);
        }
    }

    public Service newFixService(String catId, String servId, String serviceType, String briefDescription, String completeDescription, Double hourCost, Time estimatedDuration) {
        return new FixService(catId, servId, serviceType, briefDescription, completeDescription, hourCost, estimatedDuration);
    }

    public Service newLimitedService(String catId, String servId, String serviceType, String briefDescription, String completeDescription, Double hourCost) {
        return new LimitedService(catId, servId, serviceType, briefDescription, completeDescription, hourCost);
    }

    public Service newExpansivelService(String catId, String servId, String serviceType, String briefDescription, String completeDescription, Double hourCost) {
        return new ExpansivelService(catId, servId, serviceType, briefDescription, completeDescription, hourCost);
    }

    public Service getServiceById(String idCat, String idServ) {
        for (Service service : services) {
            if (service.getCatID().equalsIgnoreCase(idCat) && service.getServID().equalsIgnoreCase(idServ)) {
                return service;
            }
        }
        return null;
    }

}
