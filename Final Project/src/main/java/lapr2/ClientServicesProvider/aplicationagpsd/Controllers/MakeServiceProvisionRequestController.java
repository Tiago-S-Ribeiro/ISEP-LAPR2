/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.model.UserSession;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.CategoryRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ClientRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.FixService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.RequestedServiceDescription;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Schedule;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Service;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvisionRequest;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProvisionRequestRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations;

/**
 * FXML Controller class
 *
 * @author berna
 */
public class MakeServiceProvisionRequestController implements Initializable {
    
    @FXML
    private Client cli;
    
    @FXML
    private ServiceProvisionRequest spr;
    
    @FXML
    private Button cancelBtn;
    
    // postal codes atributes
    @FXML
    private ComboBox<String> postalAddresses;
    
    @FXML
    private Button paNext;
    
    // services atributes
    @FXML
    private Button addServiceBtn;
    
    @FXML
    private Button cNext;
    
    @FXML
    private ComboBox<String> categories;
    
    @FXML
    private ComboBox<String> services;
    
    @FXML
    private TextArea description;
    
    @FXML
    private ComboBox<Integer> durationH;
    
    @FXML
    private ComboBox<Integer> durationM;
    
    // schedule atributes
    @FXML
    private DatePicker date;
    
    @FXML
    private ComboBox<Integer> timeH;
    
    @FXML
    private ComboBox<Integer> timeM;
    
    @FXML
    private Button addScheduleBtn;
    
    @FXML
    private Button finishBtn;
    
    // cost attributes
    @FXML
    private Button confirmBtn;
    
    @FXML
    private Label postalAddressLbl;
    
    @FXML
    private ListView<String> servicesListView;
    
    @FXML
    private ListView<String> schedulesListView;
    
