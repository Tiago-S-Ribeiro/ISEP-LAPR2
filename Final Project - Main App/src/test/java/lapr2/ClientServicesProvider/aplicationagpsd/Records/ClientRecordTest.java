package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.ClientRecord;
import java.util.ArrayList;
import java.util.List;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostCode;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ClientRecordTest {
    
    public ClientRecordTest() {
    }

    /**
     * Test of getClientList method, of class ClientRecord.
     */
    @Test
    public void testGetClientList() {
        System.out.println("getClientList");
        ClientRecord instance = new ClientRecord();
        List<Client> expResult = new ArrayList<Client>();
        List<Client> result = instance.getClientList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClientList method, of class ClientRecord.
     */
    @Test
    public void testSetClientList() {
        System.out.println("setClientList");
        List<Client> clientList = new ArrayList<Client>();
        ClientRecord instance = new ClientRecord();
        instance.setClientList(clientList);
    }

    /**
     * Test of addClient method, of class ClientRecord.
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        PostCode pc = new PostCode("4000", "010");
        PostalAddress p = new PostalAddress("address","locality", pc);
        Client cli = new Client("Tiago","email","tiagoPass","111111111","999999999",p);
        ClientRecord instance = new ClientRecord();
        instance.addClient(cli);
        assertEquals(cli, instance.getClientList().get(0));
    }

    /**
     * Test of newClient method, of class ClientRecord.
     */
    @Test
    public void testNewClient() {
        System.out.println("newClient");
        String name = "Tiago";
        String email = "tiagoEmail";
        String password = "pass";
        String NIF = "123123123";
        String phone = "897987987";
        PostCode pc = new PostCode("4000", "010");
        PostalAddress postalAddress = new PostalAddress("address","locality", pc);
        ClientRecord instance = new ClientRecord();
        Client expResult = new Client(name,email,password,NIF,phone,postalAddress);
        Client result = instance.newClient(name, email, password, NIF, phone, postalAddress);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientByEmail method, of class ClientRecord.
     */
    @Test
    public void testGetClientByEmail() {
        System.out.println("getClientByEmail");
        String email = "EmailParaProcura";
        ClientRecord instance = new ClientRecord();
        PostCode pc = new PostCode("4000", "010");
        PostalAddress p = new PostalAddress("address","locality", pc);
        Client cli = new Client("Tiago","EmailParaProcura","tiagoPass","111111111","999999999",p);
        instance.getClientList().add(cli);
        Client expResult = cli;
        Client result = instance.getClientByEmail(email);
        assertEquals(expResult, result);
    }
}
