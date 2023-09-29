package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.vibrance.R;

public class Stresslevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stresslevel);
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateStressLevel();
            }
        });
    }

        private void calculateStressLevel() {
            int stressLevel = 0;

            // Question 1
            RadioGroup question1RadioGroup = findViewById(R.id.question1RadioGroup);
            int question1SelectedId = question1RadioGroup.getCheckedRadioButtonId();
            if (question1SelectedId != -1) {
                RadioButton question1SelectedRadioButton = findViewById(question1SelectedId);
                if (question1SelectedRadioButton.getText().equals("Yes")) {
                    stressLevel += 1;
                }
            }
            RadioGroup question2RadioGroup = findViewById(R.id.question2RadioGroup);
            int question2SelectedId = question2RadioGroup.getCheckedRadioButtonId();
            if (question2SelectedId != -1) {
                RadioButton question2SelectedRadioButton = findViewById(question2SelectedId);
                if (question2SelectedRadioButton.getText().equals("Yes")) {
                    stressLevel += 1;
                }
            }

            // Add more questions and calculations for each question here

            // Display the calculated stress level
            String message = "Your stress level is: " + stressLevel;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }





