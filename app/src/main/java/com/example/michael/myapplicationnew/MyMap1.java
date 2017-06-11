package com.example.michael.myapplicationnew;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;



import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import android.view.MotionEvent;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MyMap1 extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_map1);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }






    public void mapType(View view){
        if(mMap.getMapType()==GoogleMap.MAP_TYPE_NORMAL){
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }else {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        //senate
        LatLng senate = new LatLng(7.412913, 5.759506);
        mMap.addMarker(new MarkerOptions().position(senate).snippet("Visit Location Senate Building").alpha((float) 0.5).title("Senate Building"));
        // another location
        LatLng a = new LatLng(7.482973, 5.750522);
        mMap.addMarker(new MarkerOptions().position(a).snippet("Visit Location A").alpha((float) 0.5).title("A"));


        LatLng b = new LatLng(7.513441, 5.744178);
        mMap.addMarker(new MarkerOptions().position(b).snippet("Visit Location B").alpha((float) 0.5).title("B"));
        //
        LatLng c = new LatLng(7.480530, 5.741205);
        mMap.addMarker(new MarkerOptions().position(c).snippet("Visit Location C").alpha((float) 0.).title("C"));
        //
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            }
        });


        mMap.addPolyline(new PolylineOptions().add(
                b,
                new LatLng(7.513441, 5.744178),
                 new LatLng(7.513441, 5.744178),
                c
        ).width(9)
                .color(Color.RED)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLng(senate));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(b));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(c));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setTrafficEnabled(true);
        mMap.setIndoorEnabled(true);
        mMap.setBuildingsEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }



}
