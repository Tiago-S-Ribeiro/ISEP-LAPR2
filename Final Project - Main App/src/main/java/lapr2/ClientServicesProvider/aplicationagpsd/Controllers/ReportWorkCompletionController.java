/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.AuthorizationFacade;
import lapr2.ClientServicesProvider.aplicationagpsd.Authorization.model.UserSession;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.CompleteWork;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.CompleteWorkRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExecutionOrder;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ExecutionOrderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExpansivelService;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Invoice;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Service;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.InvoicesRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Records.ServiceProviderRecord;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Date;
import lapr2.ClientServicesProvider.aplicationagpsd.Utils.Validations;

/**
 * FXML Controller class
 *
 * @author Tiago
 */
public class ReportWorkCompletionController implements Initializable {

    private ServiceProvider serviceProvider;
    private String email;
    private UserSession userSession;
    private ExecutionOrderRecord executionOrderRecord;
    private CompleteWorkRecord completeWorkRecord;
    private List<ExecutionOrder> lstExecOrdersNotReported;
    private List<CompleteWork> completeWorks;
    private ExecutionOrder executionOrder;
    private CompleteWork completeWork;
    private List<ExecutionOrder> lstExecOrders;
    private InvoicesRecord invoicesRecord;
    private List<Invoice> lstInvoices;
    private Invoice invoice;
    private String clientName;
    private String clientNif;
    private String serviceExecuted;
    private Date date;
    private double price;

    @FXML
    private Button btnBack;
    @FXML
    private Button btnConfirm;
    @FXML
    private ListView<String> listViewExecutionOrders = new ListView<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AuthorizationFacade af = new AuthorizationFacade();
            ServiceProviderRecord spr = Company.getServiceProviderRecord();
            this.userSession = AuthorizationFacade.getSessaoAtual();
            this.email = userSession.getUserEmail();
            this.serviceProvider = spr.getServiceProviderByEmail(email);
            this.completeWorkRecord = Company.getCompleteWorkRecord();
            this.executionOrderRecord = Company.getExecutionOrderRecord();
            this.invoicesRecord = Company.getInvoiceRecord();
            this.completeWorks = completeWorkRecord.getLstCompleteWorks();
            this.lstExecOrdersNotReported = executionOrderRecord.getExecutionOrdersListByCompleteWorks(completeWorks);
            this.lstExecOrders = executionOrderRecord.getExecutionOrdersByServiceProviderWhenServiceExecuted(serviceProvider, lstExecOrdersNotReported);
            this.lstInvoices = invoicesRecord.getLstInvoices();
            listViewExecutionOrders.getItems().clear();
            if (!lstExecOrders.isEmpty()) {
                for (ExecutionOrder eo : lstExecOrders) {
                    listViewExecutionOrders.getItems().addAll(eo.getSequencialIdentifier() + " | " + eo.getDescription().getService() + " | " + eo.getEmissionDate());
                }
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You dont have any execution order pending report evaluation.");
            alert.setTitle("None Pending");
            alert.setHeaderText("None Pending.");
            Optional<ButtonType> result = alert.showAndWait();
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

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void confirm(ActionEvent event) {
        if (listViewExecutionOrders.getSelectionModel().getSelectedItems().size() != 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You need to select an execution order.");
            alert.setTitle("Invalid Selection");
            alert.setHeaderText("Invalid Selection");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            String[] strExecOrder = listViewExecutionOrders.getSelectionModel().getSelectedItem().split(" | ");
            this.executionOrder = executionOrderRecord.getExecutionOrderBySequenciaIdentifier(strExecOrder[0]);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Enter description if something went wrong and time if the type of sevice is expandable.");
            alert.setTitle("Report");
            alert.setHeaderText("Report - Enter description if something went wrong and time if the type of sevice is expandable.");
            GridPane gp = new GridPane();
            Label lblTime = new Label("Time(min):");
            Label lblDescription = new Label("Description:");
            TextField textFieldTime = new TextField();
            TextArea textAreaDescription = new TextArea();
            gp.addColumn(0, lblDescription);
            gp.addColumn(1, textAreaDescription);
            ButtonType reportWork = new ButtonType("Report Work Complete");
            ButtonType cancel = new ButtonType("Cancel");
            alert.getButtonTypes().clear();
            alert.getButtonTypes().setAll(reportWork, cancel);
            textFieldTime.setDisable(true);
            if (executionOrder.getDescription().getService().getServiceType().equalsIgnoreCase("Expansivel Service")) {
                gp.addColumn(0, lblTime);
                gp.addColumn(1, textFieldTime);
                textFieldTime.setDisable(false);
            }
            alert.getDialogPane().setContent(gp);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == reportWork) {
                this.clientName = executionOrder.getCli().getName();
                this.clientNif = executionOrder.getCli().getNIF();
                this.date = executionOrder.getSchedule().getDay();
                this.serviceExecuted = executionOrder.getDescription().getService().getCompleteDescription();
                this.price = (executionOrder.getDescription().getDuration().toMinutes()* + Integer.parseInt(textFieldTime.getText()))/60 * executionOrder.getDescription().getService().getHourCost();
                this.invoice = newInvoice(clientName, clientNif, serviceExecuted, price, date);
                this.completeWork = newCompleteWork(textAreaDescription.getText(), executionOrder);
                if (!textFieldTime.isDisabled()) {
                    if (!Validations.isNumeric(textFieldTime.getText())) {
                        Alert alertTime = new Alert(Alert.AlertType.ERROR, "Invalid Time.");
                        alert.setTitle("Invalid");
                        alert.setHeaderText("Invalid");
                        alertTime.showAndWait();
                        alert.close();
                    } else {
                        completeWork.setInvoice(invoice);
                        completeWork.setExtraTime(textFieldTime.getText());
                        registCompleteWork(completeWork);
                        registInvoice(invoice);
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
                } else {
                    completeWork.setInvoice(invoice);
                    registCompleteWork(completeWork);
                    registInvoice(invoice);
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
            } else {
                alert.close();
            }
        }
    }

    public CompleteWork newCompleteWork(String description, ExecutionOrder executionOrder) {
        return completeWorkRecord.newCompleteWork(description, executionOrder);
    }

    public void registCompleteWork(CompleteWork cw) {
        CompleteWorkRecord cwr = Company.getCompleteWorkRecord();
        cwr.registCompleteWork(cw);
    }

    public Invoice newInvoice(String clientName, String clientNif, String serviceExecuted, double price, Date date) {
        return invoicesRecord.newInvoice(clientName, clientNif, serviceExecuted, price, date);
    }

    public void registInvoice(Invoice invoice) {
        InvoicesRecord ir = Company.getInvoiceRecord();
        ir.registInvoice(invoice);
    }
}
