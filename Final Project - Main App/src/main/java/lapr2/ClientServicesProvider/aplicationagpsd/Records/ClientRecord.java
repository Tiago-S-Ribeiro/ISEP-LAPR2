package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ClientRecord implements Serializable{
    
    private List<Client> clientList;
    
    public ClientRecord(){
        this.clientList = new ArrayList<Client>();
    }
    
    public List<Client> getClientList(){
        return clientList;
    }
    
    /**
     * @param clientList the clientList to set
     */
    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
    
    public void addClient(Client client){
        clientList.add(client);
        System.out.println("Client added with success");
    }
    
    public boolean validatesClient(Client cli){
        ClientRecord cr = Company.getClientRecord();
        for(Client cl : cr.clientList){
            if(cl.getEmail().equalsIgnoreCase(cli.getEmail())  || cl.getPhone().equalsIgnoreCase(cli.getPhone()) || cl.getNIF().equalsIgnoreCase(cli.getNIF())){
                return false;
            }
        }
        return true;
    }
    
    private void registersClient(Client c, String password){
        
    }
    
    public Client newClient(String name, String email, String password, String NIF, String phone, PostalAddress postalAddress){
        return new Client(name, email, password, NIF, phone, postalAddress);
    }
    
    
    public Client getClientByEmail(String email) {
        for (Client cli : clientList) {
            if (cli.getEmail().equalsIgnoreCase(email)) {
                return cli;
            }
        }
        return null;
    }

}
