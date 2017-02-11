package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DaoSession;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewDao;

import java.util.List;

import static android.R.id.list;

public class ConfirmInformationActivity extends AppCompatActivity  {

    private TextView txtConfirm;
    private long IdPerson;
    private String name;
    private Intent intent;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_information);

        txtConfirm = (TextView) findViewById(R.id.txtConfirm);

        intent = getIntent();
        name = intent.getStringExtra("Name");
        IdPerson = intent.getLongExtra("Id",0);


        //Bom dia, gostaria de falar com Fulano. Ele se encontra?
        txtConfirm.setText(getSaudation() + " Gostaria de falar com " + name + ". Ele se encontra?");

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void Update(boolean value)
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        List<Interview> listInterview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'");

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        if (listInterview != null && listInterview.size() > 0) {
            Interview interview = listInterview.get(0);
            interview.dateStart = format.format(Calendar.getInstance().getTime());
            interview.viewerFound = value;
            interviewDao.save(interview);
        } else {
            Interview interview = new Interview();
            interview.setIdPerson(IdPerson);
            interview.dateStart = format.format(Calendar.getInstance().getTime());
            interview.viewerFound = value;
            interviewDao.insert(interview);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onRadioYesClicked(View view){


        Intent activity = new Intent(this, ApresentationActivity.class);
        Update(true);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onRadioNoClicked(View view)
    {

        Intent activity = new Intent(this, VerifyAgeActivity.class);
        Update(false);
        activity.putExtra("Name",name);
        activity.putExtra("Id",IdPerson);

        startActivity(activity);
    }

}
