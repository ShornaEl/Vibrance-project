package com.example.vibrance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
 private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        Button singn_up = (Button) findViewById(R.id.sign_up);
        Button log_in = (Button) findViewById(R.id.login);
        Intent login_register;
        login_register = new Intent(MainActivity.this, SignUp.class);
        Intent login_dashboard;
        login_dashboard = new Intent(MainActivity.this, Main_page.class);

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, pass;
                email = String.valueOf(username.getText());
                pass = String.valueOf(password.getText());
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(login_dashboard);
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        Toast.makeText(MainActivity.this, "password cannot be empty", Toast.LENGTH_SHORT).show();
                    }

                }else if(email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Enter correct Email", Toast.LENGTH_SHORT).show();
                }
            }
        });
      singn_up.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(login_register);
          }
      });






    }
}