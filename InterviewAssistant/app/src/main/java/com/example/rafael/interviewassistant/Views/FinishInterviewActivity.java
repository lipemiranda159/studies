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
import com.exemple.rafael.interviewassistant.model.DaoSession;
import com.exemple.rafael.interviewassistant.model.DataBaseInterview;
import com.exemple.rafael.interviewassistant.model.Interview;
import com.exemple.rafael.interviewassistant.model.InterviewDao;

public class FinishInterviewActivity extends AppCompatActivity {

    private long IdPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_interview);

        Intent intent = getIntent();
        IdPerson = intent.getLongExtra("Id", 0);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void Update()
    {
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        InterviewDao interviewDao = daoSession.getInterviewDao();
        Interview interview = interviewDao.queryRaw("WHERE id_person = '"+IdPerson+"'").get(0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        interview.dateFinish = format.format(Calendar.getInstance().getTime());
        interview.setInterviewSent(false);
        interviewDao.save(interview);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onBtnFinishClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Update();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

}
