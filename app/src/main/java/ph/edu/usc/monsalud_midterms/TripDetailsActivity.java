package ph.edu.usc.monsalud_midterms;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TripDetailsActivity extends AppCompatActivity {
    private TextView tvTripName, tvTripDate, tvTripStatus, tvTripType;
    private Button btnBacktoTrips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        btnBacktoTrips = findViewById(R.id.btn_back_to_trips); // Add this line

        tvTripName = findViewById(R.id.tv_trip_name);
        tvTripDate = findViewById(R.id.tv_trip_date);
        tvTripStatus = findViewById(R.id.tv_trip_status);
        tvTripType = findViewById(R.id.tv_trip_type);

        // Get trip details from intent
        tvTripName.setText(getIntent().getStringExtra("tripName"));
        tvTripDate.setText("Date: " + getIntent().getStringExtra("tripDate"));
        tvTripStatus.setText("Status: " + getIntent().getStringExtra("tripStatus"));
        tvTripType.setText("Type: " + getIntent().getStringExtra("tripType"));

        btnBacktoTrips.setOnClickListener(v -> {
            Intent intent = new Intent(TripDetailsActivity.this, MyTripsActivity.class);
            startActivity(intent);
        });
    }
}
