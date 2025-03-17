package ph.edu.usc.monsalud_midterms;
public class HotelModel {
    private String name, price, rating;

    public HotelModel(String name, String price, String rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getRating() { return rating; }
}

