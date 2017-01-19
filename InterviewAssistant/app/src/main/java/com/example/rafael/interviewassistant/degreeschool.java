package com.example.rafael.interviewassistant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class degreeschool extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degreeschool);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, livewith.class);
        startActivity(activity);

    }

    public void onRadioSupComClicked(View view){

        CreateActivity();
    }

    public void onRadioSupImClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioTecClicked(View view){

        CreateActivity();
    }

    public void onRadioGradClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioPosClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioConcurClicked(View view)
    {
        CreateActivity();

    }

}
