package com.example.michael.myapplicationnew;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class GallaryActivity extends AppCompatActivity {
    ViewPager viewPager;
    Gallary_custom adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setIcon(R.drawable.aaua_log);
        ab.setHomeButtonEnabled(true);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        viewPager =(ViewPager)findViewById(R.id.view_pager);
        adapter= new Gallary_custom(this);
        viewPager.setAdapter(adapter);
    }
}
