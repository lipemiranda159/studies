package com.example.rafael.interviewassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FinishInterviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_interview);
    }

    public void onBtnFinishClick(View view)
    {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

}
