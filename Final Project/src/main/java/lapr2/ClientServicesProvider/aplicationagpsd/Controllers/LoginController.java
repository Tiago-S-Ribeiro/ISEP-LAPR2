/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;

/**
 * FXML Controller class
 *
 * @author berna
 */
public class LoginController implements Initializable {

    private static final String CLIENT_ROLE = "CLIENT";
    private static final String ADMINISTRATOR_ROLE = "ADMINISTRATOR";
    private static final String SP_ROLE = "SERVICE PROVIDER";
    private static final String HRO_ROLE = "HUMAN RESOURCES OPERATOR";

    @FXML
    private Button enterBtn;
    @FXML
    private Button backBtn;
    @FXML
    private TextField txtFieldUsername;
    @FXML
    private PasswordField txtFieldPassword;
    @FXML
    private Label incorrectPassUserLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void enter(ActionEvent event) {
        try {
            AuthorizationFacade af = new AuthorizationFacade();
            af.doLogin(txtFieldUsername.getText(), txtFieldPassword.getText());
            if (AuthorizationFacade.getSessaoAtual().isLoggedInWithPart(CLIENT_ROLE)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Application AGPSD");
                stage.setResizable(false);
                stage.show();

                // Hide this current window
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (af.getSessaoAtual().isLoggedInWithPart(ADMINISTRATOR_ROLE)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AdminMenu.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Application AGPSD");
                stage.setResizable(false);
                stage.show();

                // Hide this current window
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (af.getSessaoAtual().isLoggedInWithPart(SP_ROLE)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ServiceProviderMenu.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Application AGPSD");
                stage.setResizable(false);
                stage.show();

                // Hide this current window
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (af.getSessaoAtual().isLoggedInWithPart(HRO_ROLE)) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/HROMenu.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Application AGPSD");
                stage.setResizable(false);
                stage.show();

                // Hide this current window
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException ex){
            incorrectPassUserLbl.setText("Email or password incorrect.");
            txtFieldPassword.clear();
            txtFieldUsername.clear();
        }
    }

    @FXML
    private void back(ActionEvent event) {
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
