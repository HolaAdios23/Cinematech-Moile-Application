package com.example.cinematech.screens;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cinematech.R;
import com.example.cinematech.data.util.StringUtil;
import com.example.cinematech.view.Login;
import com.squareup.picasso.Picasso;


public class ProfileFragment extends Fragment {

    LinearLayout logout, buttonaboutus, contactus, myprofile;
    ImageView imageView;

    TextView profilename, profileemail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imageView = view.findViewById(R.id.profile_image);

        myprofile = view.findViewById(R.id.myprofile_button);
        contactus = view.findViewById(R.id.contact_us_button);
        profilename = view.findViewById(R.id.profile_name);
        profileemail = view.findViewById(R.id.profile_email);
        buttonaboutus = view.findViewById(R.id.button_about_us);


        myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyProfile.class);
                startActivity(intent);
            }
        });


        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContactUs.class);
                startActivity(intent);
            }
        });



        buttonaboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aboutpage = new Intent(getActivity(), AboutUs.class);
                startActivity(aboutpage);
            }
        });

        profilename.setText(StringUtil.username);
        profileemail.setText(StringUtil.email);

        logout = view.findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });


        return view;
    }


}