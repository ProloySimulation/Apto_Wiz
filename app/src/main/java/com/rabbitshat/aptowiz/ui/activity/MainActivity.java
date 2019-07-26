package com.rabbitshat.aptowiz.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rabbitshat.aptowiz.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNotice(View view) {
    }

    public void onEmergency(View view) {
    }

    public void onComplain(View view) {
    }

    public void onMyApartment(View view) {
    }

    public void onPhoneBook(View view) {
        startActivity(new Intent(getApplicationContext(), PhoneBookActivity.class));

    }

    public void onDevelopments(View view) {
    }

    public void onMyServices(View view) {
    }

    public void onWhoWeAre(View view) {
    }
}
