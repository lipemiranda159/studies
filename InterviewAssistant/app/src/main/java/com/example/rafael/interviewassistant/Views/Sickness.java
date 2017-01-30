package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class Sickness extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sickness);

        data = new DataBaseInterview(((App) getApplication()).getDaoSession());

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);
        nome = intent.getStringExtra("Name");


    }

    public Interview CreateInterview(int value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.IDSickness = (short) value;
        return interview;

    }

    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, ClassifySUS.class);
        data.updateDb(IdPerson,nome,CreateInterview(opt),activity);
        startActivity(activity);

    }

    public void onRadioCancerClicked(View view){
        CreateActivity(1);
    }
    public void onRadioDoeHepaClicked(View view){
        CreateActivity(2);
    }
    public void onRadioCardiacClicked(View view){
        CreateActivity(3);
    }
    public void onRadioAsmaClicked(View view){
        CreateActivity(4);
    }
    public void onRadioOthersClicked(View view){
        CreateActivity(5);
    }
    public void onRadioNoClicked(View view){
        CreateActivity(6);
    }

}
