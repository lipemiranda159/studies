package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.DataBaseUtil;

import java.util.Date;

public class ConfirmInformationActivity extends AppCompatActivity {

    private TextView txtConfirm;
    private int IdPerson;
    private DataBaseUtil databaseUtils;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_information);

        txtConfirm = (TextView) findViewById(R.id.txtConfirm);
        databaseUtils = new DataBaseUtil(this);

        //Bom dia, gostaria de falar com Fulano. Ele se encontra?
        Intent intent = getIntent();
        String nome = intent.getStringExtra("Name");
        IdPerson = intent.getIntExtra("Id",0);
        txtConfirm.setText(getSaudation()+" Gostaria de falar com "+nome+". Ele se encontra?");
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

        Intent activity = new Intent(this, ApresentationActivity.class);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, VerifyAgeActivity.class);
        startActivity(activity);
    }

}
