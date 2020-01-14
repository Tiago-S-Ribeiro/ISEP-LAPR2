package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ClientRegistryControllerTest {
    
    public ClientRegistryControllerTest() {
    }

    /**
     * Test of initialize method, of class ClientRegistryController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        ClientRegistryController instance = new ClientRegistryController();
        instance.initialize(url, rb);
    }
    
    /**
     * Test of getCli method, of class ClientRegistryController.
     */
    @Test
    public void testGetCli() {
        System.out.println("getCli");
        ClientRegistryController instance = new ClientRegistryController();
        Client expResult = new Client();
        instance.setCli(expResult);
        Client result = instance.getCli();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCli method, of class ClientRegistryController.
     */
    @Test
    public void testSetCli() {
        System.out.println("setCli");
        Client cli = new Client();
        ClientRegistryController instance = new ClientRegistryController();
        instance.setCli(cli);
        assertEquals(cli, instance.getCli());
    }
    
}
