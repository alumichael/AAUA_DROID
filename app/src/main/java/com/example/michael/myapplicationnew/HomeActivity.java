package com.example.michael.myapplicationnew;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setIcon(R.drawable.aaua_logo_small);
        ab.setTitle("AAUA DROID");
        ab.setHomeButtonEnabled(true);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
    }
}
