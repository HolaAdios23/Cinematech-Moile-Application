package com.example.cinematech.data.utilities;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinematech.adapter.SearchAdapter;
import com.example.cinematech.adapter.WatchlistAdapter;
import com.example.cinematech.data.model.GetMovie;
import com.example.cinematech.data.model.GetWatchlist;
import com.example.cinematech.data.model.LoginResponse;
import com.example.cinematech.data.model.RegisterResponse;
import com.example.cinematech.data.model.SearchMovie;
import com.example.cinematech.data.model.Watchlist;
import com.example.cinematech.data.util.StringUtil;
import com.example.cinematech.screens.ProfileFragment;
import com.example.cinematech.view.Navigation;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterApiClient {


    //Retrofit is a popular HTTP client library for Android (and Java) developed by Square, Inc.
    //It simplifies the process of sending network requests and handling the associated responses in android app.
    //Retrofit makes it easy to communicate with web services and APIs by turning HTTP API call into java interaces.
    public Retrofit retrofit = new Retrofit.Builder() // This builder allows to set various configuration options such as base URL, converters, HTTP client.
            .baseUrl("http://100.64.208.241/cinematech_app/")
            .addConverterFactory(GsonConverterFactory.create())//Adds a converter factory for serialization and deserialization of request and response bodies.
            .build();



    //This method call creates an implementation of the 'RegisterApiService' interface at runtime.
    //Retrofit dynamically generates the implementation based on the annotations and method signatures defined in the interface.
    public RegisterApiService registerApiService = retrofit.create(RegisterApiService.class);

    List<LoginResponse> getUsers = new ArrayList<>();

    List<GetMovie> getMovieList = new ArrayList<>();

    List<SearchMovie> searchMovies = new ArrayList<>();

    public void loginUser(String username, String password, Activity activity)
    {
        LoginResponse loginResponse = new LoginResponse(username, password);
        Call<LoginResponse> call = registerApiService.getUser(loginResponse);
        Log.d("api called", "login data");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response)
            {
                if(response.isSuccessful())
                {
                    LoginResponse loginResponse1 =  (LoginResponse) response.body();
                    String user = loginResponse1.getUsername();
                    String pass = loginResponse1.getPassword();
                    String email = loginResponse1.getEmail();

                    System.out.println(email);

                    if(user.equals(username) && pass.equals(password))
                    {


                        StringUtil.userId = loginResponse1.getId();
                        StringUtil.username = user;
                        StringUtil.email = email;
                        Intent intent = new Intent(activity, Navigation.class);
                        activity.startActivity(intent);
                    }


                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(activity, "Either Username or password is incorrect!", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void registerUser(String username, String email, String password)
    {
        RegisterResponse registerResponse = new RegisterResponse(username, email, password);
        Call<RegisterResponse> call = registerApiService.register(registerResponse);
        Log.d("api call", "in data");

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("api called", "in response");
                if(response.isSuccessful())
                {

                    Log.d("api user", String.valueOf(response.body()));
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                System.out.println(call.request().url());
                System.out.println(t.getMessage());
            }
        });
    }

    public void addtowatchlist(String user_id, String movie_id)
    {
        Watchlist watchlist = new Watchlist(user_id, movie_id);
        Call<Watchlist> call = registerApiService.addToWatchlist(watchlist);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d(null, "Successfully Added!");
                if (response.isSuccessful())
                {

                    Log.d(null, "Successfully Added!");

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                System.out.println(call.request().url());
                System.out.println(t.getMessage());
            }
        });

    }

    public void removeWatchlist(String user_id, String movie_id)
    {
        Watchlist watchlist = new Watchlist(user_id, movie_id);
        Call<Watchlist> call = registerApiService.removeWatchlist(watchlist);
        Log.d("delete", "incomming");
        call.enqueue(new Callback<Watchlist>() {
            @Override
            public void onResponse(Call<Watchlist> call, Response<Watchlist> response) {
                if(response.isSuccessful())
                {
                    Log.d("delete", "Sucessfully remove response");


                }
            }

            @Override
            public void onFailure(Call<Watchlist> call, Throwable t) {
                System.out.println(call.request().url());
                System.out.println(t.getMessage());
            }
        });
    }
    public void getMovieInfo()
    {
        Call<List<GetMovie>> call = registerApiService.getallMovie();
        Log.d("movie response", "in data");
        call.enqueue(new Callback<List<GetMovie>>() {
            @Override
            public void onResponse(Call<List<GetMovie>> call, Response<List<GetMovie>> response) {

                if(response.isSuccessful())
                {
                    Log.d("movie response", "in response");
                    try
                    {
                        getMovieList = (List<GetMovie>) response.body();

                        assert getMovieList != null;

                        for(GetMovie getMovies : getMovieList)
                        {

                           StringUtil.getallmovies.add(new GetMovie(getMovies.getMovieid(), getMovies.getMoviename(), getMovies.getDescription(), getMovies.getDirector(), getMovies.getEntertainment(), getMovies.getCategories(), getMovies.getDuration(), getMovies.getImbd(), getMovies.getReleasedate(), getMovies.getImage(), getMovies.getCover_image()));


                        }



                    }catch (Exception ea)
                    {
                        ea.printStackTrace();

                    }

                }
            }

            @Override
            public void onFailure(Call<List<GetMovie>> call, Throwable t) {
                System.out.println(call.request().url());
                System.out.println(t.getMessage());
            }
        });


    }

    public void searchMovie(String movie_name, RecyclerView recyclerView, Activity activity, GridLayoutManager gridLayoutManager)
    {

        SearchMovie searchMovie = new SearchMovie(movie_name);
        Call<List<SearchMovie>> searchMovieCall = registerApiService.searchMovie(searchMovie);
        Log.d("Search", "incoming");
        searchMovieCall.enqueue(new Callback<List<SearchMovie>>() {
            @Override
            public void onResponse(Call<List<SearchMovie>> call, Response<List<SearchMovie>> response) {
                if(response.isSuccessful())
                {

                    searchMovies = (List<SearchMovie>)response.body();


                    assert searchMovies != null;
                    for(SearchMovie searchMovie1: searchMovies)
                    {
                        System.out.println(searchMovie1.getImbd());
                    }

                    SearchAdapter searchAdapter = new SearchAdapter(searchMovies, activity);

                    recyclerView.setAdapter(searchAdapter);
                    recyclerView.setLayoutManager(gridLayoutManager);

                    Log.d("Search", "Search responded");
                }

            }

            @Override
            public void onFailure(Call<List<SearchMovie>> call, Throwable t) {
                Log.d("Search", "not responded");
            }
        });
    }

    public void getAllWatchList(String user_id, RecyclerView recyclerView, LinearLayoutManager layoutManager, Activity activity)
    {
        GetWatchlist getWatchlist = new GetWatchlist(user_id);
        Call<List<GetWatchlist>> getwatchlist = registerApiService.getWatchlistMovies(getWatchlist);

        Log.d("get_watchlist", "Incomming!");
        getwatchlist.enqueue(new Callback<List<GetWatchlist>>() {
            @Override
            public void onResponse(Call<List<GetWatchlist>> call, Response<List<GetWatchlist>> response) {

                if(response.isSuccessful())
                {
                    Log.d("getWatchlist", "Sucessfully responded");
                    StringUtil.getWatchlistMovies = (List<GetWatchlist>) response.body();

                    for(GetWatchlist getWatchlist1: StringUtil.getWatchlistMovies)
                    {
                        Log.d(null, getWatchlist1.getMoviename());
                    }
                    WatchlistAdapter watchlistAdapter = new WatchlistAdapter(StringUtil.getWatchlistMovies, activity);

                    recyclerView.setAdapter(watchlistAdapter);
                    recyclerView.setLayoutManager(layoutManager);


                    watchlistAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<GetWatchlist>> call, Throwable t) {

                System.out.println(call.request().url());
                System.out.println(t.getMessage());
            }
        });
    }


}
