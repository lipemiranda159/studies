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

import static android.R.attr.name;
import static android.R.id.list;

public class aboutelection extends ActionBarActivity {

    private long IdPerson;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutelection);

        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        name = intent.getStringExtra("Name");
    }

    private void Update(short value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.aboutElection = value;
        interviewDao.save(interview);


    }

    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, willvote.class);
        Update((short) opt);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    public void onRadioChangCountrClicked(View view)
    {
        CreateActivity(1);
    }
    public void onRadioDestroyCountrClicked(View view)
    {
        CreateActivity(2);
    }
    public void onRadioNotChangClicked(View view)
    {
        CreateActivity(3);
    }
    public void onRadioDependsElectionClicked(View view)
    {
        CreateActivity(4);
    }

}
