package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

/**
 * The type Appliance test.
 *
 * @author Rafael Moreira 1180778
 */
class ApplianceTest {

    /**
     * Creates a company before each test starts in order to acess the Appliance Record.
     */
    @BeforeEach
    void setUp() {
        Company company = new Company();
    }

    /**
     * Gets name.
     */
    @Test
    void getName() {
        Appliance instance = new Appliance();
        String actual = instance.getName();
        String expected = "Without name";
        assertEquals(expected, actual);
    }

    /**
     * Gets email.
     */
    @Test
    void getEmail() {
        Appliance instance = new Appliance();
        String actual = instance.getEmail();
        String expected = "Without email";
        assertEquals(expected, actual);
    }

    /**
     * Gets nif.
     */
    @Test
    void getNif() {
        Appliance instance = new Appliance();
        String actual = instance.getNif();
        String expected = "Without NIF";
        assertEquals(expected, actual);
    }

    /**
     * Gets phone.
     */
    @Test
    void getPhone() {
        Appliance instance = new Appliance();
        String actual = instance.getPhone();
        String expected = "Without phone";
        assertEquals(expected, actual);
    }

    /**
     * Gets postal adress.
     */
    @Test
    void getPostalAdress() {
        Appliance instance = new Appliance();
        PostalAddress actual = instance.getPostalAddress();
        PostalAddress expected = new PostalAddress();
        assertEquals(expected, actual);
    }

    /**
     * Gets academic qualifications.
     */
    @Test
    void getAcademicQualifications() {
        Appliance instance = new Appliance();
        List actual = instance.getAcademicQualifications();
        List expected = new ArrayList<AcademicQualification>();
        assertEquals(expected, actual);
    }

    /**
     * Gets professional qualifications.
     */
    @Test
    void getProfessionalQualifications() {
        Appliance instance = new Appliance();
        List actual = instance.getProfessionalQualifications();
        List expected = new ArrayList<ProfessionalQualification>();
        assertEquals(expected, actual);
    }

    /**
     * Sets name.
     */
    @Test
    void setName() {
        Appliance instance = new Appliance();
        instance.setName("test name");
        String actual = instance.getName();
        String expected = "test name";
        assertEquals(expected, actual);
    }

    /**
     * Sets email.
     */
    @Test
    void setEmail() {
        Appliance instance = new Appliance();
        instance.setEmail("test@email.pt");
        String actual = instance.getEmail();
        String expected = "test@email.pt";
        assertEquals(expected, actual);
    }

    /**
     * Sets nif.
     */
    @Test
    void setNif() {
        Appliance instance = new Appliance();
        instance.setNif("123456789");
        String actual = instance.getNif();
        String expected = "123456789";
        assertEquals(expected, actual);
    }

    /**
     * Sets phone.
     */
    @Test
    void setPhone() {
        Appliance instance = new Appliance();
        instance.setPhone("912345678");
        String actual = instance.getPhone();
        String expected = "912345678";
        assertEquals(expected, actual);
    }

    /**
     * Sets postal adress.
     */
    @Test
    void setPostalAdress() {
        Appliance instance = new Appliance();
        instance.setPostalAddress(new PostalAddress());
        PostalAddress actual = instance.getPostalAddress();
        PostalAddress expected = new PostalAddress();
        assertEquals(expected, actual);
    }

    /**
     * Add postal address.
     */
    @Test
    void addPostalAddress() {
        Appliance instance = new Appliance();
        String address = "address";
        String locality = "locality";
        String postal1 = "4000";
        String postal2 = "010";
        instance.addPostalAddress(address, locality, postal1, postal2);
        PostalAddress actual = instance.getPostalAddress();
        PostalAddress expected = new PostalAddress(address, locality, new PostCode(postal1, postal2));
        assertEquals(expected, actual);
    }

    /**
     * Add academic qualification.
     */
    @Test
    void addAcademicQualification() {
        Appliance instance = new Appliance();
        AcademicQualification aq = new AcademicQualification();
        instance.addAcademicQualification(aq);
        List actual = instance.getAcademicQualifications();
        List expected = new ArrayList<AcademicQualification>();
        expected.add(aq);
        assertEquals(expected, actual);
    }

    /**
     * Add professional qualification.
     */
    @Test
    void addProfessionalQualification() {
        Appliance instance = new Appliance();
        ProfessionalQualification pq = new ProfessionalQualification();
        instance.addProfessionalQualification(pq);
        List actual = instance.getProfessionalQualifications();
        List expected = new ArrayList<ProfessionalQualification>();
        expected.add(pq);
        assertEquals(expected, actual);
    }

    /**
     * Equals test same object.
     */
    @Test
    void equalsTestSameObject() {
        Appliance instance = new Appliance();
        boolean expected = true;
        boolean actual = instance.equals(instance);
        assertEquals(expected, actual);
    }

    /**
     * Equals test null.
     */
    @Test
    void equalsTestNull() {
        Appliance instance = new Appliance();
        Object instance2 = null;
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Equals test class.
     */
    @Test
    void equalsTestClass() {
        Appliance instance = new Appliance();
        PostalAddress instance2 = new PostalAddress();
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Equals test attributes.
     */
    @Test
    void equalsTestAttributes() {
        Appliance instance = new Appliance();
        instance.setName("name");
        Appliance instance2 = new Appliance();
        instance2.setName("name");
        boolean expected = true;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * To string test.
     */
    @Test
    void toStringTest() {
        Appliance instance = new Appliance();
        String actual = instance.toString();
        String expected = "Appliance Information:" +
                "\nName: Without name" +
                "\nNIF: Without NIF" +
                "\nEmail: Without email" +
                "\nPhone: Without phone";
        assertEquals(expected, actual);
    }
}