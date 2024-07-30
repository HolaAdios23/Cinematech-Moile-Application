package com.example.cinematech.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinematech.R;
import com.google.android.material.imageview.ShapeableImageView;

public class All_Screen_Viewholder extends RecyclerView.ViewHolder {


    ShapeableImageView allscreenslide;

    public All_Screen_Viewholder(@NonNull View itemView) {
        super(itemView);

        allscreenslide = itemView.findViewById(R.id.slide_image);
    }
}
