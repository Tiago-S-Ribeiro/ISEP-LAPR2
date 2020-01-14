package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.*;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SpecifyServiceController implements Initializable {

    private static Service service;

    private List<String> serviceTypeList = new ArrayList<String>();

    private List<Category> availableCategories = new ArrayList<Category>();

    private static final String fixService = "Fix Service";

    private static final String expansivelService = "Expansivel Service";

    private static final String limitedService = "Limited Service";

    @FXML
    private Button nextBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button mainPageBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button cancelBtn2;
    @FXML
    private TextField idTXT;
    @FXML
    private TextField briefDescriptionTXT;
    @FXML
    private TextField completeDescriptionTXT;
    @FXML
    private TextField costPerHourTXT;
    @FXML
    private TextField hoursTXT;
    @FXML
    private TextField minutesTXT;
    @FXML
    private Label errorLabel;
    @FXML
    private ComboBox comboBoxServiceType;
    @FXML
    private ComboBox comboBoxCategory;
    @FXML
    private Label serviceTypeConfirmation;
    @FXML
    private Label serviceIDConfirmation;
    @FXML
    private Label labelBriefDescConfirmation;
    @FXML
    private Label labelCompleteDescConfirmation;
    @FXML
    private Label labelCostHourConfirmation;
    @FXML
    private Label labelHoursConfirmation;
    @FXML
    private Label labelMinutesConfirmation;
    @FXML
    private Label serviceCatIDConfirmation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceTypeList.add(fixService);
        serviceTypeList.add(limitedService);
        serviceTypeList.add(expansivelService);
        availableCategories.addAll(Company.getCategoryRecord().getListOfCategories());
        if (service == null) {
            comboBoxServiceType.getItems().addAll(serviceTypeList);
            comboBoxCategory.getItems().addAll(availableCategories);
        }
    }

    /**
     * Goes from the main page to the informations page.
     *
     * @param event the method ran by the 'nextPage' Button.
     */
    @FXML
    public void nextPage(ActionEvent event) {
        try {
            ServiceRecord sr = Company.getServiceRecord();
            String serviceType = (String) comboBoxServiceType.getSelectionModel().getSelectedItem();
            Category catID = (Category) comboBoxCategory.getSelectionModel().getSelectedItem();
            try {
                if (serviceType.equals(fixService)) {
                    try {
                        validateFields();
                        double cost = Integer.parseInt(costPerHourTXT.getText());
                        int hours = Integer.parseInt(hoursTXT.getText());
                        int minutes = Integer.parseInt(minutesTXT.getText());
                        service = sr.newFixService(idTXT.getText(), catID.getCatCode(), fixService, briefDescriptionTXT.getText(), completeDescriptionTXT.getText(), cost, new Time(hours, minutes));
                        System.out.println(service);

                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/SpecifyServiceConfirmation.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                            // Hide this current window
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } catch (Exception e) {
                        errorLabel.setText(e.getMessage());
                    }
                } else if (serviceType.equals(limitedService)) {
                    try {
                        validateFields();
                        double cost = Integer.parseInt(costPerHourTXT.getText());
                        service = sr.newLimitedService(idTXT.getText(), catID.getCatCode(), limitedService, briefDescriptionTXT.getText(), completeDescriptionTXT.getText(), cost);
                        System.out.println(service);

                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/SpecifyServiceConfirmation.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                            // Hide this current window
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } catch (Exception e) {
                        errorLabel.setText(e.getMessage());
                    }
                } else if (serviceType.equals(expansivelService)) {
                    try {
                        validateFields();
                        double cost = Integer.parseInt(costPerHourTXT.getText());
                        service = sr.newExpansivelService(idTXT.getText(), catID.getCatCode(), limitedService, briefDescriptionTXT.getText(), completeDescriptionTXT.getText(), cost);
                        System.out.println(service);

                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/SpecifyServiceConfirmation.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();

                            // Hide this current window
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } catch (Exception e) {
                        errorLabel.setText(e.getMessage());
                    }
                }
            } catch (Exception e) {
                errorLabel.setText("Please select a category and a service type.");
            }
        } catch (Exception e) {
            System.out.println("ERROR LOADING THE LISTS OR THE RECORD");
        }
    }

    /**
     * Cancels the specification of the Service.
     *
     * @param event the method being ran by the 'cancel' Button.
     */
    @FXML
    public void cancel(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AdminMenu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.setTitle("Administrator Menu");
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Goes from the confirmation page to the successeful operation page.
     *
     * @param event the method being ran by the 'next page 2' button.
     */
    @FXML
    public void confirmInfo(ActionEvent event) {
        try {
            ServiceRecord sr = Company.getServiceRecord();
            sr.addService(service);
            System.out.println(sr.getServices());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/SuccessfulSpecificationService.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.setTitle("Successful Operation");
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cancels the confirmation of information and goes back to the Admin Menu.
     *
     * @param event the method being ran by the 'cancl2' button.
     */
    @FXML
    public void cancel2(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AdminMenu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.setTitle("Administrator Menu");
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates the input fields.
     */
    @FXML
    private void validateFields() {
        if (!Validations.isNumeric(costPerHourTXT.getText())) {
            throw new IllegalArgumentException("The cost per hour is not a number.");
        }
        if (!Validations.isNumeric(hoursTXT.getText())) {
            throw new IllegalArgumentException("The hours inserted are not a number.");
        }
        if (!Validations.isNumeric(minutesTXT.getText())) {
            throw new IllegalArgumentException("The minutes inserted are not a number.");
        }
        if (Integer.parseInt(costPerHourTXT.getText()) < 0) {
            throw new IllegalArgumentException("The cost per hour is not a valid price (bigger then 0€).");
        }
        if (Integer.parseInt(hoursTXT.getText()) < 0) {
            throw new IllegalArgumentException("The hours inserter need to be a valid number (bigger then 0).");
        }
        if (Integer.parseInt(minutesTXT.getText()) < 0) {
            throw new IllegalArgumentException("The minutes inserted need to be a valid number (bigger then 0)");
        }
    }

    /**
     * Loads the information for the user to confirm.
     *
     * @param event the method being ran by the 'loadInformation' button.
     */
    @FXML
    public void loadInfoConfirmation(ActionEvent event) {
        try {
            serviceTypeConfirmation.setText(service.getServiceType());
            serviceIDConfirmation.setText(service.getServID());
            labelBriefDescConfirmation.setText(service.getBriefDescription());
            labelCompleteDescConfirmation.setText(service.getCompleteDescription());
            labelCostHourConfirmation.setText(String.valueOf(service.getHourCost()));
            if (service.getServiceType().equalsIgnoreCase(fixService)) {
                FixService tempService = (FixService) service;
                labelHoursConfirmation.setText(String.valueOf(tempService.getEstimatedDuration().getHours()));
                labelMinutesConfirmation.setText(String.valueOf(tempService.getEstimatedDuration().getMinutes()));
            }
            serviceCatIDConfirmation.setText(service.getCatID());
        } catch (Exception e) {
            errorLabel.setText("ERROR: Couldn't load the information.");
        }
    }

    /**
     * Goes back to the adminMenu page.
     *
     * @param event the method being ran by the 'backtomainpage' button.
     */
    @FXML
    public void backToMainPage(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AdminMenu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.setTitle("Administrator Menu");
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
