package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HotelResultsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HotelAdapter adapter;
    private List<HotelModel> hotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_results);

        recyclerView = findViewById(R.id.recycler_hotels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hotelList = new ArrayList<>();
        hotelList.add(new HotelModel("City Hotel", "₱2000 per night", "4.5 Stars"));
        hotelList.add(new HotelModel("Beach Resort", "₱3500 per night", "5 Stars"));

        adapter = new HotelAdapter(hotelList, this);
        recyclerView.setAdapter(adapter);
    }
}
