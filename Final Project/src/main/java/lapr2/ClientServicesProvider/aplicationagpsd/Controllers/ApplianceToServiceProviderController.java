package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.*;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ApplianceRecord;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class for the Appliance for Service Provider.
 *
 * @author Rafael Moreira 1180778
 */
public class ApplianceToServiceProviderController implements Initializable {

    private static Appliance appliance;

    @FXML
    private TextField nameTXT;
    @FXML
    private TextField nifTXT;
    @FXML
    private TextField phoneTXT;
    @FXML
    private TextField emailTXT;
    @FXML
    private TextField addressTXT;
    @FXML
    private TextField firstPartPostalCodeTXT;
    @FXML
    private TextField secondPartPostalCodeTXT;
    @FXML
    private TextField localityTXT;
    @FXML
    private Button nextBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Label labelErrorAppliance;
    @FXML
    private TextField degreeTXT;
    @FXML
    private TextField designationTXT;
    @FXML
    private TextField classificationTXT;
    @FXML
    private TextField descriptionTXT;
    @FXML
    private Button addAcademicBTN;
    @FXML
    private Button addProfessionalBTN;
    @FXML
    private Button nextBtn2;
    @FXML
    private Button cancelBtn2;
    @FXML
    private ListView<AcademicQualification> listViewAcademic;
    @FXML
    private ListView<ProfessionalQualification> listViewProfessional;
    @FXML
    private Button nextBtn3;
    @FXML
    private Button cancelBtn3;
    @FXML
    private Label labelError;
    @FXML
    private ListView<Category> listViewAvailableCategories;
    @FXML
    private ListView<Category> listViewSelectedCategories;
    @FXML
    private Button loadCategoriesBtn;
    @FXML
    private ListView<Category> listViewCategoriesConfirmation;
    @FXML
    private ListView<AcademicQualification> listViewAcademicConfirmation;
    @FXML
    private ListView<ProfessionalQualification> listViewProfessionalConfirmation;
    @FXML
    private Label nameLabel;
    @FXML
    private Label nifLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label postal1Label;
    @FXML
    private Label postal2Label;
    @FXML
    private Label localityLabel;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button discardBtn;
    @FXML
    private Button mainPageBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (listViewAcademic != null && listViewProfessional != null && appliance != null) {
            listViewAcademic.getItems().clear();
            listViewProfessional.getItems().clear();

            listViewAcademic.getItems().addAll(appliance.getAcademicQualifications());
            listViewProfessional.getItems().addAll(appliance.getProfessionalQualifications());
        }
    }

    /**
     * Goes from the main information page to the academic and professional page.
     *
     * @param event method that the button 'next' runs.
     */
    @FXML
    private void nextPage(ActionEvent event) {
        ApplianceRecord cr = Company.getApplianceRecord();
        try {
            appliance = cr.newAppliance(nameTXT.getText(), nifTXT.getText(), phoneTXT.getText(), emailTXT.getText());
            appliance.addPostalAddress(addressTXT.getText(), localityTXT.getText(), firstPartPostalCodeTXT.getText(), secondPartPostalCodeTXT.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AcademicProfessionalQualifications.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Academic and Professional Qualifications");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            labelErrorAppliance.setText(e.getMessage());
        }
    }

    /**
     * Goes from the academic and professional page to the choose category page.
     *
     * @param event method that the 'next2' button runs.
     */
    @FXML
    private void nextPage2(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ChooseCategory.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Choose the categories:");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("ERROR LOADING PAGE OF CHOOSE CATEGORY\n");
            e.printStackTrace();
        }
    }

    /**
     * Goes from the choose category page to the confirmation page.
     *
     * @param event method that the 'next3' button runs.
     */
    @FXML
    private void nextPage3(ActionEvent event) {
        try {
            FXMLLoader fxmlLoaderConfirmation = new FXMLLoader(getClass().getResource("/fxml/ApplianceToServiceProviderConfirmation.fxml"));
            Parent root = (Parent) fxmlLoaderConfirmation.load();
            Stage stage = new Stage();
            stage.setTitle("Confirm your appliance:");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("ERROR LOADING PAGE OF CONFIRMATION\n");
            e.printStackTrace();
        }
    }

    /**
     * Goes from the main information page to the initial page.
     *
     * @param event method that the button 'cancel' runs.
     */
    @FXML
    private void cancel(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InitialPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Application AGPSD");
            stage.setResizable(false);
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Goes from the academic and professional page to the initial page.
     *
     * @param event method that the button 'cancel2' runs.
     */
    @FXML
    private void cancel2(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InitialPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Application AGPSD");
            stage.setResizable(false);
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Goes from the choose category page to the academic and professional page.
     *
     * @param event method that the 'cancel3' button runs.
     */
    @FXML
    private void cancel3(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AcademicProfessionalQualifications.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Academic and Professional Qualifications");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("ERROR GOING BACK TO ACADEMIC PROFESSIONAL PAGE");
            e.printStackTrace();
        }
    }

    /**
     * Adds an academic qualification to the list when the button is clicked and the parameters are not empty.
     *
     * @param event the button being clicked.
     */
    @FXML
    private void addAcademicQualification(ActionEvent event) {
        try {
            appliance.addAcademicQualification(new AcademicQualification(degreeTXT.getText(), designationTXT.getText(), classificationTXT.getText()));
            listViewAcademic.getItems().clear();
            listViewAcademic.getItems().addAll(appliance.getAcademicQualifications());
        } catch (Exception e) {
            System.out.println("error in academic add");
            e.printStackTrace();
        }
    }

    /**
     * Adds a professional qualification to the list when the button is clicked and the description is not empty.
     *
     * @param event the button being clicked.
     */
    @FXML
    private void addProfessionalQualification(ActionEvent event) {
        try {
            appliance.addProfessionalQualification(new ProfessionalQualification(descriptionTXT.getText()));
            listViewProfessional.getItems().clear();
            listViewProfessional.getItems().addAll(appliance.getProfessionalQualifications());
        } catch (Exception e) {
            System.out.println("error in professional add");
            e.printStackTrace();
        }
    }

    /**
     * Lods the available categories when the user clicks the button.
     *
     * @param event the method being run by the button 'loadCategoriesBtn'.
     */
    @FXML
    private void loadAvailableCategories(ActionEvent event) {
        try {
            ObservableList<Category> listAvailableCategories = FXCollections.observableArrayList(Company.getCategoryRecord().getListOfCategories());
            listViewAvailableCategories.setItems(listAvailableCategories);
            listViewAvailableCategories.getSelectionModel().selectFirst();
            listViewAvailableCategories.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Category>() {
                @Override
                public void changed(ObservableValue<? extends Category> observable, Category oldValue, Category newValue) {
                    appliance.addCategory(newValue);
                    ObservableList<Category> listSelectedCategories = FXCollections.observableArrayList(appliance.getCategories());
                    listViewSelectedCategories.getItems().clear();
                    listViewSelectedCategories.setItems(listSelectedCategories);
                }
            });
        } catch (Exception e) {
            System.out.println("ERROR LOADING AVAILABLE CATEGORIES");
            e.printStackTrace();
        }
    }

    /**
     * Loads the information for the user to confirm.
     *
     * @param event the method being ran by the 'load information button'.
     */
    @FXML
    private void loadInfoConfirmation(ActionEvent event) {
        try {
            nameLabel.setText(appliance.getName());
            nifLabel.setText(appliance.getNif());
            phoneLabel.setText(appliance.getPhone());
            emailLabel.setText(appliance.getEmail());
            addressLabel.setText(appliance.getPostalAddress().getAddress());
            postal1Label.setText(appliance.getPostalAddress().getPostCode().getPostalCode1());
            postal2Label.setText(appliance.getPostalAddress().getPostCode().getPostalCode2());
            localityLabel.setText(appliance.getPostalAddress().getLocality());

            ObservableList<Category> listSelectedCategories = FXCollections.observableArrayList(appliance.getCategories());
            ObservableList<AcademicQualification> listAcademicQualifications = FXCollections.observableArrayList(appliance.getAcademicQualifications());
            ObservableList<ProfessionalQualification> listProfessionalQualifications = FXCollections.observableArrayList(appliance.getProfessionalQualifications());
            listViewCategoriesConfirmation.setItems(listSelectedCategories);
            listViewAcademicConfirmation.setItems(listAcademicQualifications);
            listViewProfessionalConfirmation.setItems(listProfessionalQualifications);
        } catch (Exception e) {
            System.out.println("ERROR LOADING THE INFORMATION TO CONFIRM!");
        }
    }

    /**
     * Confirms an appliance to Service Provider.
     *
     * @param event the method being ran by the 'confirmAppliance' button.
     */
    @FXML
    private void confirmAppliance(ActionEvent event) {
        try {
            Company.getApplianceRecord().add(appliance);
            System.out.println(Company.getApplianceRecord().getListOfAppliances());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/SuccessfulAppliance.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Successful Appliance");
            stage.setResizable(false);
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Discards an appliance to Service Provider.
     *
     * @param event the method being ran by the 'discardAppliance' button.
     */
    @FXML
    private void discardAppliance(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InitialPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Application AGPSD");
            stage.setResizable(false);
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Goes back to the main page of the application after the confirmation.
     *
     * @param event the method being ran by the 'mainPageBtn' button.
     */
    @FXML
    private void backToMainPage(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InitialPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Application AGPSD");
            stage.setResizable(false);
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
