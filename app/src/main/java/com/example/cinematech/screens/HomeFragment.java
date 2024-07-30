package com.example.cinematech.screens;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.cinematech.R;
import com.example.cinematech.data.model.GetMovie;
import com.example.cinematech.data.utilities.RegisterApiClient;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    static LinearLayout optionsbutton;
    Button allbuttons, moviebutton, tvshowbutton, categoriesbutton;
    ViewPager2 categoriesscreen;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoriesscreen = view.findViewById(R.id.categories_screen);
        optionsbutton = view.findViewById(R.id.options_button);





        allbuttons = view.findViewById(R.id.all_button);
        moviebutton = view.findViewById(R.id.movie_button);
        tvshowbutton = view.findViewById(R.id.tvshow_button);
        categoriesscreen = view.findViewById(R.id.categories_screen);

        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getActivity());
        categoriesscreen.setAdapter(categoriesAdapter);

        categoriesscreen.setUserInputEnabled(false);

        allbuttons.setBackground(getActivity().getDrawable(R.drawable.selected_categories_button));
        moviebutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));
        tvshowbutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));

        allbuttons.setTextColor(getActivity().getColor(R.color.black));
        moviebutton.setTextColor(getActivity().getColor(R.color.white));
        tvshowbutton.setTextColor(getActivity().getColor(R.color.white));




        screens();


        return view;
    }

    public void screens()
    {
//        categoriesscreen.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//
//                if(position == 0)
//                {
//                    allbuttons.setBackground(getActivity().getDrawable(R.drawable.selected_categories_button));
//                    moviebutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));
//                    tvshowbutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));
//
//                    allbuttons.setTextColor(getActivity().getColor(R.color.black));
//                    moviebutton.setTextColor(getActivity().getColor(R.color.white));
//                    tvshowbutton.setTextColor(getActivity().getColor(R.color.white));
//
//                }
//                else if(position == 1)
//                {
//
//                    allbuttons.setBackground(getActivity().getDrawable(R.drawable.categories_button));
//                    moviebutton.setBackground(getActivity().getDrawable(R.drawable.selected_categories_button));
//                    tvshowbutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));
//
//                    allbuttons.setTextColor(getActivity().getColor(R.color.white));
//                    moviebutton.setTextColor(getActivity().getColor(R.color.black));
//                    tvshowbutton.setTextColor(getActivity().getColor(R.color.white));
//
//
//                }
//                else if(position == 2)
//                {
//                    allbuttons.setBackground(getActivity().getDrawable(R.drawable.categories_button));
//                    moviebutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));
//                    tvshowbutton.setBackground(getActivity().getDrawable(R.drawable.selected_categories_button));
//                    allbuttons.setTextColor(getActivity().getColor(R.color.white));
//                    moviebutton.setTextColor(getActivity().getColor(R.color.white));
//                    tvshowbutton.setTextColor(getActivity().getColor(R.color.black));
//                }
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                super.onPageScrollStateChanged(state);
//
//            }
//        });


        allbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                categoriesscreen.setCurrentItem(0);
                allbuttons.setBackground(getActivity().getDrawable(R.drawable.selected_categories_button));
                moviebutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));
                tvshowbutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));

                allbuttons.setTextColor(getActivity().getColor(R.color.black));
                moviebutton.setTextColor(getActivity().getColor(R.color.white));
                tvshowbutton.setTextColor(getActivity().getColor(R.color.white));
            }
        });

        moviebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                categoriesscreen.setCurrentItem(1);
                allbuttons.setBackground(getActivity().getDrawable(R.drawable.categories_button));
                moviebutton.setBackground(getActivity().getDrawable(R.drawable.selected_categories_button));
                tvshowbutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));

                allbuttons.setTextColor(getActivity().getColor(R.color.white));
                moviebutton.setTextColor(getActivity().getColor(R.color.black));
                tvshowbutton.setTextColor(getActivity().getColor(R.color.white));
            }
        });

        tvshowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                categoriesscreen.setCurrentItem(2);
                allbuttons.setBackground(getActivity().getDrawable(R.drawable.categories_button));
                moviebutton.setBackground(getActivity().getDrawable(R.drawable.categories_button));
                tvshowbutton.setBackground(getActivity().getDrawable(R.drawable.selected_categories_button));
                allbuttons.setTextColor(getActivity().getColor(R.color.white));
                moviebutton.setTextColor(getActivity().getColor(R.color.white));
                tvshowbutton.setTextColor(getActivity().getColor(R.color.black));

            }
        });
    }
}