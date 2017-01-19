package com.example.rafael.interviewassistant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class ListHospital extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hospital);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, Sickness.class);
        startActivity(activity);

    }

    public void onRadioHospBalClicked(View view){

        CreateActivity();
    }

    public void onRadioJXXClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioHospEvanClicked(View view){

        CreateActivity();
    }

    public void onRadioFelRClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioJulKClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioEdMenClicked(View view)
    {
        CreateActivity();

    }
    public void onRadioAlbCalvClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioHosTerClicked(View view)
    {

        CreateActivity();
    }

    public void onBtnListHosSendClick(View view)
    {
        CreateActivity();
    }
}
