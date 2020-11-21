package com.example.interesgram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class EditProfileActivity extends AppCompatActivity {

    private TextInputLayout edtProfileUsernameLayout;
    private Button btnEditProfile;
    private ParseUser parseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        edtProfileUsernameLayout = findViewById(R.id.edtProfileUsernameLayout);
        btnEditProfile = findViewById(R.id.btnEditProfile);

        btnEditProfile.setOnClickListener(updateProfile);

        parseUser = ParseUser.getCurrentUser();

        edtProfileUsernameLayout.getEditText().setText(parseUser.get("username").toString());
    }

    private View.OnClickListener updateProfile = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            parseUser.put("username", edtProfileUsernameLayout.getEditText().getText().toString());
            parseUser.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(EditProfileActivity.this, parseUser.getUsername() + "is your new name", Toast.LENGTH_SHORT).show();

                        finish();
                    } else {
                        Toast.makeText(EditProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        finish();
                    }
                }
            });
        }
    };
}
