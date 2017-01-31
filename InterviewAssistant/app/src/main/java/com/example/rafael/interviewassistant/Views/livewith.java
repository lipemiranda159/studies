package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DaoSession;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewDao;

public class livewith extends ActionBarActivity {

    private long IdPerson;
    private String nome;
    private EditText edtOthersLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livewith);

        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        nome = intent.getStringExtra("Name");

        edtOthersLive = (EditText) findViewById(R.id.edtOthersLive);


    }

    private void Update(short value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '1'").get(0);
        interview.liveWith = value;
        interviewDao.save(interview);

    }

    private void Update(String value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '1'").get(0);
        interview.otherDweller = value;
        interviewDao.save(interview);

    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, haschildren.class);
        Update((short) opt);
        startActivity(activity);
    }

    public void CreateActivity(String opt)
    {
        Intent activity = new Intent(this, haschildren.class);
        Update(opt);
        startActivity(activity);
    }

    public void onRadioParentesClicked(View view)
    {
     CreateActivity(1);
    }
    public void onRadioAvosClicked(View view)
    {
        CreateActivity(2);
    }
    public void onRadioWifeClicked(View view)
    {
        CreateActivity(3);
    }
    public void onRadioFriendsClicked(View view)
    {
        CreateActivity(4);
    }
    public void onBtnSendLiv(View view)
    {
        CreateActivity(edtOthersLive.getText().toString());
    }
}
