package ph.edu.usc.monsalud_midterms;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JSONParserActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jsonparser);

        ArrayList<String> personName = new ArrayList<>();
        ArrayList<String> personPhone = new ArrayList<>();
        ArrayList<String> personEmail = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try{
            //get json obj from json file
            JSONObject obj = new JSONObject(loadJSONFromAssets());

            //fetch json array
            JSONArray jsonArray = obj.getJSONArray("users");

            //implement for loop
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject userDetail = jsonArray.getJSONObject(i);
                personName.add(userDetail.getString("name"));
                personPhone.add(userDetail.getString("phone"));
                personEmail.add(userDetail.getString("email"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        CustomAdapter customAdapter = new CustomAdapter(personName, personPhone, personEmail, JSONParserActivity.this);
        recyclerView.setAdapter(customAdapter);
    }

    private String loadJSONFromAssets() {
        String json = null;
        try{
            InputStream is = getAssets().open("user_list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }catch(IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}