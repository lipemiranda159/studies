package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class haschildren extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haschildrens);
    }

    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, religion.class);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, religion.class);
        startActivity(activity);
    }

}
