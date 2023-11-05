package com.example.vibrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Stresslevel2 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stresslevel2);
        Button save_btn = findViewById(R.id.save_btn);
        TextView text = findViewById(R.id.happiness_value);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        Intent i = getIntent();
        int emotion = i.getIntExtra("Stress", 0);
        String message = "Stress: " + emotion;
        Calendar calendar = Calendar.getInstance();
        text.setText(message);
        String current_date = DateFormat.getDateInstance().format(calendar.getTime());
        save_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    // Retrieve the user's UID (User ID)
                    String uid = currentUser.getUid();



                    // Create a reference to the user's document in the "users" collection
                    DocumentReference userRef = db.collection("user").document(uid).collection(current_date).document("Stresslevel");

                    // Create a user data object (you can customize this)
                    Map<String,Object> userData = new HashMap<>();

                    userData.put("date", current_date);
                    userData.put("message",message);
                    // Set the user data in Firestore using the user reference
                    userRef.set(userData)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Stresslevel2.this, "User data saved successfully", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Stresslevel2.this, "Error saving user data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    // The user is not authenticated, handle this case as needed
                    Toast.makeText(Stresslevel2.this, "User not authenticated", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
}