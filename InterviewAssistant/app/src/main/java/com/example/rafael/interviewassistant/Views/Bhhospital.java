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

public class Bhhospital extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private Interview interview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhhospital);

        /*
        data = new DataBaseInterview(InterviewedPersonEntity.getInstance(this), InterviewEntity.getInstance(this));
        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);
*/
    }

  /*  public void updateDb(boolean value, Intent intent)
    {
        interview = data.interview.recuperaPorIdPerson(IdPerson);
        interview.setProcedureHospital(value);
        data.interview.editar(interview);
        intent.putExtra("IdPerson",IdPerson);


    }
*/

    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, ListHospital.class);
//        updateDb(true,activity);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, Sickness.class);
//        updateDb(false,activity);
        startActivity(activity);
    }
}
