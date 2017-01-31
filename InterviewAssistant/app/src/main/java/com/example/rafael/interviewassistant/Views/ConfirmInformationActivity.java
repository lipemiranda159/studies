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
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class ConfirmInformationActivity extends AppCompatActivity  {

    private TextView txtConfirm;
    private Long IdPerson;
    private DataBaseInterview data;
    private String nome;
    private Intent intent;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_information);

        txtConfirm = (TextView) findViewById(R.id.txtConfirm);

        intent = getIntent();
        nome = intent.getStringExtra("Name");


        //Bom dia, gostaria de falar com Fulano. Ele se encontra?
        txtConfirm.setText(getSaudation() + " Gostaria de falar com " + nome + ". Ele se encontra?");

        data = new DataBaseInterview(((App) getApplication()).getDaoSession());

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
    public Interview CreateInterview(boolean value)
    {
        IdPerson = intent.getLongExtra("Id", Long.valueOf("0"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        /*Interview interview = new Interview(null,1,false,false,format.format(Calendar.getInstance().getTime()),"",
            value,false,false,(short)0,false,(short)0,
            "",false,(short)0,(short)0,(short)0,(short)0,"",(short)0,"",(short)0,(short)0,"",false,(short)0,
            (short)0,false,(short)0,false,(short)0,false,false,false,(short)0,(short)0,(short)0,"");

        return interview;*/
        return null;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onRadioYesClicked(View view){


        Intent activity = new Intent(this, ApresentationActivity.class);
        data.insert(IdPerson,nome,CreateInterview(true),activity);
        startActivity(activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onRadioNoClicked(View view)
    {

        Intent activity = new Intent(this, VerifyAgeActivity.class);
        data.updateDb(IdPerson,nome,CreateInterview(false),activity);
        startActivity(activity);
    }

}
