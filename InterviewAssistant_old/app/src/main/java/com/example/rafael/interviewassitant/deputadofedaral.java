package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class deputadofedaral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputadofedaral);
    }
    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, whattheydo.class);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, FinishInterview.class);
        startActivity(activity);
    }

}
