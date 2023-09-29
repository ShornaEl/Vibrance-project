package com.example.vibrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Stresslevel;

public class Main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Button stress_btn = (Button) findViewById(R.id.stress_btn);
        //  Button log_in = (Button) findViewById(R.id.login);
        Intent stress;
        stress = new Intent(Main_page.this, Stresslevel.class);
        Intent login_dashboard;
        //  login_dashboard = new Intent(MainActivity.this, splashscreen.class);
        stress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(stress);
            }
        });
    }
}