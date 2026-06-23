package viewctrl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Citizen;
import model.DataHandling;

public class CitizenController {

    @FXML private TableView<Citizen>      tabellebuerger;
    @FXML private TableColumn<Citizen, String> colName;
    @FXML private TableColumn<Citizen, Integer> colAlter;
    @FXML private TableColumn<Citizen, String> colBezirk;

    @FXML private TextField fieldName;
    @FXML private TextField fieldAlter;
    @FXML private TextField fieldBezirk;

    private DataHandling data;

    public void setData(DataHandling data) {
        this.data = data;

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAlter.setCellValueFactory(new PropertyValueFactory<>("alter"));
        colBezirk.setCellValueFactory(new PropertyValueFactory<>("bezirk"));

        tabellebuerger.setItems(data.getCitizens());
    }

    @FXML
    private void buergerHinzufuegen() {
        String name   = fieldName.getText().trim();
        String alterStr = fieldAlter.getText().trim();
        String bezirk = fieldBezirk.getText().trim();

        if (name.isEmpty() || alterStr.isEmpty() || bezirk.isEmpty()) {
            return;
        }

        try {
            int alter = Integer.parseInt(alterStr);

            data.getCitizens().add(new Citizen(name, alter, bezirk));


            fieldName.clear();
            fieldAlter.clear();
            fieldBezirk.clear();
        } catch (NumberFormatException e) {

            fieldAlter.setStyle("-fx-border-color: red;");
        }
    }

    @FXML
    private void buergerLoeschen() {

        Citizen ausgewaehlt = tabellebuerger.getSelectionModel().getSelectedItem();
        if (ausgewaehlt != null) {
            data.getCitizens().remove(ausgewaehlt);
        }
    }

    @FXML
    private void zurueck() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/viewctrl/main.fxml"));
            Stage stage = (Stage) tabellebuerger.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
