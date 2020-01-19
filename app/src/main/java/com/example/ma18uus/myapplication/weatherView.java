package com.example.ma18uus.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class weatherView extends AppCompatActivity {


    //Main url
    static final String main_url = "http://api.weatherapi.com/v1/";
    //Live or Weekly forecast
    static final String live_weather = "current.xml?key=";
    //String sevendays_weather = "orecast.xml?key=";
    //API Key + q
    static final String API_Key = "c3bdfadb90d5452bb8003318201801&q=";
    //Location Setters
    static final String location = "London";

    //Complete url for todays forecast
    static final String URLT = main_url + live_weather + API_Key + location;

    //XML node keys
    static final String KEY_ITEM = "root";//parent node
    static final String KEY_NAME = "name";//name of city, string
    static final String KEY_WIND_MPH = "wind_mph";//wind mph, float
    static final String KEY_WIND_KPH = "wind_kph";//wind kph, float
    static final String KEY_C = "temp_c";//Temperature Celsius, int
    static final String KEY_C_FEELS = "feelslike_c";//Temperature feeling Celsius, float
    static final String KEY_F = "temp_f";//Temperature Fahrenheit, int
    static final String KEY_F_FEELS = "feelslike_f";//Temperature feeling Fahrenheit, float
    static final String KEY_HUMIDITY = "humidity";//Humidity Level, int
    static final String KEY_CONDITION_TEXT = "text";//Weather Condition i.e. cloudy, sunny, clear, string


    ArrayList<HashMap<String, String>> menuItems;

    private TextView txt;
    String xml;

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_view);

        menuItems = new ArrayList<HashMap<String, String>>();

        txt = (TextView) findViewById(R.id.weather_window);

        new weatherTask().execute();
       // weatherTask.parseXML();
    }

    private class weatherTask extends AsyncTask<Void, Void, Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            parseXML();
            return null;
        }

        private void parseXML(){


            XmlPullParserFactory parserFactory;
            try {
                parserFactory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = parserFactory.newPullParser();
                try {
                    InputStream is = new URL(URLT).openStream();
                    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    parser.setInput(is, null);

                    processParsing(parser);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

        }

        private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException{

            ArrayList<WeatherConditions> weather = new ArrayList<>();
            int eventType = parser.getEventType();
            WeatherConditions currentWeather = null;

            while(eventType != XmlPullParser.END_DOCUMENT){

                String sName = null;

                switch(eventType){
                    case XmlPullParser.START_TAG:
                        sName = parser.getName();

                        if ("root".equals(sName)){
                            currentWeather = new WeatherConditions();
                            weather.add(currentWeather);
                        }else if (currentWeather != null){
                            if ("name".equals(sName)){
                                currentWeather.name = parser.nextText();
                            }
                            else if ("wind_mph".equals(sName)){
                                currentWeather.wind_mph = parser.nextText();
                            }else if ("wind_kph".equals(sName)){
                                currentWeather.wind_kph = parser.nextText();
                            }else if ("celsius".equals(sName)){
                                currentWeather.celsius = parser.nextText();
                            }else if ("feelsCelsius".equals(sName)){
                                currentWeather.feelsCelsius = parser.nextText();
                            }else if ("fahrenheit".equals(sName)){
                                currentWeather.fahrenheit = parser.nextText();
                            }else if ("feelsFahrenheit".equals(sName)){
                                currentWeather.feelsFahrenheit = parser.nextText();
                            }else if ("humidity".equals(sName)){
                                currentWeather.humidity = parser.nextText();
                            }else if ("text".equals(sName)){
                                currentWeather.condition_text = parser.nextText();
                            }
                        }
                        break;
                }

                eventType = parser.next();
            }

            printWeather(weather);
        }

        private void printWeather(ArrayList<WeatherConditions> weather){

            StringBuilder builder = new StringBuilder();

            for (WeatherConditions weatherC : weather){

                builder.append(weatherC.name).append("\n").append(weatherC.wind_mph).append("\n").append(weatherC.wind_kph).append("\n").append(weatherC.celsius).append("\n").append(weatherC.feelsCelsius).
                        append("\n").append(weatherC.fahrenheit).append("\n").append(weatherC.feelsFahrenheit).append("\n").append(weatherC.humidity).append("\n").append(weatherC.condition_text).append("\n");

            }

            txt.setText(builder.toString());
        }

    }

}
