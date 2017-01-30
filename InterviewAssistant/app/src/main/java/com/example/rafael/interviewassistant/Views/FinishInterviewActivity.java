package com.example.rafael.interviewassistant.Views;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rafael.interviewassistant.R;
import com.exemple.rafael.interviewassistant.model.App;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;

public class FinishInterviewActivity extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_interview);

        data = new DataBaseInterview(((App) getApplication()).getDaoSession());

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Interview CreateInterview(){
        Interview interview = new Interview();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        interview.dateFinish = format.format(Calendar.getInstance().getTime());
        return interview;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onBtnFinishClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        data.updateDb(IdPerson,"",CreateInterview(),intent);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

}
