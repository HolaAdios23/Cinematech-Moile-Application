package com.example.cinematech.data.model;

import com.google.gson.annotations.SerializedName;

//This class is for to get all users data from database
public class GetUser {
    //@SerializedName is an annotation provided by the Gson library, which is commonly used for JSON serialization and deserialization
    //This annotation allows to specify a custom name for a field in java class when it is serialized to JSON or deserialized from JSON

    @SerializedName("id")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private int userId;

    @SerializedName("username")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String username;

    @SerializedName("email")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String email;

    @SerializedName("password")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String password;

    public GetUser(int userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "GetUser{" +
                "userId = " + userId +
                ", username = " + username +
                ", email= " + email + '\'' +
                ", password= " + password + '\'' +
                '}';
    }
}
