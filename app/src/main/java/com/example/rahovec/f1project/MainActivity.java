package com.example.rahovec.f1project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);

        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverWins();
            }
        });
       button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeamWins();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllTimeWins();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeamPoles();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverPoles();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tracks();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllTimePoles();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Statistics();
            }
        });
    }



    public void DriverWins() {
        Intent intent = new Intent(this, DriverWins.class);
        startActivity(intent);
    }

    public void DriverPoles() {
        Intent intent = new Intent(this, DriverPoles.class);
        startActivity(intent);
    }

    public void TeamWins() {
        Intent intent = new Intent(this, DriverPoles.class);
        startActivity(intent);
    }

    public void TeamPoles() {
        Intent intent = new Intent(this, DriverPoles.class);
        startActivity(intent);
    }

    public void Tracks(){

        Intent intent = new Intent(this, DriverPoles.class);
        startActivity(intent);
    }

    public void AllTimeWins(){
        Intent intent = new Intent(this, DriverPoles.class);
        startActivity(intent);
    }

    public void AllTimePoles(){
        Intent intent = new Intent(this, DriverPoles.class);
        startActivity(intent);
    }

    public void Statistics(){
        Intent intent = new Intent(this, DriverPoles.class);
        startActivity(intent);
    }
}


