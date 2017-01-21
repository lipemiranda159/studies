package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewEntity;
import com.exemple.rafael.interviewassistant.model.InterviewedPersonEntity;

public class Sickness extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private Interview interview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sickness);
/*
        data = new DataBaseInterview(InterviewedPersonEntity.getInstance(this), InterviewEntity.getInstance(this));
        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);
*/
    }
/*
    public void updateDb(int value, Intent intent)
    {
        interview = data.interview.recuperaPorIdPerson(IdPerson);
        interview.setIDSickness((short) value);
        data.interview.editar(interview);
        intent.putExtra("IdPerson",IdPerson);


    }
*/

    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, ClassifySUS.class);
//        updateDb(opt,activity);
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
