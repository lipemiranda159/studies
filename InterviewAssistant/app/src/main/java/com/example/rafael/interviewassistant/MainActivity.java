package com.example.rafael.interviewassistant;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
        implements LocationListener{

    private TextView addressField;
    private LocationManager locationManager;
    private String provider;

    @TargetApi(Build.VERSION_CODES.M)
    private boolean checkPermission()
    {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressField = (TextView) findViewById(R.id.addresField);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        if (checkPermission()) {
            Location location = locationManager.getLastKnownLocation(provider);

            // Initialize the location fields
            if (location != null) {
                System.out.println("Provider " + provider + " has been selected.");
                onLocationChanged(location);
            } else {
                addressField.setText("Location not available");
                addressField.setText("Location not available");
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (checkPermission()) {
            locationManager.requestLocationUpdates(provider, 400, 1, (LocationListener) this);

        }
    }
    /* Remove the locationlistener updates when Activity is paused */
    @Override
    protected void onPause() {
        super.onPause();
        if (checkPermission())
        locationManager.removeUpdates((LocationListener) this);
    }

    @Override
    public void onLocationChanged(Location location) {
        int lat = (int) (location.getLatitude());
        int lng = (int) (location.getLongitude());
        addressField.setText(String.valueOf(lat)+ " "+String.valueOf(lng));
    }

    public void getLocation(View view)
    {
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = service
                .isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (!enabled) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);

        if (checkPermission()) {
            Location location = service.getLastKnownLocation(provider);
            addressField.setText(String.valueOf(location.getLatitude()));
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider " + provider,
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
                Toast.LENGTH_SHORT).show();
    }
}
