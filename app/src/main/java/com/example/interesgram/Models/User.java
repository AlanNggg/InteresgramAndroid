package com.example.interesgram.Models;

public class User {
    private String username;
    private String email;
    private String avatar;
    private int followingNum;
    private int followersNum;
    private String intro;
    private String[] followers;
    private String[] following;

    public User(String username) {
        this.username = username;
    }

    public User(String username, String email, String avatar, int followingNum, int followersNum, String intro, String[] followers, String[] following) {
            this.username = username;
            this.email = email;
            this.avatar = avatar;
            this.followingNum = followingNum;
            this.followersNum = followersNum;
            this.intro = intro;
            this.followers = followers;
            this.following = following;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getFollowingNum() {
        return followingNum;
    }

    public void setFollowingNum(int followingNum) {
        this.followingNum = followingNum;
    }

    public int getFollowersNum() {
        return followersNum;
    }

    public void setFollowersNum(int followersNum) {
        this.followersNum = followersNum;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String[] getFollowers() {
        return followers;
    }

    public void setFollowers(String[] followers) {
        this.followers = followers;
    }

    public String[] getFollowing() {
        return following;
    }

    public void setFollowing(String[] following) {
        this.following = following;
    }
}
