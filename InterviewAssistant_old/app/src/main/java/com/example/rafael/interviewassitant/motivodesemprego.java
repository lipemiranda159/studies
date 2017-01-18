package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class motivodesemprego extends AppCompatActivity {

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
