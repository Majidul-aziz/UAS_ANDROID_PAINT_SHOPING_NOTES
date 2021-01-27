package com.example.utsarisalfauzi;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class MapActivity extends AppCompatActivity {
    private  SupportMapFragment mapFragment;
    private GoogleMap map;
    private OnMapReadyCallback onMapReadyCallback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
             map = googleMap;
        }
    };
    private LocationManager locationManager;
    private FusedLocationProviderClient locationProviderClient;
    private LatLng myLocation;
    private LatLng tokoLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getSupportActionBar().hide();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        mapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMap);
        mapFragment.getMapAsync(onMapReadyCallback);
        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

        @SuppressLint("MissingPermission")
    private void setCurrentLocation(){
        map.setMyLocationEnabled(true);
        locationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                map.addMarker(new MarkerOptions().position(myLocation).title("Saya Ada Disini"));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 17));
            }
        });
    }
    public void showtokoLocation(View view){
        tokoLocation = new LatLng(-6.243115060958633, 107.00625760988804);
        map.addMarker(new MarkerOptions().position(tokoLocation).title("Toko Cat Depo Bangunan Bekasi"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(tokoLocation, 17));
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @SuppressWarnings("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            setCurrentLocation();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void showCurrentLocation (View view){
        if (locationManager.isLocationEnabled()){
            if (ActivityCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_FINE_LOCATION) !=PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(
                     this, Manifest.permission.ACCESS_COARSE_LOCATION) !=PackageManager.PERMISSION_GRANTED){
                String[] permissions ={Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(this, permissions, 100);
                return;
            }
            setCurrentLocation();
        }else {
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }
}