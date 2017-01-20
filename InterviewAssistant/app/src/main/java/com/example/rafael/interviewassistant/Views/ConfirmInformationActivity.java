package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewEntity;
import com.exemple.rafael.interviewassistant.model.InterviewedPerson;
import com.exemple.rafael.interviewassistant.model.InterviewedPersonEntity;

import com.exemple.rafael.interviewassistant.model.DataBaseInterview;

public class ConfirmInformationActivity extends AppCompatActivity  {

    private TextView txtConfirm;
    private int IdPerson;
    private DataBaseInterview data;
    private Interview interview;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_information);

        txtConfirm = (TextView) findViewById(R.id.txtConfirm);

        //Bom dia, gostaria de falar com Fulano. Ele se encontra?
        Intent intent = getIntent();
        String nome = intent.getStringExtra("Name");
        IdPerson = intent.getIntExtra("Id",0);
        txtConfirm.setText(getSaudation()+" Gostaria de falar com "+nome+". Ele se encontra?");

        data = new DataBaseInterview(InterviewedPersonEntity.getInstance(this), InterviewEntity.getInstance(this));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getSaudation()
    {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        String saudacao = "Bom dia!";
        if (hour >= 12){
            saudacao = "Boa tarde!";
        } else if (hour >= 19){
            saudacao = "Boa noite!";
        } else if (hour >= 24 || hour <= 6){
            saudacao = "Boa madrugada!";
        }
        return saudacao;
    }
    public void onRadioYesClicked(View view){

        interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.setViewerFound(true);

        data.interview.salvar(interview);
        Intent activity = new Intent(this, ApresentationActivity.class);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.setViewerFound(false);


        data.interview.salvar(interview);
        Intent activity = new Intent(this, VerifyAgeActivity.class);
        startActivity(activity);
    }

}
