package com.example.michael.myapplicationnew;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.ShareActionProvider;
import android.view.ActionProvider;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.example.michael.myapplicationnew.R.styleable.NavigationView;

public class Home_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static WebView mywebView;
    private static ProgressBar bar;

    String sharedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        //
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setLogo(R.drawable.aaua_logo_small);
        ab.setDisplayUseLogoEnabled(true);
        ab.setSubtitle("We are 21th century  University Properly Called..!");


        mywebView=(WebView)findViewById(R.id.webview);
        bar=(ProgressBar)findViewById(R.id.progressBar);
        WebSettings webSettings=mywebView.getSettings();
        mywebView.getSettings().setJavaScriptEnabled(true);
       // webSettings.setJavaScriptEnabled(true);
        mywebView.loadUrl("http://www.aaua.edu.ng");


        //Toast.makeText(Home_Activity.this, "Droid Loading.....", Toast.LENGTH_LONG).show();
        mywebView.setWebViewClient(new myWebViewClient());
        mywebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        mywebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mywebView.getSettings().setAppCacheEnabled(true);
        mywebView.getSettings().setLoadsImagesAutomatically(true);
        mywebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSaveFormData(true);
        webSettings.setSavePassword(true);
        webSettings.setEnableSmoothTransition(true);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab1();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        sharedata="Type Message";
    }

    public class myWebViewClient extends WebViewClient{
        @Override
        public void onPageFinished(WebView view, String url) {
            bar.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return super.shouldOverrideUrlLoading(view,url);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK)&&mywebView.canGoBack()){
            mywebView.goBack();
        }

        return super.onKeyDown(keyCode, event);
    }

    public void fab1() {
        Intent shareintent = new Intent();
        shareintent.setAction(Intent.ACTION_SEND);

        shareintent.setType("text/plain");

        shareintent.putExtra("android.intent.extra.SUBJECT", sharedata);

        startActivity(shareintent);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_, menu);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_info) {
            Intent intent =new Intent(this,HomeActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_share) {
            fab1();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home_icon) {
            Intent intent=new Intent(Home_Activity.this,LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(this,GallaryActivity.class);
            startActivity(intent);

        } else if (id == R.id.gps) {
            Intent intent=new Intent(this,MyMap1.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
