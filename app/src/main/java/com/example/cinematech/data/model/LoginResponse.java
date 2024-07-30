package com.example.cinematech.data.model;

import com.google.gson.annotations.SerializedName;

//This class is for login of user
public class LoginResponse {

    //@SerializedName is an annotation provided by the Gson library, which is commonly used for JSON serialization and deserialization
    //This annotation allows to specify a custom name for a field in java class when it is serialized to JSON or deserialized from JSON

    @SerializedName("userid")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String id;

    @SerializedName("username")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String username;


    @SerializedName("password")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String password;

    @SerializedName("email")//This annotation is used to specify that the field 'fieldName' should be serialized as 'Custom_name' in the JSON output, regardless of its actual name in the java class.
    private String email;

    public LoginResponse(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    @Override
    public String toString()
    {
        return "GetUser{" +
                ", username = " + username +
                ", password= " + email +
                ", password= " + password + '}';
    }
}
