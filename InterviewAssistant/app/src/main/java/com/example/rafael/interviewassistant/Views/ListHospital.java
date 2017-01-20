package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewEntity;
import com.exemple.rafael.interviewassistant.model.InterviewedPersonEntity;

public class ListHospital extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private Interview interview;
    private EditText edtOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hospital);

        edtOther = (EditText) findViewById(R.id.edtOtherHospital);

        data = new DataBaseInterview(InterviewedPersonEntity.getInstance(this), InterviewEntity.getInstance(this));
        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);

    }

    public void updateDb(int value, Intent intent)
    {
        interview = data.interview.recuperaPorIdPerson(IdPerson);
        interview.setIDHospital((short) value);
        data.interview.editar(interview);
        intent.putExtra("IdPerson",IdPerson);


    }

    public void updateDb(String value, Intent intent)
    {
        interview = data.interview.recuperaPorIdPerson(IdPerson);
        interview.setOtherHospital(value);
        data.interview.editar(interview);
        intent.putExtra("IdPerson",IdPerson);


    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, Sickness.class);
        updateDb(opt,activity);
        startActivity(activity);

    }

    public void CreateActivity(String value)
    {
        Intent activity = new Intent(this, Sickness.class);
        updateDb(value,activity);
        startActivity(activity);

    }

    public void onRadioHospBalClicked(View view){

        CreateActivity(1);
    }

    public void onRadioJXXClicked(View view)
    {
        CreateActivity(2);
    }

    public void onRadioHospEvanClicked(View view){

        CreateActivity(3);
    }

    public void onRadioFelRClicked(View view)
    {
        CreateActivity(4);
    }

    public void onRadioJulKClicked(View view)
    {
        CreateActivity(5);
    }

    public void onRadioEdMenClicked(View view)
    {
        CreateActivity(6);

    }
    public void onRadioAlbCalvClicked(View view)
    {
        CreateActivity(7);
    }

    public void onRadioHosTerClicked(View view)
    {

        CreateActivity(8);
    }

    public void onBtnListHosSendOtherClick(View view)
    {
        CreateActivity(String.valueOf(edtOther.getText()));
    }
}
