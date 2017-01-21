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
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewEntity;
import com.exemple.rafael.interviewassistant.model.InterviewedPersonEntity;

public class ConfirmInformationActivity extends AppCompatActivity  {

    private TextView txtConfirm;
    private int IdPerson;
    private DataBaseInterview data;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_information);

        txtConfirm = (TextView) findViewById(R.id.txtConfirm);

        //Bom dia, gostaria de falar com Fulano. Ele se encontra?
        Intent intent = getIntent();
        String nome = intent.getStringExtra("Name");
        IdPerson = intent.getIntExtra("Id", 0);
        txtConfirm.setText(getSaudation() + " Gostaria de falar com " + nome + ". Ele se encontra?");

        data = new DataBaseInterview(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getSaudation()
    {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        String saudacao = "Bom dia!";
        if (hour >= 12 && hour < 19){
            saudacao = "Boa tarde!";
        } else if (hour >= 19 && hour < 24){
            saudacao = "Boa noite!";
        } else if (hour >= 24 || hour <= 6){
            saudacao = "Boa madrugada!";
        }
        return saudacao;
    }

    public Interview CreateInterview(boolean value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.setViewerFound(value);
        return interview;

    }

    public void onRadioYesClicked(View view){


        Intent activity = new Intent(this, ApresentationActivity.class);
        data.updateDb(IdPerson,CreateInterview(true),activity);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {

        Intent activity = new Intent(this, VerifyAgeActivity.class);
        data.updateDb(IdPerson,CreateInterview(false),activity);
        startActivity(activity);
    }

}
