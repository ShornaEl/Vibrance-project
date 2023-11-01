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

public class Stresslevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stresslevel);
        Button submit_btn = findViewById(R.id.submit_btn);
        Intent intent = new Intent(Stresslevel.this, focuslevel2.class);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = calculateStressLevel();
                intent.putExtra("Stress",x);
                startActivity(intent);
            }
        });
    }

    private  int calculateStressLevel() {
        int focusLevel = 0;



        // Question 1
        RadioGroup question1RadioGroup = findViewById(R.id.question1RadioGroup);
        int question1SelectedId = question1RadioGroup.getCheckedRadioButtonId();
        if (question1SelectedId != -1) {
            RadioButton question1SelectedRadioButton = findViewById(question1SelectedId);
            if (question1SelectedRadioButton.getText().equals("Never")) {
                focusLevel += 13;
            }
            else if (question1SelectedRadioButton.getText().equals("Sometimes")) {
                focusLevel += 8;
            }
            else{
                focusLevel += 3;
            }
        }
        //Question2
        RadioGroup question2RadioGroup = findViewById(R.id.question2RadioGroup);
        int question2SelectedId = question2RadioGroup.getCheckedRadioButtonId();
        if (question2SelectedId != -1) {
            RadioButton question2SelectedRadioButton = findViewById(question2SelectedId);
            if (question2SelectedRadioButton.getText().equals("Never")) {
                focusLevel += 3;
            }
            else if (question2SelectedRadioButton.getText().equals("Sometimes")) {
                focusLevel += 6;
            }
            else{
                focusLevel += 12;
            }
        }
        //Question3
        RadioGroup question3RadioGroup = findViewById(R.id.question3RadioGroup);
        int question3SelectedId = question3RadioGroup.getCheckedRadioButtonId();
        if (question3SelectedId != -1) {
            RadioButton question3SelectedRadioButton = findViewById(question3SelectedId);
            if (question3SelectedRadioButton.getText().equals("Never")) {
                focusLevel += 3;
            }
            else if (question3SelectedRadioButton.getText().equals("Sometimes")) {
                focusLevel += 7;
            }
            else{
                focusLevel += 13;
            }
        }
        RadioGroup question4RadioGroup = findViewById(R.id.question4RadioGroup);
        int question4SelectedId = question4RadioGroup.getCheckedRadioButtonId();
        if (question4SelectedId != -1) {
            RadioButton question4SelectedRadioButton = findViewById(question4SelectedId);
            if (question4SelectedRadioButton.getText().equals("Never")) {
                focusLevel += 12;
            }
            else if (question4SelectedRadioButton.getText().equals("Sometimes")) {
                focusLevel += 6;
            }
            else{
                focusLevel += 3;
            }
        }
        RadioGroup question5RadioGroup = findViewById(R.id.question5RadioGroup);
        int question5SelectedId = question5RadioGroup.getCheckedRadioButtonId();
        if (question5SelectedId != -1) {
            RadioButton question5SelectedRadioButton = findViewById(question5SelectedId);
            if (question5SelectedRadioButton.getText().equals("Never")) {
                focusLevel += 13;
            }
            else if (question5SelectedRadioButton.getText().equals("Sometimes")) {
                focusLevel += 7;
            }
            else{
                focusLevel += 3;
            }
        }
        RadioGroup question6RadioGroup = findViewById(R.id.question6RadioGroup);
        int question6SelectedId = question6RadioGroup.getCheckedRadioButtonId();
        if (question6SelectedId != -1) {
            RadioButton question6SelectedRadioButton = findViewById(question6SelectedId);
            if (question6SelectedRadioButton.getText().equals("Never")) {
                focusLevel += 4;
            }
            else if (question6SelectedRadioButton.getText().equals("Sometimes")) {
                focusLevel += 6;
            }
            else{
                focusLevel += 13;
            }
        }
        RadioGroup question7RadioGroup = findViewById(R.id.question7RadioGroup);
        int question7SelectedId = question7RadioGroup.getCheckedRadioButtonId();
        if (question7SelectedId != -1) {
            RadioButton question7SelectedRadioButton = findViewById(question7SelectedId);
            if (question7SelectedRadioButton.getText().equals("Never")) {
                focusLevel += 12;
            }
            else if (question7SelectedRadioButton.getText().equals("Sometimes")) {
                focusLevel += 6;
            }
            else{
                focusLevel += 4;
            }
        }
        RadioGroup question8RadioGroup = findViewById(R.id.question8RadioGroup);
        int question8SelectedId = question8RadioGroup.getCheckedRadioButtonId();
        if (question8SelectedId != -1) {
            RadioButton question8SelectedRadioButton = findViewById(question8SelectedId);
            if (question8SelectedRadioButton.getText().equals("Never")) {
                focusLevel += 4;
            }
            else if (question8SelectedRadioButton.getText().equals("Sometimes")) {
                focusLevel += 7;
            }
            else{
                focusLevel += 13;
            }
        }
        return focusLevel;
    }

}





