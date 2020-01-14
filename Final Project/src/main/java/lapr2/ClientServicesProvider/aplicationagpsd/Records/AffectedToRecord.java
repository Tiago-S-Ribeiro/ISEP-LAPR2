package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.AffectedTo;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.RequestedServiceDescription;

/**
 *
 * @author berna
 */
public class AffectedToRecord implements Serializable{
    
    private List<AffectedTo> affectationsList;
    
    public AffectedToRecord(){
        this.affectationsList = new ArrayList<AffectedTo>();
    }

    /**
     * @return the affectationsList
     */
    public List<AffectedTo> getAffectationsList() {
        return affectationsList;
    }

    /**
     * @param affectationsList the affectationsList to set
     */
    public void setAffectationsList(List<AffectedTo> affectationsList) {
        this.affectationsList = affectationsList;
    }
    
    public AffectedTo getAffectionByDescription(RequestedServiceDescription description){
        for(AffectedTo at : affectationsList){
            if(at.getRequestedservicedescription().equals(description)){
                return at;
            }
        }
        return null;
    }
    
    public List<AffectedTo> getlistAffectionsOfAnOrder(List<RequestedServiceDescription> lstDescriptions){
        List<AffectedTo> lstAffectionsByOrder =  new ArrayList<>();
        int index = 0;
        for(RequestedServiceDescription rsd : lstDescriptions){
            if(affectationsList.get(index).getRequestedservicedescription().equals(rsd)){
                lstAffectionsByOrder.add(getAffectionByDescription(rsd));
            }
            index++;
        }
        return lstAffectionsByOrder;
    }
}
