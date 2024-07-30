package com.example.cinematech.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.cinematech.R;
import com.example.cinematech.data.util.StringUtil;

public class MyProfile extends AppCompatActivity {

    View profile_back;
    EditText myusername, myemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);


        myusername = findViewById(R.id.my_username);
        myemail = findViewById(R.id.my_email);

        myusername.setText(StringUtil.username);
        myemail.setText(StringUtil.email);

        profile_back = findViewById(R.id.profile_back);
        profile_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}