/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.GeographicArea;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.GeographicAreaRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.GeographicAreaRepetedException;

/**
 * FXML Controller class
 *
 * @author Tiago
 */
public class RegistGeographicAreaController implements Initializable {

    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtFieldZipCodeFirstDigits;
    @FXML
    private TextField txtFieldDesignation;
    @FXML
    private TextField txtFieldCostOfTravel;
    @FXML
    private TextField txtFieldRadius;
    @FXML
    private TextField txtFieldZipCodeSecondDigits;

    private GeographicArea ga;
    @FXML
    private Label lblOutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void confirmar(ActionEvent event) {
        try {
            newGeographicArea(txtFieldDesignation.getText(), Float.parseFloat(txtFieldCostOfTravel.getText()), txtFieldZipCodeFirstDigits.getText(), txtFieldZipCodeSecondDigits.getText(), Double.parseDouble(txtFieldRadius.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, ga.toString());
            alert.setTitle("Success");
            alert.setHeaderText("Do you confirm it?");
            Optional<ButtonType> result = alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                registGeographicArea(ga);
                Alert success = new Alert(Alert.AlertType.INFORMATION, "Geographic area crated and added to the list with success.");
                success.setHeaderText("Successful Operation");
                Optional<ButtonType> res = success.showAndWait();
                txtFieldZipCodeFirstDigits.clear();
                txtFieldZipCodeFirstDigits.requestFocus();
                txtFieldCostOfTravel.clear();
                txtFieldDesignation.clear();
                txtFieldRadius.clear();
                txtFieldZipCodeSecondDigits.clear();
            }
        } catch (GeographicAreaRepetedException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
            txtFieldZipCodeFirstDigits.requestFocus();
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
            txtFieldZipCodeFirstDigits.requestFocus();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ("Invalid Data"));
            alert.setTitle("Error");
            alert.setHeaderText("Incorrect!!");
            Optional<ButtonType> result = alert.showAndWait();
            txtFieldZipCodeFirstDigits.requestFocus();
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AdminMenu.fxml"));
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

    public void newGeographicArea(String designation, float cost, String postalCode1, String postalCode2, double radius) {
        GeographicAreaRecord rga = Company.getGeographicAreasRecord();
        this.ga = rga.newGeographicArea(designation, cost, radius, postalCode1, postalCode2);
    }

    public void registGeographicArea(GeographicArea ga) {
        GeographicAreaRecord rga = Company.getGeographicAreasRecord();
        rga.registGeographicArea(ga);
    }
}
