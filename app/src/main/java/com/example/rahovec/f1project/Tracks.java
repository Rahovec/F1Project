package com.example.rahovec.f1project;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Tracks extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject,jsonObject1;
    JSONArray jsonArray;
    TrackDataAdapter trackDataAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);
        listView = (ListView) findViewById(R.id.tracksView);
        trackDataAdapter = new TrackDataAdapter(this,R.layout.tracks_row);
        listView.setAdapter(trackDataAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject1 = new JSONObject(json_string);
            jsonObject = jsonObject1.getJSONObject("CircuitTable");
            jsonArray = jsonObject.getJSONArray("Circuits");
            int count = 0;
            String name,city,country;
            while(count<jsonObject.length()){
                JSONObject JO = jsonArray.getJSONObject(count);
                name = JO.getString("circuitName");
                JSONObject JO1 = JO.getJSONObject("location");
                city = JO1.getString("locality");
                country = JO1.getString("country");
                Track_Data track_data = new Track_Data(name,city,country);
                trackDataAdapter.add(track_data);
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




}
