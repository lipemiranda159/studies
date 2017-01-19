package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;

public class motivodesemprego extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivodesemprego);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, livewith.class);
        startActivity(activity);
    }


    public void onRadioOportunidadeClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioCursosClicked(View view)
    {
        CreateActivity();    }

    public void onRadioObraClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioEducationClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioCrescClicked(View view)
    {
        CreateActivity();
    }
}
