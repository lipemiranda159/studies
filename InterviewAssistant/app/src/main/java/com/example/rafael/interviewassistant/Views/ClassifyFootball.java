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

public class ClassifyFootball extends ActionBarActivity {

    private Long IdPerson;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_football);

        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        nome = intent.getStringExtra("Name");

    }

    private void Update(short value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '1'").get(0);
        interview.respDesempenho = value;
        interviewDao.save(interview);
    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, RespDesen.class);
        Update((short) opt);
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
