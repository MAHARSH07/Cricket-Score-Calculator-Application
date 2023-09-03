package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultSheet extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(ResultSheet.this, "cricket", null, 1);

        setContentView(R.layout.activity_result_sheet);
        Button newMatch = findViewById(R.id.new_match);
        Button exit=findViewById(R.id.exit);
        TextView result = findViewById(R.id.FinalResultSheet);
        int run = getIntent().getIntExtra("Runs", 0);
        int wickets = getIntent().getIntExtra("Wickets", 0);
        int team1 = getIntent().getIntExtra("Team1", 3);
        String teamname = getIntent().getStringExtra("Team Name");
        if(team1==1){
            result.setText(teamname + " Won by " +run+ " runs");
            db.deleteAllRows();
        }
        else if(team1==0){
            result.setText(teamname + " Won by " +wickets+ " wickets");
            db.deleteAllRows();
        }
        else{
                result.setText("Match draw");
                db.deleteAllRows();
        }

        newMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ResultSheet.this,MainActivity.class);
                startActivity(intent2);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}