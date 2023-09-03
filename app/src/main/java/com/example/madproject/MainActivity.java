package com.example.madproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailText,password;
    String remail,rpass;
    EditText teamname;

    String team1;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clickHereButton = findViewById(R.id.calculate);
        teamname = (EditText) findViewById(R.id.editTextTextTeamName);
        //Button saveButton=findViewById(R.id.save);
        db=new DatabaseHelper(MainActivity.this,"cricket",null,1);

        int secInningsStatus=getIntent().getIntExtra("secInningsStatus",0);
        clickHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                team1 = teamname.getText().toString();

                //showToast(team1);
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                intent.putExtra("Team Name", team1);
                intent.putExtra("SecondStatus",secInningsStatus);
                startActivity(intent);
            }
        });
    }

    private void showToast(String toast){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }


}