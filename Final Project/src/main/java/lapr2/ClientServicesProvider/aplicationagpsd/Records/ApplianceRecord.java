package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Appliance;

/**
 * Class that allows to create a list of candidatures to service provider.
 *
 * @author Rafael Moreira 1180778.
 */
public class ApplianceRecord implements Serializable{

    /**
     * List of candidatures to service providers.
     */
    private List<Appliance> listOfAppliances;

    /**
     * Allows to create a new list for the record of candidatures.
     */
    public ApplianceRecord() {
        this.listOfAppliances = new ArrayList<Appliance>();
    }

    /**
     * Gets the list with all the candidatures for service providers.
     *
     * @return the desired list.
     */
    public List<Appliance> getListOfAppliances() {
        return listOfAppliances;
    }
    
    /**
     * @param listOfAppliances the appliances to set
     */
    public void setAppliances(List<Appliance> listOfAppliances) {
        this.listOfAppliances = listOfAppliances;
    }

    /**
     * Has the responsability to create a candidature with all the parameters.
     *
     * @param name name of the service provider.
     * @param nif NIF of the service provider.
     * @param phone phone of the service provider.
     * @param email email of the service provider.
     * @return the candidature created.
     */
    public Appliance newAppliance(String name, String nif, String phone, String email) {
        return new Appliance(name, nif, phone, email);
    }

    /**
     * Adds a candidature to the list of the record.
     *
     * @param appliance candidature to be added.
     */
    public void add(Appliance appliance) {
        this.listOfAppliances.add(appliance);
    }
    
    public Appliance getApplianceByNif(String nif){
        for (Appliance appliance : listOfAppliances) {
            if(appliance.getNif().equals(nif)){
                return appliance;
            }
        }
        throw new IllegalArgumentException("Candidature with that nif does not exist");
    }
     
    public void ApplianceIsValid(Appliance appliance){
        if(!appliance.getStatus().equalsIgnoreCase("ACCEPTED")){
            throw new IllegalArgumentException("Service Provider has been already registered");
        }
    }
}
