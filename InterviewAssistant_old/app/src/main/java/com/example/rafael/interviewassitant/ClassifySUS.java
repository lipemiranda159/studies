package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClassifySUS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_sus);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, howgetbetter.class);
        startActivity(activity);

    }

    public void onRadioOtmClicked(View view)
    {
        CreateActivity();
    }

    public void onRadioBomClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioRegClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioRuimClicked(View view)
    {
        CreateActivity();
    }
    public void onRadioPessimoClicked(View view)
    {
        CreateActivity();
    }
}
