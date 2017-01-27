package interviewassistant.Views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import interviewassistant.example.rafael.interviewassistant.R;
import interviewassistant.models.DataBaseInterview;
import interviewassistant.models.Interview;

public class Hasproblemswithplan extends ActionBarActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasproblemswithplan);

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(this);

    }

    public Interview CreateInterview(short value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.IDProblemWithPlan = value;
        return interview;

    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, Sickness.class);
        data.updateDb(IdPerson,nome,CreateInterview((short) opt),activity);
        startActivity(activity);

    }

    public void onRadioAutorizeClicked(View view){
        CreateActivity(1);
    }
    public void onRadioNoMedClicked(View view){
        CreateActivity(2);
    }
    public void onRadioDescMedClicked(View view){
        CreateActivity(3);
    }
    public void onRadioDescLabClicked(View view){
        CreateActivity(4);
    }
    public void onRadioHardPayClicked(View view){
        CreateActivity(5);
    }
    public void onRadioHardScheduleClicked(View view){
        CreateActivity(6);
    }


}
