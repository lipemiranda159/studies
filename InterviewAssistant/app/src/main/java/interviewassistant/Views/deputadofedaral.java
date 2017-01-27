package interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import interviewassistant.models.DataBaseInterview;
import interviewassistant.models.Interview;

public class deputadofedaral extends ActionBarActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(interviewassistant.example.rafael.interviewassistant.R.layout.activity_deputadofedaral);

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(this);

    }

    public Interview CreateInterview(boolean value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.whatTheyDo = value;
        return interview;

    }


    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, whattheydo.class);
        data.updateDb(IdPerson,nome,CreateInterview(true),activity);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, ClassifyFootball.class);
        data.updateDb(IdPerson,nome,CreateInterview(true),activity);
        startActivity(activity);
    }

}