    @FXML
    private Label costLbl;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param resources
     */
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        String location = url.toString();
        System.out.println(location);
        String[] fileName = location.split("/");
        if(fileName[fileName.length - 1].equals("MakeServiceProvisionRequestUI.fxml")){
            List<PostalAddress> pal = newRequest();
            
            for(PostalAddress pa : pal){
                postalAddresses.getItems().addAll(pa.getAddress()+", "+pa.getLocality()+", "+pa.getPostCode().getPostalCode1()+"-"+pa.getPostCode().getPostalCode2());
            }
            
        }
        else if(fileName[fileName.length - 1].equals("MakeServiceProvisionRequest_ServiceUI.fxml")){
            durationH.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            durationM.getItems().addAll(0, 30);
            durationH.getSelectionModel().select(0);
            durationM.getSelectionModel().select(1);
            durationM.setDisable(true);
            durationM.setStyle("-fx-opacity: 1;");
            List<Category> cList = getCategories();
            for(Category category : cList){
                categories.getItems().addAll(category.getCatCode()+". "+category.getCatDescription());
            }
            
        }
        else if(fileName[fileName.length - 1].equals("MakeServiceProvisionRequest_ScheduleUI.fxml")){
            timeH.getItems().addAll(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);
            timeM.getItems().addAll(0, 30);
            timeH.getSelectionModel().select(0);
            timeM.getSelectionModel().select(1);   
        }
        else if(fileName[fileName.length - 1].equals("MakeServiceProvisionRequest_CostUI.fxml")){
            Platform.runLater(() -> {
                
                ServiceProvisionRequest spreq = getSpr();
                postalAddressLbl.setText(spreq.getpAdd().getAddress()+", "+spreq.getpAdd().getLocality()+", "+spreq.getpAdd().getPostCode().getPostalCode1()+" - "+spreq.getpAdd().getPostCode().getPostalCode2());
                List<RequestedServiceDescription> rsdList = spreq.getRequestedServicesDecriptionList();
                for(RequestedServiceDescription description : rsdList){
                    servicesListView.getItems().add("Service: "+description.getService().getServiceType()+". Description: "+description.getDescription()+". Duration: "+description.getDuration().getHours()+":"+description.getDuration().getMinutes()+".");
                }
                List<Schedule> schedulesList = spreq.getSchedulesList();
                for(Schedule schedule : schedulesList){
                    schedulesListView.getItems().add("Preferencial Order: "+schedule.getOrder()+"Date: "+schedule.getDay().getYear()+"/"+schedule.getDay().getMonth()+"/"+schedule.getDay().getDay()+". Time: "+schedule.getBeginingHour().getHours()+":"+schedule.getBeginingHour().getMinutes()+".");
                }
                String totalCost = ""+spreq.getTotalCost();
                costLbl.setText(totalCost+" euros.");
                servicesListView.setDisable(true);
                schedulesListView.setDisable(true);
                servicesListView.setStyle("-fx-opacity: 1;");
                schedulesListView.setStyle("-fx-opacity: 1;");
            });
        }
    }    

    /**
     * @return the cli
     */
    public Client getCli() {
        return cli;
    }

    /**
     * @param cli the cli to set
     */
    public void setCli(Client cli) {
        this.cli = cli;
    }
    
    /**
     * @return the spr
     */
    public ServiceProvisionRequest getSpr() {
        return spr;
    }

    /**
     * @param spr the spr to set
     */
    public void setSpr(ServiceProvisionRequest spr) {
        this.spr = spr;
    }
    
    @FXML
    private void setPostalAdd(ActionEvent event) {
        try{
            String postalAddress = postalAddresses.getValue();
            String[] postalAddressParts = postalAddress.split(", ");
            String[] postCodeParts = postalAddressParts[3].split("-");
            Client client = getCli();
            PostalAddress pAdd = client.getPostalAddress(postalAddressParts[0], postalAddressParts[1], postCodeParts[0], postCodeParts[1]);
            ServiceProvisionRequestRecord reqr = Company.getRequestRecord();
            ServiceProvisionRequest spreq = reqr.newRequest(client, pAdd);
            spr = new ServiceProvisionRequest(spreq);

            try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MakeServiceProvisionRequest_ServiceUI.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                MakeServiceProvisionRequestController c = fxmlLoader.getController();
                c.setCli(getCli());
                c.setSpr(getSpr());

                ((Node)(event.getSource())).getScene().getWindow().hide();

                stage.setOnCloseRequest((WindowEvent event1) -> {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
                            Parent root1;
                            root1 = (Parent) loader.load();
                            Stage stage1 = new Stage();
                            stage1.setScene(new Scene(root1));
                            stage1.show();

                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch(NullPointerException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select one of your postal addresses.");
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
            postalAddresses.requestFocus();
        }
    }
    
    @FXML
    private void categoriesChanged(ActionEvent event) {
            durationH.setDisable(false);
            if(durationH.getValue() != 0 && durationH.getValue() != 16){
                durationM.setDisable(false);
            }
            int hours = durationH.getValue();
            int minutes = durationM.getValue();
            boolean disable = durationM.isDisabled();
            durationH.getItems().clear();
            durationM.getItems().clear();
            durationH.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            durationM.getItems().addAll(0, 30);
            durationH.setValue(hours);
            durationM.setValue(minutes);
            durationM.setDisable(disable);
            durationM.setStyle("-fx-opacity: 1;");
            
            services.getItems().clear();
            String selectedCat = categories.getValue();
            String[] selectedCatParts = selectedCat.split(". ");
            String catId = selectedCatParts[0];
            List<Service> sl = getCategoryServices(catId);
            for(Service service : sl){
                services.getItems().addAll(service.getServID()+". "+service.getBriefDescription());
            }
                 
    }
    
    @FXML
    private void servicesChanged(ActionEvent event) {
        if(categories.getValue() != null && services.getValue() != null){
            int hours = durationH.getValue();
            int minutes = durationM.getValue();
            boolean disable = durationM.isDisabled();
            durationH.getItems().clear();
            durationM.getItems().clear();
            String[] catId = categories.getValue().split(". ");
            String[] servId = services.getValue().split(". ");
            ServiceRecord sr = Company.getServiceRecord();
            Service s = sr.getServiceById(catId[0], servId[0]);
            if(s instanceof FixService){
                FixService fs = (FixService) s;
                durationH.getItems().addAll(fs.getEstimatedDuration().getHours());
                durationH.getSelectionModel().select(0);
                durationH.setDisable(true);
                durationH.setStyle("-fx-opacity: 1;");
                durationM.getItems().addAll(fs.getEstimatedDuration().getMinutes());
                durationM.getSelectionModel().select(0);
                durationM.setDisable(true);
                durationM.setStyle("-fx-opacity: 1;");
            }
            else{
                durationH.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
                durationM.getItems().addAll(0, 30);
                durationH.setValue(hours);
                durationM.setValue(minutes);
                durationM.setDisable(disable);
                durationM.setStyle("-fx-opacity: 1;");
            }
        }
    }
    
    @FXML
    private void durationHChanged(ActionEvent event){
        if(durationH.getValue() != null){
        durationM.setDisable(false);
            if(durationH.getValue() == 0){
                durationM.getSelectionModel().select(1);
                durationM.setDisable(true);
                durationM.setStyle("-fx-opacity: 1;");
            }
            else if(durationH.getValue() == 16){
                durationM.getSelectionModel().select(0);
                durationM.setDisable(true);
                durationM.setStyle("-fx-opacity: 1;");
            }
        }
    }
    
    @FXML
    private void addService(ActionEvent event) {
        try{
            String[] catId = categories.getValue().split(". ");
            String[] servId = services.getValue().split(". ");
            Time duration = new Time(durationH.getValue(), durationM.getValue());
            addRequestedServiceDescription(catId[0], servId[0], description.getText(), duration);

            try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MakeServiceProvisionRequest_ServiceUI.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                
                MakeServiceProvisionRequestController c = fxmlLoader.getController();
                c.setCli(getCli());
                c.setSpr(getSpr());

                ((Node)(event.getSource())).getScene().getWindow().hide();

                stage.setOnCloseRequest((WindowEvent event1) -> {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
                            Parent root1;
                            root1 = (Parent) loader.load();
                            Stage stage1 = new Stage();
                            stage1.setScene(new Scene(root1));
                            stage1.show();

                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(NullPointerException | IllegalArgumentException e){
            StringBuilder failures = new StringBuilder();
            if(categories.getValue() == null){
                failures.append("Category is missing.\n");
            }
            if(services.getValue() == null){
                failures.append("Service is missing.\n");
            }
            if(description.getText().equals("")){
                failures.append("Descrption is missing.\n");
            }
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter the following requiered data:\n"+failures.toString());
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
    @FXML
    private void cNext(ActionEvent event){
        ServiceProvisionRequest spr = getSpr();
        if(!spr.getRequestedServicesDecriptionList().isEmpty()){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MakeServiceProvisionRequest_ScheduleUI.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                
                MakeServiceProvisionRequestController c = fxmlLoader.getController();
                c.setCli(getCli());
                c.setSpr(getSpr());

                ((Node)(event.getSource())).getScene().getWindow().hide();
                
                stage.setOnCloseRequest((WindowEvent event1) -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
                        Parent root1;
                        root1 = (Parent) loader.load();
                        Stage stage1 = new Stage();
                        stage1.setScene(new Scene(root1));
                        stage1.show();
                        
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have to introduce at least one service to continue.");
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
    @FXML
    private void addPrefSchedule(ActionEvent event){
        try{
        LocalDate localDate = date.getValue();
        String [] day = localDate.toString().trim().split("-");
        Date prefDay = new Date(Integer.parseInt(day[0]),Integer.parseInt(day[1]),Integer.parseInt(day[2]));
        Time beginingHour = new Time(timeH.getValue(), timeM.getValue());
        if(Validations.isPreferentialDateValid(prefDay.getYear(), prefDay.getMonth(), prefDay.getDay()) == false){
            throw new IllegalArgumentException();
        }
        if(prefDay.weekDay().equalsIgnoreCase("Sunday")){
            throw new IllegalArgumentException("At Sundays this company doesn't work.\nPlease choose another day.");
        }
        addSchedule(prefDay, beginingHour);
            try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MakeServiceProvisionRequest_ScheduleUI.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

                    MakeServiceProvisionRequestController c = fxmlLoader.getController();
                    c.setCli(getCli());
                    c.setSpr(getSpr());

                    ((Node)(event.getSource())).getScene().getWindow().hide();

                    stage.setOnCloseRequest((WindowEvent event1) -> {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
                            Parent root1;
                            root1 = (Parent) loader.load();
                            Stage stage1 = new Stage();
                            stage1.setScene(new Scene(root1));
                            stage1.show();

                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                    } catch (IOException e) {
                    e.printStackTrace();
                }
        } catch(NullPointerException | IllegalArgumentException e){
            String message;
            if(e.getMessage() != null){
                message = e.getMessage();
            }
            else{
                if(date.getValue() == null){
                    message = "Date is missing. Please enter a preferential date.";
                }
                else{
                    message = "Please incert a valid date.";
                }
            }
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
    @FXML
    private void finish(ActionEvent event){
        ServiceProvisionRequest spr = getSpr();
        if(!spr.getSchedulesList().isEmpty()){
            if(validate(spr) == true){
                try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MakeServiceProvisionRequest_CostUI.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();

                        MakeServiceProvisionRequestController c = fxmlLoader.getController();
                        c.setCli(getCli());
                        c.setSpr(getSpr());

                        ((Node)(event.getSource())).getScene().getWindow().hide();

                        stage.setOnCloseRequest((WindowEvent event1) -> {
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
                                Parent root1;
                                root1 = (Parent) loader.load();
                                Stage stage1 = new Stage();
                                stage1.setScene(new Scene(root1));
                                stage1.show();

                                ((Node)(event.getSource())).getScene().getWindow().hide();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        });
                        } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Request already exists.");
                alert.setTitle("Error");
                alert.setHeaderText("Invalid!!");
                Optional<ButtonType> result = alert.showAndWait();
                try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
                        Parent root1;
                        root1 = (Parent) loader.load();
                        Stage stage1 = new Stage();
                        stage1.setScene(new Scene(root1));
                        stage1.show();

                            ((Node)(event.getSource())).getScene().getWindow().hide();
                    } catch (IOException ex) {
                            ex.printStackTrace();
                    }
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have to introduce at least one schedule to continue.");
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
    @FXML
    private void confirm(ActionEvent event){
        ServiceProvisionRequest spr = getSpr();
        int requestNumber = registerRequest(spr);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Service Provision Request registed with success!\nThe number of the request is: "+requestNumber+".");
        alert.setTitle("Info");
        alert.setHeaderText("Done!");
        Optional<ButtonType> result = alert.showAndWait();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void cancel(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<PostalAddress> newRequest(){
        UserSession session = AuthorizationFacade.getSessaoAtual();
        String email = session.getUserEmail();
        ClientRecord cr = Company.getClientRecord();
        Client cl = cr.getClientByEmail(email);
        List<PostalAddress> pal = cl.getAddressList();
        cli = cl;
        
        return pal;
    }
    
    public List<Category> getCategories(){
        CategoryRecord catR = Company.getCategoryRecord();
        List<Category> catL = catR.getListOfCategories();
        
        return catL;
    }
    
    public List<Service> getCategoryServices(String catId){
        ServiceRecord catR = Company.getServiceRecord();
        List<Service> servList = catR.getCategoryServices(catId);
        
        return servList;
    }
    
    public void addRequestedServiceDescription(String idCat, String idServ, String description, Time duration){
        ServiceRecord sr = Company.getServiceRecord();
        Service s = sr.getServiceById(idCat, idServ);
        ServiceProvisionRequest spreq = getSpr();
        RequestedServiceDescription rsd = spreq.addRequestedServiceDescription(s, description, duration);
        Boolean validateDescription = spreq.validateRequestedServiceDescription(rsd);
        if(validateDescription == true){
            Boolean addDescription = spreq.addRequestedServiceDescription(rsd);
            if(addDescription == true){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Service added with success.");
                alert.setTitle("Info");
                alert.setHeaderText("Done!");
                Optional<ButtonType> result = alert.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong because the service wasn't added.");
                alert.setTitle("Error");
                alert.setHeaderText("Error!!");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have incerted an already existing service. Please try again.");
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
    public void addSchedule(Date day, Time beginingHour){
        ServiceProvisionRequest spr = getSpr();
        Schedule schedule = spr.addSchedule(day, beginingHour);
        Boolean validateSchedule = spr.validateSchedule(schedule);
        if(validateSchedule == true){
            Boolean addSchedule = spr.addSchedule(schedule);
            if(addSchedule == true){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Schedule added with success.");
                alert.setTitle("Info");
                alert.setHeaderText("Done!");
                Optional<ButtonType> result = alert.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong because the schedule wasn't added.");
                alert.setTitle("Error");
                alert.setHeaderText("Error!!");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have incerted an already existing schedule. Please try again.");
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
    public boolean validate(ServiceProvisionRequest spr){
        ServiceProvisionRequestRecord sprr = Company.getRequestRecord();
        if(sprr.validateRequest(spr) == true){
            return true;
        }
        return false;
    }
    
    public int registerRequest(ServiceProvisionRequest spreq){
        ServiceProvisionRequestRecord sprr = Company.getRequestRecord();
        int requestNumber = sprr.registerRequest(spreq);
        return requestNumber;
    }
    
}