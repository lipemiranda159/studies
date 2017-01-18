package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DescribeUseSUS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe_use_sus);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, Bhhospital.class);
        startActivity(activity);

    }

    public void onRadioUrgClicked(View view){

        CreateActivity();
    }

    public void onRadioConClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioExsClicked(View view){

        CreateActivity();
    }

    public void onRadioVacClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioNatClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioOdtClicked(View view)
    {
        CreateActivity();

    }
}
