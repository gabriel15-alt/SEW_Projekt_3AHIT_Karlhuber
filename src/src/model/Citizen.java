package model;

public class Citizen {

    private String name;
    private int alter;
    private String bezirk;

    public Citizen(String name, int alter, String bezirk) {
        this.name = name;
        this.alter = alter;
        this.bezirk = bezirk;
    }

    public String getName()    { return name; }
    public int    getAlter()   { return alter; }
    public String getBezirk()  { return bezirk; }

    public void setName(String name)      { this.name = name; }
    public void setAlter(int alter)       { this.alter = alter; }
    public void setBezirk(String bezirk)  { this.bezirk = bezirk; }
}
