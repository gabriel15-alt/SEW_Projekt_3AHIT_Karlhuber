package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataHandling {

    private ObservableList<Citizen> citizens = FXCollections.observableArrayList();

    private ObservableList<EnergyUsage> energyList = FXCollections.observableArrayList();

    private ObservableList<GarbageRoute> garbageRoutes = FXCollections.observableArrayList();

    private ObservableList<TrafficData> trafficList = FXCollections.observableArrayList();

    public DataHandling() {
        citizens.addAll(
            new Citizen("Anna Müller",   32, "Innere Stadt"),
            new Citizen("Max Huber",     45, "Wels-Land"),
            new Citizen("Lisa Mayr",     28, "Wels-Stadt"),
            new Citizen("Karl Gruber",   60, "Innere Stadt"),
            new Citizen("Eva Steiner",   37, "Wels-Land")
        );

        energyList.addAll(
            new EnergyUsage("Innere Stadt", 12500.0, "Januar"),
            new EnergyUsage("Wels-Land",    9800.5,  "Januar"),
            new EnergyUsage("Wels-Stadt",   11200.0, "Januar"),
            new EnergyUsage("Innere Stadt", 13100.0, "Februar"),
            new EnergyUsage("Wels-Land",    10200.0, "Februar")
        );

        garbageRoutes.addAll(
            new GarbageRoute("Hauptstraße 1",    "Innere Stadt", "Montag"),
            new GarbageRoute("Ringstraße 5",     "Wels-Stadt",   "Dienstag"),
            new GarbageRoute("Landstraße 12",    "Wels-Land",    "Mittwoch"),
            new GarbageRoute("Bahnhofstraße 3",  "Innere Stadt", "Donnerstag")
        );

        trafficList.addAll(
            new TrafficData("Hauptstraße",   320, "Frei"),
            new TrafficData("Ringstraße",    850, "Stau"),
            new TrafficData("Landstraße",    410, "Baustelle"),
            new TrafficData("Bahnhofstraße", 200, "Frei")
        );
    }

    public ObservableList<Citizen>      getCitizens()      { return citizens; }
    public ObservableList<EnergyUsage>  getEnergyList()    { return energyList; }
    public ObservableList<GarbageRoute> getGarbageRoutes() { return garbageRoutes; }
    public ObservableList<TrafficData>  getTrafficList()   { return trafficList; }
}
