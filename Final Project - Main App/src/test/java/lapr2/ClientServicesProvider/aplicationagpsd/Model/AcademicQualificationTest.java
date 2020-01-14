package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcademicQualificationTest {

    /**
     * Test of method 'getDegree' of class 'AcademicQualification'.
     */
    @Test
    void getDegree() {
        AcademicQualification instance = new AcademicQualification();
        String actual = instance.getDegree();
        String expected = "Without Degree";
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'getDesignation' of class 'AcademicQualification'.
     */
    @Test
    void getDesignation() {
        AcademicQualification instance = new AcademicQualification();
        String actual = instance.getDesignation();
        String expected = "Without Designation";
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'getClassification' of class 'AcademicQualification'.
     */
    @Test
    void getClassification() {
        AcademicQualification instance = new AcademicQualification();
        String actual = instance.getClassification();
        String expected = "Without Classification";
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'setDegree' of class 'AcademicQualification'.
     */
    @Test
    void setDegree() {
        AcademicQualification instance = new AcademicQualification();
        instance.setDegree("test degree");
        String actual = instance.getDegree();
        String expected = "test degree";
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'setDesignation' of class 'AcademicQualification'.
     */
    @Test
    void setDesignation() {
        AcademicQualification instance = new AcademicQualification();
        instance.setDesignation("test designation");
        String actual = instance.getDesignation();
        String expected = "test designation";
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'setClassification' of class 'AcademicQualification'.
     */
    @Test
    void setClassification() {
        AcademicQualification instance = new AcademicQualification();
        instance.setClassification("test classification");
        String actual = instance.getClassification();
        String expected = "test classification";
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'equals' of class 'AcademicQualification'.
     */
    @Test
    void equalsTestNull() {
        AcademicQualification instance = new AcademicQualification();
        Object instance2 = null;
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'equals' of class 'AcademicQualification'.
     */
    @Test
    void equalsTestClass() {
        AcademicQualification instance = new AcademicQualification();
        ProfessionalQualification instance2 = new ProfessionalQualification();
        boolean expected = false;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'equals' of class 'AcademicQualification'.
     */
    @Test
    void equalsTestAttributes() {
        AcademicQualification instance = new AcademicQualification();
        instance.setDesignation("designation");
        AcademicQualification instance2 = new AcademicQualification();
        instance2.setDesignation("designation");
        boolean expected = true;
        boolean actual = instance.equals(instance2);
        assertEquals(expected, actual);
    }

    /**
     * Test of method 'toString' of class 'AcademicQualification'.
     */
    @Test
    void toStringTest() {
        AcademicQualification instance = new AcademicQualification();
        String actual = instance.toString();
        String expected = "Degree: Without Degree; Designation: Without Designation; Classification: Without Classification";
        assertEquals(expected, actual);
    }
}