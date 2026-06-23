package viewctrl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DataHandling;
import model.GarbageRoute;

public class GarbageController {

    @FXML private TableView<GarbageRoute>        tabelleGarbage;
    @FXML private TableColumn<GarbageRoute, String> colStrasse;
    @FXML private TableColumn<GarbageRoute, String> colBezirk;
    @FXML private TableColumn<GarbageRoute, String> colAbholtag;

    @FXML private TextField fieldStrasse;
    @FXML private TextField fieldBezirk;
    @FXML private TextField fieldAbholtag;

    private DataHandling data;

    public void setData(DataHandling data) {
        this.data = data;

        colStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
        colBezirk.setCellValueFactory(new PropertyValueFactory<>("bezirk"));
        colAbholtag.setCellValueFactory(new PropertyValueFactory<>("abholtag"));

        tabelleGarbage.setItems(data.getGarbageRoutes());
    }

    @FXML
    private void routeHinzufuegen() {
        String strasse  = fieldStrasse.getText().trim();
        String bezirk   = fieldBezirk.getText().trim();
        String abholtag = fieldAbholtag.getText().trim();

        if (strasse.isEmpty() || bezirk.isEmpty() || abholtag.isEmpty()) return;

        data.getGarbageRoutes().add(new GarbageRoute(strasse, bezirk, abholtag));
        fieldStrasse.clear();
        fieldBezirk.clear();
        fieldAbholtag.clear();
    }

    @FXML
    private void routeLoeschen() {
        GarbageRoute ausgewaehlt = tabelleGarbage.getSelectionModel().getSelectedItem();
        if (ausgewaehlt != null) {
            data.getGarbageRoutes().remove(ausgewaehlt);
        }
    }

    @FXML
    private void zurueck() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/viewctrl/main.fxml"));
            Stage stage = (Stage) tabelleGarbage.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
