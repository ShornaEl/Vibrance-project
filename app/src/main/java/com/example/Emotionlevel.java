package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.vibrance.R;

public class Emotionlevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotionlevel);
        Button calculateButton = findViewById(R.id.calculateButton);
        Intent intent = new Intent(Emotionlevel.this, Emtionlevel2.class);
        calculateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int x = calculateEmotionLevel();
                intent.putExtra("IntValue",x);
                startActivity(intent);
            }
        });
    }


    private  int calculateEmotionLevel() {
        int focusLevel = 0;



        // Question 1
        RadioGroup question1RadioGroup = findViewById(R.id.question1RadioGroup);
        int question1SelectedId = question1RadioGroup.getCheckedRadioButtonId();
        if (question1SelectedId != -1) {
            RadioButton question1SelectedRadioButton = findViewById(question1SelectedId);
            if (question1SelectedRadioButton.getText().equals("No")) {
                focusLevel += 1;
            }
        }
        //Question2
        RadioGroup question2RadioGroup = findViewById(R.id.question2RadioGroup);
        int question2SelectedId = question2RadioGroup.getCheckedRadioButtonId();
        if (question2SelectedId != -1) {
            RadioButton question2SelectedRadioButton = findViewById(question2SelectedId);
            if (question2SelectedRadioButton.getText().equals("Yes")) {
                focusLevel += 1;
            }
        }
        RadioGroup question3RadioGroup = findViewById(R.id.question3RadioGroup);
        int question3SelectedId = question3RadioGroup.getCheckedRadioButtonId();
        if (question3SelectedId != -1) {
            RadioButton question3SelectedRadioButton = findViewById(question3SelectedId);
            if (question3SelectedRadioButton.getText().equals("Yes")) {
                focusLevel += 1;
            }
        }
        RadioGroup question4RadioGroup = findViewById(R.id.question4RadioGroup);
        int question4SelectedId = question4RadioGroup.getCheckedRadioButtonId();
        if (question4SelectedId != -1) {
            RadioButton question4SelectedRadioButton = findViewById(question4SelectedId);
            if (question4SelectedRadioButton.getText().equals("No")) {
                focusLevel += 1;
            }
        }
        return focusLevel;
    }



}            // Add more questions and calculations for each question her// Display the calculated stress lev
