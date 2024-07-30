package com.example.cinematech.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinematech.R;
import com.example.cinematech.data.model.GetMovie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class All_Screen_Adapter extends RecyclerView.Adapter<All_Screen_Viewholder> {

    ArrayList<GetMovie> arrayList;

    public All_Screen_Adapter(ArrayList<GetMovie> arrayList)
    {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public All_Screen_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new All_Screen_Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.all_imageviewpager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull All_Screen_Viewholder holder, int position) {

        Picasso.get().load(arrayList.get(position).getImage()).into(holder.allscreenslide);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
