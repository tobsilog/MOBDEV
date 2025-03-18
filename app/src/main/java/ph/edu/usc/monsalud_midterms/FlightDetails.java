package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FlightDetails extends AppCompatActivity {

    private TextView textViewFlightRoute, textViewFlightDate, textViewDepartureCity, textViewArrivalCity,
            textViewDepartureTime, textViewFlightDuration, textViewPassengerName, textViewFlightCode,
            textViewAirlineName, textViewFlightPrice;
    private Button buttonProceedToPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        // Initialize Views
        textViewFlightRoute = findViewById(R.id.textViewFlightRoute);
        textViewFlightDate = findViewById(R.id.textViewFlightDate);
        textViewDepartureCity = findViewById(R.id.textViewDepartureCity);
        textViewArrivalCity = findViewById(R.id.textViewArrivalCity);
        textViewDepartureTime = findViewById(R.id.textViewDepartureTime);
        textViewFlightDuration = findViewById(R.id.textViewFlightDuration);
        textViewPassengerName = findViewById(R.id.textViewPassengerName);
        textViewFlightCode = findViewById(R.id.textViewFlightCode);
        textViewAirlineName = findViewById(R.id.textViewAirlineName);
        textViewFlightPrice = findViewById(R.id.textViewFlightPrice);
        buttonProceedToPayment = findViewById(R.id.buttonProceedToPayment);

        // Retrieve the flight details from intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("flight")) {
            Flight selectedFlight = (Flight) intent.getSerializableExtra("flight");

            if (selectedFlight != null) {
                // Populate the flight details with actual data
                textViewFlightRoute.setText(selectedFlight.getDepartureCity() + " - " + selectedFlight.getArrivalCity());
                textViewFlightDate.setText(selectedFlight.getTravelDate());
                textViewDepartureCity.setText(selectedFlight.getDepartureCity());
                textViewArrivalCity.setText(selectedFlight.getArrivalCity());
                textViewDepartureTime.setText(selectedFlight.getDepartureTime());
                textViewFlightDuration.setText(selectedFlight.getFlightDuration());
                textViewPassengerName.setText(selectedFlight.getPassengerName());
                textViewFlightCode.setText("Flight: " + selectedFlight.getFlightCode());
                textViewAirlineName.setText(selectedFlight.getAirlineName());
                textViewFlightPrice.setText("$" + selectedFlight.getPrice());
            }
        }

        // Proceed to Payment Button Click Listener
        buttonProceedToPayment.setOnClickListener(v -> {
            Intent paymentIntent = new Intent(this, PaymentActivity.class);
            startActivity(paymentIntent);
        });
    }
}
