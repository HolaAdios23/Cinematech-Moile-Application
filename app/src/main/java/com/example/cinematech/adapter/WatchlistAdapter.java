package com.example.cinematech.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinematech.R;
import com.example.cinematech.data.model.GetMovie;
import com.example.cinematech.data.model.GetWatchlist;
import com.example.cinematech.data.util.StringUtil;
import com.example.cinematech.data.utilities.RegisterApiClient;
import com.example.cinematech.screens.MovieDetail;
import com.example.cinematech.screens.WatchlistFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WatchlistAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    List<GetWatchlist> getMovies;
    Activity activity;

    public WatchlistAdapter(List<GetWatchlist> getMovies, Activity activity)
    {
        this.getMovies = getMovies;
        this.activity = activity;
        this.notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.watchlist_movie_viewholder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Picasso.get().load(getMovies.get(position).getImage()).into(holder.watchlistposter);
        holder.watchlistname.setText(getMovies.get(position).getMoviename());
        holder.watchlistdate.setText(getMovies.get(position).getReleasedate());
        holder.watchlistcategories.setText(getMovies.get(position).getCategories());

        holder.watchlistimbd.setText(getMovies.get(position).getImbd());

        if(getMovies.get(position).getEntertainment().equals("movie"))
        {
            holder.watchlistduration.setText(getMovies.get(position).getDuration() + "m");
        }
        else
        {
            holder.watchlistduration.setText(getMovies.get(position).getDuration() + " Episode");
        }


        holder.watchlistremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int check_movies = 0;
                RegisterApiClient registerApiClient = new RegisterApiClient();
                registerApiClient.removeWatchlist(getMovies.get(position).getId(), getMovies.get(position).getMovieid());
                System.out.println(getMovies.get(position).getMovieid() + "  " + getMovies.get(position).getId());


                for(GetWatchlist getWatchlist : StringUtil.getWatchlistMovies)
                {

                    if(getWatchlist.getMovieid().equals(getMovies.get(position).getMovieid()) && getWatchlist.getId().equals(getMovies.get(position).getId()))
                    {
                        break;

                    }

                    check_movies += 1;

                }

                StringUtil.getWatchlistMovies.remove(check_movies);

                notifyDataSetChanged();


            }
        });

        holder.watchlistposter.setOnClickListener(new View.OnClickListener() {
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
            }
        });



    }

    @Override
    public int getItemCount() {
        return getMovies.size();
    }
}
