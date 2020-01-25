package com.example.ma18uus.imagesandtext;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
/**
 * Created by ma18uus on 22/01/2020.
 */

public class SQLiteHelper extends SQLiteOpenHelper{


    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    //insert data into database
    public void insertData(String Clothes, String Weather, String Prefrence, String Tag, byte[] image){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO CLOTHES VALUES (NULL, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, Clothes);
        statement.bindString(2, Weather);
        statement.bindString(3, Prefrence);
        statement.bindString(4, Tag);
        statement.bindBlob(5, image);
        statement.executeInsert();

    }




    //get all data from database
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }


    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }



    @Override

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }




}
