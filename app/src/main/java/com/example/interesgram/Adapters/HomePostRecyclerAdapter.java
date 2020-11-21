package com.example.interesgram.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interesgram.Models.Post;
import com.example.interesgram.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomePostRecyclerAdapter extends RecyclerView.Adapter<HomePostRecyclerAdapter.ViewHolder> {
    private List<Post> posts;
    private OnHomeListener onHomeListener;

    public HomePostRecyclerAdapter(List<Post> posts, OnHomeListener onHomeListener) {
        this.posts = posts;
        this.onHomeListener = onHomeListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_post_row_item, parent, false);
        return new ViewHolder(view, onHomeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Post post = posts.get(position);
        holder.username.setText(post.getAuthor());

        Picasso.get().load(post.getImages()[0]).fit().into(holder.postImage);
    }



    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView avator, postImage;
        private TextView username;
        private CheckBox cbLike, cbComment;
        private OnHomeListener onHomeListener;

        public ViewHolder(@NonNull View itemView, OnHomeListener onHomeListener) {
            super(itemView);
            avator = itemView.findViewById(R.id.home_row_item_avatar);
            username = itemView.findViewById(R.id.home_row_item_username);
            postImage = itemView.findViewById(R.id.home_row_item_post_images);
            cbLike = itemView.findViewById(R.id.home_row_item_like);
            cbComment = itemView.findViewById(R.id.home_row_item_comment);
            this.onHomeListener = onHomeListener;

            avator.setOnClickListener(this);
            username.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onHomeListener.onHomeProfileClick(getAdapterPosition());
        }
    }


    public interface OnHomeListener {
        void onHomeProfileClick(int position);
    }
}
