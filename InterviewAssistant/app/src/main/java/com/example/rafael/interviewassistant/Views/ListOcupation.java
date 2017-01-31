package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DaoSession;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewDao;

public class ListOcupation extends ActionBarActivity {

    private EditText edtOtherOcupation;
    private long IdPerson;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ocupation);

        edtOtherOcupation = (EditText) findViewById(R.id.edtOtherOcupation);
        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        name = intent.getStringExtra("Name");


    }


    private void Update(short value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.IDOcupation = value;
        interviewDao.save(interview);
    }

    private void Update(String value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.otherOcupation = value;
        interviewDao.save(interview);
    }


    public void onRadioTrabClicked(View view)
    {
        Intent activity = new Intent(this, livewith.class);
        Update((short) 1);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }
    public void onRadioDesempClicked(View view)
    {
        Intent activity = new Intent(this, motivodesemprego.class);
        Update((short) 2);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    public void onRadioDonaCasaClicked(View view)
    {
        Intent activity = new Intent(this, housewife.class);
        Update((short) 3);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    public void onRadioEstudaClicked(View view)
    {
        Intent activity = new Intent(this, degreeschool.class);
        Update((short) 4);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    public void onRadioLojClicked(View view)
    {
        Intent activity = new Intent(this, conhecesupersimples.class);
        Update((short) 5);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    public void onRadioLiberalClicked(View view)
    {
        Intent activity = new Intent(this, conhecesupersimples.class);
        Update((short) 6);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    public void onRadioAposenClicked(View view)
    {
        Intent activity = new Intent(this, aposentado.class);
        Update((short) 7);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    public void btnSendOtherOcupationClick(View view){

        Intent activity = new Intent(this, livewith.class);
        Update((edtOtherOcupation.getText().toString()));
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);

    }


}
