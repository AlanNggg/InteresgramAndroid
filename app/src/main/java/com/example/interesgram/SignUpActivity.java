package com.example.interesgram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private ConstraintLayout signUpConstraintLayout;
    private TextView txtTitle, txtSwitchLogin;
    private TextInputLayout edtSignUpEmailLayout, edtSignUpPasswordLayout, edtSignUpUsernameLayout;
    private Button btnSignUp;
    private CardView imgAvatarCard;
    private ProgressBar signUpProgressBar;

    private final String btn_tag_next = "btn_tag_next";
    private final String btn_tag_sign_up = "btn_tag_sign_up";

    private ParseUser appUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setTitle("Sign Up");

        signUpConstraintLayout = findViewById(R.id.signUpLayout);
        txtTitle = findViewById(R.id.txtTitle);
        edtSignUpEmailLayout = findViewById(R.id.edtSignUpEmailLayout);
        edtSignUpPasswordLayout = findViewById(R.id.edtSignUpPasswordLayout);
        edtSignUpUsernameLayout = findViewById(R.id.edtSignUpUsernameLayout);
        btnSignUp = findViewById(R.id.btnSignUp);
        txtSwitchLogin = findViewById(R.id.txtSwitchLogin);
        imgAvatarCard = findViewById(R.id.imgAvatarCard);
        signUpProgressBar = findViewById(R.id.signUpProgressBar);

        btnSignUp.setOnClickListener(signUpOnClick);
        txtSwitchLogin.setOnClickListener(switchLoginOnClick);

        edtSignUpUsernameLayout.setOnKeyListener(finishSignUpOnKey);


        if (ParseUser.getCurrentUser() != null) {
            transitionToSocialMediaActivity();
        }
    }

    private View.OnClickListener signUpOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (btnSignUp.getTag().toString()) {
                case btn_tag_next:
                    if (edtSignUpEmailLayout.getEditText().getText().toString().trim().equals("") ||
                            edtSignUpPasswordLayout.getEditText().getText().toString().trim().equals("")) {
                        Toast.makeText(SignUpActivity.this, "Email, Password is required!", Toast.LENGTH_SHORT).show();
                    } else {
                        appUser = new ParseUser();
                        appUser.setEmail(edtSignUpEmailLayout.getEditText().getText().toString());
                        appUser.setPassword(edtSignUpPasswordLayout.getEditText().getText().toString());
                        btnSignUp.setTag(btn_tag_sign_up);

                        txtTitle.setVisibility(View.INVISIBLE);
                        edtSignUpEmailLayout.setVisibility(View.GONE);
                        edtSignUpPasswordLayout.setVisibility(View.GONE);

                        edtSignUpUsernameLayout.setVisibility(View.VISIBLE);
                        imgAvatarCard.setVisibility(View.VISIBLE);
                        btnSignUp.setText(R.string.sign_up_button_text);

                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.clone(signUpConstraintLayout);;
                        constraintSet.connect(R.id.btnSignUp, ConstraintSet.TOP, R.id.edtSignUpUsernameLayout, ConstraintSet.BOTTOM, 16);
                        constraintSet.applyTo(signUpConstraintLayout);
                    }
                    break;
                case btn_tag_sign_up:

                    if (edtSignUpUsernameLayout.getEditText().getText().toString().trim().equals("")) {
                        Toast.makeText(SignUpActivity.this, "Username is required!", Toast.LENGTH_SHORT).show();
                    } else {

                        appUser.setUsername(edtSignUpUsernameLayout.getEditText().getText().toString());

                        processSignUp(true);
                        appUser.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    Toast.makeText(SignUpActivity.this, appUser.getUsername() + "is signed up", Toast.LENGTH_SHORT).show();

                                    transitionToSocialMediaActivity();
                                } else {
                                    Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        processSignUp(false);

                    }
                    break;
            }

        }
    };

    private View.OnKeyListener finishSignUpOnKey = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                signUpOnClick.onClick(btnSignUp);
            }
            return false;
        }
    };

    private View.OnClickListener switchLoginOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };

    public void rootLayoutTapped(View v) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processSignUp(final boolean isProcess) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (isProcess) {
                    btnSignUp.setVisibility(View.INVISIBLE);
                    signUpProgressBar.setVisibility(View.VISIBLE);
                } else {
                    btnSignUp.setVisibility(View.VISIBLE);
                    signUpProgressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    private void transitionToSocialMediaActivity() {
        Intent intent = new Intent(SignUpActivity.this, SocialMediaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

