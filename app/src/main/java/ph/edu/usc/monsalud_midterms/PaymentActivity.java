package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity {
    private TextView tvHotelName, tvHotelPrice;
    private RadioGroup radioPaymentMethod;
    private Button btnConfirmBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        tvHotelName = findViewById(R.id.tv_payment_hotel_name);
        tvHotelPrice = findViewById(R.id.tv_payment_hotel_price);
        radioPaymentMethod = findViewById(R.id.radio_payment_method);
        btnConfirmBooking = findViewById(R.id.btn_confirm_booking);

        // Get booking details
        Intent intent = getIntent();
        String tripType = intent.getStringExtra("tripType"); // Determine type of booking
        String name = intent.getStringExtra("tripName"); // Airline, Hotel, Train, Bus
        String price = intent.getStringExtra("tripPrice"); // Total price

        // Update UI based on trip type
        if (tripType != null) {
            switch (tripType) {
                case "Flight":
                    tvHotelName.setText("Airline: " + name);
                    break;
                case "Hotel":
                    tvHotelName.setText("Hotel: " + name);
                    break;
                case "Train":
                    tvHotelName.setText("Train Service: " + name);
                    break;
                case "Bus":
                    tvHotelName.setText("Bus Company: " + name);
                    break;
                default:
                    tvHotelName.setText("Booking Details");
                    break;
            }
        }

        tvHotelPrice.setText("Total Price: " + price);

        btnConfirmBooking.setOnClickListener(v -> {
            int selectedId = radioPaymentMethod.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedPayment = findViewById(selectedId);
                String paymentMethod = selectedPayment.getText().toString();

                // ✅ Use already declared variables instead of redeclaring them
                saveTripToSharedPreferences(tripType, name, price, paymentMethod);

                // Navigate to confirmation page
                Intent confirmIntent = new Intent(PaymentActivity.this, ConfirmationActivity.class);
                confirmIntent.putExtra("tripType", tripType);
                confirmIntent.putExtra("tripName", name);
                confirmIntent.putExtra("tripPrice", price);
                confirmIntent.putExtra("paymentMethod", paymentMethod);
                startActivity(confirmIntent);
            }
        });
    }
    private void saveTripToSharedPreferences(String tripType, String tripName, String tripPrice, String paymentMethod) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyTrips", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Retrieve existing trips (stored as JSON array)
        String existingTrips = sharedPreferences.getString("trips", "[]"); // Default: empty array
        JSONArray tripsArray;
        try {
            tripsArray = new JSONArray(existingTrips);
        } catch (Exception e) {
            tripsArray = new JSONArray();
        }

        // Create JSON object for new trip
        JSONObject tripObject = new JSONObject();
        try {
            tripObject.put("tripType", tripType);
            tripObject.put("tripName", tripName);
            tripObject.put("tripPrice", tripPrice);
            tripObject.put("paymentMethod", paymentMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add new trip to the array
        tripsArray.put(tripObject);

        // Save updated trips back to SharedPreferences
        editor.putString("trips", tripsArray.toString());
        editor.apply();

        Log.d("MyTrips", "Trip saved: " + tripObject.toString());
    }

}
