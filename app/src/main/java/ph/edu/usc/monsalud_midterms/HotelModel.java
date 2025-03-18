package ph.edu.usc.monsalud_midterms;

public class HotelModel {
    private String name;
    private double price;  // Changed from String to double
    private float rating;  // Changed from String to float

    public HotelModel(String name, double price, float rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }  // Returns double
    public float getRating() { return rating; }  // Returns float

    public String getFormattedPrice() {
        return String.format("$%.2f / night", price);  // Format price as currency
    }

    public String getFormattedRating() {
        return String.format("%.1f ★", rating);  // Format rating with a star symbol
    }
}
