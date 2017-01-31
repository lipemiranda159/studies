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

public class whattheydo extends ActionBarActivity {

    private long IdPerson;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whattheydo);

        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        name = intent.getStringExtra("Name");


    }

    private void Update(short value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.describePoliticJob = value;
        interviewDao.save(interview);
    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, ClassifyFootball.class);
        Update((short) opt);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

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
