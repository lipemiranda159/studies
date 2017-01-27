package interviewassistant.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import interviewassistant.models.DataBaseInterview;
import interviewassistant.models.Interview;

public class ListHospital extends AppCompatActivity {

    private int IdPerson;
    private DataBaseInterview data;
    private String nome;
    private EditText edtOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(interviewassistant.example.rafael.interviewassistant.R.layout.activity_list_hospital);

        edtOther = (EditText) findViewById(interviewassistant.example.rafael.interviewassistant.R.id.edtOtherHospital);

        Intent intent = getIntent();
        IdPerson = intent.getIntExtra("Id", 0);
        nome = intent.getStringExtra("Name");
        data = new DataBaseInterview(this);
    }

    public Interview CreateInterview(short value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.IDHospital = value;
        return interview;

    }

    public Interview CreateInterview(String value)
    {
        Interview interview = new Interview();
        interview.setIdPerson(IdPerson);
        interview.otherHospital = value;
        return interview;

    }


    public void CreateActivity(int opt)
    {
        Intent activity = new Intent(this, Sickness.class);
        data.updateDb(IdPerson,nome,CreateInterview((short) opt),activity);
        startActivity(activity);

    }

    public void CreateActivity(String value)
    {
        Intent activity = new Intent(this, Sickness.class);
        data.updateDb(IdPerson,nome,CreateInterview(value),activity);
        startActivity(activity);

    }

    public void onRadioHospBalClicked(View view){

        CreateActivity(1);
    }

    public void onRadioJXXClicked(View view)
    {
        CreateActivity(2);
    }

    public void onRadioHospEvanClicked(View view){

        CreateActivity(3);
    }

    public void onRadioFelRClicked(View view)
    {
        CreateActivity(4);
    }

    public void onRadioJulKClicked(View view)
    {
        CreateActivity(5);
    }

    public void onRadioEdMenClicked(View view)
    {
        CreateActivity(6);

    }
    public void onRadioAlbCalvClicked(View view)
    {
        CreateActivity(7);
    }

    public void onRadioHosTerClicked(View view)
    {

        CreateActivity(8);
    }

    public void onBtnListHosSendOtherClick(View view)
    {
        CreateActivity(edtOther.getText().toString());
    }
}
