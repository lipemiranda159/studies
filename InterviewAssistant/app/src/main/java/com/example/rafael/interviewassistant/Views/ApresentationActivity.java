package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DaoSession;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewDao;

public class ApresentationActivity extends AppCompatActivity {

    private long IdPerson;
    private String name;
    private TextView txtApresentation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentation);

        txtApresentation = (TextView) findViewById(R.id.txtApresentation);
        //Sr. Fulano, eu sou pesquisador e estamos realizando uma avaliação do atendimento de saúde em minas gerais. Pode coloborar respondendo algumas perguntas?
        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        name = intent.getStringExtra("Name");
        txtApresentation.setText(name+", eu sou pesquisador e estamos realizando uma avaliação do atendimento de saúde em minas gerais. Pode coloborar respondendo algumas perguntas?");

    }

    private void Update(boolean value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        interview.viewerAccept = value;
        interviewDao.save(interview);

    }

    public void onRadioYesClicked(View view){


        Intent activity = new Intent(this, UseSUS.class);
        Update(true);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, FinishInterviewActivity.class);
        Update(false);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

}
