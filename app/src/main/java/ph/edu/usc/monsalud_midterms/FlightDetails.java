package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FlightDetails extends AppCompatActivity {

    private TextView textViewPassengerDetails, textViewSeatSelection, textViewAdditionalServices;
    private Button buttonProceedToPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        // Initialize Views
        textViewPassengerDetails = findViewById(R.id.textViewPassengerDetails);
        textViewSeatSelection = findViewById(R.id.textViewSeatSelection);
        textViewAdditionalServices = findViewById(R.id.textViewAdditionalServices);
        buttonProceedToPayment = findViewById(R.id.buttonProceedToPayment);

        // Get the selected flight from previous activity
        Flight selectedFlight = (Flight) getIntent().getSerializableExtra("flight");

        // Check if the flight object is not null before accessing it
        if (selectedFlight != null) {
            // Populate the flight details into the TextViews
            textViewPassengerDetails.setText("Passenger: " + selectedFlight.getPassengerName());
            textViewSeatSelection.setText("Seat: " + selectedFlight.getSelectedSeat());
            textViewAdditionalServices.setText("Additional Services: " + selectedFlight.getAdditionalServices());
        }

        // Set up the button action for proceeding to payment
        buttonProceedToPayment.setOnClickListener(v -> {
            // Handle proceed to payment action
            // Navigate to the Payment Activity or show a toast for now
            proceedToPayment();
        });
    }

    private void proceedToPayment() {
        // Navigate to PaymentActivity
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }

}
