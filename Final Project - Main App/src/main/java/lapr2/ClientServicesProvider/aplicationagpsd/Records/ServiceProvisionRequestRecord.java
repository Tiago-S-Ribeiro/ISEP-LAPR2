package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvisionRequest;

/**
 *
 * @author berna
 */
public class ServiceProvisionRequestRecord implements Serializable{
    
    private List<ServiceProvisionRequest> servProvReqList;
    
    public ServiceProvisionRequestRecord(){
        this.servProvReqList = new ArrayList<ServiceProvisionRequest>();
    }

    /**
     * @return the servProvReqList
     */
    public List<ServiceProvisionRequest> getServProvReqList() {
        return servProvReqList;
    }

    /**
     * @param servProvReqList the servProvReqList to set
     */
    public void setServProvReqList(List<ServiceProvisionRequest> servProvReqList) {
        this.servProvReqList = servProvReqList;
    }
    
    public ServiceProvisionRequest newRequest(Client cli, PostalAddress pAdd){
        return new ServiceProvisionRequest(cli, pAdd);
    }
    
    public boolean validateRequest(ServiceProvisionRequest spr){
        double cost = spr.calculateCost();
        spr.setTotalCost(cost);
        for(ServiceProvisionRequest spreq : servProvReqList){
            if(spr.equals(spreq)){
                return false;
            }
        }
        return true;
    }
    
    public int registerRequest(ServiceProvisionRequest spreq){
        int requestNumber = generateRequestNumber();
        spreq.setRequestNumber(requestNumber);
        addRequest(spreq);
        return requestNumber;
    }
    
    public int generateRequestNumber(){
        return this.servProvReqList.size();
    }
    
    public boolean addRequest(ServiceProvisionRequest spreq){
        return this.servProvReqList.add(new ServiceProvisionRequest(spreq));
    }
    
    public List<ServiceProvisionRequest> getServiceProvisionsListByClient(Client cli) {
        List<ServiceProvisionRequest> lstSpr = new ArrayList<ServiceProvisionRequest>();
        for(ServiceProvisionRequest spr : this.servProvReqList){
            if(spr.getClient().getNIF().equals(cli.getNIF())){
                lstSpr.add(spr);
            }
        }
        return lstSpr;
    }
    
    public ServiceProvisionRequest getServiceProvisionByNumberRequest(String reqNumber) {
        for(ServiceProvisionRequest spr : this.servProvReqList){
            if(spr.getRequestNumber() == Integer.parseInt(reqNumber)){
                return spr;
            }
        }
        return new ServiceProvisionRequest();
    }

    
}
