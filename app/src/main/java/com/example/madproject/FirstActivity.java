package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    Button one, two, three, four, six, wide, no, out,dot;
    Button convert;
    EditText resultconvert,resetScore;
    DatabaseHelper db;
    Button clear;
    int runs = 0, wickets=0, balls=0;
    double runrate=0;
    double overs=0.0;

    double temp=0.0;
    EditText run, wicket, over,rr;
    Button Extra;
    EditText exruns;
    int secondStatus=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        run = (EditText)findViewById(R.id.editTextTextPersonName2);
        wicket = (EditText) findViewById(R.id.editTextTextPersonName3);
        over = (EditText)findViewById(R.id.editTextTextPersonName4);
        one = (Button)findViewById(R.id.button);
        two = (Button)findViewById(R.id.button2);
        three = (Button)findViewById(R.id.button3);
        four = (Button)findViewById(R.id.button4);
        six = (Button)findViewById(R.id.button6);
        wide = (Button)findViewById(R.id.button8);
        no = (Button)findViewById(R.id.button7);
        out = (Button)findViewById(R.id.button5);
        // convert = (Button)findViewById(R.id.button10);
        resultconvert = (EditText)findViewById(R.id.editTextTextPersonName);
        Extra = (Button)findViewById(R.id.button9);
        exruns = (EditText)findViewById(R.id.editTextTextPersonName5);
        rr = (EditText)findViewById(R.id.editTextTextPersonName6);
        clear=(Button)findViewById(R.id.clear);
        dot = (Button)findViewById(R.id.dot);
        secondStatus=getIntent().getIntExtra("SecondStatus",0);

        db=new DatabaseHelper(FirstActivity.this,"cricket",null,1);

        String  teamname = getIntent().getStringExtra("Team Name");
        Button finish = findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the SecondActivity
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

                //database

                long recordId=db.saveUserData(teamname,runs,wickets);
                if(recordId>0)
                {
                    Toast.makeText(getApplicationContext(),"Saved successfully",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Not saved successfully",Toast.LENGTH_LONG).show();
            }

                // Pass variables to the new activity using putExtra()


                intent.putExtra("SCORE", runs);

                //intent.putExtra("OVERS_BOWLED", overs);

                intent.putExtra("WICKETS_TAKEN",wickets);

                intent.putExtra("BALLS_BOWLED",balls);

                intent.putExtra("Team Name",teamname);

                intent.putExtra("SecondStatus",secondStatus);
                // Start the new activity
                startActivity(intent);
            }
        });




        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear text of all TextView objects
                runs=0;
                balls=0;
                overs=0;
                runrate=0;
                wickets=0;
                run.setText("");
                over.setText("");
                rr.setText("");
                resultconvert.setText((""));
                wicket.setText("");
                // Clear text of additional TextView objects if present
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<10) {
                    balls = balls + 1;
                    temp = balls;


                    over.setText(Integer.toString(balls));
                    overs = balls / 6.0;
                    String no = over.getText().toString();
                    int a = Integer.parseInt(no);
                    int rem = a % 6;
                    int quotient = a / 6;
                    resultconvert.setText((quotient + "." + rem));


                    //resultconvert.setText(Double.toString(overs));
                    runrate = (double) runs / overs;
                    rr.setText(String.format("%.2f", runrate));
                }



            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<10) {
                    runs = runs + 1;
                    run.setText(Integer.toString(runs));
                    balls = balls + 1;
                    temp = balls;


                    over.setText(Integer.toString(balls));
                    overs = balls / 6.0;
                    String no = over.getText().toString();
                    int a = Integer.parseInt(no);
                    int rem = a % 6;
                    int quotient = a / 6;
                    resultconvert.setText((quotient + "." + rem));
                    //resultconvert.setText(Double.toString(overs));
                    runrate = (double) runs / overs;
                    rr.setText(String.format("%.2f", runrate));
                }

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<10) {
                    runs = runs + 2;
                    run.setText(Integer.toString(runs));
                    balls = balls + 1;
                    over.setText(Integer.toString(balls));
                    overs = balls / 6.0;
                    String no = over.getText().toString();
                    int a = Integer.parseInt(no);
                    int rem = a % 6;
                    int quotient = a / 6;
                    resultconvert.setText((quotient + "." + rem));
                    //resultconvert.setText(Double.toString(overs));
                    runrate = (double) runs / overs;
                    rr.setText(String.format("%.2f", runrate));
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<10) {
                    runs = runs + 3;
                    run.setText(Integer.toString(runs));
                    balls = balls + 1;
                    over.setText(Integer.toString(balls));
                    overs = balls / 6.0;
                    String no = over.getText().toString();
                    int a = Integer.parseInt(no);
                    int rem = a % 6;
                    int quotient = a / 6;
                    resultconvert.setText((quotient + "." + rem));
                    //resultconvert.setText(Double.toString(overs));
                    runrate = (double) runs / overs;
                    rr.setText(String.format("%.2f", runrate));
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<10) {
                    runs = runs + 4;
                    run.setText(Integer.toString(runs));
                    balls = balls + 1;
                    over.setText(Integer.toString(balls));
                    overs = balls / 6.0;
                    String no = over.getText().toString();
                    int a = Integer.parseInt(no);
                    int rem = a % 6;
                    int quotient = a / 6;
                    resultconvert.setText((quotient + "." + rem));
                    //resultconvert.setText(Double.toString(overs));
                    runrate = (double) runs / overs;
                    rr.setText(String.format("%.2f", runrate));
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<10) {
                    runs = runs + 6;
                    run.setText(Integer.toString(runs));
                    balls = balls + 1;
                    over.setText(Integer.toString(balls));
                    overs = balls / 6.0;
                    String no = over.getText().toString();
                    int a = Integer.parseInt(no);
                    int rem = a % 6;
                    int quotient = a / 6;
                    resultconvert.setText((quotient + "." + rem));
                    //resultconvert.setText(Double.toString(overs));
                    runrate = (double) runs / overs;
                    rr.setText(String.format("%.2f", runrate));
                }
            }
        });
        wide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<10) {
                    runs = runs + 1;
                    run.setText(Integer.toString(runs));
                    over.setText(Integer.toString(balls));
                    overs = balls / 6.0;
                    if (balls == 0) {
                        rr.setText("Yet to bowl");
                    } else {
                        runrate = (double) runs / overs;
                        rr.setText(String.format("%.2f", runrate));
                    }
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<10) {

                    runs = runs + 1;
                    run.setText(Integer.toString(runs));
                    if (balls == 0) {
                        rr.setText("Yet to bowl");
                    } else {
                        runrate = (double) runs / overs;
                        rr.setText(String.format("%.2f", runrate));
                    }
                }


            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<=9) {
                    wickets = wickets + 1;
                    wicket.setText(Integer.toString(wickets));
                    balls = balls + 1;
                    over.setText(Integer.toString(balls));
                    overs=balls/6.0;
                    String no=over.getText().toString();
                    int a = Integer.parseInt(no);
                    int rem = a%6;
                    int quotient = a/6;
                    resultconvert.setText((quotient+"."+rem));
                    //resultconvert.setText(Double.toString(overs));
                    runrate=(double)runs/overs;
                    rr.setText(String.format("%.2f",runrate));
                }
            }
        });

//        convert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String no=over.getText().toString();
//                int a = Integer.parseInt(no);
//                int rem = a%6;
//                int quotient = a/6;
//                resultconvert.setText((quotient+"."+rem));
//            }
//        });

        Extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wickets<10) {
                    String no = exruns.getText().toString();
                    int zero = 0;
                    int a = Integer.parseInt(no);
                    runs = runs + a;
                    run.setText(Integer.toString(runs));
                    exruns.setText(Integer.toString(zero));
                    over.setText(Integer.toString(balls));
                    overs = balls / 6.0;
                    if (balls == 0) {
                        rr.setText("Yet to bowl");
                    } else {
                        runrate = (double) runs / overs;
                        rr.setText(String.format("%.2f", runrate));
                    }
                }
            }
        });
    }
}