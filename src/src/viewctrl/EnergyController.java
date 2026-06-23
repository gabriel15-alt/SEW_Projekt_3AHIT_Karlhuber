package viewctrl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DataHandling;
import model.EnergyUsage;

public class EnergyController {

    @FXML private TableView<EnergyUsage>       tabelleEnergie;
    @FXML private TableColumn<EnergyUsage, String> colBezirk;
    @FXML private TableColumn<EnergyUsage, Double> colKwh;
    @FXML private TableColumn<EnergyUsage, String> colMonat;

    @FXML private TextField fieldBezirk;
    @FXML private TextField fieldKwh;
    @FXML private TextField fieldMonat;

    private DataHandling data;

    public void setData(DataHandling data) {
        this.data = data;

        colBezirk.setCellValueFactory(new PropertyValueFactory<>("bezirk"));
        colKwh.setCellValueFactory(new PropertyValueFactory<>("verbrauchKwh"));
        colMonat.setCellValueFactory(new PropertyValueFactory<>("monat"));

        tabelleEnergie.setItems(data.getEnergyList());
    }

    @FXML
    private void energieHinzufuegen() {
        String bezirk = fieldBezirk.getText().trim();
        String kwhStr = fieldKwh.getText().trim();
        String monat  = fieldMonat.getText().trim();

        if (bezirk.isEmpty() || kwhStr.isEmpty() || monat.isEmpty()) return;

        try {
            double kwh = Double.parseDouble(kwhStr);
            data.getEnergyList().add(new EnergyUsage(bezirk, kwh, monat));
            fieldBezirk.clear();
            fieldKwh.clear();
            fieldMonat.clear();
        } catch (NumberFormatException e) {
            fieldKwh.setStyle("-fx-border-color: red;");
        }
    }

    @FXML
    private void energieLoeschen() {
        EnergyUsage ausgewaehlt = tabelleEnergie.getSelectionModel().getSelectedItem();
        if (ausgewaehlt != null) {
            data.getEnergyList().remove(ausgewaehlt);
        }
    }

    @FXML
    private void zurueck() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/viewctrl/main.fxml"));
            Stage stage = (Stage) tabelleEnergie.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
