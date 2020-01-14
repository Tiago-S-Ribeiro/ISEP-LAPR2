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
import javafx.stage.WindowEvent;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;

/**
 * FXML Controller class
 *
 * @author berna
 */
public class ClientMenuController implements Initializable {

    @FXML
    private Button requestBtn;
    @FXML
    private Button addressBtn;
    @FXML
    private Button rateServiceBtn;
    @FXML
    private Button btnDecideAffection;
    @FXML
    private Button signOutBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void signOut(ActionEvent event){
       try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InitialPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            AuthorizationFacade af = new AuthorizationFacade();
            af.doLogout();
            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @FXML
    private void request(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MakeServiceProvisionRequestUI.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Request Window");
            stage.setScene(new Scene(root));
            stage.show();
            
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

    @FXML
    private void address(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientAddressAditionUI.fxml"));
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
    private void rateService(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RateService.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Rate service");
            stage.setScene(new Scene(root1));
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void decideAffection(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DecideAboutSPAndSchedule.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Decide Affection");
            stage.setScene(new Scene(root));
            stage.show();
            
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
    
}
