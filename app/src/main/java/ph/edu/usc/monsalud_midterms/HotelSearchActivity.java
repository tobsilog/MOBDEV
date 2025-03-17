package ph.edu.usc.monsalud_midterms;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class HotelSearchActivity extends AppCompatActivity {
    private EditText etDestination, etCheckin, etCheckout, etGuests;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search);

        etDestination = findViewById(R.id.et_destination_city);
        etCheckin = findViewById(R.id.et_checkin_date);
        etCheckout = findViewById(R.id.et_checkout_date);
        etGuests = findViewById(R.id.et_guests);
        btnSearch = findViewById(R.id.btn_search_hotels);

        // Date Picker for Check-in and Check-out
        etCheckin.setOnClickListener(v -> showDatePicker(etCheckin));
        etCheckout.setOnClickListener(v -> showDatePicker(etCheckout));

        btnSearch.setOnClickListener(v -> {
            String destination = etDestination.getText().toString();
            String checkin = etCheckin.getText().toString();
            String checkout = etCheckout.getText().toString();
            String guests = etGuests.getText().toString();

            Intent intent = new Intent(HotelSearchActivity.this, HotelResultsActivity.class);
            intent.putExtra("destination", destination);
            intent.putExtra("checkin", checkin);
            intent.putExtra("checkout", checkout);
            intent.putExtra("guests", guests);
            startActivity(intent);
        });
    }

    private void showDatePicker(EditText editText) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            editText.setText(dayOfMonth + "/" + (month1 + 1) + "/" + year1);
        }, year, month, day);
        datePickerDialog.show();
    }
}
