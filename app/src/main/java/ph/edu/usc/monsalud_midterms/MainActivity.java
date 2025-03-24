package ph.edu.usc.monsalud_midterms;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txt1, txt2, txt3;
    Button seb;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        seb = findViewById(R.id.btn);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        getData();
        seb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt1.getText().toString();
                String phone = txt2.getText().toString();
                String email = txt3.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name, name);
                editor.putString(Phone, phone);
                editor.putString(Email, email);
                editor.apply();
                Toast.makeText(getApplicationContext(),"Data has been saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getData(){
        if(sharedPreferences.contains(Name)){
            txt1.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Phone)){
            txt2.setText(sharedPreferences.getString(Phone,""));
        }
        if(sharedPreferences.contains(Email)){
            txt3.setText(sharedPreferences.getString(Email,""));
        }
    }
}