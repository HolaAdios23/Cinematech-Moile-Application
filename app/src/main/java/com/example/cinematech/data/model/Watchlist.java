package com.example.cinematech.data.model;

import com.google.gson.annotations.SerializedName;


//This class is used for the serialized watchlist api from database
public class Watchlist {


    //@SerializedName is an annotation provided by the Gson library, which is commonly used for JSON serialization and deserialization
    //This annotation allows to specify a custom name for a field in java class when it is serialized to JSON or deserialized from JSON

    @SerializedName("user_id") //This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String userid;

    @SerializedName("movie_id") //This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String movie_id;


    //Constructor in java is special type of method that is automatically invokedd when an object is created.
    //it is used for initalize the newly created object.
    public Watchlist(String userid, String movie_id) {
        this.userid = userid;
        this.movie_id = movie_id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public String getUserid() {
        return userid;
    }
}
