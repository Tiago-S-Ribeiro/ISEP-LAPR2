/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author berna
 */
public class ClientAddressAditionControllerTest {
    
    public ClientAddressAditionControllerTest() {
    }

    /**
     * Test of getCli method, of class ClientAddressAditionController.
     */
    @Test
    public void testGetCli() {
        System.out.println("getCli");
        ClientAddressAditionController instance = new ClientAddressAditionController();
        Client expResult = null;
        Client result = instance.getCli();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCli method, of class ClientAddressAditionController.
     */
    @Test
    public void testSetCli() {
        System.out.println("setCli");
        Client cli = null;
        ClientAddressAditionController instance = new ClientAddressAditionController();
        instance.setCli(cli);
    }
    
}
