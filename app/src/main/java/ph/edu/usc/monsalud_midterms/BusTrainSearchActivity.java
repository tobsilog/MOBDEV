package ph.edu.usc.monsalud_midterms;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class BusTrainSearchActivity extends AppCompatActivity {
    private EditText etDepartureCity, etArrivalCity, etTravelDate;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_train_search);

        etDepartureCity = findViewById(R.id.et_departure_city);
        etArrivalCity = findViewById(R.id.et_arrival_city);
        etTravelDate = findViewById(R.id.et_travel_date);
        btnSearch = findViewById(R.id.btn_search_bus_train);

        // Date Picker for Travel Date
        etTravelDate.setOnClickListener(v -> showDatePicker());

        btnSearch.setOnClickListener(v -> {
            String departure = etDepartureCity.getText().toString();
            String arrival = etArrivalCity.getText().toString();
            String date = etTravelDate.getText().toString();
            String category = getIntent().getStringExtra("category"); // Get category from previous screen

            Intent intent = new Intent(BusTrainSearchActivity.this, BusTrainResultsActivity.class);
            intent.putExtra("departure", departure);
            intent.putExtra("arrival", arrival);
            intent.putExtra("date", date);
            intent.putExtra("category", category);
            startActivity(intent);
        });
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            etTravelDate.setText(dayOfMonth + "/" + (month1 + 1) + "/" + year1);
        }, year, month, day);
        datePickerDialog.show();
    }
}
