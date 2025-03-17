package ph.edu.usc.monsalud_midterms;
public class BusTrainModel {
    private String name, departureCity, arrivalCity, travelTime, price;

    public BusTrainModel(String name, String departureCity, String arrivalCity, String travelTime, String price) {
        this.name = name;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.travelTime = travelTime;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getTravelDate() {
        return travelTime;
    }

    public String getPrice() {
        return price;
    }
}

