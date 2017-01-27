package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class whattheydo extends ActionBarActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whattheydo);

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(this);

    }

    public Interview CreateInterview(short value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.describePoliticJob = value;
        return interview;

    }

    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, ClassifyFootball.class);
        data.updateDb(IdPerson,nome,CreateInterview((short) opt),activity);
        startActivity(activity);

    }
    

    public void onRadioNoneClicked(View view)
    {
        CreateActivity(1);
    }

    public void onRadioFiscalClicked(View view)
    {
        CreateActivity(2);
    }
    public void onRadioCreateClicked(View view)
    {
        CreateActivity(3);
    }
    public void onRadioVerbClicked(View view)
    {
        CreateActivity(4);
    }
    public void onRadioLeisClicked(View view)
    {
        CreateActivity(5);
    }

}
