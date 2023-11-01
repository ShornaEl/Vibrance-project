package com.example.vibrance;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.focuslevel2;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Recycleview extends AppCompatActivity {

    RecyclerView recyle;
    ArrayList<User> userArrayList;
    MyAdapter myAdapter;
    FirebaseFirestore db;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        recyle = findViewById(R.id.recycleview);
        recyle.setHasFixedSize(true);
        recyle.setLayoutManager(new LinearLayoutManager(this));
         db = FirebaseFirestore.getInstance();
         userArrayList = new ArrayList<User>();
         myAdapter = new MyAdapter(Recycleview.this,userArrayList);
        EventchangeListener();

    }
    public  void EventchangeListener(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String uid = currentUser.getUid();
        db.collection(uid).orderBy("date", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
               if(error!=null){
                   Toast.makeText(Recycleview.this, "Recycleview Document failed", Toast.LENGTH_SHORT).show();
                   return;
               }
               for(DocumentChange dc : value.getDocumentChanges()){
                   if(dc.getType()==DocumentChange.Type.ADDED){
                       userArrayList.add(dc.getDocument().toObject(User.class));
                   }
               }
             myAdapter.notifyDataSetChanged();
            }
        });


    }
}