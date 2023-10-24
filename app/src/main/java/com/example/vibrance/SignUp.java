package com.example.vibrance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
 private FirebaseAuth  auth;
 private EditText email,password;
 private Button register;
 private TextView click_login;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       auth = FirebaseAuth.getInstance();
       email = findViewById(R.id.username);
       password = findViewById(R.id.password);
       register =findViewById(R.id.rgister);
       click_login =findViewById(R.id.clicklogin);
       Intent intent = new Intent(SignUp.this,MainActivity.class);
       click_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(intent);
           }
       });
       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String user,pass;
               user = email.getText().toString().trim();
               pass = password.getText().toString().trim();
               if(user.isEmpty()){
                   email.setError("Username cannot be empty");
               }
               if(pass.isEmpty()){
                   password.setError("Username cannot be empty");
               }else{
                   auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()){
                               Toast.makeText(SignUp.this,"Register Successful",Toast.LENGTH_SHORT).show();

                           }
                           else {
                               Toast.makeText(SignUp.this,"Register failed",Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
           }
       });
    }
}