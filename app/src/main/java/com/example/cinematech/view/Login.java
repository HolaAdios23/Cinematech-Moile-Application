package com.example.cinematech.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.cinematech.R;
import com.example.cinematech.data.model.GetUser;
import com.example.cinematech.data.utilities.RegisterApiClient;
import com.example.cinematech.data.utilities.RegisterApiService;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    View loginback;
    Button loginbutton;

    EditText userlogin, userpassword;

    ArrayList<GetUser> getdata = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginback = findViewById(R.id.login_back);
        loginbutton = findViewById(R.id.login_button);

        userlogin = findViewById(R.id.login_user);
        userpassword = findViewById(R.id.userpassword);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterApiClient registerApiClient = new RegisterApiClient();
//                registerApiClient.getAllData();
//               registerApiClient.getAllData(userlogin, userpassword, Login.this);
                registerApiClient.loginUser(String.valueOf(userlogin.getText()), String.valueOf(userpassword.getText()), Login.this);

                registerApiClient.getMovieInfo();


            }
        });

        loginback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}