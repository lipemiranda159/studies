package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;

public class ClassifyFootball extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_football);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, RespDesen.class);
        startActivity(activity);

    }

    public void onRadioOtmClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioBomClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioRegClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioRuimClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioPessimoClicked(View view)
    {
        CreateActivity();
    }
}
