package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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

        // Load sample trips (replace this with data from a database later)
        tripList = new ArrayList<>();
        tripList.add(new Trip("Hotel ABC", "March 20, 2025", "Paid", "Hotel"));
        tripList.add(new Trip("Bus to Manila", "April 5, 2025", "Confirmed", "Bus"));
        tripList.add(new Trip("Train to Cebu", "April 10, 2025", "Pending", "Train"));

        adapter = new MyTripsAdapter(tripList, this);
        recyclerView.setAdapter(adapter);
    }
}
