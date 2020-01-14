package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that contains information about a candidature to Service Provider.
 *
 * @author Rafael Moreira 1180778
 */
public class Appliance implements Serializable{

    /**
     * Name of the Servive Provider.
     */
    private String name;

    /**
     * Email of the Service Provider;
     */
    private String email;

    /**
     * NIF of the Service Provider.
     */
    private String nif;

    /**
     * Telephone of the Service Provider.
     */
    private String phone;

    /**
     * The status of the appliance.
     * We don't have a way to confirm if the appliance was rejected or not (not a Use Case).
     */
    private String status;

    /**
     * List of Academic Qualfications of the Service Provider.
     */
    private ArrayList<AcademicQualification> academicQualificationList = new ArrayList<AcademicQualification>();

    /**
     * List of Professional Qualfication of the Service Provider.
     */
    private ArrayList<ProfessionalQualification> professionalQualificationList = new ArrayList<ProfessionalQualification>();

    /**
     * List of Categories in wich the Service Provider provides work.
     */
    private ArrayList<Category> categoriesList = new ArrayList<Category>();

    /**
     * Postal Address of the Service Provider.
     */
    private PostalAddress postalAddress;

    /**
     * Name of the Service Provider by omission.
     */
    private static final String NAME_BY_OMISSION = "Without name";

    /**
     * Email of the Service Provider by omission.
     */
    private static final String EMAIL_BY_OMISSION = "Without email";

    /**
     * NIF of the Service Provider by omission.
     */
    private static final String NIF_BY_OMISSION = "Without NIF";

    /**
     * Phone of the Service Provider by omission.
     */
    private static final String PHONE_BY_OMISSION = "Without phone";

    /**
     * Postal Address of the Service Provider by omission.
     */
    private static final PostalAddress POSTALADRESS_BY_OMISSION = new PostalAddress();

    /**
     * The status of the appliance.
     */
    private static final String STATUS_BY_OMISSION = "Accepted";

    /**
     * Candidature with all parameters.
     *
     * @param name  name of the Service Provider.
     * @param nif   NIF of the Service Provider.
     * @param phone telephone of the Service Provider.
     * @param email email of the Service Provider.
     */
    public Appliance(String name, String nif, String phone, String email) {
        this.setName(name);
        this.setNif(nif);
        this.setPhone(phone);
        this.setEmail(email);
        this.academicQualificationList = new ArrayList<AcademicQualification>();
        this.professionalQualificationList = new ArrayList<ProfessionalQualification>();
        this.categoriesList = new ArrayList<Category>();
        this.status = STATUS_BY_OMISSION;
    }

    /**
     * Candidature with all the parameters by omission.
     */
    public Appliance() {
        this.name = NAME_BY_OMISSION;
        this.nif = NIF_BY_OMISSION;
        this.phone = PHONE_BY_OMISSION;
        this.email = EMAIL_BY_OMISSION;
        this.postalAddress = POSTALADRESS_BY_OMISSION;
        this.status = STATUS_BY_OMISSION;
    }

    /**
     * Gets the name of the Service Provider.
     *
     * @return the name of the Service Provider.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the email of the Service Provider.
     *
     * @return the email of the Service Provider.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the NIF of the Service Provider.
     *
     * @return the NIF of the Service Provider.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Gets the phone of the Service Provider.
     *
     * @return the phone of the Service Provider.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the Postal Adress of the Service Provider.
     *
     * @return the Postal Adress of the Service Provider.
     */
    public PostalAddress getPostalAddress() {
        return this.postalAddress;
    }

    /**
     * Gets the Academic Qualifications of the Service Provider.
     *
     * @return the Academic Qualifications of the Service Provider.
     */
    public List getAcademicQualifications() {
        return this.academicQualificationList;
    }

    /**
     * Gets the Professional Qualifications of the Service Provider.
     *
     * @return the Professional Qualifications of the Service Provider.
     */
    public List getProfessionalQualifications() {
        return this.professionalQualificationList;
    }

    /**
     * Gets the Categories selected for the appliance.
     *
     * @return the categories for the appliance.
     */
    public List getCategories() {
        return this.categoriesList;
    }
    
    public String getStatus(){
        return status;
    }

