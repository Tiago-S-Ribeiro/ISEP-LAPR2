package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Model.Appliance;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplianceRecordTest {

    /**
     * Creates a company before each test starts in order to acess the Appliance Record.
     */
    @BeforeEach
    void setUp() {
        Company company = new Company();
    }

    /**
     * Tests the 'get' for the list of appliances.
     */
    @Test
    void getListOfAppliances() {
        ApplianceRecord instance = new ApplianceRecord();
        List<Appliance> actual = instance.getListOfAppliances();
        List<Appliance> expected = new ArrayList<Appliance>();
        assertEquals(expected, actual);
    }

    /**
     * Tests the creation of a new appliance in the record.
     */
    @Test
    void newAppliance() {
        ApplianceRecord instance = new ApplianceRecord();
        Appliance actual = instance.newAppliance("name", "123456789", "912345678", "email@test.pt");
        Appliance expected = new Appliance("name", "123456789", "912345678", "email@test.pt");
        assertEquals(expected, actual);
    }

    /**
     * Tests the addition of an appliance to the record.
     */
    @Test
    void add() {
        ApplianceRecord instance = new ApplianceRecord();
        Appliance appliance = new Appliance("name", "123456789", "912345678", "email@test.pt");
        instance.add(appliance);
        List<Appliance> actual = instance.getListOfAppliances();
        ArrayList<Appliance> expected = new ArrayList<Appliance>();
        expected.add(appliance);
        assertEquals(expected, actual);
    }
}