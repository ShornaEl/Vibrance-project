package com.example.vibrance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
                String userId = currentUser.getUid();

                // Fetch data for the authenticated user
                db.collection(userId)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    userList.clear();

                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        // Deserialize Firestore data into a User object (you need to define the User class)
                                        Message user = document.toObject(Message.class);
                                        userList.add(user);
                                    }

                                    // Notify the adapter that the data has changed
                                    adapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(MainActivity2.this, "Error fetching user data", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else {
                // Handle the case where the user is not authenticated
                // You may want to display a login screen or handle this differently
                // For simplicity, we'll show a toast message here
                Toast.makeText(MainActivity2.this, "User not authenticated", Toast.LENGTH_SHORT).show();
            }
        }

}