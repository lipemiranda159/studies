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

public class livewith extends ActionBarActivity {

    private long IdPerson;
    private DataBaseInterview data;
    private String nome;
    private EditText edtOthersLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livewith);

        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(((App) getApplication()).getDaoSession());

        edtOthersLive = (EditText) findViewById(R.id.edtOthersLive);


    }

    public Interview CreateInterview(int value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.liveWith = (short) value;
        return interview;

    }

    public Interview CreateInterview(String value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.otherDweller = value;
        return interview;

    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, haschildren.class);
        data.updateDb(IdPerson,nome,CreateInterview(opt),activity);
        startActivity(activity);
    }

    public void CreateActivity(String opt)
    {
        Intent activity = new Intent(this, haschildren.class);
        data.updateDb(IdPerson,nome,CreateInterview(opt),activity);
        startActivity(activity);
    }

    public void onRadioParentesClicked(View view)
    {
     CreateActivity(1);
    }
    public void onRadioAvosClicked(View view)
    {
        CreateActivity(2);
    }
    public void onRadioWifeClicked(View view)
    {
        CreateActivity(3);
    }
    public void onRadioFriendsClicked(View view)
    {
        CreateActivity(4);
    }
    public void onBtnSendLiv(View view)
    {
        CreateActivity(edtOthersLive.getText().toString());
    }
}
