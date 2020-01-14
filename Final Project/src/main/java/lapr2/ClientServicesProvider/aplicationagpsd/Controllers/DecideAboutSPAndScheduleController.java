package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.model.UserSession;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.AffectedTo;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExecutionOrder;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ExecutionOrderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.PostalAddress;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.RequestedServiceDescription;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Schedule;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvisionRequest;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.RepeatedExecutionOrderException;

/**
 * FXML Controller class
 *
 * @author Tiago
 */
public class DecideAboutSPAndScheduleController implements Initializable {

    private Client cli;
    private List<ServiceProvisionRequest> lstProvisions;
    private ServiceProvisionRequest request;
    private List<RequestedServiceDescription> lstDescriptions;
    private List<AffectedTo> lstAffections;
    private AffectedTo affection;
    private RequestedServiceDescription description;
    private Schedule schedule;
    private ServiceProvider sp;
    private double distance;
    private PostalAddress postalAddress;
    private ExecutionOrder eo;
    private static String[] requestNrProvision;

    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnBack;
    @FXML
    private ListView<String> lstViewProvisions = new ListView<>();
    @FXML
    private Button btnBackAffection;
    @FXML
    private Button btnConfirmAffection;
    @FXML
    private ListView<String> lstViewAffections = new ListView<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String location = url.toString();
        String[] fileName = location.split("/");
        if (fileName[fileName.length - 1].equals("DecideAboutSPAndSchedule.fxml")) {
            UserSession us = AuthorizationFacade.getSessaoAtual();
            this.cli = Company.getClientRecord().getClientByEmail(us.getUserEmail());
            this.lstProvisions = Company.getRequestRecord().getServiceProvisionsListByClient(cli);
            lstViewProvisions.getItems().clear();
            for (ServiceProvisionRequest provision : lstProvisions) {
                lstViewProvisions.getItems().addAll(provision.getRequestNumber() + " | " + provision.getpAdd() + " | " + listDescriptions(provision.getRequestedServicesDecriptionList()));
            }
        } else {
            try {
                this.request = Company.getRequestRecord().getServiceProvisionByNumberRequest(requestNrProvision[0]);
                this.lstDescriptions = request.getRequestedServicesDecriptionList();
                this.lstAffections = Company.getAffectedToRecord().getlistAffectionsOfAnOrder(lstDescriptions);
                if (!lstAffections.isEmpty()) {
                    lstViewAffections.getItems().clear();
                    for (AffectedTo at : lstAffections) {
                        lstViewAffections.getItems().addAll(at.getRequestedservicedescription().toString() + " | " + at.getSchedule() + " | Service Provider´s label: " +  at.getServiceProvider().getRatingLabel() + " | Service Provider mean rating: " + at.getServiceProvider().getRatingsMean());
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You dont have any decision pending in this order.");
                alert.setTitle("None Pending");
                alert.setHeaderText("None Pending.");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
    }

    @FXML
    private void confirm(ActionEvent event) {
        if (lstViewProvisions.getSelectionModel().getSelectedItems().size() != 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You need to select just one order.");
            alert.setTitle("Invalid Selection");
            alert.setHeaderText("Invalid Selection");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            requestNrProvision = lstViewProvisions.getSelectionModel().getSelectedItem().split(" | ");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DecisionConfirmationAboutSPAndSchedule.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                ((Node) (event.getSource())).getScene().getWindow().hide();

                stage.setOnCloseRequest((WindowEvent event1) -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
                        Parent root1;
                        root1 = (Parent) loader.load();
                        Stage stage1 = new Stage();
                        stage1.setScene(new Scene(root1));
                        stage1.show();

                        ((Node) (event.getSource())).getScene().getWindow().hide();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void back(ActionEvent event) {
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

    @FXML
    private void backAffection(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DecideAboutSPAndSchedule.fxml"));
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
    private void confirmAffection(ActionEvent event) {
        try {
            if (lstViewAffections.getSelectionModel().getSelectedItems().size() != 1) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "You need to select just one order.");
                alert.setTitle("Invalid Selection");
                alert.setHeaderText("Invalid Selection");
                Optional<ButtonType> result = alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you accept it or reject it?");
                alert.setTitle("DECIDE!!!!");
                alert.setHeaderText("DECIDE!!!");
                ButtonType accept = new ButtonType("Accept");
                ButtonType reject = new ButtonType("Reject");
                alert.getButtonTypes().clear();
                alert.getButtonTypes().addAll(accept, reject);
                Optional<ButtonType> result = alert.showAndWait();
                this.affection = lstAffections.get(lstViewAffections.getSelectionModel().getSelectedIndex());
                if (result.get() == accept) {
                    this.postalAddress = affection.getPostalAddress();
                    this.sp = this.affection.getServiceProvider();
                    this.distance = calculateDistance(postalAddress.getPostCode().getLatitude(), postalAddress.getPostCode().getLongitude(),
                            sp.getPostalAddress().getPostCode().getLatitude(), sp.getPostalAddress().getPostCode().getLongitude());
                    this.description = this.affection.getRequestedservicedescription();
                    this.schedule = this.affection.getSchedule();
                    this.cli = request.getClient();
                    this.eo = newExecutionOrder(postalAddress, distance, description, schedule, sp, cli);
                    registExecutionOrder(eo);
                    Company.getAffectedToRecord().getAffectationsList().remove(affection);
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Accepted Successfully");
                    alert2.showAndWait();
                } else if (result.get() == reject) {
                    Company.getAffectedToRecord().getAffectationsList().remove(affection);
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Denied successfully");
                    alert2.showAndWait();
                }
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/DecideAboutSPAndSchedule.fxml"));
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
        } catch (RepeatedExecutionOrderException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.setTitle("Invalid Execution Order");
            alert.setHeaderText("Invalid Execution Order");
            Optional<ButtonType> result = alert.showAndWait();
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.setTitle("Invalid Execution Order");
            alert.setHeaderText("Invalid Execution Order");
            Optional<ButtonType> result = alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Data");
            alert.setTitle("Invalid Execution Order");
            alert.setHeaderText("Invalid Execution Order");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371e3;
        double x = lat2 - lat1;
        double y = lon2 - lon1;
        double theta1 = Math.toRadians(lat1);
        double theta2 = Math.toRadians(lat2);
        double deltaTheta = Math.toRadians(x);
        double deltaLambda = Math.toRadians(y);
        double a = Math.sin(deltaTheta / 2) * Math.sin(deltaTheta / 2)
                + Math.cos(theta1) * Math.cos(theta2)
                * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;
        return d;
    }

    public ExecutionOrder newExecutionOrder(PostalAddress postalAddress, double distance, RequestedServiceDescription description, Schedule schedule, ServiceProvider sp, Client cli) {
        ExecutionOrderRecord executionOrderRecord = Company.getExecutionOrderRecord();
        return executionOrderRecord.newExecutionOrder(postalAddress, distance, description, schedule, sp, cli);
    }

    public void registExecutionOrder(ExecutionOrder eo) {
        ExecutionOrderRecord executionOrderRecord = Company.getExecutionOrderRecord();
        executionOrderRecord.registExecutionOrder(eo);
    }
    
    public static String listDescriptions(List<RequestedServiceDescription> lstDescriptions) {
        String descriptions = "";
        for (RequestedServiceDescription rsd : lstDescriptions) {
            descriptions += rsd.getService() + " ";
        }
        return descriptions;
    }

}
