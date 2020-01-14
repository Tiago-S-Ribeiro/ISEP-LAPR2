/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.AffectedTo;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Availability;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.GeographicArea;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.RequestedServiceDescription;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Schedule;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvisionRequest;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.AffectedToRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProviderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProvisionRequestRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

/**
 *
 * @author berna
 */
public class TaskAlgorithm {
    
    public class NotAffectedDescription{
        
        private ServiceProvisionRequest spr;
        
        private RequestedServiceDescription rsd;
        
        public NotAffectedDescription(ServiceProvisionRequest spr, RequestedServiceDescription rsd){
            this.spr = spr;
            this.rsd = rsd;
        }

        /**
         * @return the spr
         */
        public ServiceProvisionRequest getSpr() {
            return spr;
        }

        /**
         * @return the rsd
         */
        public RequestedServiceDescription getRsd() {
            return rsd;
        }
    }
    
    public void fcfs(){
        GeographicAreaRecord gar = Company.getGeographicAreasRecord();
        ServiceProvisionRequestRecord sprr = Company.getRequestRecord();
        ServiceProviderRecord spr = Company.getServiceProviderRecord();
        AffectedToRecord ar = Company.getAffectedToRecord();
        if(!sprr.getServProvReqList().isEmpty() && sprr.getServProvReqList() != null 
                && !spr.getServiceProvidersList().isEmpty() && spr.getServiceProvidersList() != null){
        List<NotAffectedDescription> notAffectedDescriptions = getNotAffectedDescFCFS();
        List<NotAffectedDescription> descsToRemove = new ArrayList<NotAffectedDescription>();
        if(!(notAffectedDescriptions.isEmpty() || notAffectedDescriptions == null)){
            for (NotAffectedDescription notAffectedDescription : notAffectedDescriptions) {
                //System.out.println("Pedido: "+notAffectedDescription.getSpr().getRequestNumber()+", Serviço: "+notAffectedDescription.getRsd().getDescription());
                for(AffectedTo affection : ar.getAffectationsList()){
                    if(affection.getRequestedservicedescription().equals(notAffectedDescription.getRsd())){
                        descsToRemove.add(notAffectedDescription);
                    }
                }
            }
        }
        notAffectedDescriptions.removeAll(descsToRemove);
        List<ServiceProvider> spsToRemove = new ArrayList<ServiceProvider>();
        List<ServiceProvider> sps = new ArrayList(spr.getServiceProvidersList());
            if(!notAffectedDescriptions.isEmpty()){
                
                for(NotAffectedDescription notAffectedDescription : notAffectedDescriptions){
                        GeographicArea ga = gar.getGeographicAreaByPostCode(notAffectedDescription.getSpr().getpAdd().getPostCode().getPostalCode1(), notAffectedDescription.getSpr().getpAdd().getPostCode().getPostalCode2());
                        Category cat = Company.getCategoryRecord().getCategoryById(notAffectedDescription.getRsd().getService().getCatID());
                        for (ServiceProvider serviceProvider : spr.getServiceProvidersList()) {
                            if(!serviceProvider.getGeographicAreasList().contains(ga)){
                                spsToRemove.add(serviceProvider);
                            }
                            if(!serviceProvider.getCategoriesList().contains(cat)){
                                spsToRemove.add(serviceProvider);
                            }
                        }
                        sps.removeAll(spsToRemove);
                        if(!sps.isEmpty()){
                            List<AffectedTo> possibleAffectations = new ArrayList<AffectedTo>();
                            for(ServiceProvider sp : sps){
                                AffectedTo af = scheduleCompatibility(sp, notAffectedDescription);
                                if(af != null){
                                    possibleAffectations.add(af);
                                }
                            }
                            if(possibleAffectations != null || possibleAffectations.isEmpty()){
                                Random rand = new Random();
    //                            AffectedTo affectation = new AffectedTo(sps.get(rand.nextInt(sps.size())), notAffectedDescription.getRsd(), notAffectedDescription.getSpr().getSchedulesList().get(rand.nextInt(notAffectedDescription.getSpr().getSchedulesList().size())), notAffectedDescription.getSpr().getpAdd());
                                if(!ar.getAffectationsList().contains(possibleAffectations.get(rand.nextInt(possibleAffectations.size())))){
                                    ar.getAffectationsList().add(possibleAffectations.get(rand.nextInt(possibleAffectations.size())));
                                }
                            }
                        }
                }
            }
        }
    }
    
    public List<NotAffectedDescription> getNotAffectedDescFCFS() {
        ServiceProvisionRequestRecord sprr = Company.getRequestRecord();
        AffectedToRecord ar = Company.getAffectedToRecord();
        List<NotAffectedDescription> descriptionsList = new ArrayList<NotAffectedDescription>();
                    for(ServiceProvisionRequest servProvReq : sprr.getServProvReqList()){
                        for (RequestedServiceDescription description : servProvReq.getRequestedServicesDecriptionList()) {
                            descriptionsList.add(new NotAffectedDescription(servProvReq, description));
                        }
                    }
        return descriptionsList;
    }
    
