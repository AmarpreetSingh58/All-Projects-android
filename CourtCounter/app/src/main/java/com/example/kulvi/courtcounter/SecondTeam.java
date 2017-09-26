package com.example.kulvi.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SecondTeam extends AppCompatActivity{

    String firstTeamName,team1Color;
    String TAG = "msg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_team);

        Intent intent = getIntent();
        firstTeamName = intent.getStringExtra("firstteamname");
        team1Color = intent.getStringExtra("team1color");
        Spinner spinner = (Spinner)findViewById(R.id.colorspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teamcolor1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void getValue1(View view)
    {
        Log.d(TAG, "getValue1: "+team1Color);
        Spinner team2_colorspinner = (Spinner)findViewById(R.id.colorspinner);
        String team2_color = team2_colorspinner.getSelectedItem().toString();

        TextView team2_nametextView = (TextView)findViewById(R.id.firstteamnametextview);
        String team2_name = team2_nametextView.getText().toString();

        if(team2_color.equals(team1Color))
        {
            EditText errorteaxtview = (EditText)findViewById(R.id.errortextview);
            errorteaxtview.setText("@string/SameColorErrorText");
        }
        else {
            Intent j = new Intent(SecondTeam.this, count.class);
            Bundle bundleData = new Bundle();
            bundleData.putString("firstteamname", firstTeamName);
            bundleData.putString("secondteamname", team2_name);
            bundleData.putString("team1Color", team1Color);
            bundleData.putString("team2Color", team2_color);
            j.putExtras(bundleData);
            startActivity(j);
        }
    }
}

