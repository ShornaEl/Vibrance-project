package com.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vibrance.R;

public class Stresslevel extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup radioGroup;
    private Button nextButton;
    private double stressLevel = 0.0; // Initialize stress level
    private String[] questions = {
            "How often do you experience stress?",
            "Do you have trouble sleeping due to stress?",
            "Do you find it hard to concentrate when stressed?",
            "Have you noticed any changes in your appetite when stressed?",
            "Do you use coping mechanisms to deal with stress?"
    };
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        radioGroup = findViewById(R.id.radioGroup);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected radio button's text
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String selectedAnswer = selectedRadioButton.getText().toString();

                // Calculate stress level based on the selected answer
                if (selectedAnswer.equals("Yes")) {
                    stressLevel += 1.0;
                } else if (selectedAnswer.equals("Sometimes")) {
                    stressLevel += 0.5;
                } // No answer implies 0 stress level

                // Move to the next question or finish the survey
                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    questionTextView.setText(questions[currentQuestionIndex]);
                    radioGroup.clearCheck(); // Clear selected radio button
                } else {
                    // Survey is complete; you can show the stress level result
                    questionTextView.setText("Survey Complete");
                    radioGroup.setVisibility(View.GONE);
                    nextButton.setVisibility(View.GONE);
                    displayStressLevel();
                }
            }
        });
    }

    // Display the calculated stress level
    private void displayStressLevel() {
        TextView stressLevelTextView = findViewById(R.id.Final_stresslevel);
        stressLevelTextView.setText("Stress Level: " + stressLevel);
    }
}
