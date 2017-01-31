package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DaoSession;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewDao;

public class ListHospital extends AppCompatActivity {

    private long IdPerson;
    private String name;
    private EditText edtOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hospital);

        edtOther = (EditText) findViewById(R.id.edtOtherHospital);

        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        name = intent.getStringExtra("Name");

    }

    private void Update(short value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.IDHospital = value;
        interviewDao.save(interview);
    }

    private void Update(String value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.otherHospital = value;
        interviewDao.save(interview);
    }



    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, Sickness.class);
        Update((short) opt);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);

    }

    public void CreateActivity(String value)
    {
        Intent activity = new Intent(this, Sickness.class);
        Update(value);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);

    }

    public void onRadioHospBalClicked(View view){

        CreateActivity(1);
    }

    public void onRadioJXXClicked(View view)
    {
        CreateActivity(2);
    }

    public void onRadioHospEvanClicked(View view){

        CreateActivity(3);
    }

    public void onRadioFelRClicked(View view)
    {
        CreateActivity(4);
    }

    public void onRadioJulKClicked(View view)
    {
        CreateActivity(5);
    }

    public void onRadioEdMenClicked(View view)
    {
        CreateActivity(6);

    }
    public void onRadioAlbCalvClicked(View view)
    {
        CreateActivity(7);
    }

    public void onRadioHosTerClicked(View view)
    {

        CreateActivity(8);
    }

    public void onBtnListHosSendOtherClick(View view)
    {
        CreateActivity(edtOther.getText().toString());
    }
}
