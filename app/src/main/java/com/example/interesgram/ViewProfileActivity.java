package com.example.interesgram;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.interesgram.Adapters.ProfileFragmentPagerAdapter;
import com.example.interesgram.Fragments.FavoriteTab;
import com.example.interesgram.Fragments.GalleryTab;
import com.example.interesgram.Fragments.TagTab;
import com.google.android.material.tabs.TabLayout;

public class ViewProfileActivity extends AppCompatActivity {

    private ProfileFragmentPagerAdapter profileFragmentPagerAdapter;
    private ViewPager profilePager;
    private TabLayout profileTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_tab);

        profilePager = findViewById(R.id.profile_view_pager);
        profileTabLayout = findViewById(R.id.profile_tab_bar);

        profileFragmentPagerAdapter = new ProfileFragmentPagerAdapter(getSupportFragmentManager());
        profileFragmentPagerAdapter.addItem(new GalleryTab(), "Gallery");
        profileFragmentPagerAdapter.addItem(new FavoriteTab(), "Favorite");
        profileFragmentPagerAdapter.addItem(new TagTab(), "@ You");
        profilePager.setAdapter(profileFragmentPagerAdapter);

        profileTabLayout.setupWithViewPager(profilePager, false);
    }
}
