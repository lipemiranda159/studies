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
    private Interview interview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_sus);
/*
        data = new DataBaseInterview(InterviewedPersonEntity.getInstance(this), InterviewEntity.getInstance(this));
        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);
*/
    }
/*
    public void updateDb(boolean value)
    {
        interview = data.interview.recuperaPorIdPerson(IdPerson);

        interview.setUseSus(value);

        data.interview.editar(interview);

    }

*/
    public void onRadioYesClicked(View view){

  //      updateDb(true);
        Intent activity = new Intent(this, DescribeUseSUS.class);
//        activity.putExtra("IdPerson",IdPerson);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
//        updateDb(true);
        Intent activity = new Intent(this, UsePlan.class);
//        activity.putExtra("IdPerson",IdPerson);
        startActivity(activity);
    }

}
