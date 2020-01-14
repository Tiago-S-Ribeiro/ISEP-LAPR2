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
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Appliance;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.FilesReaderWriter;

/**
 * FXML Controller class
 *
 * @author berna
 */
public class InitialPageController implements Initializable {

    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private Button submitionBtn;
    @FXML
    private Button leaveBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void closeApp(ActionEvent event){
        FilesReaderWriter frw = new FilesReaderWriter();
        frw.saveClientRecordBinaryFile                 ("clientRecord.ser");
        frw.saveAffectedToRecordBinaryFile             ("affectedToRecord.ser");
        frw.saveAppliaceRecordBinaryFile               ("applianceRecord.ser");
        frw.saveCategoryRecordBinaryFile               ("categoryRecord.ser");
        frw.saveCompleteWorkRecordBinaryFile           ("completeWorkRecord.ser");
        frw.saveExecutionOrderRecordBinaryFile         ("executionOrderRecord.ser");
        frw.saveGeographicAreasRecordBinaryFile        ("geographicAreaRecord.ser");
        frw.saveInvoiceRecordBinaryFile                ("invoiceRecord.ser");
        frw.saveRatingRecordBinaryFile                 ("ratingRecord.ser");
        frw.saveServiceProviderRecordBinaryFile        ("serviceProviderRecord.ser");
        frw.saveServiceProvisionRequestRecordBinaryFile("serviceProvisionRequestRecord.ser");
        frw.saveServicesRecordBinaryFile               ("serviceRecord.ser");
        frw.saveUserRecordBinaryFile                   ("userRecord.ser");
        System.exit(0);
    }
    @FXML
    private void login(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Login Window");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
            
            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void register(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientRegistryUI.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Client Registry Window");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
            
            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void submition(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ApplianceToServiceProvider.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Appliance Window");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
            Appliance cand = new Appliance();
            
            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
