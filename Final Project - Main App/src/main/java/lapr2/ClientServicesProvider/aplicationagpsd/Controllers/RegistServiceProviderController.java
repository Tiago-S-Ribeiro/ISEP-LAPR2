/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Appliance;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.GeographicArea;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ApplianceRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProviderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations;

/**
 * FXML Controller class
 *
 * @author Tiago
 */
public class RegistServiceProviderController implements Initializable {

    private ApplianceRecord ar;
    private static Appliance appliance;
    private static PostalAddress postalAddress;
    private static String fullName;
    private static String abreviatedName;
    private static List<Category> lstCategories;
    private static ServiceProvider serviceProvider;
    private List<GeographicArea> lstGeographicAreas;
    private GeographicAreaRecord areaRecord;
    private AuthorizationFacade authorizationFacade;

    private static final String NEW_STATUS = "Processed";
    private static final String SERVICE_PROVIDER = "SERVICE PROVIDER";

    @FXML
    private TextField txtFieldNIF;
    @FXML
    private TextField txtFieldFullName = new TextField();
    @FXML
    private TextField txtFieldEmail;
    @FXML
    private TextField txtFieldMecanNum;
    @FXML
    private TextField txtFieldAbrevName = new TextField();
    @FXML
    private ListView<String> listViewCategories = new ListView<String>();
    @FXML
    private ListView<String> listViewCompanyAreas = new ListView<String>();
    @FXML
    private ListView<String> listViewSPAreas = new ListView<String>();
    @FXML
    private Button btnNext;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnNextArea;
    @FXML
    private Button btnCancelArea;
    @FXML
    private Button btnAddArea;
    @FXML
    private Button btnRemoveArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String location = url.toString();
        String[] fileName = location.split("/");
        if (fileName[fileName.length - 1].equals("RegistServiceProvider.fxml")) {
            txtFieldFullName.setText(fullName);
            txtFieldAbrevName.setText(abreviatedName);
            listViewCategories.getItems().clear();
            for (Category category : lstCategories) {
                listViewCategories.getItems().addAll(category.getCatDescription());
            }
            ar = Company.getApplianceRecord();
            txtFieldAbrevName.setEditable(false);
            txtFieldFullName.setEditable(false);
        } else if (fileName[fileName.length - 1].equals("RegistServiceProviderInsertGeographicArea.fxml")) {
            this.areaRecord = Company.getGeographicAreasRecord();
            this.lstGeographicAreas = new ArrayList<GeographicArea>(areaRecord.getLstGeographicAreas());
            listViewCompanyAreas.getItems().clear();
            listViewSPAreas.getItems().clear();
            for (GeographicArea ga : lstGeographicAreas) {
                listViewCompanyAreas.getItems().addAll(ga.getDesignation() + "/" + ga.getPostalCode().getPostalCode1() + "-" + ga.getPostalCode().getPostalCode2());
            }
            authorizationFacade = new AuthorizationFacade();
        } else if (fileName[fileName.length - 1].equals("RegistServiceProviderInsertNIF.fxml")) {
            ar = Company.getApplianceRecord();
        }
    }

    @FXML
    private void next(ActionEvent event) {
        if (Validations.isEmailValid(txtFieldEmail.getText()) && Validations.isNumeric(txtFieldMecanNum.getText())) {
            this.serviceProvider = newServiceProvider(txtFieldFullName.getText(), ServiceProvider.obtainPassword(), txtFieldEmail.getText(), abreviatedName, txtFieldMecanNum.getText(), postalAddress);
            serviceProvider.setCategoriesList(lstCategories);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RegistServiceProviderInsertGeographicArea.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

                // Hide this current window
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Data");
            alert.setHeaderText("Invalid Data");
            alert.setTitle("Invalid");
            alert.showAndWait();
        }
    }

    @FXML
    private void nextNIF(ActionEvent event) {
        try {
            if (!Validations.isNIFValid(txtFieldNIF.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid NIF");
                alert.setHeaderText("Invalid NIF");
                alert.setTitle("Invalid NIF");
                alert.showAndWait();
            } else {
                appliance = ar.getApplianceByNif(txtFieldNIF.getText());
                ar.ApplianceIsValid(appliance);
                fullName = appliance.getName();
                String[] separatedName = appliance.getName().split(" ");
                abreviatedName = separatedName[0] + " " + separatedName[separatedName.length - 1];
                lstCategories = appliance.getCategories();
                postalAddress = appliance.getPostalAddress();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm data?\n" + fullName + "\n" + abreviatedName + "\n" + postalAddress + "\n" + listCategories(lstCategories));
                alert.getButtonTypes().set(0, ButtonType.YES);
                alert.getButtonTypes().set(1, ButtonType.NO);
                alert.setHeaderText("Confirm data");
                alert.setTitle("Confirm data");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.YES) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RegistServiceProvider.fxml"));

                        RegistServiceProviderController controller = fxmlLoader.getController();
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.show();

                        // Hide this current window
                        ((Node) (event.getSource())).getScene().getWindow().hide();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    alert.close();
                }
            }
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, ex.getMessage());
            alert.setHeaderText("Invalid");
            alert.setTitle("Invalid");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelNIF(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/HROMenu.fxml"));
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

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setAbreviatedName(String abreviatedName) {
        this.abreviatedName = abreviatedName;
    }

    public void setListCategories(List<Category> lstCategories) {
        this.lstCategories = lstCategories;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String listCategories(List<Category> lstCategories) {
        String categories = "";
        for (Category c : lstCategories) {
            categories += c.getCatDescription() + " ";
        }
        return categories;
    }

    public ServiceProvider newServiceProvider(String fullName, String password, String institucionalEmail, String abreviatedName, String mecanographicalNumber, PostalAddress postalAddress) {
        ServiceProviderRecord spr = Company.getServiceProviderRecord();
        return spr.newServiceProvider(fullName, password, institucionalEmail, abreviatedName, mecanographicalNumber, postalAddress);
    }

    public void registServiceProvider(ServiceProvider serviceProvider) {
        ServiceProviderRecord spr = Company.getServiceProviderRecord();
        spr.registServiceProvider(serviceProvider);
    }

    @FXML
    private void cancel(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/HROMenu.fxml"));
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
    private void nextArea(ActionEvent event) throws IOException {
        try {
            if (listViewSPAreas.getItems().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "You need to select at least one ");
                alert.setHeaderText("Confirm data");
                alert.setTitle("Confirm data");
                alert.showAndWait();
            } else {
                for (String s : listViewSPAreas.getItems()) {
                    String postCode1 = s.split("/|-")[1];
                    String postCode2 = s.split("/|-")[2];
                    this.serviceProvider.getGeographicAreasList().add(areaRecord.getGeographicAreaByPostCode(postCode1, postCode2));
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you confirm the service provider?");
                alert.setHeaderText("Confirm Service Provider?");
                alert.setTitle("Confirmation");
                alert.getButtonTypes().set(0, ButtonType.YES);
                alert.getButtonTypes().set(1, ButtonType.NO);
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get() == ButtonType.YES) {
                    registServiceProvider(serviceProvider);
                    this.appliance.setStatus(NEW_STATUS);
                    authorizationFacade.registUserWithRole(serviceProvider.getInstitucionalEmail(), serviceProvider.getPassword(), RegistServiceProviderController.SERVICE_PROVIDER);
                    try {
                        FileWriter fw = new FileWriter("Passwords.txt");
                        fw.write("Email: " + serviceProvider.getEmail() + " password: " + serviceProvider.getPassword());
                        fw.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setHeaderText("Service Provider Registered with success.");
                    alert1.setTitle("Success");
                    alert1.showAndWait();
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/HROMenu.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.show();

                        // Hide this current window
                        ((Node) (event.getSource())).getScene().getWindow().hide();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    alert.close();
                }
            }
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setHeaderText("Invalid Area");
            alert.setTitle("Invalid Area");
            alert.showAndWait();
        }

    }

    @FXML
    private void cancelArea(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/HROMenu.fxml"));
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
    private void addArea(ActionEvent event) {
        listViewSPAreas.getItems().addAll(listViewCompanyAreas.getSelectionModel().getSelectedItems());
        listViewCompanyAreas.getItems().removeAll(listViewCompanyAreas.getSelectionModel().getSelectedItems());
    }

    @FXML
    private void removeArea(ActionEvent event) {
        listViewCompanyAreas.getItems().addAll(listViewSPAreas.getSelectionModel().getSelectedItems());
        listViewSPAreas.getItems().removeAll(listViewSPAreas.getSelectionModel().getSelectedItems());
    }
}
