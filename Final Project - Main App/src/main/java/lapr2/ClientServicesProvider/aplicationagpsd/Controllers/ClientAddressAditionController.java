package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.model.UserSession;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostCode;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ClientRecord;

/**
 * FXML Controller class
 *
 * @author berna
 */
public class ClientAddressAditionController implements Initializable {

    private Client cli;
    
    @FXML
    private TextField address2Txt;
    @FXML
    private TextField locality2Txt;
    @FXML
    private TextField postal12Txt;
    @FXML
    private TextField postal22Txt;
    @FXML
    private Button addAddressBtn;
    @FXML
    private Button finishBtn;
    @FXML
    private Label successLbl;
    @FXML
    private Label finishLbl;
    @FXML
    private Label invalidInfo2Lbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserSession session = AuthorizationFacade.getSessaoAtual();
        String email = session.getUserEmail();
        ClientRecord cr = Company.getClientRecord();
        Client cl = cr.getClientByEmail(email);
        setCli(cl);
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

    @FXML
    private void newPostalAddress(ActionEvent event) {
        try {
            PostalAddress pa = new PostalAddress();
            PostCode pc = new PostCode();

            pc = pa.newPostCode(postal12Txt.getText(), postal22Txt.getText());
            pa = getCli().newPostalAddress(address2Txt.getText(), locality2Txt.getText(), pc);
            getCli().addPostalAddress(getCli(), pa);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientAddressAditionUI.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();

                ClientAddressAditionController c = fxmlLoader.getController();
                c.setCli(getCli());

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

    @FXML
    private void finish(ActionEvent event) {
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
    
}
