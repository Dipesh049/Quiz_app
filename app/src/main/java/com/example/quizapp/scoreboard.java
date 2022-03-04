package com.example.quizapp;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class scoreboard extends AppCompatActivity {
    TextView cor, inc;
    int correct, incorrect;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        correct = getIntent().getIntExtra("correct", 0);
        incorrect = getIntent().getIntExtra("incorrect", 0);


        cor = findViewById(R.id.corr);
        inc = findViewById(R.id.wrong);

        String right = String.valueOf(correct);
        String wrong = String.valueOf(incorrect);
        cor.setText(right);
        inc.setText(wrong);


        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(scoreboard.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}