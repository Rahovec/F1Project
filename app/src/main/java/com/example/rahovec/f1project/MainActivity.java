package com.example.rahovec.f1project;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    String JSON_STRING;
    String json_string;

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
        new BackgroundTaskTracks().execute();
        View listview = findViewById(R.id.tracksView);
        ParseJSONTracks(listview);
    }

    public void ParseJSONTracks (View view){
        if(json_string == null){
            Toast.makeText(this, "no json :(", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, Tracks.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }
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
    class BackgroundTaskTracks extends AsyncTask<Void,Void,String> {

        String json_url;

        @Override
        protected void onPreExecute() {
            json_url = "http://ergast.com/api/f1/circuits.json";
        }

        @Override
        protected String doInBackground(Void... params) {

            try {
                URL url =  new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while((JSON_STRING = bufferedReader.readLine()) != null){

                    stringBuilder.append(JSON_STRING+"\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            json_string = result;
        }
    }

}


