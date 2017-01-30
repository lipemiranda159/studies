package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class Bhhospital extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhhospital);


        data = new DataBaseInterview(((App) getApplication()).getDaoSession());

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);
        nome = intent.getStringExtra("Name");

    }

    public Interview CreateInterview(boolean value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.setProcedureHospital(value);
        return interview;

    }

    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, ListHospital.class);
        data.updateDb(IdPerson,nome,CreateInterview(true),activity);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, Sickness.class);
        data.updateDb(IdPerson,nome,CreateInterview(false),activity);
        startActivity(activity);
    }
}
