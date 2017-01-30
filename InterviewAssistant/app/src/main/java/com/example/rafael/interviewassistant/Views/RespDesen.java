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

public class RespDesen extends ActionBarActivity {

    private EditText edtOtherResp;
    private int IdPerson;
    private DataBaseInterview data;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resp_desen);

        edtOtherResp = (EditText) findViewById(R.id.edtOtherResp);
        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(((App) getApplication()).getDaoSession());


    }

    public Interview CreateInterview(int value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.respDesempenho = (short) value;
        return interview;

    }

    public Interview CreateInterview(String value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.otherResp = value;
        return interview;

    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, FinishInterviewActivity.class);
        data.updateDb(IdPerson,nome,CreateInterview(opt),activity);
        startActivity(activity);

    }

    public void CreateActivity(String opt)
    {
        Intent activity = new Intent(this, FinishInterviewActivity.class);
        data.updateDb(IdPerson,nome,CreateInterview(opt),activity);
        startActivity(activity);

    }


    public void onRadioPlayClicked(View view){
        CreateActivity(1);
    }
    public void onRadioTecClicked(View view){
        CreateActivity(2);
    }
    public void onRadioCBFClicked(View view){
        CreateActivity(3);
    }
    public void btnOtherRespClick(View view){CreateActivity(edtOtherResp.getText().toString());}
}
