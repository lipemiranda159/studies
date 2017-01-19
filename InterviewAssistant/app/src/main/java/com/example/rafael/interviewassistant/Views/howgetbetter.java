package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;

public class howgetbetter extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howgetbetter);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, ListOcupation.class);
        startActivity(activity);

    }

    public void onRadioPlusMedClicked(View view){ CreateActivity();}

    public void onRadioRefHosClicked(View view){ CreateActivity();}

    public void onRadioNewHosClicked(View view){ CreateActivity();}

    public void onRadioDisMedClicked(View view){ CreateActivity();}

    public void onRadioLtConsClicked(View view){ CreateActivity();}

    public void onRadioTimeConClicked(View view){ CreateActivity();}

    public void onRadioTimeCirClicked(View view){ CreateActivity();}

    public void onRadioTimeExClicked(View view){ CreateActivity();}

    public void btnOthersClick(View view){ CreateActivity();}
}
