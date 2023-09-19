package com.example.vibrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {


    TextView welcome,psycho;

    private static int time = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        welcome = findViewById(R.id.welcome);
        psycho = findViewById(R.id.psycho);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(splashscreen.this, Main_page.class);
                startActivity(splash);
                finish();
            }
        },time);

        Animation myanimation = AnimationUtils.loadAnimation(splashscreen.this,R.anim.animation2);
        welcome.startAnimation(myanimation);
        Animation myanimation1 = AnimationUtils.loadAnimation(splashscreen.this,R.anim.animation1);
        psycho.startAnimation(myanimation1);
    }
}