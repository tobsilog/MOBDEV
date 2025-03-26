package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AvailableFlights extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FlightAdapter flightAdapter;
    private List<Flight> availableFlights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_flights);

        // Get search criteria from previous activity
        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");
        String departureDate = getIntent().getStringExtra("departureDate");

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerViewAvailableFlights);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load flights from JSON file
        availableFlights = loadFlightsFromJSON(origin, destination, departureDate);

        Log.d("FlightSearch", "Flights in RecyclerView: " + availableFlights.size());

        // 🔥 Fix: Ensure adapter is always set, even if empty 🔥
        flightAdapter = new FlightAdapter(availableFlights);
        recyclerView.setAdapter(flightAdapter);
        recyclerView.post(() -> flightAdapter.notifyDataSetChanged());

        Log.d("RecyclerViewCheck", "Items in adapter: " + flightAdapter.getItemCount());
    }


    private List<Flight> loadFlightsFromJSON(String origin, String destination, String departureDate) {
        List<Flight> flightList = new ArrayList<>();
        try {
            InputStream is = getAssets().open("flights.json");
            Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name());
            String jsonString = scanner.useDelimiter("\\A").next();
            scanner.close();

            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonFlight = jsonArray.getJSONObject(i);

                String depCity = jsonFlight.getString("departureCity");
                String arrCity = jsonFlight.getString("arrivalCity");
                String travelDate = jsonFlight.getString("travelDate");

                Log.d("FlightSearch", "Checking Flight: " + depCity + " -> " + arrCity + " on " + travelDate);

                if (depCity.equalsIgnoreCase(origin) && arrCity.equalsIgnoreCase(destination) && travelDate.equals(departureDate)) {
                    Flight flight = new Flight(
                            jsonFlight.getString("airlineName"),
                            jsonFlight.getString("flightNumber"),
                            jsonFlight.getString("departureTime"),
                            jsonFlight.getString("arrivalTime"),
                            jsonFlight.getString("duration"),
                            jsonFlight.getDouble("price"),
                            jsonFlight.getString("passengerName"),
                            jsonFlight.getString("selectedSeat"),
                            jsonFlight.getString("additionalServices"),
                            depCity,
                            arrCity,
                            travelDate
                    );

                    Log.d("FlightSearch", "Match Found: " + flight.getAirlineName());
                    flightList.add(flight);
                }
            }

            // Debug log to check how many flights matched
            Log.d("FlightSearch", "Total Matched Flights: " + flightList.size());

        } catch (Exception e) {
            Log.e("FlightSearch", "Error loading flights", e);
        }
        return flightList;
    }

}
