package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class ClassifyFootball extends ActionBarActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_football);

        data = new DataBaseInterview(((App) getApplication()).getDaoSession());

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);
        nome = intent.getStringExtra("Name");

    }

    public Interview CreateInterview(short value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.setRespDesempenho(value);
        return interview;

    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, RespDesen.class);
        data.updateDb(IdPerson,nome,CreateInterview((short) opt),activity);
        startActivity(activity);

    }

    public void onRadioOtmClicked(View view)
    {
        CreateActivity(1);
    }

    public void onRadioBomClicked(View view)
    {
        CreateActivity(2);
    }
    public void onRadioRegClicked(View view)
    {
        CreateActivity(3);
    }
    public void onRadioRuimClicked(View view)
    {
        CreateActivity(4);
    }
    public void onRadioPessimoClicked(View view)
    {
        CreateActivity(5);
    }
}
