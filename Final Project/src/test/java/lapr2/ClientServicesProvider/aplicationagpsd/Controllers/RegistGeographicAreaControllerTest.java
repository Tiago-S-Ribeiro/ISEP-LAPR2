package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.GeographicArea;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class RegistGeographicAreaControllerTest {
    
    public RegistGeographicAreaControllerTest() {
    }

    /**
     * Test of initialize method, of class RegistGeographicAreaController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        RegistGeographicAreaController instance = new RegistGeographicAreaController();
        instance.initialize(url, rb);
    }

    /**
     * Test of newGeographicArea method, of class RegistGeographicAreaController.
     */
    @Test
    public void testNewGeographicArea() {
        System.out.println("newGeographicArea");
        Company c = new Company();
        GeographicArea ga;
        GeographicAreaRecord rga = Company.getGeographicAreasRecord();
        ga = rga.newGeographicArea("abc", 23, 1000, "4000", "010");
        assertEquals(ga,rga.newGeographicArea("abc", 23, 1000, "4000", "010"));
    }

    /**
     * Test of registGeographicArea method, of class RegistGeographicAreaController.
     */
    @Test
    public void testRegistGeographicArea() {
        System.out.println("registGeographicArea");
        Company c = new Company();
        GeographicArea ga = new GeographicArea("abc", 23, 1000, "4000", "010");
        GeographicAreaRecord rga = Company.getGeographicAreasRecord();
        rga.registGeographicArea(ga);
        assertEquals(true, rga.getLstGeographicAreas().contains(ga));
    }
    
}
