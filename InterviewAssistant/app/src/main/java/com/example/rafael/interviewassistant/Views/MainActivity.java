package com.example.rafael.interviewassistant.Views;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.InterviewedPerson;
import com.exemple.rafael.interviewassistant.model.InterviewedPersonEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements LocationListener {

    private TextView addressField;
    private Button btnStartInterview;
    private EditText edtNumber;
    private LocationManager locationManager;
    private String provider;
    private String postCode;
    public void getNumber(View view) {
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
            List<Address> list = new ArrayList<Address>();

            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            try {
                list = (ArrayList<Address>) geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!list.isEmpty()) {

                Address a = list.get(0);
                edtNumber.setText(a.getFeatureName());
                edtNumber.setEnabled(true);
                btnStartInterview.setEnabled(true);
                postCode = a.getPostalCode();
            }

        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private boolean checkPermission() {
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
        btnStartInterview = (Button) findViewById(R.id.btnStartInterview);
        edtNumber = (EditText) findViewById(R.id.edtNumber);

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

        InterviewedPersonEntity interviewedPersonEntity = InterviewedPersonEntity.getInstance(this);
        InterviewedPerson interviewedPerson = new InterviewedPerson();
        interviewedPerson.setId(1);
        interviewedPerson.setName("Felipe");
        interviewedPerson.setPostCode("30620-490");
        interviewedPerson.setNumber((short) 312);
        interviewedPersonEntity.salvar(interviewedPerson);

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

    public void startInterview(View view){

        if (!edtNumber.getText().equals("")) {

            InterviewedPersonEntity interviewedPersonEntity = InterviewedPersonEntity.getInstance(this);

            String sql = "SELECT * FROM TbPerson WHERE postCode ='" + postCode + "' and number =" + edtNumber.getText();
            try {
                List<InterviewedPerson> list = interviewedPersonEntity.recuperarPorQuery(sql);
                if (!list.isEmpty()) {
                    Intent activity = new Intent(this, ConfirmInformationActivity.class);
                    activity.putExtra("Name",list.get(0).getName());
                    activity.putExtra("Id",list.get(0).getId());
                    startActivity(activity);
                }

            }  catch (Exception ex)
            {
                Log.i("Log",ex.getMessage());
            }
        }
    }

}
