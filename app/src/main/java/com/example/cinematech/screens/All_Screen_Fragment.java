package com.example.cinematech.screens;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.cinematech.R;
import com.example.cinematech.adapter.All_Screen_Adapter;
import com.example.cinematech.adapter.MovieAdapter;
import com.example.cinematech.data.model.GetMovie;
import com.example.cinematech.data.util.StringUtil;
import com.example.cinematech.data.utilities.RegisterApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class All_Screen_Fragment extends Fragment {


    ViewPager2 viewPager2;
    ScrollView scrollView;
    RecyclerView movierecycler, tvrecycler;
    int scroll_num = 0;
    int three_slide = 0;

    int count =0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all__screen_, container, false);

        scrollView = view.findViewById(R.id.all_scroll);

        viewPager2 = view.findViewById(R.id.all_imageslide);

        movierecycler = view.findViewById(R.id.movie_recyclerview);
        tvrecycler = view.findViewById(R.id.tvshow_recyclerview);

        ArrayList<GetMovie> heading_slide = new ArrayList<>();
        ArrayList<GetMovie> latestmovies = new ArrayList<>();
        ArrayList<GetMovie> latesttvshow = new ArrayList<>();



        for(GetMovie getMovie : StringUtil.getallmovies)
        {

            if(three_slide < 3)
            {

                heading_slide.add(new GetMovie(getMovie.getMovieid(), getMovie.getMoviename(), getMovie.getDescription(), getMovie.getDirector(), getMovie.getEntertainment(), getMovie.getCategories(), getMovie.getDuration(), getMovie.getImbd(), getMovie.getReleasedate(), getMovie.getImage(), getMovie.getCover_image()));


                three_slide += 1;
            }

        }
        All_Screen_Adapter allScreenAdapter = new All_Screen_Adapter(heading_slide);

        viewPager2.setAdapter(allScreenAdapter);

        for(GetMovie getMovies : StringUtil.getallmovies)
        {
            if(getMovies.getReleasedate().equals("2024") && getMovies.getEntertainment().equals("movie"))
            {
                latestmovies.add(new GetMovie(getMovies.getMovieid(), getMovies.getMoviename(), getMovies.getDescription(), getMovies.getDirector(), getMovies.getEntertainment(), getMovies.getCategories(), getMovies.getDuration(), getMovies.getImbd(), getMovies.getReleasedate(), getMovies.getImage(), getMovies.getCover_image()));

            }
        }

        for(GetMovie gettvshow : StringUtil.getallmovies)
        {
            if(gettvshow.getReleasedate().equals("2024") && gettvshow.getEntertainment().equals("tvshow"))
            {
                latesttvshow.add(new GetMovie(gettvshow.getMovieid(), gettvshow.getMoviename(), gettvshow.getDescription(), gettvshow.getDirector(), gettvshow.getEntertainment(), gettvshow.getCategories(), gettvshow.getDuration(), gettvshow.getImbd(), gettvshow.getReleasedate(), gettvshow.getImage(), gettvshow.getCover_image()));
            }
        }


        MovieAdapter movieAdapter = new MovieAdapter(latestmovies, getActivity());
        MovieAdapter tvadapter = new MovieAdapter(latesttvshow, getActivity());

        LinearLayoutManager movielayout = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        LinearLayoutManager tvlayout = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        movierecycler.setAdapter(movieAdapter);
        movierecycler.setLayoutManager(movielayout);

        tvrecycler.setAdapter(tvadapter);
        tvrecycler.setLayoutManager(tvlayout);




        setThree_slide();
        scrollview();

        return view;
    }

    public void scrollview()
    {

        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {


//                Log.d(null, String.valueOf(v.getScrollY()));

                if(v.getScrollY() > 50)
                {
                    scroll_num = 1;
                }
                else if(v.getScrollY() < 50)
                {
                    scroll_num = 5;
                }



                if(scroll_num == 1)
                {
                    LinearLayout.LayoutParams optionssize = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
                    HomeFragment.optionsbutton.setLayoutParams(optionssize);
                    scroll_num += 1;
                }
                else if(scroll_num == 5)
                {
                    LinearLayout.LayoutParams optionssize = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    HomeFragment.optionsbutton.setLayoutParams(optionssize);
                    scroll_num += 1;
                }

            }
        });



    }

    public void setThree_slide()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try{

                    Thread.sleep(3000);
                }
                catch (InterruptedException ea)
                {

                    ea.printStackTrace();
                }


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if(count < 3)
                        {
                            viewPager2.setCurrentItem(count);

//                            System.out.println(count);
                            count += 1;
                        }
                        else
                        {
                            count = 0;
                        }


                        setThree_slide();
                    }
                });


            }
        }).start();

    }
}