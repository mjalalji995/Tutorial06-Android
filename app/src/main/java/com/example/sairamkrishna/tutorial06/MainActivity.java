package com.example.sairamkrishna.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, pass;
    Button login;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.edUsername);
        pass = findViewById(R.id.edPassword);
        login = findViewById(R.id.btnLogin);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_EMAIL, null);
        if (name != null) {
            // if data is avelable so directly call on Homeactivity
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(i);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("admin@gmail.com") && pass.getText().toString().equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (pass.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    pass.requestFocus();
                }
                if (email.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Enter Valid Mail Addredss", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                }
            }
        });
    }
}