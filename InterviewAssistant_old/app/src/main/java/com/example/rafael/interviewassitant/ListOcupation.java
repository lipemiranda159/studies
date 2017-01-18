package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListOcupation extends AppCompatActivity {

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