    public AffectedTo scheduleCompatibility(ServiceProvider sp, NotAffectedDescription description){
        
        List<AffectedTo> affectations = new ArrayList<AffectedTo>();
        Time time = new Time();
        for (Schedule schedulePref : description.getSpr().getSchedulesList()) {
            for (Availability availability : sp.getAvailabilitiesList()) {
                if(!(schedulePref.getDay().isGreater(availability.getStartDate()) && schedulePref.getDay().isGreater(availability.getEndDate())) && !(!schedulePref.getDay().isGreater(availability.getStartDate()) && !schedulePref.getDay().isGreater(availability.getEndDate()))){
                    Time finalHour = time.obtainFinalTime(schedulePref.getBeginingHour(), description.getRsd().getDuration());
                    if((schedulePref.getBeginingHour().equals(availability.getStartTime()) || schedulePref.getBeginingHour().isGreater(availability.getStartTime())) && (finalHour.equals(availability.getEndTime()) || !finalHour.isGreater(availability.getEndTime()))){
                        affectations.add(new AffectedTo(sp, description.getRsd(), schedulePref, description.getSpr().getpAdd()));
                    }
                }
            }
        }
        
        List<AffectedTo> afsToRemove = new ArrayList<AffectedTo>();
        for (AffectedTo af : affectations) {
            for (AffectedTo affectedTo : Company.getAffectedToRecord().getAffectationsList()) {
                if(af.getSchedule().equals(affectedTo.getSchedule()) && af.getServiceProvider().equals(affectedTo.getServiceProvider())){
                    afsToRemove.add(af);
                }
            }
        }
        affectations.removeAll(afsToRemove);
        
        if(affectations.isEmpty()){
            return null;
        }
        else{
            return affectations.get(0);
        }
    }
    
    public void affectSPToServiceRequest(List<AffectedTo> affectations){
        ServiceProvider spWithGraterRating = affectations.get(0).getServiceProvider();
        for (AffectedTo affectation : affectations) {
            if(affectation.getServiceProvider().getRatingsMean() > spWithGraterRating.getRatingsMean()){
                spWithGraterRating = affectation.getServiceProvider();
            }
        }
        
        for (AffectedTo affectation : affectations) {
            if(affectation.getServiceProvider().getRatingsMean() < spWithGraterRating.getRatingsMean()){
                affectations.remove(affectation);
            }
        }
        
        List<String> spNameList = new ArrayList<String>();
        if(affectations.size() > 1){
            double minorDistance = calculateDistance(affectations.get(0).getServiceProvider().getPostalAddress().getPostCode().getLatitude(),
                    affectations.get(0).getServiceProvider().getPostalAddress().getPostCode().getLongitude(),
                    affectations.get(0).getPostalAddress().getPostCode().getLatitude(),
                    affectations.get(0).getPostalAddress().getPostCode().getLongitude());
            for (AffectedTo affectation : affectations) {
                double distance = calculateDistance(affectation.getServiceProvider().getPostalAddress().getPostCode().getLatitude(),
                    affectation.getServiceProvider().getPostalAddress().getPostCode().getLongitude(),
                    affectation.getPostalAddress().getPostCode().getLatitude(),
                    affectation.getPostalAddress().getPostCode().getLongitude());
                if(distance < minorDistance){
                    minorDistance = distance;
                }
            }
            for (AffectedTo affectation : affectations) {
                double distance = calculateDistance(affectation.getServiceProvider().getPostalAddress().getPostCode().getLatitude(),
                    affectation.getServiceProvider().getPostalAddress().getPostCode().getLongitude(),
                    affectation.getPostalAddress().getPostCode().getLatitude(),
                    affectation.getPostalAddress().getPostCode().getLongitude());
                if(distance > minorDistance){
                    affectations.remove(affectation);
                }
            }
            
            if(affectations.size() > 1){
                for (AffectedTo affectation : affectations) {
                    spNameList.add(affectation.getServiceProvider().getFullName());
                }
                spNameList.sort(String::compareToIgnoreCase);
                for (AffectedTo affectation : affectations) {
                    if(!affectation.getServiceProvider().getFullName().equals(spNameList.get(0))){
                        affectations.remove(affectation);
                        if(affectations.size() > 1){
                            Random rand = new Random();
                            Company.getAffectedToRecord().getAffectationsList().add(affectations.get(rand.nextInt(affectations.size())));
                        }
                        else{
                            if(affectations.size() == 1){
                            Company.getAffectedToRecord().getAffectationsList().add(affectations.get(0));
                            }
                        }
                    }
                }
            }
            else{
                if(affectations.size() == 1){
                Company.getAffectedToRecord().getAffectationsList().add(affectations.get(0));
                }
            }
        }
        else{
            if(affectations.size() == 1){
            Company.getAffectedToRecord().getAffectationsList().add(affectations.get(0));
            }
        }
    }
    
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371e3;
        double x = lat2 - lat1;
        double y = lon2 - lon1;
        double theta1 = Math.toRadians(lat1);
        double theta2 = Math.toRadians(lat2);
        double deltaTheta = Math.toRadians(x);
        double deltaLambda = Math.toRadians(y);
        double a = Math.sin(deltaTheta / 2) * Math.sin(deltaTheta / 2)
                + Math.cos(theta1) * Math.cos(theta2)
                * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;
        return d;
    }
    
}
