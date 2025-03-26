package ph.edu.usc.monsalud_midterms;

public class Trip {
    private String name;
    private String date;
    private String status;
    private String type;
    private String price;
    private String paymentMethod;

    public Trip(String name, String date, String status, String type, String price, String paymentMethod) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.type = type;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public String getType() { return type; }
    public String getPrice() { return price; }
    public String getPaymentMethod() { return paymentMethod; }
}
