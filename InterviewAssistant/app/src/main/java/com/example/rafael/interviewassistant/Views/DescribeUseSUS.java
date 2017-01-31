package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DaoSession;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewDao;

public class DescribeUseSUS extends AppCompatActivity {

    private Long IdPerson;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe_use_sus);


        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        nome = intent.getStringExtra("Name");


    }

    private void Update(short value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '1'").get(0);
        interview.idProcedure = value;
        interviewDao.save(interview);
    }


    public void CreateActivity(short opt)
    {
        Intent activity = new Intent(this, Bhhospital.class);
        Update(opt);
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
