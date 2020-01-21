package com.example.ma18uus.myapplication;

import android.location.Location;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class Forecast extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }
    protected static final String xmlLoader(String Criteria){
        String xmlData[] = new String[2];
        String APIURL = "http://api.weatherapi.com/v1/forecast.xml?key=89250dc123984f1ea03114448202101&q="+Criteria+"&days=3";
        try{
            //insert get weather stuff
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Criteria;
    }
    protected void CurrentLocationClick (View v){
        //Runs API call for current location and changes view as such
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                //Logic in case this returns null
                if (location != null){
                // do next!
                }
                else {
                    double templong = location.getLongitude();
                    double templat = location.getLatitude();
                    String s1 = String.valueOf(templong), s2 = String.valueOf(templat), s3 = (s2 + ", " + s1);
                    xmlLoader(s3);
                    // finish on location processing
                }
            }
        })
    }
    protected void ChooseLocationClick (View v) {
        //changes layout to the google maps view, allows user to select a lat,long which will be used in the weather api http request

    }
}
