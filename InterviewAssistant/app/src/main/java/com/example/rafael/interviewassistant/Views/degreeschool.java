package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class degreeschool extends ActionBarActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degreeschool);

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(((App) getApplication()).getDaoSession());


    }

    public Interview CreateInterview(short value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.degreeSchool = value;
        return interview;

    }

    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, livewith.class);
        data.updateDb(IdPerson,nome,CreateInterview((short) opt),activity);
        startActivity(activity);

    }

    public void onRadioSupComClicked(View view){

        CreateActivity(1);
    }

    public void onRadioSupImClicked(View view)
    {
        CreateActivity(2);
    }

    public void onRadioTecClicked(View view){

        CreateActivity(3);
    }

    public void onRadioGradClicked(View view)
    {
        CreateActivity(4);
    }

    public void onRadioPosClicked(View view)
    {
        CreateActivity(5);
    }

    public void onRadioConcurClicked(View view)
    {
        CreateActivity(6);

    }

}
