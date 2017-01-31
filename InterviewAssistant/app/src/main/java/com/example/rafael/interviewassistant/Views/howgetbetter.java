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

public class howgetbetter extends ActionBarActivity {

    private EditText edtOhostpital;
    private long IdPerson;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howgetbetter);

        edtOhostpital = (EditText) findViewById(R.id.edtOhostpital);
        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        name = intent.getStringExtra("Name");


    }

    private void Update(short value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.needGetBetter = value;
        interviewDao.save(interview);
    }

    private void Update(String value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.otherImprovement = value;
        interviewDao.save(interview);
    }



    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, ListOcupation.class);
        Update((short) opt);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);

    }

    public void CreateActivity(String opt)
    {
        Intent activity = new Intent(this, ListOcupation.class);
        Update(opt);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);

    }

    public void onRadioPlusMedClicked(View view){ CreateActivity(1);}

    public void onRadioRefHosClicked(View view){ CreateActivity(2);}

    public void onRadioNewHosClicked(View view){ CreateActivity(3);}

    public void onRadioDisMedClicked(View view){ CreateActivity(4);}

    public void onRadioLtConsClicked(View view){ CreateActivity(5);}

    public void onRadioTimeConClicked(View view){ CreateActivity(6);}

    public void onRadioTimeCirClicked(View view){ CreateActivity(7);}

    public void onRadioTimeExClicked(View view){ CreateActivity(8);}

    public void btnOthersClick(View view){ CreateActivity(edtOhostpital.getText().toString());}
}
