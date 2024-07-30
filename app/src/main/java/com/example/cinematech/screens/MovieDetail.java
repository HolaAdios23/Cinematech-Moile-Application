package com.example.cinematech.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinematech.R;
import com.example.cinematech.data.util.StringUtil;
import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {



    View backbutton;
    TextView moviename, moviedate, moviecategories, movieduration, movieimbd, moviedirector;
    ImageView coverimage, movieposter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        backbutton =  findViewById(R.id.moviedetail_back);
        coverimage = findViewById(R.id.top_image);
        movieposter = findViewById(R.id.movie_poster);
        moviename = findViewById(R.id.description_name);
        moviedate = findViewById(R.id.description_date);
        moviecategories = findViewById(R.id.description_categories);
        movieduration = findViewById(R.id.description_duration);
        movieimbd = findViewById(R.id.description_imbd);
        moviedirector = findViewById(R.id.description_director_name);

        moviename.setText(StringUtil.movie_name);
        moviedate.setText(StringUtil.movie_date);
        moviecategories.setText(StringUtil.movie_categories);
        movieduration.setText(StringUtil.movie_duration);
        movieimbd.setText(StringUtil.movie_imbd + " / 10");
        moviedirector.setText(StringUtil.movie_director);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

      Picasso.get().load(StringUtil.movie_cover_image_url).into(coverimage);
        Picasso.get().load(StringUtil.movie_image_url).into(movieposter);


    }
}