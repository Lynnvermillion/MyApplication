package com.example.ma18uus.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CoatsJackets extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coats_jackets);
        btn=(Button)findViewById(R.id.AddCoatsJackets);
        btn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(i);
            }
        });
    }
}