    /**
     * Sets the name of the Service Provider.
     *
     * @param name the name to be set.
     */
    public void setName(String name) {
        if (Validations.isNameValid(name) == false) {
            throw new IllegalArgumentException("Invalid Mail.");
        }
        this.name = name;
    }

    /**
     * Sets the email of the Service Provider.
     *
     * @param email the email to be set.
     */
    public void setEmail(String email) {
        for (int i = 0; i < Company.getApplianceRecord().getListOfAppliances().size(); i++) {
            if (email.equalsIgnoreCase(Company.getApplianceRecord().getListOfAppliances().get(i).getEmail())) {
                throw new IllegalArgumentException("Email already exists in the system.");
            }
        }
        if (!Validations.isEmailValid(email)) {
            throw new IllegalArgumentException("Invalid Email.");
        }
        this.email = email;
    }

    /**
     * Sets the NIF of the Service Provider.
     *
     * @param nif the NIF to be set.
     */
    public void setNif(String nif) {
        for (int i = 0; i < Company.getApplianceRecord().getListOfAppliances().size(); i++) {
            if (nif.equalsIgnoreCase(Company.getApplianceRecord().getListOfAppliances().get(i).getNif())) {
                throw new IllegalArgumentException("NIF already exists in the system.");
            }
        }
        if (!Validations.isNIFValid(nif)) {
            throw new IllegalArgumentException("Invalid NIF.");
        }
        this.nif = nif;
    }

    /**
     * Sets the Phone Number of the Service Provider.
     *
     * @param phone the phone number to be set.
     */
    public void setPhone(String phone) {
        if (!Validations.isPhoneValid(phone)) {
            throw new IllegalArgumentException("Invalid Phone Number.");
        }
        this.phone = phone;
    }

    /**
     * Sets the Postal Address of the Service Provider.
     *
     * @param postalAddress the Postal Address to be set.
     */
    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Compares an appliance with another appliance.
     *
     * @param otherAppliance other appliance to compare to.
     * @return true if the appliance is equals or false if the appliances are not equal.
     */
    @Override
    public boolean equals(Object otherAppliance) {
        if (this == otherAppliance) {
            return true;
        }
        if (otherAppliance == null || otherAppliance.getClass() != Appliance.class) {
            return false;
        }

        Appliance appli = (Appliance) otherAppliance;
        return this.name.equalsIgnoreCase(appli.getName()) && this.email.equalsIgnoreCase(appli.getEmail()) && this.phone.equalsIgnoreCase(appli.getPhone()) && this.nif.equalsIgnoreCase(appli.getNif());
    }

    /**
     * Prints the information of an appliance.
     *
     * @return the information of an appliance.
     */
    @Override
    public String toString() {
        return String.format("Appliance Information:" +
                "\nName: %s" +
                "\nNIF: %s" +
                "\nEmail: %s" +
                "\nPhone: %s", this.name, this.nif, this.email, this.phone);
    }

    /**
     * Adds a Postal Address to an Appliance.
     *
     * @param address  address of the postal address.
     * @param locality locality of the postal address.
     * @param postal1  first 4 digits of the postal address.
     * @param postal2  second 3 digits of the postal address.
     */
    public void addPostalAddress(String address, String locality, String postal1, String postal2) {
        PostCode postCode = new PostCode(postal1, postal2);
        PostalAddress postal = new PostalAddress(address, locality, postCode);
        this.setPostalAddress(postal);
    }

    /**
     * Adds an Academic Qualification to the appliance.
     *
     * @param aq academic qualification to be added.
     */
    public void addAcademicQualification(AcademicQualification aq) {
        this.academicQualificationList.add(aq);
    }

    /**
     * Adds a Professional Qualification to the appliance.
     *
     * @param pq professional qualification to be added.
     */
    public void addProfessionalQualification(ProfessionalQualification pq) {
        this.professionalQualificationList.add(pq);
    }

    /**
     * Adds a category to the appliance's category list.
     *
     * @param cat category to be added.
     */
    public void addCategory(Category cat) {
        this.categoriesList.add(cat);
    }

    /**
     * Removes a category from tyhe appliance's category list.
     *
     * @param cat the category to be removed.
     */
    public void removeCategory(Category cat) {
        this.categoriesList.remove(this.categoriesList.indexOf(cat));
    }
}
