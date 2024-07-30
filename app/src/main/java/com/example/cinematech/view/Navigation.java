package com.example.cinematech.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cinematech.R;
import com.example.cinematech.data.utilities.RegisterApiClient;
import com.example.cinematech.screens.HomeFragment;
import com.example.cinematech.screens.ProfileFragment;
import com.example.cinematech.screens.SearchFragment;
import com.example.cinematech.screens.WatchlistFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Navigation extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    WatchlistFragment watchlistFragment = new WatchlistFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        if(item.getItemId() == R.id.profile)
        {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
            return true;
        }
        else if(item.getItemId() == R.id.watchlist)
        {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, watchlistFragment).commit();
            return true;
        }
        else if(item.getItemId() == R.id.search)
        {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment).commit();
            return true;
        }
        else if(item.getItemId() == R.id.home)
        {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
        }
        return false;
    }
}