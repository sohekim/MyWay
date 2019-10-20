package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private Button buttonQuestion;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private TextView textViewSignin;
    //private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //progressDialog = new ProgressDialog(this);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonQuestion = (Button) findViewById(R.id.buttonQuestion);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword  = (EditText) findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        buttonRegister.setOnClickListener(this);
        buttonQuestion.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();



    }
    @Override
    public void onClick(View view){

        if(view== buttonRegister){
            registerUser();
        }
        if(view== textViewSignin){
            //log in here
            //finish();
            Intent i = new Intent(MainActivity.this,LogInActivity.class);
            startActivity(i);
        }

        if(view== buttonQuestion){
            openAsk();
        }

    }

    public void openAsk () {
        Intent i = new Intent(MainActivity.this,Ask.class);
        startActivity(i);
    }
    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty()){
            //email is empty
            Toast.makeText(this, "please enter email",Toast.LENGTH_SHORT).show();

            return;
        }
        if(password.isEmpty()){
            //password is empty
            Toast.makeText(this, "please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        //if valid
        //first we show progress dialogue
        //progressDialog.setMessage("Registering...");
        //progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //progressDialog.dismiss();
                if(task.isSuccessful()){
                    //you are registered and log in
                    //start profile activity here
                    finish();
                    Intent i = new Intent(MainActivity.this,ExploreActivity.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();

                }
                else {
                    //Toast.makeText(MainActivity.this, "Could not register, please try again", Toast.LENGTH_SHORT).show();
                    FirebaseAuthException e = (FirebaseAuthException )task.getException();


                    Toast.makeText(MainActivity.this, "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    //message.hide();
                    //return;
                }
            }
        });


    }
}
