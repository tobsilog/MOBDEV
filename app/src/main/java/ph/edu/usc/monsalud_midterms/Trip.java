package ph.edu.usc.monsalud_midterms;
public class Trip {
    private String name;
    private String date;
    private String status;
    private String type;

    public Trip(String name, String date, String status, String type) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.type = type;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public String getType() { return type; }
}

