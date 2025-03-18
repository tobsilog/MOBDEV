package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

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

        // Sample data (replace with actual flight search results)
        availableFlights = new ArrayList<>();
        availableFlights.add(new Flight("Lorem Ipsum Airlines", "432GH4", "19:15", "21:45",
                "02:35 H Non-Stop", 199.00, "Anne Williams", "Seat 1A", "Meals", "MAD", "NY", "2025-03-20"));

        availableFlights.add(new Flight("SkyJet Airways", "987HJ3", "14:30", "17:00",
                "02:30 H Non-Stop", 220.00, "Michael Reyes", "Seat 3C", "Baggage, Meals", "LAX", "JFK", "2025-03-22"));

        // Set up the adapter
        flightAdapter = new FlightAdapter(availableFlights);
        recyclerView.setAdapter(flightAdapter);

        // Handle flight selection and navigate to FlightDetails
        flightAdapter.setOnItemClickListener(new FlightAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Get the selected flight
                Flight selectedFlight = availableFlights.get(position);

                // Create an intent to navigate to FlightDetails activity
                Intent intent = new Intent(AvailableFlights.this, FlightDetails.class);
                intent.putExtra("flight", selectedFlight); // Pass the flight object

                // Start the FlightDetails activity
                startActivity(intent);
            }
        });
    }
}
