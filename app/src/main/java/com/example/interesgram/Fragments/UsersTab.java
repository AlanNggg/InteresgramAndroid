package com.example.interesgram.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.interesgram.Adapters.SearchUserListAdapter;
import com.example.interesgram.Models.User;
import com.example.interesgram.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class UsersTab extends Fragment {

    private RecyclerView usersRecyclerView;
    private RecyclerView.Adapter usersAdapter;
    private RecyclerView.LayoutManager usersLayoutManager;
    private SearchUserListAdapter searchUserListAdapter;
    private List<User> users;

    public UsersTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users_tab, container, false);
        usersRecyclerView = view.findViewById(R.id.search_users_list);
        usersRecyclerView.setHasFixedSize(true);

        usersLayoutManager = new LinearLayoutManager(getContext());
        usersRecyclerView.setLayoutManager(usersLayoutManager);

        users = new ArrayList<>();
        usersAdapter = new SearchUserListAdapter(users);

        final ProgressBar usersLoadingProgressBar = view.findViewById(R.id.search_users_progress_bar);

        ParseQuery<ParseUser> parseQuery = ParseUser.getQuery();
        parseQuery.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());
        parseQuery.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0) {
                        for (ParseUser user : objects) {
                            users.add(new User(user.getUsername()));
                        }
                        usersRecyclerView.setAdapter(usersAdapter);

                        usersLoadingProgressBar.setVisibility(View.GONE);
                        usersRecyclerView.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


        return view;
    }
}
