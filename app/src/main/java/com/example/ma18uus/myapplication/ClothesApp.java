package com.example.ma18uus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClothesApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_app);
    }

    public void HoodiesSweatShirts (View v){
        Intent hs = new Intent(this, HoodiesSweatShirts.class);
        startActivity(hs);
    }

    public void CoatsJackets (View v){
        Intent cj = new Intent(this, HoodiesSweatShirts.class);
        startActivity(cj);
    }

    public void Shirts (View v){
        Intent s = new Intent(this, HoodiesSweatShirts.class);
        startActivity(s);
    }

    public void Trousers (View v){
        Intent t = new Intent(this, HoodiesSweatShirts.class);
        startActivity(t);
    }

    public void Shoes (View v){
        Intent sh = new Intent(this, HoodiesSweatShirts.class);
        startActivity(sh);
    }

    public void Accessories (View v){
        Intent a = new Intent(this, HoodiesSweatShirts.class);
        startActivity(a);
    }
}