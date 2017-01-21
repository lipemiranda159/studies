package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewEntity;
import com.exemple.rafael.interviewassistant.model.InterviewedPersonEntity;

public class ClassifySUS extends ActionBarActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private Interview interview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_sus);

        //data = new DataBaseInterview(InterviewedPersonEntity.getInstance(this), InterviewEntity.getInstance(this));
        //Intent intent = getIntent();
        //IdPerson = intent.getIntExtra("Id",0);

    }
/*
    public void updateDb(int value, Intent intent)
    {
        interview = data.interview.recuperaPorIdPerson(IdPerson);
        interview.setIDSickness((short) value);
        data.interview.editar(interview);
        intent.putExtra("IdPerson",IdPerson);


    }
*/

    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, howgetbetter.class);
//        updateDb(opt,activity);
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
