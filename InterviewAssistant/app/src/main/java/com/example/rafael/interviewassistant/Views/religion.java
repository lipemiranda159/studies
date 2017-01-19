package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;

public class religion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religion);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, aboutelection.class);
        startActivity(activity);
    }

    public void onRadioCatClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioProtClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioHavNotClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioOthersClicked(View view)
    {
        CreateActivity();
    }

}
