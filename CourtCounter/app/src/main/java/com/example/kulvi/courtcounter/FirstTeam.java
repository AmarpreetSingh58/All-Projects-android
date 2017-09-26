package com.example.kulvi.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class FirstTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_team);
        Spinner spinner = (Spinner)findViewById(R.id.colorspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teamcolor1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void getvalue(View view)
    {
        Spinner team1_colorspinner = (Spinner)findViewById(R.id.colorspinner);
        String team1_color = team1_colorspinner.getSelectedItem().toString();

        TextView team1_nametextView = (TextView)findViewById(R.id.firstteamnametextview);
        String team1_name = team1_nametextView.getText().toString();

        Intent i = new Intent(FirstTeam.this,SecondTeam.class);
        i.putExtra("firstteamname",team1_name);
        i.putExtra("team1color",team1_color);
        startActivity(i);
    }
}
