package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.model.UserSession;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.CompleteWork;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Rating;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.RatingsRecord;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.round;

/**
 * FXML Controller class
 *
 * @author Tiago Ribeiro (1181444)
 */
public class RateServiceController implements Initializable {

    @FXML
    private ListView<CompleteWork> completedServices;
    @FXML
    private Button returnBtn;
    @FXML
    private Button watchInvoices;
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    @FXML
    private RadioButton radioButton3;
    @FXML
    private RadioButton radioButton4;
    @FXML
    private RadioButton radioButton5;
    @FXML
    private Button rateBtn;
    @FXML
    private Label clientName;
    @FXML
    private Label nif;
    @FXML
    private Label service;
    @FXML
    private Label date;
    @FXML
    private Label cost;
    @FXML
    private Label infoAlreadyLoaded;

    private Rating rating;

    /**
     * @return the rating
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioButton1.setDisable(true);
        radioButton2.setDisable(true);
        radioButton3.setDisable(true);
        radioButton4.setDisable(true);
        radioButton5.setDisable(true);
        rateBtn.setDisable(true);
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Client Menu");
            stage.setScene(new Scene(root1));
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void rate(ActionEvent event) {
        try {
            ToggleGroup group = new ToggleGroup();
            radioButton1.setToggleGroup(group);
            radioButton2.setToggleGroup(group);
            radioButton3.setToggleGroup(group);
            radioButton4.setToggleGroup(group);
            radioButton5.setToggleGroup(group);
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
            newRating(selectedRadioButton.getText(), completedServices.getSelectionModel().selectedItemProperty().get());
            Company.getRatingsRecord().addRating(rating);
        } catch (Exception k) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, ("Completed services can only be rated once."));
            alert.setTitle("Information");
            alert.setHeaderText("This service was already rated.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void invoicesWatch(ActionEvent event) {
        try {
            UserSession userLogged = AuthorizationFacade.getSessaoAtual();
            Client cli = Company.getClientRecord().getClientByEmail(userLogged.getUserEmail());

            ObservableList<CompleteWork> completedServicesList = FXCollections.observableArrayList(Company.getCompleteWorkRecord().getCompleteWorkByClient(cli));
            completedServices.setItems(completedServicesList);
            completedServices.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CompleteWork>() {
                @Override
                public void changed(ObservableValue<? extends CompleteWork> observable, CompleteWork oldValue, CompleteWork newValue) {
                    try {
                        radioButton1.setDisable(false);
                        radioButton2.setDisable(false);
                        radioButton3.setDisable(false);
                        radioButton4.setDisable(false);
                        radioButton5.setDisable(false);
                        rateBtn.setDisable(false);
                        ToggleGroup group = new ToggleGroup();
                        radioButton1.setToggleGroup(group);
                        radioButton2.setToggleGroup(group);
                        radioButton3.setToggleGroup(group);
                        radioButton4.setToggleGroup(group);
                        radioButton5.setToggleGroup(group);
                        clientName.setText(completedServices.getSelectionModel().selectedItemProperty().get().getInvoice().getClientName());
                        nif.setText(completedServices.getSelectionModel().selectedItemProperty().get().getInvoice().getClientNif());
                        service.setText(completedServices.getSelectionModel().selectedItemProperty().get().getInvoice().getServiceExecuted());
                        date.setText(completedServices.getSelectionModel().selectedItemProperty().get().getInvoice().getDate().toYearMonthDayString());
                        cost.setText(String.valueOf(round.format(completedServices.getSelectionModel().selectedItemProperty().get().getInvoice().getPrice())) + " €");
                    } catch (NullPointerException np) {
                        infoAlreadyLoaded.setText("   List is already loaded above");
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("It was not possible to load the list of completed services.");
            e.printStackTrace();
        }
    }

    public void newRating(String rating, CompleteWork executionOrder) {
        RatingsRecord rr = Company.getRatingsRecord();
        this.rating = rr.newRating(rating, executionOrder);
    }
}
