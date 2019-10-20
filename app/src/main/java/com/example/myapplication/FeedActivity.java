package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class FeedActivity extends AppCompatActivity {
    private Button buttonQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        buttonQuestion = findViewById(R.id.buttonQuestion);

        buttonQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAsk();
            }
        });

    }

    public void moveToAsk() {
        Intent intent = new Intent (this, Ask.class );
        startActivity(intent);

    }
}
