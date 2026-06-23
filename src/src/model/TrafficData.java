package model;

public class TrafficData {

    private String strasse;
    private int    fahrzeugProStunde;
    private String status;

    public TrafficData(String strasse, int fahrzeugProStunde, String status) {
        this.strasse = strasse;
        this.fahrzeugProStunde = fahrzeugProStunde;
        this.status = status;
    }

    public String getStrasse()             { return strasse; }
    public int    getFahrzeugProStunde()   { return fahrzeugProStunde; }
    public String getStatus()              { return status; }

    public void setStrasse(String strasse)                      { this.strasse = strasse; }
    public void setFahrzeugProStunde(int fahrzeugProStunde)     { this.fahrzeugProStunde = fahrzeugProStunde; }
    public void setStatus(String status)                        { this.status = status; }
}
