package com.example.vibrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.Emotionlevel;
import com.example.Focus_level;
import com.example.Happinesslevel;
import com.example.Stresslevel;

import java.text.DateFormat;
import java.util.Calendar;
import android.os.Handler;

public class Main_page extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progressStatus = 0;

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        TextView focus_result = findViewById(R.id.focus_result);
        Button stress_btn = (Button) findViewById(R.id.stress_btn);
         Button focus_btn = (Button) findViewById(R.id.focus_btn);
        Button emtion_btn = (Button) findViewById(R.id.emotion_btn);
        Button happines_btn = (Button) findViewById(R.id.happiness_btn);
        TextView text = findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        String current_date = DateFormat.getDateInstance().format(calendar.getTime());
        text.setText(current_date);
       Intent fousresult = new Intent(Main_page.this,MainActivity2.class);
        //  Button log_in = (Button) findViewById(R.id.login);
        Intent stress;
        stress = new Intent(Main_page.this, Stresslevel.class);
        Intent login_dashboard;
        //  login_dashboard = new Intent(MainActivity.this, splashscreen.class);
       focus_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(fousresult);
            }
        });
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
    private void startProgressBar() {
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus <50) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        Thread.sleep(100); // You can adjust the sleep duration to control the speed.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // When the desired value is reached, you can hide the ProgressBar.
                runOnUiThread(new Runnable() {
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();
    }

}