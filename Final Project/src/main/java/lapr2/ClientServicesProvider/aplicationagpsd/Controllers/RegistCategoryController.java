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
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.CategoryRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.CategoryRepeatedException;

/**
 * @author Pedro Borda de Água
 */
public class RegistCategoryController implements Initializable {

    @FXML
    private TextField catCode;
    @FXML
    private TextField catDescription;
    @FXML
    private Button nextBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Label labelError;

    private Category cat;

    private static CategoryRecord catRec;

    /**
     * Initializes the controller class.
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void nextPage(ActionEvent event) {
        try {
            newCategory(catCode.getText(), catDescription.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, cat.toString());
            alert.setTitle("Success");
            alert.setHeaderText("Do you confirm it?");
            Optional<ButtonType> result = alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                registCategory(cat);
                Alert success = new Alert(Alert.AlertType.INFORMATION, "Category created and added to the list with success.");
                success.setHeaderText("Successful Operation");
                Optional<ButtonType> res = success.showAndWait();
                catCode.clear();
                catDescription.clear();
            }
        } catch (CategoryRepeatedException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
            catCode.clear();
            catDescription.clear();
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.setTitle("Error");
            alert.setHeaderText("Invalid!!");
            Optional<ButtonType> result = alert.showAndWait();
            catCode.clear();
            catDescription.clear();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ("Invalid Data"));
            alert.setTitle("Error");
            alert.setHeaderText("Incorrect!!");
            Optional<ButtonType> result = alert.showAndWait();
            catCode.clear();
            catDescription.clear();
        }
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

    public void newCategory(String catCode, String catDescription) {
        CategoryRecord catRec = Company.getCategoryRecord();
        this.cat = catRec.newCategory(catCode, catDescription);

    }

    public void registCategory(Category cat) {
        CategoryRecord catRec = Company.getCategoryRecord();
        catRec.registCategory(cat);
    }

}
