package com.example.cinematech.data.util;

import com.example.cinematech.data.model.GetMovie;
import com.example.cinematech.data.model.GetWatchlist;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {



    //Users details from datrbase such as userid, username and email
    public static String userId = null;
    public static String username = null;
    public static String email = null;

    /////////////////////////////////////////////////////////////////////////////


    //Movie Detail from database moviename, moviedate, moviecategories, movieduration, movieimbd, moviedirector
    //moviecoverimage url,
    public static String movie_name = null;
    public static String movie_date = null;
    public static String movie_categories = null;
    public static String movie_duration = null;
    public static String movie_imbd = null;
    public static String movie_director = null;
    public static String movie_cover_image_url = null;
    public static String movie_image_url = null;


    ///////////////////////////////////////////////////////////////////////////////
    public static ArrayList<GetMovie> getallmovies = new ArrayList<>(); // All Movie data from database
    public static List<GetWatchlist> getWatchlistMovies = new ArrayList<>(); // All movie data from watchlist database


}
