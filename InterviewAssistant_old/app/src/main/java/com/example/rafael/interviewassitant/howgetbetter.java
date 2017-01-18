package com.example.rafael.interviewassitant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class howgetbetter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howgetbetter);
    }

    public void CreateActivity()
    {
        Intent activity = new Intent(this, howgetbetter.class);
        startActivity(activity);

    }

    public void onRadioPlusMedClicked(View view){ CreateActivity();}

    public void onRadioRefHosClicked(View view){ CreateActivity();}

    public void onRadioNewHosClicked(View view){ CreateActivity();}

    public void onRadioDisMedClicked(View view){ CreateActivity();}

    public void onRadioLtConsClicked(View view){ CreateActivity();}

    public void onRadioTimeConClicked(View view){ CreateActivity();}

    public void onRadioTimeCirClicked(View view){ CreateActivity();}

    public void onRadioTimeExClicked(View view){ CreateActivity();}

    public void btnOthersClick(View view){ CreateActivity();}
}
