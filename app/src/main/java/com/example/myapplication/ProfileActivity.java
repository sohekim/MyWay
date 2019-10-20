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

import java.io.Serializable;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = (User) getIntent().getSerializableExtra("USER");

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
//        coursesField.setText(user.getCourses());
    }


    @Override
    public void onClick(View v) {

    }
}
