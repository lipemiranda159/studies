package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;

public class ListOcupation extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ocupation);
    }

    public void onRadioTrabClicked(View view)
    {
        Intent activity = new Intent(this, livewith.class);
        startActivity(activity);
    }
    public void onRadioDesempClicked(View view)
    {
        Intent activity = new Intent(this, motivodesemprego.class);
        startActivity(activity);
    }

    public void onRadioDonaCasaClicked(View view)
    {
        Intent activity = new Intent(this, housewife.class);
        startActivity(activity);
    }

    public void onRadioEstudaClicked(View view)
    {
        Intent activity = new Intent(this, degreeschool.class);
        startActivity(activity);
    }

    public void onRadioLojClicked(View view)
    {
        Intent activity = new Intent(this, conhecesupersimples.class);
        startActivity(activity);
    }

    public void onRadioLiberalClicked(View view)
    {
        Intent activity = new Intent(this, conhecesupersimples.class);
        startActivity(activity);
    }

    public void onRadioAposenClicked(View view)
    {
        Intent activity = new Intent(this, aposentado.class);
        startActivity(activity);
    }


}
