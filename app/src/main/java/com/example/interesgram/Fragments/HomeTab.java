package com.example.interesgram.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interesgram.Adapters.HomePostRecyclerAdapter;
import com.example.interesgram.Models.Post;
import com.example.interesgram.R;
import com.example.interesgram.ViewProfileActivity;

import java.util.List;

public class HomeTab extends Fragment implements HomePostRecyclerAdapter.OnHomeListener {
    private RecyclerView recyclerView;
    private HomePostRecyclerAdapter homePostRecyclerAdapter;
    private List<Post> posts;

    public HomeTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_tab, container, false);
        recyclerView = view.findViewById(R.id.home_recyclerview);

        homePostRecyclerAdapter = new HomePostRecyclerAdapter(posts, this);
        recyclerView.setAdapter(homePostRecyclerAdapter);
        return view;
    }

    @Override
    public void onHomeProfileClick(int position) {
        posts.get(position);
        Intent intent = new Intent(getContext(), ViewProfileActivity.class);
        startActivity(intent);

    }
}
