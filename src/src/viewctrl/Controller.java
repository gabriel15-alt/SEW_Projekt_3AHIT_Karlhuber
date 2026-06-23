package viewctrl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.MenuButton;
import javafx.event.ActionEvent;
import model.DataHandling;

public class Controller {

    @FXML private MenuButton menuButton;

    private DataHandling data = new DataHandling();

    private void wechsleSzene(String fxmlDatei, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/viewctrl/" + fxmlDatei)
            );
            Parent root = loader.load();

            Object ctrl = loader.getController();
            if (ctrl instanceof CitizenController) {
                ((CitizenController) ctrl).setData(data);
            }
            else if (ctrl instanceof TrafficController) {
                ((TrafficController) ctrl).setData(data);
            }
            else if (ctrl instanceof DashboardController) {
                ((DashboardController) ctrl).setData(data);
            }
            else if (ctrl instanceof EnergyController) {
                ((EnergyController) ctrl).setData(data);
            }
            else if (ctrl instanceof GarbageController) {
                ((GarbageController) ctrl).setData(data);
            }

            Stage stage = (Stage) menuButton.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML private void zumDashboard(ActionEvent e)   { wechsleSzene("dashboard.fxml", e); }
    @FXML private void zumBuerger(ActionEvent e)     { wechsleSzene("citizen.fxml",   e); }
    @FXML private void zumVerkehr(ActionEvent e)     { wechsleSzene("traffic.fxml",   e); }
    @FXML private void zurEnergie(ActionEvent e)     { wechsleSzene("energie.fxml",   e); }
    @FXML private void zurMuellabfuhr(ActionEvent e) { wechsleSzene("garbage.fxml",   e); }
}
