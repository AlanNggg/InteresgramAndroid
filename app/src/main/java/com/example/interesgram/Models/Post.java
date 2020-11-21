package com.example.interesgram.Models;

import java.util.List;

public class Post {
    private String _id;
    private String author;
    private String desc;
    private String[] images;
    private List<Comment> comments;

    public Post(String author, String desc, String[] images) {
        this.author = author;
        this.desc = desc;
        this.images = images;
    }

    public Post(String _id, String author, String desc, String[] images, List<Comment> comments) {
        this._id = _id;
        this.author = author;
        this.desc = desc;
        this.images = images;
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String Author) {
        this.author = Author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] image) {
        this.images = image;
    }

    public Post() {

    }
}
