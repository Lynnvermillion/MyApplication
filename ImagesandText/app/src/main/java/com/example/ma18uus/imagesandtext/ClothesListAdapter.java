package com.example.ma18uus.imagesandtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ma18uus on 22/01/2020.
 */


//create custom adapter and override its getView() method
public class ClothesListAdapter extends BaseAdapter{

    private Context context;
    private  int layout;
    private ArrayList<Clothes> clothesList;

    public ClothesListAdapter(Context context, int layout, ArrayList<Clothes> clothesList) {
        this.context = context;
        this.layout = layout;
        this.clothesList = clothesList;
    }

    @Override
    public int getCount() {
        return clothesList.size();
    }

    @Override
    public Object getItem(int position) {
        return clothesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    private class ViewHolder{
        ImageView imageView;
        TextView Clothestxt, Weathertxt, Prefrencetxt, Tagtxt;
    }



    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;

        ViewHolder holder = new ViewHolder();



        if(row == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.Clothestxt = (TextView) row.findViewById(R.id.Clothestxt);
            holder.Weathertxt = (TextView) row.findViewById(R.id.Weathertxt);
            holder.Prefrencetxt = (TextView) row.findViewById(R.id.Prefrencetxt);
            holder.Tagtxt = (TextView) row.findViewById(R.id.Tagtxt);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Clothes food = clothesList.get(position);
        holder.Clothestxt.setText(food.getClothes());
        holder.Weathertxt.setText(food.getWeather());
        holder.Prefrencetxt.setText(food.getPrefrence());
        holder.Tagtxt.setText(food.getTag());

        byte[] clothesImage = food.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(clothesImage, 0, clothesImage.length);
        holder.imageView.setImageBitmap(bitmap);



        return row;





    }
}
