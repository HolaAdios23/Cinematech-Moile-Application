package com.example.cinematech.screens;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CategoriesAdapter extends FragmentStateAdapter {
    public CategoriesAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 0:
                return new All_Screen_Fragment();

            case 1:
                return new Movie_Screen_Fragment();

            case 2:
                return new Tvshows_Screen_Fragment();

            case 3:
                return new Categories_Screen_Fragment();

            default:
                return new All_Screen_Fragment();

        }


    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
