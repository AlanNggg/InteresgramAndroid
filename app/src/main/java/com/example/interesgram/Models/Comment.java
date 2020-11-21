package com.example.interesgram.Models;

public class Comment {
    private String _id;
    private String postId;
    private String comment;
    private String user;
    private String createAt;

    public Comment(String postId, String comment, String user) {
        this.postId = postId;
        this.comment = comment;
        this.user = user;
    }

    public Comment(String postId, String comment, String user, String createAt) {
        this.postId = postId;
        this.comment = comment;
        this.user = user;
        this.createAt = createAt;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

}
