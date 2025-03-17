package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BookingDetailsActivity extends AppCompatActivity {
    private TextView tvHotelName, tvHotelPrice, tvHotelRating;
    private EditText etFullName, etContactNumber;
    private Button btnProceedPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        tvHotelName = findViewById(R.id.tv_hotel_name);
        tvHotelPrice = findViewById(R.id.tv_hotel_price);
        tvHotelRating = findViewById(R.id.tv_hotel_rating);
        etFullName = findViewById(R.id.et_full_name);
        etContactNumber = findViewById(R.id.et_contact_number);
        btnProceedPayment = findViewById(R.id.btn_proceed_payment);

        // Get hotel details from intent
        Intent intent = getIntent();
        String hotelName = intent.getStringExtra("name");
        String hotelPrice = intent.getStringExtra("price");
        String hotelRating = intent.getStringExtra("rating");

        tvHotelName.setText(hotelName);
        tvHotelPrice.setText("Price: " + hotelPrice);
        tvHotelRating.setText("Rating: " + hotelRating);

        btnProceedPayment.setOnClickListener(v -> {
            String fullName = etFullName.getText().toString().trim();
            String contactNumber = etContactNumber.getText().toString().trim();

            if (fullName.isEmpty() || contactNumber.isEmpty()) {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
            } else {
                Intent paymentIntent = new Intent(BookingDetailsActivity.this, PaymentActivity.class);
                paymentIntent.putExtra("hotelName", hotelName);
                paymentIntent.putExtra("hotelPrice", hotelPrice);
                paymentIntent.putExtra("fullName", fullName);
                paymentIntent.putExtra("contactNumber", contactNumber);
                startActivity(paymentIntent);
            }
        });
    }
}
