package ph.edu.usc.monsalud_midterms;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MyTripsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyTripsAdapter adapter;
    private List<Trip> tripList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trips);

        recyclerView = findViewById(R.id.recycler_my_trips);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 🔥 Load only saved trips from SharedPreferences
        tripList = loadTripsFromSharedPreferences();

        // 🔥 If no trips are found, show a message (optional)
        if (tripList.isEmpty()) {
            Log.d("MyTrips", "No trips found in SharedPreferences");
        }

        adapter = new MyTripsAdapter(tripList, this);
        recyclerView.setAdapter(adapter);
    }

    private List<Trip> loadTripsFromSharedPreferences() {
        List<Trip> trips = new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences("MyTrips", MODE_PRIVATE);
        String tripsData = sharedPreferences.getString("trips", "[]");

        try {
            JSONArray tripsArray = new JSONArray(tripsData);
            for (int i = 0; i < tripsArray.length(); i++) {
                JSONObject trip = tripsArray.getJSONObject(i);

                String tripType = trip.getString("tripType");
                String tripName = trip.getString("tripName");
                String tripPrice = trip.getString("tripPrice");
                String paymentMethod = trip.getString("paymentMethod");

                // ✅ Check if `tripDate` exists before accessing it
                String tripDate = trip.has("tripDate") ? trip.getString("tripDate") : "Unknown Date";

                // ✅ Add trip from SharedPreferences
                trips.add(new Trip(tripName, tripDate, "Paid", tripType, tripPrice, paymentMethod));
            }
        } catch (Exception e) {
            Log.e("MyTrips", "Error loading trips", e);
        }

        return trips;
    }
}
