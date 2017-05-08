package com.example.rahovec.f1project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class DriverWins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_wins);

        String url = "http://ergast.com/api/f1/results/1/drivers";
        WebView view = (WebView) this.findViewById(R.id.driver_wins);
        view.loadUrl(url);
    }
}
