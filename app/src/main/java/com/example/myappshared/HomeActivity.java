package com.example.myappshared;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView textView_name, textView_npm, textView_kelas, textView_prodi;
    Button button_exit;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_NPM = "npm";
    private static final String KEY_KELAS = "kelas";
    private static final String KEY_PRODI = "prodi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView_npm = findViewById(R.id.text_npm);
        textView_name = findViewById(R.id.text_nama);
        textView_kelas = findViewById(R.id.text_kelas);
        textView_prodi = findViewById(R.id.text_prodi);
        button_exit = findViewById(R.id.button_exit);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        String npm = sharedPreferences.getString(KEY_NPM, null);
        String kelas = sharedPreferences.getString(KEY_KELAS, null);
        String prodi = sharedPreferences.getString(KEY_PRODI, null);

        if (name != null || npm != null){
            textView_name.setText("Nama - "+name);
            textView_npm.setText("NPM - "+npm);
            textView_kelas.setText("Kelas - "+kelas);
            textView_prodi.setText("Program Studi - "+prodi);
        }

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this, "Terima Kasih!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}