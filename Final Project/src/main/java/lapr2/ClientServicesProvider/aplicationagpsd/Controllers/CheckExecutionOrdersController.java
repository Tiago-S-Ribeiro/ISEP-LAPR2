package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.model.UserSession;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExecutionOrder;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExportAdapterCSV;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExportAdapterXLS;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExportAdapterXML;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isEndDateValid;
import static lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations.isStartDateValid;

/**
 * FXML Controller class
 *
 * @author Tiago Ribeiro (1181444)
 */
public class CheckExecutionOrdersController implements Initializable {

    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private ListView<ExecutionOrder> executionOrdersList;
    @FXML
    private Button xlsBtn;
    @FXML
    private Button xmlBtn;
    @FXML
    private Button csvBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Button consultOrdersBtn;
    @FXML
    private Label errorMsgLbl;
    @FXML
    private Label errorMsgLbl2;

    private ServiceProvider sp;
    private Date timePeriodStart;
    private Date timePeriodEnd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void exportXLS(ActionEvent event) {
        try {
            ExportAdapterXLS ex = new ExportAdapterXLS();
            List<ExecutionOrder> list = Company.getExecutionOrderRecord().getExecutionOrdersByServiceProvider(sp, timePeriodStart, timePeriodEnd);
            ex.exportFile(list, sp.getCompanyNumber());
        } catch (NullPointerException npe) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ("Please select a valid date to consult in order to export later."));
            alert.setTitle("Information");
            alert.setHeaderText("Not possible to export.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void exportXML(ActionEvent event) {
        try {
            ExportAdapterXML ex = new ExportAdapterXML();
            ArrayList<ExecutionOrder> list = Company.getExecutionOrderRecord().getExecutionOrdersByServiceProvider(sp, timePeriodStart, timePeriodEnd);
            ex.exportFile(list, sp.getCompanyNumber());
        } catch (NullPointerException npe) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ("Please select a valid date to consult in order to export later."));
            alert.setTitle("Information");
            alert.setHeaderText("Not possible to export.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void exportCSV(ActionEvent event) {
        try {
            ExportAdapterCSV ex = new ExportAdapterCSV();
            ArrayList<ExecutionOrder> list = Company.getExecutionOrderRecord().getExecutionOrdersByServiceProvider(sp, timePeriodStart, timePeriodEnd);
            ex.exportFile(list, sp.getCompanyNumber());
        } catch (NullPointerException npe) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ("Please select a valid date to consult in order to export later."));
            alert.setTitle("Information");
            alert.setHeaderText("Not possible to export.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void consultOrders(ActionEvent event) {
        UserSession loggedUser = AuthorizationFacade.getSessaoAtual();
        this.sp = Company.getServiceProviderRecord().getServiceProviderByEmail(loggedUser.getUserEmail());
        try {
            LocalDate localDate1 = date1.getValue();
            LocalDate localDate2 = date2.getValue();
            String[] dateOne = localDate1.toString().trim().split("-");
            String[] dateTwo = localDate2.toString().trim().split("-");
            Date dateOfStart = new Date(Integer.parseInt(dateOne[0]), Integer.parseInt(dateOne[1]), Integer.parseInt(dateOne[2]));
            Date dateOfEnd = new Date(Integer.parseInt(dateTwo[0]), Integer.parseInt(dateTwo[1]), Integer.parseInt(dateTwo[2]));
            this.timePeriodStart = dateOfStart;
            this.timePeriodEnd = dateOfEnd;

            if ((isStartDateValid(dateOfStart.getYear(), dateOfStart.getMonth(), dateOfStart.getDay()) == true) && (isEndDateValid(dateOfEnd.getYear(), dateOfEnd.getMonth(), dateOfEnd.getDay(), dateOfStart) == true)) {
                ObservableList<ExecutionOrder> executionOrders = FXCollections.observableArrayList(Company.getExecutionOrderRecord().getExecutionOrdersByServiceProvider(sp, dateOfStart, dateOfEnd));
                executionOrdersList.setItems(executionOrders);
                errorMsgLbl.setText("");
                errorMsgLbl2.setText("");
                if (executionOrders.isEmpty()) {
                    errorMsgLbl2.setText("No execution orders in this time period.");
                }
            } else {
                errorMessages();
            }
        } catch (NullPointerException n) {
            errorMessages();
        }
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ServiceProviderMenu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void errorMessages() {
        errorMsgLbl.setText("ERROR");
        errorMsgLbl2.setText("Please provide a valid time period above.");
    }
}
