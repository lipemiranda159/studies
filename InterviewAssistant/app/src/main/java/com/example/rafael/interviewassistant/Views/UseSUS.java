package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewEntity;
import com.exemple.rafael.interviewassistant.model.InterviewedPersonEntity;

public class UseSUS extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_sus);

        data = new DataBaseInterview(this);
        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);
        nome = intent.getStringExtra("Name");

    }

    public Interview CreateInterview(boolean value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.useSus = value;
        return interview;

    }

    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, DescribeUseSUS.class);
        data.updateDb(IdPerson,nome,CreateInterview(true),activity);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, UsePlan.class);
        data.updateDb(IdPerson,nome,CreateInterview(false),activity);
        startActivity(activity);
    }

}
