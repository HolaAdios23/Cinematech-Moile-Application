package com.example.cinematech.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinematech.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    ImageView movieimage, watchlistposter;
    TextView moviename, imbdrating, moviedate, watchlistname, watchlistimbd, watchlistdate, watchlistcategories, watchlistduration;

    //Search movie view holder
    TextView searchmoviename, searchimbdrating;
    ImageView searchimageposter;

    View searchaddtowatchlist;


    //////////////////////////////////////

    Button watchlistremove;
    View addtowatchlist;
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        searchimageposter = itemView.findViewById(R.id.search_movie_image);
        searchmoviename = itemView.findViewById(R.id.search_movie_name);
        searchimbdrating = itemView.findViewById(R.id.search_imbd_rating);
        searchaddtowatchlist = itemView.findViewById(R.id.search_addto_watchlist);






        movieimage = itemView.findViewById(R.id.movie_image);
        moviename = itemView.findViewById(R.id.movie_name);
        imbdrating = itemView.findViewById(R.id.imbd_rating);
        moviedate = itemView.findViewById(R.id.movie_date);
        addtowatchlist = itemView.findViewById(R.id.addto_watchlist);

        watchlistposter = itemView.findViewById(R.id.watchlist_movieposter);
        watchlistname = itemView.findViewById(R.id.watchlist_moviename);
        watchlistimbd = itemView.findViewById(R.id.watchlist_imbd);
        watchlistdate = itemView.findViewById(R.id.watchlist__date);
        watchlistcategories = itemView.findViewById(R.id.watchlist_categories);
        watchlistremove = itemView.findViewById(R.id.watchlist_remove);
        watchlistduration = itemView.findViewById(R.id.watchlist__duration);




    }
}
