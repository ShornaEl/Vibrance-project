package com.example.vibrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.Emotionlevel;
import com.example.Focus_level;
import com.example.Happinesslevel;
import com.example.Stresslevel;

import java.text.DateFormat;
import java.util.Calendar;

public class Main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Button stress_btn = (Button) findViewById(R.id.stress_btn);
         Button focus_btn = (Button) findViewById(R.id.focus_btn);
        Button emtion_btn = (Button) findViewById(R.id.emotion_btn);
        Button happines_btn = (Button) findViewById(R.id.happiness_btn);
        TextView text = findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        String current_date = DateFormat.getDateInstance().format(calendar.getTime());
        text.setText(current_date);
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
        Intent focus;
        focus = new Intent(Main_page.this, Focus_level.class);

        //  login_dashboard = new Intent(MainActivity.this, splashscreen.class);
        focus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(focus);
            }
        });
        Intent emotion;
        emotion = new Intent(Main_page.this, Emotionlevel.class);

        //  login_dashboard = new Intent(MainActivity.this, splashscreen.class);
        emtion_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(emotion);
            }
        });
        Intent happiness;
        happiness = new Intent(Main_page.this, Happinesslevel.class);

        //  login_dashboard = new Intent(MainActivity.this, splashscreen.class);
        happines_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(happiness);
            }
        });
    }
}