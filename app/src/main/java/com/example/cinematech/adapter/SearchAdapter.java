package com.example.cinematech.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinematech.R;
import com.example.cinematech.data.model.GetMovie;
import com.example.cinematech.data.model.SearchMovie;
import com.example.cinematech.data.util.StringUtil;
import com.example.cinematech.data.utilities.RegisterApiClient;
import com.example.cinematech.screens.MovieDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    List<SearchMovie> getMovies;
    Activity activity;

    public SearchAdapter(List<SearchMovie> getMovies, Activity activity)
    {
        this.getMovies = getMovies;
        this.activity = activity;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.search_movie_viewholder, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Picasso.get().load(getMovies.get(position).getImage()).into(holder.searchimageposter);
        holder.searchmoviename.setText(getMovies.get(position).getMoviename());
        holder.searchimbdrating.setText(getMovies.get(position).getImbd());

        holder.searchaddtowatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterApiClient registerApiClient = new RegisterApiClient();
                registerApiClient.addtowatchlist(StringUtil.userId, getMovies.get(position).getMovieid());
                System.out.println(getMovies.get(position).getMovieid() + "  " + StringUtil.userId);
            }
        });

        holder.searchimageposter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringUtil.movie_name = getMovies.get(position).getMoviename();
                StringUtil.movie_cover_image_url = getMovies.get(position).getCover_image();
                StringUtil.movie_image_url = getMovies.get(position).getImage();
                StringUtil.movie_date = getMovies.get(position).getReleasedate();
                StringUtil.movie_categories = getMovies.get(position).getCategories();

                if(getMovies.get(position).getEntertainment().equals("movie"))
                {
                    StringUtil.movie_duration = getMovies.get(position).getDuration() + "m";
                }
                else
                {
                    StringUtil.movie_duration = getMovies.get(position).getDuration() + " Episode";
                }

                StringUtil.movie_imbd = getMovies.get(position).getImbd();
                StringUtil.movie_director = getMovies.get(position).getDirector();

                Intent intent = new Intent(activity, MovieDetail.class);
                activity.startActivity(intent);

                Log.d("Adapt", "Clicked!");
            }
        });

    }

    @Override
    public int getItemCount() {
        return getMovies.size();
    }
}
