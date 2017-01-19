package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;

public class RespDesen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resp_desen);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, FinishInterviewActivity.class);
        startActivity(activity);

    }


    public void onRadioPlayClicked(View view){
        CreateActivity();
    }
    public void onRadioTecClicked(View view){
        CreateActivity();
    }
    public void onRadioCBFClicked(View view){
        CreateActivity();
    }
}
