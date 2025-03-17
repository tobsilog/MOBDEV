package ph.edu.usc.monsalud_midterms;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(v -> startActivity(new Intent(ConfirmationActivity.this, HomeScreen.class)));
    }
}
