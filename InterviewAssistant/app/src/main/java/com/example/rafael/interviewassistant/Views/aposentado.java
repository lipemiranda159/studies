package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class aposentado extends ActionBarActivity {

    private int IdPerson;
    private DataBaseInterview data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aposentado);
        Intent intent = new Intent();
        IdPerson = intent.getIntExtra("Id", 0);

        data = new DataBaseInterview(this);

    }

    public Interview CreateInterview(boolean value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.setViewerFound(value);
        return interview;

    }

    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, livewith.class);
        data.updateDb(IdPerson,CreateInterview(true),activity);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, livewith.class);
        data.updateDb(IdPerson,CreateInterview(false),activity);
        startActivity(activity);
    }

}
