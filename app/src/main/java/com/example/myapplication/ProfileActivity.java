package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.data.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.Random;

public class ProfileActivity extends AppCompatActivity {
    FirebaseFirestore db;

//    private String loadCourses() {
//
//        DocumentReference docRef = db.collection("users").document("uid");
//        ApiFuture<DocumentSnapshot> future = docRef.get().getResult();
//        String future = docRef.get().toString();
//
//        return future;
//
//
//    }

//    DocumentReference docRef = db.collection("cities").document("SF");
//    // asynchronously retrieve the document
//    ApiFuture<DocumentSnapshot> future = docRef.get();
//    // ...
//// future.get() blocks on response
//    DocumentSnapshot document = future.get();
//if (document.exists()) {
//        System.out.println("Document data: " + document.getData());
//    } else {
//        System.out.println("No such document!");
//    }


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        processExtraData();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
        processExtraData();
    }

    private void processExtraData(){
        User user = (User) getIntent().getSerializableExtra("USER");
        TextView nameField = findViewById(R.id.userProfile);
        nameField.setText(user.getName());

        TextView majorField = findViewById(R.id.profileMajor);
        majorField.setText(user.getMajor());

//        TextView classField = findViewById(R.id.profileClass);
//        classField.setText(user.getClass().toString());

//        TextView clubField = findViewById(R.id.profileClubs);
//        clubField.setText(user.getClubs().toString());

        TextView studyField = findViewById(R.id.profileStudyAbroad);
        if (user.getStudyAborad()) {
            studyField.setText(user.getAbroadCountry());
        } else {
            studyField.setText("no");
        }

//        TextView coursesField = findViewById(R.id.profileCourses);
//        coursesField.setText(loadCourses());
    }


}
