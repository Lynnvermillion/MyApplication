package com.example.ma18uus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class weatherView extends AppCompatActivity {

    private static final String TAG = weatherView.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_view);

        try {

           URL();

           // Log.i(TAG, "OnCreate: weatherUrl:" + );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void URL() throws Exception {

        //Main url
        String main_url = "http://api.weatherapi.com/v1/";

        //Live or Weekly forecast
        String live_weather = "current.xml?key=";
        //String sevendays_weather = "orecast.xml?key=";

        //API Key + q
        String API_Key = "c3bdfadb90d5452bb8003318201801&q=";

        //Location Setters
        String location = "London";


        InputSource inSource = null;
        InputStream in = null;

        XMLReader xr = null;

        String complete_url = null;

        URL urlObject = null;

        try
        {
            // Turn the string into a URL object
            complete_url = main_url + live_weather + API_Key + location;
            urlObject = new URL(complete_url);

            // Open the stream (which returns an InputStream):
            in = urlObject.openStream();

            /** Now parse the data (the stream) that we received back ***/

            // Create an XML reader
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            xr = parser.getXMLReader();

            // Tell that XML reader to use our special Google Handler
            Handler ourSpecialHandler = new Handler();
            xr.setContentHandler(ourSpecialHandler);

            // We have an InputStream, but let's just wrap it in
            // an InputSource (the SAX parser likes it that way)
            inSource = new InputSource(in);

            // And parse it!
            xr.parse(inSource);

        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch(SAXException se)
        {
            se.printStackTrace();
        }

    }

}
