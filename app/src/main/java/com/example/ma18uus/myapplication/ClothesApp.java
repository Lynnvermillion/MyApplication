package com.example.ma18uus.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ClothesApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_app);
    }
    public void Menu (View v){
        Intent hs = new Intent(this, HoodiesSweatShirts.class);
        startActivity(hs);
    }

    public void HoodiesSweatShirts (View v){
        Intent hs = new Intent(this, HoodiesSweatShirts.class);
        startActivity(hs);
    }

    public void CoatsJackets (View v){
        Intent cj = new Intent(this, CoatsJackets.class);
        startActivity(cj);
    }

    public void Shirts (View v){
        Intent s = new Intent(this, Shirts.class);
        startActivity(s);
    }

    public void Trousers (View v){
        Intent t = new Intent(this, Trousers.class);
        startActivity(t);
    }

    public void Shoes (View v){
        Intent sh = new Intent(this, Shoes.class);
        startActivity(sh);
    }

    public void Accessories (View v){
        Intent a = new Intent(this, Accessories.class);
        startActivity(a);
    }

    public void weatherView(View v){
        Intent w = new Intent(this, weatherView.class);
        startActivity(w);
    }

}
