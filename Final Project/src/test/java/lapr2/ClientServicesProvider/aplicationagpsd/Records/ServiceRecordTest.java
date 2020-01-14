package lapr2.ClientServicesProvider.aplicationagpsd.Records;

import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExpansivelService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.FixService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.LimitedService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Service;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The Service record test.
 */
class ServiceRecordTest {

    /**
     * Gets services test.
     */
    @Test
    void getServices() {
        ServiceRecord instance = new ServiceRecord();
        List<Service> actual = instance.getServices();
        List<Service> expected = new ArrayList<Service>();
        assertEquals(expected, actual);
    }

    /**
     * Sets services test.
     */
    @Test
    void setServices() {
        ServiceRecord instance = new ServiceRecord();
        List<Service> expected = new ArrayList<Service>();
        instance.setServices(expected);
        List<Service> actual = instance.getServices();
        assertEquals(expected, actual);
    }

    /**
     * Gets category services test.
     */
    @Test
    void getCategoryServices() {
        ServiceRecord instance = new ServiceRecord();
        Service service = new LimitedService("1", "1", "limpeza", "colchões", "limpeza a seco", 5.5);
        instance.addService(service);
        List<Service> expected = new ArrayList<Service>();
        expected.add(service);
        List<Service> actual = instance.getCategoryServices("1");
        assertEquals(expected, actual);
    }

    /**
     * Add fix service test.
     */
    @Test
    void addFixService() {
        ServiceRecord instance = new ServiceRecord();
        Service service = new FixService("4", "1", "cenas", "copos", "levantamento do copo", 7.6, new Time(2, 30));
        instance.addService(service);
        List<Service> expected = new ArrayList<Service>();
        expected.add(service);
        List<Service> actual = instance.getServices();
        assertEquals(expected, actual);
    }

    /**
     * Add limited service test.
     */
    @Test
    void addLimitedService() {
        ServiceRecord instance = new ServiceRecord();
        Service service = new LimitedService("1", "1", "limpeza", "colchões", "limpeza a seco", 5.5);
        instance.addService(service);
        List<Service> expected = new ArrayList<Service>();
        expected.add(service);
        List<Service> actual = instance.getServices();
        assertEquals(expected, actual);
    }

    /**
     * Add expansivel service test.
     */
    @Test
    void addExpansivelService() {
        ServiceRecord instance = new ServiceRecord();
        Service service = new ExpansivelService("2", "1", "empregado mesa", "whatever", "whatever more complete", 5.4);
        instance.addService(service);
        List<Service> expected = new ArrayList<Service>();
        expected.add(service);
        List<Service> actual = instance.getServices();
        assertEquals(expected, actual);
    }

    /**
     * New fix service.
     */
    @Test
    void newFixService() {
        ServiceRecord instance = new ServiceRecord();
        Service expected = new FixService("4", "1", "cenas", "copos", "levantamento do copo", 7.6, new Time(2, 30));
        Service actual = instance.newFixService("4", "1", "cenas", "copos", "levantamento do copo", 7.6, new Time(2, 30));
        assertEquals(expected, actual);
    }

    /**
     * New limited service.
     */
    @Test
    void newLimitedService() {
        ServiceRecord instance = new ServiceRecord();
        Service expected = new LimitedService("1", "1", "limpeza", "colchões", "limpeza a seco", 5.5);
        Service actual = instance.newLimitedService("1", "1", "limpeza", "colchões", "limpeza a seco", 5.5);
        assertEquals(expected, actual);
    }

    /**
     * New expansivel service.
     */
    @Test
    void newExpansivelService() {
        ServiceRecord instance = new ServiceRecord();
        Service expected = new ExpansivelService("2", "1", "empregado mesa", "whatever", "whatever more complete", 5.4);
        Service actual = instance.newExpansivelService("2", "1", "empregado mesa", "whatever", "whatever more complete", 5.4);
        assertEquals(expected, actual);
    }

    /**
     * Gets service by id test.
     */
    @Test
    void getServiceById() {
        ServiceRecord instance = new ServiceRecord();
        Service expected = new ExpansivelService("2", "1", "empregado mesa", "whatever", "whatever more complete", 5.4);
        instance.addService(expected);
        Service actual = instance.getServiceById("2", "1");
        assertEquals(expected, actual);
    }
}