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

public class deputadofedaral extends ActionBarActivity {

    private long IdPerson;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputadofedaral);

        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        name = intent.getStringExtra("Name");

    }

    private void Update(boolean value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.whatTheyDo = value;
        interviewDao.save(interview);

    }


    public Interview CreateInterview(boolean value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.whatTheyDo = value;
        return interview;

    }

    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, whattheydo.class);
        Update(true);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, ClassifyFootball.class);
        Update(false);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

}
