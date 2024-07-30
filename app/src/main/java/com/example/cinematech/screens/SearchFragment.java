package com.example.cinematech.screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinematech.R;
import com.example.cinematech.data.utilities.RegisterApiClient;

import java.security.Key;

public class SearchFragment extends Fragment{


    RecyclerView recyclerView;
    EditText searchinput;
    View searchbutton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchinput = view.findViewById(R.id.search_input);
        searchbutton = view.findViewById(R.id.search_button);
        recyclerView = view.findViewById(R.id.search_recyclerview);



        searchinput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String searchname = searchinput.getText().toString();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                RegisterApiClient registerApiClient = new RegisterApiClient();
                registerApiClient.searchMovie(searchname, recyclerView, getActivity(), gridLayoutManager);



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchname = searchinput.getText().toString();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                RegisterApiClient registerApiClient = new RegisterApiClient();
                registerApiClient.searchMovie(searchname, recyclerView, getActivity(), gridLayoutManager);
            }
        });




        return view;
    }
}