package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class howgetbetter extends ActionBarActivity {

    private EditText edtOhostpital;
    private int IdPerson;
    private DataBaseInterview data;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howgetbetter);

        edtOhostpital = (EditText) findViewById(R.id.edtOhostpital);
        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(this);

    }

    public Interview CreateInterview(short value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.needGetBetter = value;
        return interview;

    }

    public Interview CreateInterview(String value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.otherImprovement = value;
        return interview;

    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, ListOcupation.class);
        data.updateDb(IdPerson,nome,CreateInterview((short) opt),activity);
        startActivity(activity);

    }

    public void CreateActivity(String opt)
    {
        Intent activity = new Intent(this, ListOcupation.class);
        data.updateDb(IdPerson,nome,CreateInterview(opt),activity);
        startActivity(activity);

    }

    public void onRadioPlusMedClicked(View view){ CreateActivity(1);}

    public void onRadioRefHosClicked(View view){ CreateActivity(2);}

    public void onRadioNewHosClicked(View view){ CreateActivity(3);}

    public void onRadioDisMedClicked(View view){ CreateActivity(4);}

    public void onRadioLtConsClicked(View view){ CreateActivity(5);}

    public void onRadioTimeConClicked(View view){ CreateActivity(6);}

    public void onRadioTimeCirClicked(View view){ CreateActivity(7);}

    public void onRadioTimeExClicked(View view){ CreateActivity(8);}

    public void btnOthersClick(View view){ CreateActivity(edtOhostpital.getText().toString());}
}
