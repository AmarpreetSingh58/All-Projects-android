package com.example.kulvi.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class count extends AppCompatActivity {

    int score1=0,score2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        Intent i = getIntent();
        Button firstTeamButton = (Button)findViewById(R.id.Firstteam);
        firstTeamButton.setText(i.getStringExtra("firstteamname"));
        switch (i.getStringExtra("team1Color"))
        {
            case "Blue":firstTeamButton.setBackgroundColor(Integer.parseInt("#2196F3"));
                break;
            case "Red":firstTeamButton.setBackgroundColor(Integer.parseInt("#F44336"));
                break;
            case "Yellow":firstTeamButton.setBackgroundColor(Integer.parseInt("#FFEB3B"));
                break;
            case "Green":firstTeamButton.setBackgroundColor(Integer.parseInt("#4CAF50"));
                break;
            case "Voilet":firstTeamButton.setBackgroundColor(Integer.parseInt("#9C27B0"));
                break;
            case "Orange":firstTeamButton.setBackgroundColor(Integer.parseInt("#FF9800"));
                break;
            case "White":firstTeamButton.setBackgroundColor(Integer.parseInt("#FFFFFF"));
                break;
            default:firstTeamButton.setBackgroundColor(Integer.parseInt("#ECEFF1"));
               
        }
        
        Button secondTeamButton = (Button)findViewById(R.id.Secondteam);
        secondTeamButton.setText(i.getStringExtra("secondteamname"));
        switch (i.getStringExtra("team2Color"))
        {
            case "Blue":secondTeamButton.setBackgroundColor(Integer.parseInt("#2196F3"));
                break;
            case "Red":secondTeamButton.setBackgroundColor(Integer.parseInt("#F44336"));
                break;
            case "Yellow":secondTeamButton.setBackgroundColor(Integer.parseInt("#FFEB3B"));
                break;
            case "Green":secondTeamButton.setBackgroundColor(Integer.parseInt("#4CAF50"));
                break;
            case "Voilet":secondTeamButton.setBackgroundColor(Integer.parseInt("#9C27B0"));
                break;
            case "Orange":secondTeamButton.setBackgroundColor(Integer.parseInt("#FF9800"));
                break;
            case "White":secondTeamButton.setBackgroundColor(Integer.parseInt("#FFFFFF"));
                break;
            default:secondTeamButton.setBackgroundColor(Integer.parseInt("#ECEFF1"));

        }


    }

    public void incrementteam1(View view)
    {
        TextView teamScore = (TextView)findViewById(R.id.firstTeamScore);
        score1++;
        teamScore.setText(score1);
    }

    public void incrementteam2(View view)
    {
        TextView teamScore = (TextView)findViewById(R.id.firstTeamScore);
        score2++;
        teamScore.setText(score2);
    }

    public void resetScore(View view)
    {
        TextView teamScore = (TextView)findViewById(R.id.firstTeamScore);
        score1=0;
        teamScore.setText(score1);
        teamScore = (TextView)findViewById(R.id.secondTeamScore);
        score2=0;
        teamScore.setText(score2);
    }
}
