package viewctrl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DataHandling;
import model.TrafficData;

public class TrafficController {

    @FXML private TableView<TrafficData>         tabelleTraffic;
    @FXML private TableColumn<TrafficData, String>  colStrasse;
    @FXML private TableColumn<TrafficData, Integer> colFahrzeug;
    @FXML private TableColumn<TrafficData, String>  colStatus;

    @FXML private TextField fieldStrasse;
    @FXML private TextField fieldFahrzeug;
    @FXML private TextField fieldStatus;

    private DataHandling data;

    public void setData(DataHandling data) {
        this.data = data;

        colStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
        colFahrzeug.setCellValueFactory(new PropertyValueFactory<>("fahrzeugProStunde"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tabelleTraffic.setItems(data.getTrafficList());
    }

    @FXML
    private void verkehrHinzufuegen() {
        String strasse     = fieldStrasse.getText().trim();
        String fahrzeugStr = fieldFahrzeug.getText().trim();
        String status      = fieldStatus.getText().trim();

        if (strasse.isEmpty() || fahrzeugStr.isEmpty() || status.isEmpty()) return;

        try {
            int fahrzeug = Integer.parseInt(fahrzeugStr);
            data.getTrafficList().add(new TrafficData(strasse, fahrzeug, status));
            fieldStrasse.clear();
            fieldFahrzeug.clear();
            fieldStatus.clear();
        } catch (NumberFormatException e) {
            fieldFahrzeug.setStyle("-fx-border-color: red;");
        }
    }

    @FXML
    private void verkehrLoeschen() {
        TrafficData ausgewaehlt = tabelleTraffic.getSelectionModel().getSelectedItem();
        if (ausgewaehlt != null) {
            data.getTrafficList().remove(ausgewaehlt);
        }
    }

    @FXML
    private void zurueck() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/viewctrl/main.fxml"));
            Stage stage = (Stage) tabelleTraffic.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
