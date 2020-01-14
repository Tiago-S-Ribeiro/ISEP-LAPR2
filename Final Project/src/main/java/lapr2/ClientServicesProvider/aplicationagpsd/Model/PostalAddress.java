package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class PostalAddress implements Serializable{

    /**
     * Address of the Postal Address
     */
    private String address;
    /**
     * Locality of the Postal Address
     */
    private String locality;
    /**
     * PostCode of the Postal Address
     */
    private PostCode postCode;
    /**
     * Address of the Postal Address by omission
     */
    private static final String ADDRESS_BY_OMISSION = "no address";
    /**
     * Locality of the Postal Address by omission
     */
    private static final String LOCALITY_BY_OMISSION = "no locality";
    /**
     * PostCode of the Postal Address by omission
     */
    private static final PostCode POSTCODE_BY_OMISSION = new PostCode();

    /**
     * Builds an instance of PostalAdress that receives address, locality and postcode
     *
     * @param address Address of the Postal Address
     * @param locality Localidade de um determinado Endereço Postal
     * @param postCode PostCode of the Postal Address
     */
    public PostalAddress(String address, String locality, PostCode postCode) {
        if ((address == null) || (locality == null) || (address.isEmpty()) || (locality.isEmpty()) || (postCode == null)) {
            throw new IllegalArgumentException("None of the fields should be empty of null");
        }
        this.setAddress(address);
        this.setLocality(locality);
        this.postCode = new PostCode(postCode);
    }
    
    public PostalAddress(PostCode postCode){
        address = ADDRESS_BY_OMISSION; 
        locality = LOCALITY_BY_OMISSION;
        this.postCode = postCode;
    }
    /**
     * Builds an instance of PostalAddress that is copy of the one passed by parameter
     *
     * @param otherPostalAddress PostalAddress to be copied
     */
    public PostalAddress(PostalAddress otherPostalAddress) {
        this.address = otherPostalAddress.getAddress();
        this.locality = otherPostalAddress.getLocality();
        this.postCode = new PostCode(otherPostalAddress.getPostCode());
    }

    /**
     * Builds an instance of PostalAdress with the omission values
     */
    public PostalAddress() {
        address = ADDRESS_BY_OMISSION;
        locality = LOCALITY_BY_OMISSION;
        postCode = POSTCODE_BY_OMISSION;
    }

    /**
     * Returns the address of the postal address
     *
     * @return address of the postal address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the postal adresse's locality
     *
     * @return postal adresse's locality
     */
    public String getLocality() {
        return locality;
    }

    /**
     * Returns the postal adresse's postcode
     *
     * @return postal adresse's postcode
     */
    public PostCode getPostCode() {
        return new PostCode(postCode);
    }

    /**
     * Changes the address of the postal address
     *
     * @param address address of the postal address
     */
    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("'Address' should not be empty or null.");
        }
        this.address = address;
    }

    /**
     * Changes the postal adresse's locality
     *
     * @param locality postal adresse's locality
     */
    public void setLocality(String locality) {
        if (locality == null || locality.isEmpty()) {
            throw new IllegalArgumentException("'Locality' should not be empty or null.");
        }
        this.locality = locality;
    }
//    /**
//     * Changes the postal adresse's postcode
//     * @param postCode postal adresse's postcode
//     */
//    public void setPostCode(PostCode postCode){
//        if (postCode == null)
//            throw new IllegalArgumentException("O argumento do tipo'CodigoPostal' não deve ser nulo");
//        this.postCode.setCodigoPostal(postCode.getCodPostal(), postCode.getLatitude(), postCode.getLongitude());
//    }
//    /**
//     * Modifica o código-postal do endereço postal
//     * @param codPostal código-postal do endereço postal
//     * @param latitude latitude referente ao código-postal
//     * @param longitude longitude referente ao código-postal
//     */
//    public void setPostCode(String codPostal, String latitude, String longitude){
//        if (codPostal.isEmpty() || codPostal == null) throw new IllegalArgumentException("O argumento 'código postal' não deve estar vazio.");
//        this.codPostal.setCodigoPostal(codPostal, latitude, longitude);
//    }

    /**
     * Compares 2 PostalAdress objects through address, locality and postcode with both objects being considered equal only when these 3 parameteres are the same
     *
     * @param otherObject object to be compared with the object that calls the method
     * @return true, if the references of both objects being compared are pointing at the same object false, if the compared object is null or the class of the objects are different true, if address, locality and postCode of both objects are the same
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        PostalAddress otherPostalAddress = (PostalAddress) otherObject;
        return this.address.equalsIgnoreCase(otherPostalAddress.address)
                && this.locality.equalsIgnoreCase(otherPostalAddress.locality)
                && this.postCode.equals(otherPostalAddress.postCode);
    }
    
    public PostCode newPostCode(String postal1, String postal2) {
        return new PostCode(postal1, postal2);
    }

    /**
     * Returns the characteristics of the Postal Address
     *
     * @return characteristics of the Postal Address
     */
    @Override
    public String toString() {
        return String.format("%s, Locality: %s, PostCode: %s - %s", address, locality, this.postCode.getPostalCode1(), this.postCode.getPostalCode2());
    }    
}
