package com.example.vibrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        Button singn_up = (Button) findViewById(R.id.sign_up);
        Button log_in = (Button) findViewById(R.id.login);
        Intent login_register;
        login_register = new Intent(MainActivity.this, SignUp.class);
        Intent login_dashboard;
        login_dashboard = new Intent(MainActivity.this, splashscreen.class);

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("Shorna") && password.getText().toString().equals("12345")) {
                    startActivity(login_dashboard);

                } else {
                    Toast.makeText(MainActivity.this, "username and password does not match", Toast.LENGTH_SHORT).show();

                }
            }
        });
        singn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(login_register);
            }
        });


    }
}