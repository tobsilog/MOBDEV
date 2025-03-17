package ph.edu.usc.monsalud_midterms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

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
        String hotelName = intent.getStringExtra("hotelName");
        String hotelPrice = intent.getStringExtra("hotelPrice");

        tvHotelName.setText(hotelName);
        tvHotelPrice.setText("Total Price: " + hotelPrice);

        btnConfirmBooking.setOnClickListener(v -> {
            int selectedId = radioPaymentMethod.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedPayment = findViewById(selectedId);
                String paymentMethod = selectedPayment.getText().toString();

                // Navigate to confirmation page
                Intent confirmIntent = new Intent(PaymentActivity.this, ConfirmationActivity.class);
                confirmIntent.putExtra("hotelName", hotelName);
                confirmIntent.putExtra("paymentMethod", paymentMethod);
                startActivity(confirmIntent);
            }
        });
    }
}
