package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isNIFValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isNameValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isPhoneValid;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class Client extends User implements Serializable{
    /**
     * Client's name
     */
    private String name;
    /**
     * Client's NIF
     */
    private String NIF;
    /**
     * Client's phone number
     */
    private String phone;
    /**
     * List that will store the Client's addresses
     */
    private List<PostalAddress> addressList = new ArrayList<PostalAddress>();
    /**
     * Client's name by omission
     */
    private static final String NAME_BY_OMISSION = "no name";
    /**
     * Client's NIF by omission
     */
    private static final String NIF_BY_OMISSION = "no fiscal number";
    /**
     * Client's phone number by omission
     */
    private static final String PHONE_BY_OMISSION = "no phone number";
    /**
     * Builds an instance of Client that receives name, email, password, NIF, phone, postalAddress
     * @param name Client's name
     * @param email Client's e-mail
     * @param password Client's password
     * @param NIF Client's NIF
     * @param phone Client's phone number
     * @param postalAddress Client's postal address
     */
    public Client(String name, String email, String password, String NIF, String phone, PostalAddress postalAddress){
        super(email, password, "CLIENT");
        this.name = name;
        this.NIF = NIF;
        this.phone = phone;
        addressList.add(postalAddress);
    }
    
    /**
     * Builds an instance of Client that is copy of another passed by parameter
     * @param otherClient Client to be 'copied'
     */
    public Client(Client otherClient){
        super(otherClient);
        this.name = otherClient.name;
        this.NIF = otherClient.NIF;
        this.phone = otherClient.phone;
        this.addressList = otherClient.addressList;
    }
    
    /**
     * Builds an instance of Client with omission values
     */
    public Client(){
        super();
        name = NAME_BY_OMISSION;
        NIF = NIF_BY_OMISSION;
        phone = PHONE_BY_OMISSION;
    }
    /**
     * Returns the Client's name
     * @return Client's name
     */
    public String getName(){
        return name;
    }
    /**
     * Returns the Client's NIF
     * @return Client's NIF
     */
    public String getNIF(){
        return NIF;
    }
    
    /**
     * Returns the Client's phone number
     * @return Client's phone number
     */
    public String getPhone(){
        return phone;
    }
    
    /**
     * Returns the Client's address list
     * @return Client's address list
     */
    public List<PostalAddress> getAddressList(){
        return addressList;
    }
    /**
     * Changes the Client's name
     * @param name Client's name
     */
    public void setName(String name){
       if(name == null || name.isEmpty() || isNameValid(name) == false)
            throw new IllegalArgumentException("'Name' should not be empty or null.");
        this.name = name; 
    }
    /**
     * Changes the Client's NIF
     * @param NIF Client's NIF
     */
    public void setNIF(String NIF){
        if(NIF == null || NIF.isEmpty() || isNIFValid(NIF) == false)
            throw new IllegalArgumentException("'NIF' should not be empty or null.");
        this.NIF = NIF;
    }
    
    /**
     * Changes the Client's phone number
     * @param phone Client's phone number
     */
    public void setPhone(String phone){
        if(phone == null || phone.isEmpty() || isPhoneValid(phone) == false)
            throw new IllegalArgumentException("'Phone' should not be empty or null.");
        this.phone = phone;
    }
    
    /**
     * Changes the Client's address list
     * @param addressList Client's address list
     */
    public void setAddressList(List<PostalAddress> addressList){
        if(addressList == null || addressList.isEmpty())
            throw new IllegalArgumentException("'Address list' should not be empty or null.");
        this.addressList = addressList;
    }
    
    public PostalAddress getPostalAddress(String add, String local, String postalCod1, String postalCod2){
        for(PostalAddress address : addressList){
            if(address.getAddress().equalsIgnoreCase(add) && address.getLocality().equalsIgnoreCase(local)
                    && address.getPostCode().getPostalCode1().equalsIgnoreCase(postalCod1)
                    && address.getPostCode().getPostalCode2().equalsIgnoreCase(postalCod2)){
                return address;
            }
        }
        return null;
    }
    
    public PostalAddress newPostalAddress(String address, String locality, PostCode pc){
        if(address == null || address.isEmpty() || locality == null || locality.isEmpty())
            throw new IllegalArgumentException("'Postal Adress fields ' should not be null or empty.");
        PostalAddress pa = new PostalAddress(address, locality, pc);
        return pa;
    }
    
    public void addPostalAddress(Client cli, PostalAddress pa){
        cli.getAddressList().add(pa);
    }
    
    /**
     * Compares to Client objects through name, NIF, phone number and password
     * with both objects being equal only when this 4 parameters are exactly the same.
     * @param otherObject object that will be compared with the object that calls this method
     * @return true, if the references of the objects being compared are pointing at the same object
     *         false, if the object being compared is null or the object's classes are different
     *         true, if both objects name, NIF, phone number and password are the same
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        Client otherClient = (Client) otherObject;
            return this.NIF.equalsIgnoreCase(otherClient.NIF)
                && this.name.equalsIgnoreCase(otherClient.name)
                && this.getPassword().equalsIgnoreCase(otherClient.getPassword())
                && this.phone.equalsIgnoreCase(otherClient.phone);
    }    
    
    /**
     * Returns the Client's characteristics (name, email, NIF, phone number)
     * @return Client's characteristics
     */
    @Override
    public String toString(){
        return String.format("Client: %s , E-mail: %s \nNIF nº %s\nPhone Number: %s", this.name, this.getEmail(), NIF, phone);
    }
}
