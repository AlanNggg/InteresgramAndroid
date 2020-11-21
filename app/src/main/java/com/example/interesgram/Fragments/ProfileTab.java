package com.example.interesgram.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.interesgram.Adapters.ProfilePagerAdapter;
import com.example.interesgram.EditProfileActivity;
import com.example.interesgram.R;
import com.google.android.material.tabs.TabLayout;

public class ProfileTab extends Fragment {

    private ProfilePagerAdapter profilePagerAdapter;
    private ViewPager profilePager;
    private TabLayout profileTabLayout;
    private Button btnEditProfile;

    public ProfileTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_tab, container, false);
        profilePager = view.findViewById(R.id.profile_view_pager);
        profileTabLayout = view.findViewById(R.id.profile_tab_bar);
        btnEditProfile = view.findViewById(R.id.profile_edit_button);

        btnEditProfile.setOnClickListener(switchEditProfileOnClick);

        profilePagerAdapter = new ProfilePagerAdapter(getChildFragmentManager());
        profilePagerAdapter.addItem(new GalleryTab(), "Gallery");
        profilePagerAdapter.addItem(new FavoriteTab(), "Favorite");
        profilePagerAdapter.addItem(new TagTab(), "@ You");
        profilePager.setAdapter(profilePagerAdapter);

        profileTabLayout.setupWithViewPager(profilePager, false);
        // Inflate the layout for this fragment
        return view;
    }

    private View.OnClickListener switchEditProfileOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), EditProfileActivity.class);
            startActivity(intent);
        }
    };
}
