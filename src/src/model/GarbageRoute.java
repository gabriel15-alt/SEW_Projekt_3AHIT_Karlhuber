package model;

public class GarbageRoute {

    private String strasse;
    private String bezirk;
    private String abholtag;

    public GarbageRoute(String strasse, String bezirk, String abholtag) {
        this.strasse = strasse;
        this.bezirk = bezirk;
        this.abholtag = abholtag;
    }

    public String getStrasse()   { return strasse; }
    public String getBezirk()    { return bezirk; }
    public String getAbholtag()  { return abholtag; }

    public void setStrasse(String strasse)    { this.strasse = strasse; }
    public void setBezirk(String bezirk)      { this.bezirk = bezirk; }
    public void setAbholtag(String abholtag)  { this.abholtag = abholtag; }
}
