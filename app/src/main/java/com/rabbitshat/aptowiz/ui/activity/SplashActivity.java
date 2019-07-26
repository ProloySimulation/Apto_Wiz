package com.rabbitshat.aptowiz.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.rabbitshat.aptowiz.R;
import com.rabbitshat.aptowiz.util.AppUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // check if user is logged in or not.
                if (isLoggedIn(AppUtil.FIRST_TIME)) {
                    // if not logged in then go to activation page
                    startActivity(new Intent(SplashActivity.this, ActivationActivity.class));

                } else {
                    // if logged in then go to main page
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));

                }

            }
        }, 1000);
    }

    private boolean isLoggedIn(String name) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String str = preferences.getString(name, "Yes");
        if (str.equals("No"))
            return false;
        return true;
    }
}
