package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;

/**
 * FXML Controller class
 *
 * @author Tiago Ribeiro (1181444)
 * @author Rafael Moreira 1180778
 */
public class HROMenuController implements Initializable {

    @FXML
    private Button evaluateServiceProviderBtn;
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
    
    /**
     * Starts the evaluation of the Service Provider.
     *
     * @param actionEvent the action of clicking the button to start the evaluation.
     */
    @FXML
    private void evaluateServiceProvider(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EvaluateSPs.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Evaluation of Service Providers Performance");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();

            // Hide this current window
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void registerServiceProvider(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RegistServiceProviderInsertNIF.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Regist Service Provider");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();

            // Hide this current window
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
