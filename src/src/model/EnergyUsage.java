package model;

public class EnergyUsage {

    private String bezirk;
    private double verbrauchKwh;
    private String monat;

    public EnergyUsage(String bezirk, double verbrauchKwh, String monat) {
        this.bezirk = bezirk;
        this.verbrauchKwh = verbrauchKwh;
        this.monat = monat;
    }

    public String getBezirk()          { return bezirk; }
    public double getVerbrauchKwh()    { return verbrauchKwh; }
    public String getMonat()           { return monat; }

    public void setBezirk(String bezirk)              { this.bezirk = bezirk; }
    public void setVerbrauchKwh(double verbrauchKwh)  { this.verbrauchKwh = verbrauchKwh; }
    public void setMonat(String monat)                { this.monat = monat; }
}
