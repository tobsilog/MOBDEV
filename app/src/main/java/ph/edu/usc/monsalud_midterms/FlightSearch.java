package ph.edu.usc.monsalud_midterms;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class FlightSearch extends AppCompatActivity {

    private EditText editTextOrigin, editTextDestination, editTextDepartureDate, editTextReturnDate;
    private Button buttonSearchFlights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_search);

        // Initialize Views
        editTextOrigin = findViewById(R.id.editTextOrigin);
        editTextDestination = findViewById(R.id.editTextDestination);
        editTextDepartureDate = findViewById(R.id.editTextDepartureDate);
        editTextReturnDate = findViewById(R.id.editTextReturnDate);
        buttonSearchFlights = findViewById(R.id.buttonSearchFlights);

        // Date Picker for Departure and Return Date
        editTextDepartureDate.setOnClickListener(v -> showDatePicker(editTextDepartureDate));
        editTextReturnDate.setOnClickListener(v -> showDatePicker(editTextReturnDate));

        // Handle Search Button Click
        buttonSearchFlights.setOnClickListener(v -> {
            // Get user input
            String origin = editTextOrigin.getText().toString();
            String destination = editTextDestination.getText().toString();
            String departureDate = editTextDepartureDate.getText().toString();
            String returnDate = editTextReturnDate.getText().toString();

            // Pass data to Available Flights Activity
            Intent intent = new Intent(FlightSearch.this, AvailableFlights.class);
            intent.putExtra("origin", origin);
            intent.putExtra("destination", destination);
            intent.putExtra("departureDate", departureDate);
            intent.putExtra("returnDate", returnDate);
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
