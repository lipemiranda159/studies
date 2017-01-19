package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rafael.interviewassistant.R;

public class ConfirmInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_information);
    }

    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, ApresentationActivity.class);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, VerifyAgeActivity.class);
        startActivity(activity);
    }

}
