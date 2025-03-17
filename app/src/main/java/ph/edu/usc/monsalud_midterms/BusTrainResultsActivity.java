package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BusTrainResultsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BusTrainAdapter adapter;
    private List<BusTrainModel> busTrainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_train_results);

        recyclerView = findViewById(R.id.recycler_bus_train);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get category from Intent
        String category = getIntent().getStringExtra("category");

        // Initialize list
        busTrainList = new ArrayList<>();

        // Add trips but filter by category
        if ("bus".equals(category)) {
            busTrainList.add(new BusTrainModel("Bus Express", "Cebu", "Manila", "10:00 AM", "₱500"));
            busTrainList.add(new BusTrainModel("Bus Deluxe", "Cebu", "Davao", "2:00 PM", "₱750"));
        } else if ("train".equals(category)) {
            busTrainList.add(new BusTrainModel("Train Line 1", "Cebu", "Davao", "1:00 PM", "₱700"));
            busTrainList.add(new BusTrainModel("Train Express", "Cebu", "Manila", "3:00 PM", "₱600"));
        }

        adapter = new BusTrainAdapter(busTrainList, this);
        recyclerView.setAdapter(adapter);
    }
}
