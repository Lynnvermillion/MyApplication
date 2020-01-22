package com.example.ma18uus.imagesandtext;

/**
 * Created by ma18uus on 22/01/2020.
 */

public class Clothes {
    private int id;
    private String Clothes;
    private String Weather;
    private String Prefrence;
    private String Tag;
    private byte[] image;


    public Clothes(String clothes, String weather, String prefrence, String tag, byte[] image, int id) {
        this.Clothes = clothes;
        this.Weather = weather;
        this.Prefrence = prefrence;
        this.Tag = tag;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClothes() {
        return Clothes;
    }

    public void setClothes(String clothes) {
        this.Clothes = clothes;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        this.Weather = weather;
    }

    public String getPrefrence() {
        return Prefrence;
    }

    public void setPrefrence(String prefrence) {
        this.Prefrence = prefrence;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        this.Tag = tag;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
