package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class howselectcandidate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howselectcandidate);
    }
    public void CreateActivity()
    {
        Intent activity = new Intent(this, haschildren.class);
        startActivity(activity);
    }

    public void onRadioCleanHistoryClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioJobsClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioCarismaClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioBornCityClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioConfiancaClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioHonestyClicked(View view)
    {
        CreateActivity();
    }

}
