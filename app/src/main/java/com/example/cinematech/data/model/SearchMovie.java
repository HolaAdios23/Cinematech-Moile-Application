package com.example.cinematech.data.model;

import com.google.gson.annotations.SerializedName;

//This class is used for to get data from movie database for search functionality
public class SearchMovie {

    //@SerializedName is an annotation provided by the Gson library, which is commonly used for JSON serialization and deserialization
    //This annotation allows to specify a custom name for a field in java class when it is serialized to JSON or deserialized from JSON

    @SerializedName("movieId")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String movieid;

    @SerializedName("moviename")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String moviename;

    @SerializedName("description")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String description;

    @SerializedName("director")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String director;

    @SerializedName("entertainment")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String entertainment;

    @SerializedName("categories")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String categories;

    @SerializedName("duration")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String duration;

    @SerializedName("imbd")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String imbd;

    @SerializedName("release_date")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String releasedate;

    @SerializedName("image")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String image;

    @SerializedName("cover_image")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String cover_image;

    public SearchMovie(String moviename) {
        this.moviename = moviename;
    }

    public String getMovieid() {
        return movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getEntertainment() {
        return entertainment;
    }

    public String getCategories() {
        return categories;
    }

    public String getDuration() {
        return duration;
    }

    public String getImbd() {
        return imbd;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public String getImage() {
        return image;
    }

    public String getCover_image() {
        return cover_image;
    }
}
