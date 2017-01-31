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

public class RespDesen extends ActionBarActivity {

    private EditText edtOtherResp;
    private long IdPerson;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resp_desen);

        edtOtherResp = (EditText) findViewById(R.id.edtOtherResp);
        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        name = intent.getStringExtra("Name");


    }

    private void Update(short value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.respDesempenho = value;
        interviewDao.save(interview);
    }

    private void Update(String value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.otherResp = value;
        interviewDao.save(interview);
    }

    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, FinishInterviewActivity.class);
        Update((short) opt);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);

    }

    public void CreateActivity(String opt)
    {
        Intent activity = new Intent(this, FinishInterviewActivity.class);
        Update(opt);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);

    }


    public void onRadioPlayClicked(View view){
        CreateActivity(1);
    }
    public void onRadioTecClicked(View view){
        CreateActivity(2);
    }
    public void onRadioCBFClicked(View view){
        CreateActivity(3);
    }
    public void btnOtherRespClick(View view){CreateActivity(edtOtherResp.getText().toString());}
}
