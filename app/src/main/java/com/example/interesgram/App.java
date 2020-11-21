package com.example.interesgram;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("9CA0DZs7TwT7nTnBM5apVPRDsDQqHh1wGKHtoHb1")
                .clientKey("29oqCxZ0B52o95nU7pJRvvfyuiUSUzKCS2YBuakf")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }

}
