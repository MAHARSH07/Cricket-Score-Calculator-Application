package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public int firstscore,firstwickets;
    public String firstteam;

    public int secInningsstatus=0;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView scoreTextView = findViewById(R.id.finalScoreTextView);
        TextView oversTextView = findViewById(R.id.oversBowledTextView);
        TextView wicketsTextView = findViewById(R.id.wicketsTakenTextView);

        TextView anyTeam=findViewById(R.id.display);
        db = new DatabaseHelper(SecondActivity.this, "cricket", null, 1);
        String records=db.getAllRecords();
        anyTeam.setText("Team name: "+records);

        // Retrieve the passed variables from the intent
        int score = getIntent().getIntExtra("SCORE", 0);

        int balls = getIntent().getIntExtra("BALLS_BOWLED", 0);

        String  teamname = getIntent().getStringExtra("Team Name");
        double overs=0.0;
        overs = balls / 6.0;

        int a = balls;
        int rem = a % 6;
        int quotient = a / 6;




        int wickets = getIntent().getIntExtra("WICKETS_TAKEN", 0);

        secInningsstatus=getIntent().getIntExtra("SecondStatus",0);



        // Display the values in TextViews
        scoreTextView.setText("Score: " + score);
        oversTextView.setText("Overs : " + quotient + "." + rem);
        wicketsTextView.setText("Wickets : "+wickets);

        Button newInnings = findViewById(R.id.newInningsButton);
        Button secInnings = findViewById(R.id.secinnings);
        Button finalresult = findViewById(R.id.finalresult);

        if(secInningsstatus==1)
            secInnings.setVisibility(View.GONE);
            //secInnings.setEnabled(false);

        newInnings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the SecondActivity
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                db.deleteAllRows();

                // Start the new activity
                startActivity(intent);
            }
        });
        secInnings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                secInningsstatus=1;
                firstscore = score;
                firstwickets = wickets;
                firstteam = records;

                //long recordId=db.saveUserData(records,firstscore,firstwickets);
                // Create an intent to navigate to the SecondActivity
                Intent intent1 = new Intent(SecondActivity.this, MainActivity.class);
                intent1.putExtra("secInningsStatus",secInningsstatus);

                // Start the new activity
                startActivity(intent1);
            }
        });
        finalresult.setOnClickListener((new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(SecondActivity.this,ResultSheet.class);
                Cursor cursor = db.getAllData();

                // Variables to store column values
                String name1 = "";
                int score1 = 0;
                int wickets1 = 0;
                String name2 = "";
                int score2 = 0;
                int wickets2 = 0;

                // Check if there are at least two rows
                if (cursor.moveToFirst()) {
                    // Get column values from the first row
                    name1 = cursor.getString(cursor.getColumnIndex("teamname"));
                    score1 = cursor.getInt(cursor.getColumnIndex("score"));
                    wickets1=cursor.getInt(cursor.getColumnIndex("wickets"));

                    // Move to the second row
                    if (cursor.moveToNext()) {
                        // Get column values from the second row
                        name2 = cursor.getString(cursor.getColumnIndex("teamname"));
                        score2 = cursor.getInt(cursor.getColumnIndex("score"));
                        wickets2=cursor.getInt(cursor.getColumnIndex("wickets"));
                    }
                }
                cursor.close();


                int team1;
                if(score2<score1){
                    team1 = 1;
                    intent2.putExtra("Team Name", name1);
                    intent2.putExtra("Team1", team1);
                    int finalscore = score1-score2;
                    intent2.putExtra("Runs", finalscore);
                }
                else if(score2>score1){
                    team1 = 0;
                    intent2.putExtra("Team Name", name2);
                    intent2.putExtra("Team1", team1);
                    int finalwicket = 10 - wickets;
                   intent2.putExtra("Wickets", finalwicket);
               }
               else{
                  team1 = 2;
               }
                startActivity(intent2);
            }
        }));
    }
}