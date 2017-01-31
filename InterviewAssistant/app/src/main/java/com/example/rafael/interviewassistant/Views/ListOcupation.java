package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class ListOcupation extends ActionBarActivity {

    private EditText edtOtherOcupation;
    private long IdPerson;
    private DataBaseInterview data;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ocupation);

        edtOtherOcupation = (EditText) findViewById(R.id.edtOtherOcupation);
        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(((App) getApplication()).getDaoSession());


    }

    public Interview CreateInterview(int value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.IDOcupation = (short) value;
        return interview;

    }

    public Interview CreateInterview(String value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.otherOcupation = value;
        return interview;

    }


    public void onRadioTrabClicked(View view)
    {
        Intent activity = new Intent(this, livewith.class);
        data.updateDb(IdPerson,nome,CreateInterview(1),activity);
        startActivity(activity);
    }
    public void onRadioDesempClicked(View view)
    {
        Intent activity = new Intent(this, motivodesemprego.class);
        data.updateDb(IdPerson,nome,CreateInterview(2),activity);
        startActivity(activity);
    }

    public void onRadioDonaCasaClicked(View view)
    {
        Intent activity = new Intent(this, housewife.class);
        data.updateDb(IdPerson,nome,CreateInterview(3),activity);
        startActivity(activity);
    }

    public void onRadioEstudaClicked(View view)
    {
        Intent activity = new Intent(this, degreeschool.class);
        data.updateDb(IdPerson,nome,CreateInterview(4),activity);
        startActivity(activity);
    }

    public void onRadioLojClicked(View view)
    {
        Intent activity = new Intent(this, conhecesupersimples.class);
        data.updateDb(IdPerson,nome,CreateInterview(5),activity);
        startActivity(activity);
    }

    public void onRadioLiberalClicked(View view)
    {
        Intent activity = new Intent(this, conhecesupersimples.class);
        data.updateDb(IdPerson,nome,CreateInterview(6),activity);
        startActivity(activity);
    }

    public void onRadioAposenClicked(View view)
    {
        Intent activity = new Intent(this, aposentado.class);
        data.updateDb(IdPerson,nome,CreateInterview(7),activity);
        startActivity(activity);
    }

    public void btnSendOtherOcupationClick(View view){

        Intent activity = new Intent(this, livewith.class);
        data.updateDb(IdPerson,nome,CreateInterview(edtOtherOcupation.getText().toString()),activity);
        startActivity(activity);

    }


}
