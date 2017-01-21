package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewEntity;
import com.exemple.rafael.interviewassistant.model.InterviewedPersonEntity;

public class DescribeUseSUS extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private Interview interview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe_use_sus);
/*
        data = new DataBaseInterview(InterviewedPersonEntity.getInstance(this), InterviewEntity.getInstance(this));
        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);
*/
    }

    /*
    public void updateDb(short value, Intent intent)
    {
        interview = data.interview.recuperaPorIdPerson(IdPerson);
        interview.setIdProcedure(value);
        data.interview.editar(interview);
        intent.putExtra("IdPerson",IdPerson);


    }
*/
    public void CreateActivity(short opt)
    {
        Intent activity = new Intent(this, Bhhospital.class);
//        updateDb(opt,activity);
        startActivity(activity);

    }

    public void onRadioUrgClicked(View view){

        CreateActivity((short) 1);
    }

    public void onRadioConClicked(View view)
    {
        CreateActivity((short) 2);
    }

    public void onRadioExsClicked(View view){

        CreateActivity((short) 3);
    }

    public void onRadioVacClicked(View view)
    {
        CreateActivity((short) 4);
    }

    public void onRadioNatClicked(View view)
    {
        CreateActivity((short) 5);
    }

    public void onRadioOdtClicked(View view)
    {
        CreateActivity((short) 6);

    }
}
