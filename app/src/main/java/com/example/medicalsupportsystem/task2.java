package com.example.medicalsupportsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class task2 extends AppCompatActivity {
    Button home, signninn, pSignin;
    EditText pemail, pUserPassword;
    FirebaseAuth mAuth;
    ProgressBar prrogrsbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        home = (Button) findViewById(R.id.btnb6);
        signninn = (Button) findViewById(R.id.btnb9);
        pSignin = (Button) findViewById(R.id.btnb5);
        pemail = (EditText) findViewById(R.id.txvs2);
        pUserPassword = (EditText) findViewById(R.id.txvs3);
        prrogrsbar = (ProgressBar)findViewById(R.id.prrogbar);
        //pSignin.setOnClickListener(this:: pSignin);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hom = new Intent(task2.this, MainActivity.class);
                startActivity(hom);
            }
        });
        signninn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hom = new Intent(task2.this, signuppatient.class);
                startActivity(hom);
            }
        });
        prrogrsbar.setVisibility(View.INVISIBLE);
        pSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                String email = pemail.getText().toString().trim();
                String password = pUserPassword.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(task2.this, "user registration is completed you can now sign in", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), patientloggedin.class));
                            prrogrsbar.setVisibility(View.GONE);
                        }
                        else {
                            Toast.makeText(task2.this, "either email or password is not correct" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            prrogrsbar.setVisibility(View.GONE);
                        }
                    }
                });

            }


        });
      }
    }


