package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vibrance.R;

public class focuslevel2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focuslevel2);

        TextView text = findViewById(R.id.focus_value);


//get value through intent
        Intent i = getIntent();
        int focusLevel = i.getIntExtra("IntValue",0);

        String message = "Your stress level is: " + focusLevel;

        text.setText(message);

    }
}
