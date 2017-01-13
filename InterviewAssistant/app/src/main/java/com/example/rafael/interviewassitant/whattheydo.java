package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class whattheydo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whattheydo);
    }
    public void CreateActivity()
    {
        Intent activity = new Intent(this, ClassifyFootball.class);
        startActivity(activity);

    }
    

    public void onRadioNoneClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioFiscalClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioCreateClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioVerbClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioLeisClicked(View view)
    {
        CreateActivity();
    }

}
