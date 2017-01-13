package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sickness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sickness);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, ClassifySUS.class);
        startActivity(activity);

    }

    public void onRadioCancerClicked(View view){
        CreateActivity();
    }
    public void onRadioDoeHepaClicked(View view){
        CreateActivity();
    }
    public void onRadioCardiacClicked(View view){
        CreateActivity();
    }
    public void onRadioAsmaClicked(View view){
        CreateActivity();
    }
    public void onRadioOthersClicked(View view){
        CreateActivity();
    }
    public void onRadioNoClicked(View view){
        CreateActivity();
    }

}
