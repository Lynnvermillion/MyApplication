package com.example.ma18uus.imagesandtext;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by ma18uus on 22/01/2020.
 */

public class ClothesList extends AppCompatActivity{

    //create this activity and then display all data in GridView

    GridView gridView;
    ArrayList<Clothes> list;
    ClothesListAdapter adapter = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothes_list_activity);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new ClothesListAdapter(this, R.layout.clothes_items, list);
        gridView.setAdapter(adapter);



        // get all data from sqlite
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM CLOTHES");
        list.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String clothes = cursor.getString(1);
            String weather = cursor.getString(2);
            String prefrence = cursor.getString(3);
            String tag = cursor.getString(4);
            byte[] image = cursor.getBlob(5);

            list.add(new Clothes(clothes, weather, prefrence, tag, image, id));
        }
        /*adapter.notifyDataSetChanged();*/








    }






}
