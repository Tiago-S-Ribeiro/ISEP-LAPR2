package lapr2.ClientServicesProvider.aplicationagpsd.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Rafael Moreira 1180778
 */
public class EvaluateServiceProviderController implements Initializable {


    private List<ServiceProvider> serviceProvidersList = new ArrayList<ServiceProvider>();

    private List<String> availableLabelsList = new ArrayList<String>();

    private final static String WORST_PROVIDER = "Worst Providers";

    private final static String REGULAR_PROVIDER = "Regular Providers";

    private final static String OUTSTANDING_PROVIDER = "Outstanding Providers";

    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private Label standardDeviationSpLabel;
    @FXML
    public Text errorLabel;
    @FXML
    private Button finishBtn;
    @FXML
    private Button setLabelBtn;
    @FXML
    private BarChart<?, ?> histogram;
    @FXML
    private ComboBox<ServiceProvider> serviceProvidersComboBox;
    @FXML
    private Label evaluationLabel;
    @FXML
    private ComboBox<String> availableLabelsComboBox;
    @FXML
    private Label averageRatingSPLabel;
    @FXML
    private Label averageRatingTotalLabel;
    @FXML
    private Label numOfSPsLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        serviceProvidersList = Company.getServiceProviderRecord().getServiceProvidersList();
        availableLabelsList.add(WORST_PROVIDER);
        availableLabelsList.add(OUTSTANDING_PROVIDER);
        availableLabelsList.add(REGULAR_PROVIDER);
        serviceProvidersComboBox.getItems().addAll(serviceProvidersList);
        availableLabelsComboBox.getItems().addAll(availableLabelsList);
        averageRatingTotalLabel.setText(String.valueOf(Company.getRatingsRecord().getPopulationMean()));
        numOfSPsLabel.setText(String.valueOf(Company.getServiceProviderRecord().getServiceProvidersList().size()));

        XYChart.Series set1 = new XYChart.Series();
        for (int i = 0; i < Company.getServiceProviderRecord().getServiceProvidersList().size(); i++) {
            String name = Company.getServiceProviderRecord().getServiceProvidersList().get(i).getAbreviatedName();
            double rating = Company.getServiceProviderRecord().getServiceProvidersList().get(i).getRatingsMean();
            System.out.println(name + " " + rating);
            if (rating > 0) {
                set1.getData().addAll(new XYChart.Data<String, Number>(name, rating));
            }
        }
        histogram.getData().addAll(set1);
    }

    /**
     * The HRO finishes the evaluation of the service providers.
     *
     * @param event the click of the button to finish the evaluation.
     */
    @FXML
    private void finishEvaluation(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Evaluation of The Service Providers");
        alert.setHeaderText(null);
        alert.setContentText("Thank you for your evaluation.\nBy clicking 'Ok' you will be redirected to the menu.");
        alert.showAndWait();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/HROMenu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Human Resources Officer Menu");
            stage.setResizable(false);
            stage.show();

            // Hide this current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }

    /**
     * Sets the new SP label according to the HRO preference.
     *
     * @param event the click of the button to change the label.
     */
    @FXML
    private void setNewLabel(ActionEvent event) {
        ServiceProvider serviceProvider = serviceProvidersComboBox.getSelectionModel().getSelectedItem();
        String label = availableLabelsComboBox.getSelectionModel().getSelectedItem();
        Company.getRatingsRecord().setRatingLabel(serviceProvider, label);
        evaluationLabel.setText(serviceProvider.getRatingLabel());
    }

    /**
     * Changes the statistics of the service provider selected.
     *
     * @param actionEvent the choosing of a service provider from the combo box.
     */
    public void changeStatistics(ActionEvent actionEvent) {
        evaluationLabel.setText(serviceProvidersComboBox.getSelectionModel().getSelectedItem().getRatingLabel());
        averageRatingSPLabel.setText(String.valueOf(serviceProvidersComboBox.getSelectionModel().getSelectedItem().getRatingsMean()));
        standardDeviationSpLabel.setText(String.valueOf(serviceProvidersComboBox.getSelectionModel().getSelectedItem().getStandardDeviation()));
    }
}

