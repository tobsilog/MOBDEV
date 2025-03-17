package ph.edu.usc.monsalud_midterms;

import java.io.Serializable;

public class Flight implements Serializable {

    private String airlineName;
    private String flightNumber;
    private String departureTime;
    private String arrivalTime;
    private String duration;
    private double price;
    private String passengerName;
    private String selectedSeat;
    private String additionalServices;

    // Constructor
    public Flight(String airlineName, String flightNumber, String departureTime, String arrivalTime,
                  String duration, double price, String passengerName, String selectedSeat, String additionalServices) {
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.price = price;
        this.passengerName = passengerName;
        this.selectedSeat = selectedSeat;
        this.additionalServices = additionalServices;
    }

    // Getters
    public String getAirlineName() { return airlineName; }
    public String getFlightNumber() { return flightNumber; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public String getDuration() { return duration; }
    public double getPrice() { return price; }
    public String getPassengerName() { return passengerName; }
    public String getSelectedSeat() { return selectedSeat; }
    public String getAdditionalServices() { return additionalServices; }
}
