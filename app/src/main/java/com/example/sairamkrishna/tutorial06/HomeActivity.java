package com.example.sairamkrishna.tutorial06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView email;
    SharedPreferences sharedPreferences;
    private static  final String SHARED_PREF_NAME="mypref";
    private static final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_EMAIL,null);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu mymenu) {
        getMenuInflater().inflate(R.menu.mymenu,mymenu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.logout:
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent i = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                Toast.makeText(this,"Logout SuccessFully..!",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}


