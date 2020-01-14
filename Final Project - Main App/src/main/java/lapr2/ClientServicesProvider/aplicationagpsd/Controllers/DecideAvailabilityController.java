package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.model.UserSession;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Availability;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProviderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Time;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isEndDateValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isEndTimeValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isStartDateValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isStartTimeValid;

/**
 * FXML Controller class
 *
 * @author Tiago Ribeiro (1181444)
 */
public class DecideAvailabilityController implements Initializable {

    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private TextField startHour;
    @FXML
    private TextField startMinute;
    @FXML
    private TextField endHour;
    @FXML
    private TextField endMinute;
    @FXML
    private Button leaveBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Label wrongInfoLbl;

    private Availability ava;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * @return the availability
     */
    public Availability getAvailability() {
        return ava;
    }
    
    /**
     * @param ava the availability to set
     */
    public void setAvailability(Availability ava) {
        this.ava = ava;
    }
    
    @FXML
    private void chooseStartDate(ActionEvent event) {
    }

    @FXML
    private void chooseEndDate(ActionEvent event) {
    }

    @FXML
    private void leave(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ServiceProviderMenu.fxml"));
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
    private void newAvailability(ActionEvent event) {
        try {
            UserSession userLogged = AuthorizationFacade.getSessaoAtual();
            ServiceProviderRecord spr = Company.getServiceProviderRecord();
            ServiceProvider sp = Company.getServiceProviderRecord().getServiceProviderByEmail(userLogged.getUserEmail());

            LocalDate localDate1 = date1.getValue();
            LocalDate localDate2 = date2.getValue();
            String[] dateOne = localDate1.toString().trim().split("-");
            String[] dateTwo = localDate2.toString().trim().split("-");

            Date dateOfStart = new Date(Integer.parseInt(dateOne[0]), Integer.parseInt(dateOne[1]), Integer.parseInt(dateOne[2]));
            Date dateOfEnd = new Date(Integer.parseInt(dateTwo[0]), Integer.parseInt(dateTwo[1]), Integer.parseInt(dateTwo[2]));
            Time timeOfStart = new Time(Integer.parseInt(startHour.getText()), Integer.parseInt(startMinute.getText()));
            Time timeOfEnd = new Time(Integer.parseInt(endHour.getText()), Integer.parseInt(endMinute.getText()));

            if ((isStartDateValid(dateOfStart.getYear(), dateOfStart.getMonth(), dateOfStart.getDay()) == true) && (isEndDateValid(dateOfEnd.getYear(), dateOfEnd.getMonth(), dateOfEnd.getDay(), dateOfStart) == true) && isStartTimeValid(startHour.getText(), startMinute.getText()) == true && isEndTimeValid(endHour.getText(), endMinute.getText(), timeOfStart) == true) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, spr.newAvailability(dateOfStart, dateOfEnd, timeOfStart, timeOfEnd).toString());
                alert.setTitle("Success");
                alert.setHeaderText("Do you confirm the availability?");
                Optional<ButtonType> result = alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {

                    newAvailability(dateOfStart, dateOfEnd, timeOfStart, timeOfEnd);
                    sp.addAvailability(ava);
                }
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ServiceProviderMenu.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
                wrongInfoLbl.setText("Wrong Information. Please confirm the fields above.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException it){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Time provided is not valid.");
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    public void newAvailability(Date startDate, Date endDate, Time startTime, Time endTime) {
        ServiceProviderRecord spr = Company.getServiceProviderRecord();
        this.ava = spr.newAvailability(startDate,endDate,startTime,endTime);
    }
}
