package com.example.interesgram.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interesgram.Adapters.SearchPagerAdapter;
import com.example.interesgram.R;
import com.google.android.material.tabs.TabLayout;

public class SearchTab extends Fragment {

    private SearchPagerAdapter searchPagerAdapter;
    private ViewPager searchPager;
    private TabLayout searchTabLayout;

    public SearchTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_tab, container, false);
        searchPager = view.findViewById(R.id.search_view_pager);
        searchTabLayout = view.findViewById(R.id.search_tab_bar);

        searchPagerAdapter = new SearchPagerAdapter(getChildFragmentManager());
        searchPagerAdapter.addItem(new DiscoverTab(), "Discover");
        searchPagerAdapter.addItem(new UsersTab(), "Users");
        searchPager.setAdapter(searchPagerAdapter);

        searchTabLayout.setupWithViewPager(searchPager, false);


        // Inflate the layout for this fragment
        return view;
    }
}
