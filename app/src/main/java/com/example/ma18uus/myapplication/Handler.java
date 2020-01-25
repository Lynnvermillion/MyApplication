package com.example.ma18uus.myapplication;

import android.util.Log;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler
{

    // Create three array lists to store the data

    //Humidity Arrays
    public ArrayList<Integer> humidityDs = new ArrayList<Integer>();

    //Wind Speed Arrays
    public ArrayList<Float> windKphs = new ArrayList<Float>();
    public ArrayList<Float> windMphs = new ArrayList<Float>();

    //Tempratures
    public ArrayList<Integer> tempCs = new ArrayList<Integer>();
    public ArrayList<Float> tempCFeels = new ArrayList<Float>();
    public ArrayList<Integer> tempFs = new ArrayList<Integer>();
    public ArrayList<Float> tempFFeels = new ArrayList<Float>();

    //Condition's arrays
    public ArrayList<String> conditions = new ArrayList<String>();

    //Region's arrays
    public ArrayList<String> regions = new ArrayList<String>();


    // Make sure that the code in DefaultHandler's
    // constructor is called:
    public Handler()
    {
        super();
    }


    /*** Below are the three methods that we are extending ***/

    @Override
    public void startDocument()
    {
        System.out.println("Start document");
    }


    @Override
    public void endDocument()
    {
        System.out.println("End document");
    }

    //Keeps track of the current tag;
    String currentTag = "";

    // This is where all the work is happening:
    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
        //Save the current tag being handled
        currentTag = qName;
    }

    //Detect end tag
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Reset it
        currentTag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //Rules based on current tag
        switch (currentTag) {
            case "region":
                String region = String.valueOf(ch, start, length);
                this.regions.add(region);
                System.out.println("Region : " + region);
                break;
            case "temp_c":
                int tempC = Integer.parseInt(String.valueOf(ch, start, length));
                System.out.println("Temprature in Celsius : " + tempC);
                this.tempCs.add(tempC);
                break;
            case "feelslike_c":
                float tempCFeel = Float.parseFloat(String.valueOf(ch, start, length));
                System.out.println("Temprature Feels like in Celsius : " + tempCFeel);
                this.tempCFeels.add(tempCFeel);
                break;
            case "temp_f":
                int tempF = Integer.parseInt(String.valueOf(ch, start, length));
                System.out.println("Temprature in Farenheit : " + tempF);
                this.tempFs.add(tempF);
                break;
            case "feelslike_f":
                float tempFFeel = Float.parseFloat(String.valueOf(ch, start, length));
                System.out.println("Temprature Feels in Farenheit : " + tempFFeel);
                this.tempFFeels.add(tempFFeel);
                break;
            case "text":
                String condition = String.valueOf(ch, start, length);
                this.conditions.add(condition);
                System.out.println("Condition : " + condition);
                Log.i("condition", "done");
                break;
            case "wind_mph":
                float windMph = Float.parseFloat(String.valueOf(ch, start, length));
                System.out.println("Wind MPH : " + windMph);
                this.windMphs.add(windMph);
                break;
            case "wind_kph":
                float windKph = Float.parseFloat(String.valueOf(ch, start, length));
                System.out.println("Wind KPH : " + windKph);
                this.windKphs.add(windKph);
                break;
            case "humidity":
                int humidityD = Integer.parseInt(String.valueOf(ch, start, length));
                System.out.println("Humidity : " + humidityD);
                this.humidityDs.add(humidityD);
                break;
        }

    }
}
