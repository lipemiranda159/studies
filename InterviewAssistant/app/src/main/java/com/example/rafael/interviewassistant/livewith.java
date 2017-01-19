package com.example.rafael.interviewassistant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class livewith extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livewith);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, haschildren.class);
        startActivity(activity);
    }
    public void onRadioParentesClicked(View view)
    {
     CreateActivity();
    }
    public void onRadioAvosClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioWifeClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioFriendsClicked(View view)
    {
        CreateActivity();
    }
    public void onBtnSendLiv(View view)
    {
        CreateActivity();
    }
}
