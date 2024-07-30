package com.example.cinematech.data.utilities;

import com.example.cinematech.data.model.GetMovie;
import com.example.cinematech.data.model.GetUser;
import com.example.cinematech.data.model.GetWatchlist;
import com.example.cinematech.data.model.LoginResponse;
import com.example.cinematech.data.model.RegisterResponse;
import com.example.cinematech.data.model.SearchMovie;
import com.example.cinematech.data.model.Watchlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;



//An interface is like a contract that defines a set of method signatures that a class must implement if it wants to adhere to that contract.
//It only includes method declarations, without method bodies.
//Classes can implement multiple interfaces, enabling them to inherit behavior from multiple sources.

//This interface is for API Service
public interface RegisterApiService {



    //@POST annotation is used to specify that the method will send an HTTP POST request.
    //It typically accompanies a method in an interface that represents the API service.
    //It is used when a new resources is created.
    @POST("register.php")
    Call<RegisterResponse> register(@Body RegisterResponse registerResponse);

    //@POST annotation is used to specify that the method will send an HTTP POST request.
    //It typically accompanies a method in an interface that represents the API service.
    //It is used when a new resources is created.
    @POST("api.php")
    Call<LoginResponse> getUser(@Body LoginResponse loginResponse);



    //@GET annotation is used to specify that the method will send an HTTP GET request.
    //It is commonly used for fetching data from the server without altering it.
    @GET("movie_api.php")
    Call<List<GetMovie>> getallMovie();




    //@POST annotation is used to specify that the method will send an HTTP POST request.
    //It typically accompanies a method in an interface that represents the API service.
    //It is used when a new resources is created.
    @POST("watchlist.php")
    Call<Watchlist> addToWatchlist(@Body Watchlist watchlist);




    //@POST annotation is used to specify that the method will send an HTTP POST request.
    //It typically accompanies a method in an interface that represents the API service.
    //It is used when a new resources is created.
    @POST("watchlist_movies.php")
    Call<List<GetWatchlist>> getWatchlistMovies(@Body GetWatchlist getWatchlist);




    //@POST annotation is used to specify that the method will send an HTTP POST request.
    //It typically accompanies a method in an interface that represents the API service.
    //It is used when a new resources is created.
    @POST("remove_watchlist.php")
    Call<Watchlist> removeWatchlist(@Body Watchlist watchlist);



    //@POST annotation is used to specify that the method will send an HTTP POST request.
    //It typically accompanies a method in an interface that represents the API service.
    //It is used when a new resources is created.
    @POST("search_api.php")
    Call<List<SearchMovie>> searchMovie(@Body SearchMovie searchMovie);

}
