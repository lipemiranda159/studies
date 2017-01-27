package interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import interviewassistant.example.rafael.interviewassistant.R;
import interviewassistant.models.DataBaseInterview;
import interviewassistant.models.Interview;

public class VerifyAgeActivity extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_age);

        data = new DataBaseInterview(this);
        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id",0);
        nome = intent.getStringExtra("Name");

    }

    public Interview CreateInterview(boolean value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.verifyAge = value;
        return interview;

    }


    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, ApresentationActivity.class);
        data.updateDb(IdPerson,nome,CreateInterview(true),activity);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, FinishInterviewActivity.class);
        data.updateDb(IdPerson,nome,CreateInterview(false),activity);
        startActivity(activity);
    }

}
