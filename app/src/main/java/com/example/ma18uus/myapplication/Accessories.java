package com.example.ma18uus.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Accessories extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories);
        btn=(Button)findViewById(R.id.AddAccessories);
        btn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(i);
            }
        });
    }
}