package viewctrl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.DataHandling;

public class DashboardController {

    @FXML private Label labelBuerger;
    @FXML private Label labelEnergie;
    @FXML private Label labelMuell;
    @FXML private Label labelVerkehr;

    private DataHandling data;

    public void setData(DataHandling data) {
        this.data = data;
        aktualisieren();
    }

    private void aktualisieren() {
        labelBuerger.setText("Anzahl: " + data.getCitizens().size());

        double gesamtKwh = data.getEnergyList().stream()
                .mapToDouble(e -> e.getVerbrauchKwh())
                .sum();
        labelEnergie.setText(String.format("%.1f kWh", gesamtKwh));

        labelMuell.setText("Routen: "  + data.getGarbageRoutes().size());
        labelVerkehr.setText("Straßen: " + data.getTrafficList().size());
    }

    @FXML
    private void zurueck() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/viewctrl/main.fxml"));
            Stage stage = (Stage) labelBuerger.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
