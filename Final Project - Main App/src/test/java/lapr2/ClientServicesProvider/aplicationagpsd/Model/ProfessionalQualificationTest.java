package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionalQualificationTest {

    /**
     * Test of method 'getDescription' of class 'ProfessionalQualification'.
     */
    @Test
    void getDescription() {
        ProfessionalQualification instance = new ProfessionalQualification();
        String actual = instance.getDescription();
        String expected = "Without professional qualification.";
        assertEquals(expected, actual);
    }


    /**
     * Test of method 'setDescription' of class 'ProfessionalQualification'.
     */
    @Test
    void setDescription() {
        ProfessionalQualification instance = new ProfessionalQualification();
        instance.setDescription("test description");
        String actual = instance.getDescription();
        String expected = "test description";
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'equals' of class 'ProfessionalQualification'.
     */
    @Test
    void equalsTestNull() {
        ProfessionalQualification instance = new ProfessionalQualification();
        Object instance2 = null;
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'equals' of class 'ProfessionalQualification'.
     */
    @Test
    void equalsTestClass() {
        ProfessionalQualification instance = new ProfessionalQualification();
        AcademicQualification instance2 = new AcademicQualification();
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'equals' of class 'ProfessionalQualification'.
     */
    @Test
    void equalsTestAttributes() {
        ProfessionalQualification instance = new ProfessionalQualification();
        instance.setDescription("description");
        ProfessionalQualification instance2 = new ProfessionalQualification();
        instance2.setDescription("description");
        boolean expected = true;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'toString' of class 'ProfessionalQualification'.
     */
    @Test
    void toStringTest() {
        ProfessionalQualification instance = new ProfessionalQualification();
        String actual = instance.toString();
        String expected = "Professional Qualification: Without professional qualification.";
        assertEquals(expected, actual);
    }
}