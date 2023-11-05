package com.example.vibrance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Emotionrecycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotionrecycler);
        RecyclerView recyclerView;
        List<Message> userList;
        MessageAdapter adapter;

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userList = new ArrayList<>();
        adapter = new  MessageAdapter(userList);
        recyclerView.setAdapter(adapter);

        // Initialize Firebase Firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Get the authenticated current user
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


        if (currentUser != null) {
            String uid = currentUser.getUid();
            Calendar calendar = Calendar.getInstance();
            String current_date = DateFormat.getDateInstance().format(calendar.getTime());


            // Fetch data for the authenticated user
            db.collection("user")
                    .document(uid)
                    .collection(current_date)
                    .document("Emotionlevel")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();

                                if (document.exists()) {
                                    // Deserialize Firestore data into a Message object (you need to define the Message class)
                                    Message message = document.toObject(Message.class);

                                    if (message != null) {
                                        userList.clear();
                                        userList.add(message);
                                        // Notify the adapter that the data has changed
                                        adapter.notifyDataSetChanged();
                                    } else {
                                        Toast.makeText(Emotionrecycler.this, "Error parsing data", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(Emotionrecycler.this, "Document not found", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Emotionrecycler.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        } else {
            // Handle the case where the user is not authenticated
            // You may want to display a login screen or handle this differently
            // For simplicity, we'll show a toast message here
            Toast.makeText(Emotionrecycler.this, "User not authenticated", Toast.LENGTH_SHORT).show();
        }
    }
}