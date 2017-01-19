package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;

public class Hasproblemswithplan extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasproblemswithplan);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, Sickness.class);
        startActivity(activity);

    }

    public void onRadioAutorizeClicked(View view){
        CreateActivity();
    }
    public void onRadioNoMedClicked(View view){
        CreateActivity();
    }
    public void onRadioDescMedClicked(View view){
        CreateActivity();
    }
    public void onRadioDescLabClicked(View view){
        CreateActivity();
    }
    public void onRadioHardPayClicked(View view){
        CreateActivity();
    }
    public void onRadioHardScheduleClicked(View view){
        CreateActivity();
    }


}
