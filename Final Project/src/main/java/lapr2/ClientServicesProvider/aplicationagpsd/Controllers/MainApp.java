package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.*;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ApplianceRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.UsersRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.CategoryRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ClientRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.CompleteWorkRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ExecutionOrderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProviderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProvisionRequestRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Timer.DoAffectations;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.FilesReaderWriter;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FilesReaderWriter frw = new FilesReaderWriter();
        frw.readsAffectedToRecordBinaryFile("affectedToRecord.ser");
        frw.readsApplianceRecordBinaryFile("applianceRecord.ser");
        frw.readsCategoryRecordBinaryFile("categoryRecord.ser");
        frw.readsClientRecordBinaryFile("clientRecord.ser");
        frw.readsCompleteWorkRecordBinaryFile("completeWorkRecord.ser");
        frw.readsExecutionOrderRecordBinaryFile("executionOrderRecord.ser");
        frw.readsGeographicAreasRecordBinaryFile("geographicAreaRecord.ser");
        frw.readsInvoiceRecordBinaryFile("invoiceRecord.ser");
        frw.readsRatingRecordBinaryFile("ratingRecord.ser");
        frw.readsServiceProviderRecordBinaryFile("serviceProviderRecord.ser");
        frw.readsServiceProvisionRequestRecordBinaryFile("serviceProvisionRequestRecord.ser");
        frw.readsServicesRecordBinaryFile("serviceRecord.ser");
        frw.readsUserRecordBinaryFile("userRecord.ser");

        if (Company.getAffectedToRecord().getAffectationsList().isEmpty() && Company.getApplianceRecord().getListOfAppliances().isEmpty() && Company.getCategoryRecord().getListOfCategories().isEmpty() && Company.getClientRecord().getClientList().isEmpty() && Company.getCompleteWorkRecord().getLstCompleteWorks().isEmpty() && Company.getExecutionOrderRecord().getExecutionOrdersList().isEmpty() && Company.getGeographicAreasRecord().getLstGeographicAreas().isEmpty() && Company.getRequestRecord().getServProvReqList().isEmpty() && Company.getServiceProviderRecord().getServiceProvidersList().isEmpty() && Company.getServiceRecord().getServices().isEmpty() && Company.getUserRecord().getUserList().isEmpty()) {
            AuthorizationFacade af = new AuthorizationFacade();
            Client cli1 = new Client("Maria Santos", "msantos@gmail.com", "prosdbsts190", "100542369", "936565651", new PostalAddress("Rua D. Joao de França nº 1", "Gondomar", new PostCode("4420", "001")));
            Client cli2 = new Client("Antonio Lage", "aLage@gmail.com", "aLage1234", "200542669", "916535661", new PostalAddress("R. Goncalves de Castro, nº 8", "Pedroso", new PostCode("4415", "999")));
            Client cli3 = new Client("Ana Santos", "aSantos@isep.ipp.pt", "aSantini456", "1105432349", "966535661", new PostalAddress("R. do Carvalhido, nº9", "Porto", new PostCode("4250", "100")));
            Client cli4 = new Client("Joana Santos", "jSantos@isep.ipp.pt", "jjSantos23", "210975020", "966545644", new PostalAddress("R. Cegonheira, nº3", "Maia", new PostCode("4470", "528")));
            af.registUserWithRole("msantos@gmail.com", "prosdbsts190", "CLIENT");
            af.registUserWithRole("aLage@gmail.com", "aLage1234", "CLIENT");
            af.registUserWithRole("aSantos@isep.ipp.pt", "aSantini456", "CLIENT");
            af.registUserWithRole("jSantos@isep.ipp.pt", "jjSantos23", "CLIENT");
            Company.getClientRecord().addClient(cli1);
            Company.getClientRecord().addClient(cli2);
            Company.getClientRecord().addClient(cli3);
            Company.getClientRecord().addClient(cli4);

            Appliance app1 = new Appliance("Antonio Patrao", "500324896", "968795236", "aPatrao@gmail.com");
            app1.addPostalAddress("R. Central", "Crestuma", "4415", "995");
            app1.getAcademicQualifications().add(new AcademicQualification("Bachelor", "Software Engineering", "14,5"));
            app1.getProfessionalQualifications().add(new ProfessionalQualification("Professional Training Course of Automotive Mechanic of the Center of Professional Training of Automotive Repair"));
            app1.getProfessionalQualifications().add(new ProfessionalQualification("Professional license of light and heavy vehicles"));
            app1.getProfessionalQualifications().add(new ProfessionalQualification("Advanced Course in Automotive Mechanics"));
            app1.getCategories().add(new Category("cat01", "Plumber"));
            app1.getCategories().add(new Category("cat03", "Automotive Mechanic"));
            Appliance app2 = new Appliance("Maria Silva", "510324896", "928735537", "mSilva@hotmail.com");
            app2.addPostalAddress("Rua 1", "Porto", "4420", "002");
            app2.getAcademicQualifications().add(new AcademicQualification("Bachelor", "Eletronics Engineering", "16,7"));
            app2.getAcademicQualifications().add(new AcademicQualification("Master", "Systems Engineering", "10"));
            app2.getAcademicQualifications().add(new AcademicQualification("PhD", "Robotics", "12"));
            app2.getProfessionalQualifications().add(new ProfessionalQualification("Advanced Course of plumbing and lock smithing"));
            app2.getProfessionalQualifications().add(new ProfessionalQualification("Professional License for light and heavy vehicles"));
            app2.getProfessionalQualifications().add(new ProfessionalQualification("Cooking Course"));
            app2.getCategories().add(new Category("cat05", "Painter"));
            app2.getCategories().add(new Category("cat02", "Lock Smith"));
            app2.getCategories().add(new Category("cat04", "Cook"));
            Appliance app3 = new Appliance("Joaquina dos Santos", "510324877", "934735567", "jaquina@hotmail.com");
            app3.addPostalAddress("Rua Altino Silva Gomes", "Maia", "4470", "526");
            app3.getAcademicQualifications().add(new AcademicQualification("Bachelor", "Mechanics", "14.5"));
            app3.getProfessionalQualifications().add(new ProfessionalQualification("Advanced Course of plumbing and lock smithing"));
            app3.getProfessionalQualifications().add(new ProfessionalQualification("Advanced Course in Automotive Mechanics"));
            app3.getCategories().add(new Category("cat01", "Plumber"));
            app3.getCategories().add(new Category("cat02", "Lock Smith"));
            app3.getCategories().add(new Category("cat03", "Automotive Mechanic"));
            Appliance app4 = new Appliance("Serafim Santos", "230324822", "223654987", "sSantos@gmail.com");
            app4.addPostalAddress("R. Alberto Alves Tavares", "Vila Nova de Gaia", "4430", "601");
            app4.addAcademicQualification(new AcademicQualification("HighSchool", "Sciences", "15"));
            app4.getProfessionalQualifications().add(new ProfessionalQualification("Painter Course"));
            app4.getCategories().add(new Category("cat05", "Painter"));
            app4.getCategories().add(new Category("cat01", "Plumber"));

            ApplianceRecord ar = Company.getApplianceRecord();
            ar.add(app1);
            ar.add(app2);
            ar.add(app3);
            ar.add(app4);

            CategoryRecord cr = Company.getCategoryRecord();

            cr.registCategory(new Category("cat01", "Plumber"));
            cr.registCategory(new Category("cat02", "Lock Smith"));
            cr.registCategory(new Category("cat03", "Automotive Mechanic"));
            cr.registCategory(new Category("cat04", "Cook"));
            cr.registCategory(new Category("cat05", "Painter"));

            ServiceRecord sr = Company.getServiceRecord();

            sr.addService(new FixService("cat01", "serv01", "FixService", "Light plumbing", "Intall water tap", 100, new Time(1)));
            sr.addService(new LimitedService("cat01", "serv02", "Limited Service", "Heavy plumbing", "Pipeline Repair", 40));
            sr.addService(new LimitedService("cat05", "serv03", "Limited Service", "Gate painting", "Gate painting", 60));
            sr.addService(new ExpansivelService("cat04", "serv04", "Expansivel Service", "Prepare dinner", "Prepair dinner and clean kitchen", 80));
            sr.addService(new LimitedService("cat03", "serv05", "Limited Service", "Repair vehicle", "Repair vehicle engine", 80));
            sr.addService(new FixService("cat05", "serv06", "Fix Service", "Gate painting", "Gate painting", 90, new Time(1)));

            GeographicAreaRecord gar = Company.getGeographicAreasRecord();

            GeographicArea ga1 = new GeographicArea("Gondomar-1", 50, 10, "4420", "002");
            GeographicArea ga2 = new GeographicArea("Gondomar-2", 10, 5, "4420", "570");
            GeographicArea ga3 = new GeographicArea("Gondomar-3", 20, 8, "4435", "685");
            GeographicArea ga4 = new GeographicArea("Porto-1", 30, 10, "4250", "108");
            GeographicArea ga5 = new GeographicArea("Maia-1", 40, 5, "4470", "526");

            gar.registGeographicArea(ga1);
            gar.registGeographicArea(ga2);
            gar.registGeographicArea(ga3);
            gar.registGeographicArea(ga4);
            gar.registGeographicArea(ga5);

            ServiceProvisionRequestRecord sprr = Company.getRequestRecord();

            ServiceProvisionRequest spr1 = new ServiceProvisionRequest(cli1, new PostalAddress("Rua D. João de França nº 1", "Gondomar", new PostCode("4420", "001")), new RequestedServiceDescription(new FixService("cat01", "serv01", "FixService", "Light plumbing", "Intall water tap", 100, new Time(1)), "Close water tap", new Time(1)), new Schedule(0, new Date(2019, 6, 3), new Time(9)), 150.0);
            spr1.addSchedule(new Schedule(1, new Date(2019, 6, 5), new Time(22)));
            ServiceProvisionRequest spr2 = new ServiceProvisionRequest(cli1, new PostalAddress("Rua D. João de França nº 1", "Gondomar", new PostCode("4420", "001")), new RequestedServiceDescription(new LimitedService("cat01", "serv02", "Limited Service", "Heavy plumbing", "Pipeline Repair", 40), "Pipeline Repair", new Time(1)), new Schedule(0, new Date(2019, 6, 24), new Time(9)), 90.0);
            spr2.addSchedule(new Schedule(1, new Date(2019, 6, 25), new Time(22)));
            ServiceProvisionRequest spr3 = new ServiceProvisionRequest(cli3, new PostalAddress("R. do Carvalhido, nº9", "Porto", new PostCode("4250", "100")), new RequestedServiceDescription(new LimitedService("cat05", "serv03", "Limited Service", "Gate painting", "Gate painting", 60), "Iron gate painting", new Time(2)), new Schedule(0, new Date(2019, 6, 24), new Time(10)), 90.0);
            spr3.addSchedule(new Schedule(1, new Date(2019, 6, 25), new Time(14, 30)));
            ServiceProvisionRequest spr4 = new ServiceProvisionRequest(cli3, new PostalAddress("R. do Carvalhido, nº9", "Porto", new PostCode("4250", "100")), new RequestedServiceDescription(new ExpansivelService("cat04", "serv04", "Expansivel Service", "Prepare dinner", "Prepair dinner and clean kitchen", 80), "Prepare dinner and clean kitchen", new Time(2)), new Schedule(0, new Date(2019, 6, 6), new Time(19)), 190.0);
            ServiceProvisionRequest spr5 = new ServiceProvisionRequest(cli4, new PostalAddress("R. Cegonheira, nº3", "Maia", new PostCode("4470", "528")), new RequestedServiceDescription(new FixService("cat01", "serv01", "FixService", "Light plumbing", "Intall water tap", 100, new Time(1)), "water tap repair", new Time(1)), new Schedule(0, new Date(2019, 6, 7), new Time(19)), 140.0);
            ServiceProvisionRequest spr6 = new ServiceProvisionRequest(cli4, new PostalAddress("R. Cegonheira, nº3", "Maia", new PostCode("4470", "528")), new RequestedServiceDescription(new LimitedService("cat03", "serv05", "Limited Service", "Repair vehicle", "Repair vehicle engine", 80), "repair vehicle engine and change oil", new Time(1)), new Schedule(0, new Date(2019, 6, 8), new Time(9)), 120.0);
            ServiceProvisionRequest spr7 = new ServiceProvisionRequest(cli4, new PostalAddress("R. Cegonheira, nº3", "Maia", new PostCode("4470", "528")), new RequestedServiceDescription(new FixService("cat05", "serv06", "Fix Service", "Gate painting", "Gate painting", 90, new Time(1)), "gate painting", new Time(1)), new Schedule(0, new Date(2019, 6, 29), new Time(20)), 130.0);

            sprr.addRequest(spr1);
            sprr.addRequest(spr2);
            sprr.addRequest(spr3);
            sprr.addRequest(spr4);
            sprr.addRequest(spr5);
            sprr.addRequest(spr6);
            sprr.addRequest(spr7);

            app1.setStatus("Processed");
            app2.setStatus("Processed");
            app3.setStatus("Processed");
            app4.setStatus("Processed");

            ServiceProviderRecord spr = Company.getServiceProviderRecord();

            ServiceProvider sp1 = new ServiceProvider("Antonio dos Santos Patrao", "000", app1.getEmail(), app1.getName(), "10001", app1.getPostalAddress());
            sp1.getCategoriesList().addAll(app1.getCategories());
            sp1.addGeographicArea(ga1);
            sp1.addGeographicArea(ga2);
            ServiceProvider sp2 = new ServiceProvider("Maria das Neves Silva", "000", app2.getEmail(), app2.getName(), "10002", app2.getPostalAddress());
            sp2.getCategoriesList().addAll(app2.getCategories());
            sp1.addGeographicArea(ga4);
            ServiceProvider sp3 = new ServiceProvider("Joaquina dos Santos", "000", app3.getEmail(), app3.getName(), "10003", app3.getPostalAddress());
            sp3.getCategoriesList().addAll(app3.getCategories());
            sp3.addGeographicArea(ga5);
            ServiceProvider sp4 = new ServiceProvider("Serafim Santos", "000", app4.getEmail(), app4.getName(), "10004", app4.getPostalAddress());
            sp4.getCategoriesList().addAll(app4.getCategories());
            sp4.addGeographicArea(ga5);
            sp4.addGeographicArea(ga2);

            spr.addServiceProvider(sp4);
            spr.addServiceProvider(sp2);
            spr.addServiceProvider(sp3);
            spr.addServiceProvider(sp1);
            af.registUserWithRole(app1.getEmail(), "000", "SERVICE PROVIDER");
            af.registUserWithRole(app2.getEmail(), "000", "SERVICE PROVIDER");
            af.registUserWithRole(app3.getEmail(), "000", "SERVICE PROVIDER");
            af.registUserWithRole(app4.getEmail(), "000", "SERVICE PROVIDER");

            sp1.addAvailability(new Availability(new Date(2019, 6, 3), new Date(2019, 6, 5), new Time(9), new Time(23)));
            sp1.addAvailability(new Availability(new Date(2019, 6, 24), new Date(2019, 6, 25), new Time(9), new Time(13)));
            sp2.addAvailability(new Availability(new Date(2019, 6, 6), new Date(2019, 6, 7), new Time(9), new Time(23)));
            sp2.addAvailability(new Availability(new Date(2019, 6, 24), new Date(2019, 6, 25), new Time(9), new Time(22)));
            sp2.addAvailability(new Availability(new Date(2019, 6, 28), new Date(2019, 6, 29), new Time(20), new Time(18)));
            sp3.addAvailability(new Availability(new Date(2019, 6, 7), new Date(2019, 6, 10), new Time(9), new Time(23)));
            sp3.addAvailability(new Availability(new Date(2019, 6, 28), new Date(2019, 6, 29), new Time(20), new Time(18)));
            sp4.addAvailability(new Availability(new Date(2019, 6, 28), new Date(2019, 6, 29), new Time(20), new Time(18)));

            ExecutionOrderRecord eor = Company.getExecutionOrderRecord();

            ExecutionOrder eo1 = new ExecutionOrder(new PostalAddress("Rua D. João de França nº 1", "Gondomar", new PostCode("4420", "001")), sp1, cli1, spr1.getRequestedServicesDecriptionList().get(0), spr1.getSchedulesList().get(1), 8.09);
            ExecutionOrder eo2 = new ExecutionOrder(new PostalAddress("R. do Carvalhido, nº9", "Porto", new PostCode("4250", "100")), sp2, cli3, spr4.getRequestedServicesDecriptionList().get(0), spr4.getSchedulesList().get(0), 9.54);
            ExecutionOrder eo3 = new ExecutionOrder(new PostalAddress("R. Cegonheira, nº3", "Maia", new PostCode("4470", "528")), sp3, cli4, spr5.getRequestedServicesDecriptionList().get(0), spr5.getSchedulesList().get(0), 0.77);
            ExecutionOrder eo4 = new ExecutionOrder(new PostalAddress("R. Cegonheira, nº3", "Maia", new PostCode("4470", "528")), sp3, cli4, spr6.getRequestedServicesDecriptionList().get(0), spr6.getSchedulesList().get(0), 0.77);

            eor.registExecutionOrder(eo1);
            eor.registExecutionOrder(eo2);
            eor.registExecutionOrder(eo3);
            eor.registExecutionOrder(eo4);

            CompleteWorkRecord cwr = Company.getCompleteWorkRecord();

            CompleteWork cw1 = new CompleteWork("As expected", eo1);
            CompleteWork cw2 = new CompleteWork("As expected", eo2);
            cw2.setExtraTime("60");
            CompleteWork cw3 = new CompleteWork("As expected", eo3);
            CompleteWork cw4 = new CompleteWork("Customer complained about the delay, work performed without the presence of the client. Not as Expected", eo4);

            cwr.registCompleteWork(cw1);
            cwr.registCompleteWork(cw2);
            cwr.registCompleteWork(cw3);
            cwr.registCompleteWork(cw4);
            
            for (User user : Company.getUserRecord().getUserList()) {
                System.out.println(user);
            }
            
        }
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/InitialPage.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/initialpage.css");
        stage.setTitle("TRPBT Services Application");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the application can not be launched through deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File fichConfiguracao = new File("config.properties");
        FileReader reader = new FileReader(fichConfiguracao);
        Properties props = new Properties();
        props.load(reader);

        Company company = new Company(props.getProperty("Company.NIF"), props.getProperty("Company.Designation"));
        DoAffectations aTask = new DoAffectations();
        aTask.start(props);
        launch(args);
    }
}
