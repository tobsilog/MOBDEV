package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        String returnDate = getIntent().getStringExtra("returnDate");

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerViewAvailableFlights);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data (you would replace this with actual flight search results)
        availableFlights = new ArrayList<>();
        availableFlights.add(new Flight("Airline A", "AA123", "10:00 AM", "12:00 PM", "2h", 300.00,
                "John Doe", "Seat 1A", "Baggage, Meals"));
        availableFlights.add(new Flight("Airline B", "BB456", "2:00 PM", "4:00 PM", "2h", 250.00,
                "Jane Smith", "Seat 2B", "Meals"));

        // Set up the adapter
        flightAdapter = new FlightAdapter(availableFlights);
        recyclerView.setAdapter(flightAdapter);

        // Implementing the "Book Flight" button functionality
        flightAdapter.setOnItemClickListener(new FlightAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Get the selected flight from the adapter
                Flight selectedFlight = availableFlights.get(position);

                // Create an intent to navigate to the FlightDetails activity
                Intent intent = new Intent(AvailableFlights.this, FlightDetails.class);

                // Pass the selected flight to the FlightDetails activity
                intent.putExtra("flight", selectedFlight);

                // Start the FlightDetails activity
                startActivity(intent);
            }
        });
    }
}
