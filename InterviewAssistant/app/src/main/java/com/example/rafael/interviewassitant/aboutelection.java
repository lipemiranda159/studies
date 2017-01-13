package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class aboutelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutelection);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, willvote.class);
        startActivity(activity);
    }

    public void onRadioChangCountrClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioDestroyCountrClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioNotChangClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioDependsElectionClicked(View view)
    {
        CreateActivity();
    }

}
