package com.example.cinematech.screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cinematech.R;
import com.example.cinematech.data.util.StringUtil;
import com.example.cinematech.data.utilities.RegisterApiClient;

public class WatchlistFragment extends Fragment {

    RecyclerView watchlistmovies;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_watchlist, container, false);

        watchlistmovies = view.findViewById(R.id.watchlist_movies);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        RegisterApiClient registerApiClient = new RegisterApiClient();
//        registerApiClient.getWatchlistMovies(StringUtil.userId, watchlistmovies, layoutManager, getActivity());


        registerApiClient.getAllWatchList(StringUtil.userId, watchlistmovies, layoutManager, getActivity());




        return view;
    }
}