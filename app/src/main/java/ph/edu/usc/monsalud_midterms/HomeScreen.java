package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;
    private List<ImageAdapter.Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        itemList = new ArrayList<>();
        itemList.add(new ImageAdapter.Item(R.drawable.plane, "Flights"));
        itemList.add(new ImageAdapter.Item(R.drawable.bus, "Bus"));
        itemList.add(new ImageAdapter.Item(R.drawable.train, "Train"));
        itemList.add(new ImageAdapter.Item(R.drawable.hotel, "Hotel"));
        itemList.add(new ImageAdapter.Item(R.drawable.trips, "My Trips"));

        imageAdapter = new ImageAdapter(itemList, item -> {

            Intent intent = null;
            switch (item.getTitle()) {
                case "Flights":
                    intent = new Intent(HomeScreen.this, FlightSearch.class);
                    break;
                case "Bus":
                    intent = new Intent(HomeScreen.this, BusTrainSearchActivity.class);
                    intent.putExtra("category", "bus"); // Pass "bus" category
                    break;
                case "Train":
                    intent = new Intent(HomeScreen.this, BusTrainSearchActivity.class);
                    intent.putExtra("category", "train"); // Pass "train" category
                    break;
                case "Hotel":
                    intent = new Intent(HomeScreen.this, HotelSearchActivity.class);
                    break;
                case "My Trips":
                    intent = new Intent(HomeScreen.this, MyTripsActivity.class);
                    break;
            }

            if (intent != null) {
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(imageAdapter);
    }
}
