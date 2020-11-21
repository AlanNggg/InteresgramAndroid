package com.example.interesgram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.interesgram.Fragments.FollowTab;
import com.example.interesgram.Fragments.HomeTab;
import com.example.interesgram.Fragments.ProfileTab;
import com.example.interesgram.Fragments.SearchTab;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SocialMediaActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        loadFragment(new HomeTab());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.action_home:
                    fragment = new HomeTab();
                    break;
                case R.id.action_search:
                    fragment = new SearchTab();
                    break;
                case R.id.action_post:
                    Intent intent = new Intent(SocialMediaActivity.this, CreatePostActivity.class);
                    startActivity(intent);
                    break;
                case R.id.action_follow:
                    fragment = new FollowTab();
                    break;
                case R.id.action_profile:
                    fragment = new ProfileTab();
                    break;
            }

            if (fragment != null) {
                loadFragment(fragment);
            }

            return true;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}
