package interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import interviewassistant.models.DataBaseInterview;
import interviewassistant.models.Interview;

public class conhecesupersimples extends ActionBarActivity {


    private int IdPerson;
    private DataBaseInterview data;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(interviewassistant.example.rafael.interviewassistant.R.layout.activity_conhecesupersimples);

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(this);

    }

    public Interview CreateInterview(boolean value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.knowSuperSimples = value;
        return interview;

    }

    public void CreateActivity(boolean opt)
    {
        Intent activity = new Intent(this, willvote.class);
        data.updateDb(IdPerson,nome,CreateInterview(opt),activity);
        startActivity(activity);
    }


    public void onRadioYesClicked(View view){

        Intent activity = new Intent(this, livewith.class);
        data.updateDb(IdPerson,nome,CreateInterview(true),activity);
        startActivity(activity);
    }

    public void onRadioNoClicked(View view)
    {
        Intent activity = new Intent(this, livewith.class);
        data.updateDb(IdPerson,nome,CreateInterview(false),activity);
        startActivity(activity);
    }

}
