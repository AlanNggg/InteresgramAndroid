package com.example.interesgram.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interesgram.Models.User;
import com.example.interesgram.R;

import java.util.ArrayList;
import java.util.List;

public class SearchUserListAdapter extends RecyclerView.Adapter<SearchUserListAdapter.SearchUserListViewHolder> {
    private List<User> userList;

    public class SearchUserListViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatar;
        private TextView username, intro;
        private Button btnFollow;

        public SearchUserListViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.search_row_item_avatar);
            username = itemView.findViewById(R.id.search_row_item_username);
            intro = itemView.findViewById(R.id.search_row_item_intro);
            btnFollow = itemView.findViewById(R.id.search_row_item_follow_button);
        }
    }

    public SearchUserListAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public SearchUserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_user_row_item, parent, false);
        return new SearchUserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchUserListViewHolder holder, int position) {
        User user = userList.get(position);
        holder.username.setText(user.getUsername());
        holder.intro.setText(user.getIntro());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
