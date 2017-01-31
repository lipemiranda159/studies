package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DaoSession;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewDao;

public class UsePlan extends ActionBarActivity {

    private long IdPerson;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_plan);

        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        nome = intent.getStringExtra("Name");


    }

    private void Update(boolean value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '1'").get(0);
        interview.useMedicalPlan = value;
        interviewDao.save(interview);

    }


    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, Hasproblemswithplan.class);
        Update(true);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, Sickness.class);
        Update(false);
        startActivity(activity);
    }

}
