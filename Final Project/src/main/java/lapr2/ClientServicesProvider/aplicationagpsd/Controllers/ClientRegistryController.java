package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ClientRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostCode;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isAddressValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isEmailValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isLocalityValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isNIFValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isNameValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isPhoneValid;

/**
 * FXML Controller class
 *
 * @author Tiago Ribeiro (1181444)
 */
public class ClientRegistryController implements Initializable {

    @FXML
    private Client cli;

    @FXML
    private Button cancelBtn;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField nifTxt;
    @FXML
    private TextField phoneTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private PasswordField pwdTxt;
    @FXML
    private TextField addressTxt;
    @FXML
    private TextField localityTxt;
    @FXML
    private TextField postal1Txt;
    @FXML
    private TextField postal2Txt;
    @FXML
    private TextField address2Txt;
    @FXML
    private TextField locality2Txt;
    @FXML
    private TextField postal12Txt;
    @FXML
    private TextField postal22Txt;
    @FXML
    private Button nextBtn;
    @FXML
    private Button addAddressBtn;
    @FXML
    private Button finishBtn;
    @FXML
    private Label successLbl;
    @FXML
    private Label finishLbl;
    @FXML
    private Label invalidInfoLbl;
    @FXML
    private Label invalidInfo2Lbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * @return the client
     */
    public Client getCli() {
        return cli;
    }

    /**
     * @param cli the client to set
     */
    public void setCli(Client cli) {
        this.cli = cli;
    }

    @FXML
    private void cancel(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InitialPage.fxml"));
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
    private void newClient(ActionEvent event) {
        try {

            Client cli = new Client();
            PostalAddress pa = new PostalAddress();
            PostCode pc = new PostCode();
            ClientRecord cr = Company.getClientRecord();
            AuthorizationFacade af = new AuthorizationFacade();
            
            pc = pa.newPostCode(postal1Txt.getText(), postal2Txt.getText());
            pa = cli.newPostalAddress(addressTxt.getText(), localityTxt.getText(), pc);
            cli = cr.newClient(nameTxt.getText(), emailTxt.getText(), pwdTxt.getText(), nifTxt.getText(), phoneTxt.getText(), pa);

            if (isEmailValid(emailTxt.getText()) == true && isNIFValid(nifTxt.getText()) == true && isNameValid(nameTxt.getText()) == true && isPhoneValid(phoneTxt.getText()) == true && isAddressValid(addressTxt.getText()) == true && isLocalityValid(localityTxt.getText()) == true && cr.validatesClient(cli)==true) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientRegistryAddressInclusion.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Client Registry");
                stage.setScene(new Scene(root1));
                stage.show();

                ClientRegistryController controller = fxmlLoader.getController();
                af.registUserWithRole(emailTxt.getText(), pwdTxt.getText(), "CLIENT");
                controller.setCli(cli);
                cr.addClient(cli);
                
                
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
                invalidInfoLbl.setText("The information you provided is not valid or already exists. Please confirm the fields above.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException r) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ("Please provide valid information."));
            alert.setTitle("Error");
            alert.setHeaderText("Incorrect postal address information.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void finish(ActionEvent event) throws InterruptedException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InitialPage.fxml"));
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
    private void newPostalAddress(ActionEvent event) {
        try {
            PostalAddress pa = new PostalAddress();
            PostCode pc = new PostCode();

            pc = pa.newPostCode(postal12Txt.getText(), postal22Txt.getText());
            pa = cli.newPostalAddress(address2Txt.getText(), locality2Txt.getText(), pc);
            cli.addPostalAddress(cli, pa);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientRegistryAddressInclusion.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

                ClientRegistryController c = fxmlLoader.getController();
                c.setCli(cli);

                ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException r) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ("Please provide valid information."));
            alert.setTitle("Error");
            alert.setHeaderText("Incorrect postal address information.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
}
