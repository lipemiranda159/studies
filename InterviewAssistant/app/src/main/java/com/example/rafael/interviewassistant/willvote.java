package com.example.rafael.interviewassistant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class willvote extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_willvote);
    }

    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, howselectcandidate.class);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, howselectcandidate.class);
        startActivity(activity);
    }

}
