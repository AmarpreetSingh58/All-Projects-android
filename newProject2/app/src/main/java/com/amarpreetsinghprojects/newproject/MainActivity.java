package com.amarpreetsinghprojects.newproject;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void changeText(String text) {
        Fragment fragmentB = getSupportFragmentManager().findFragmentById(R.id.fragmentb);
        FragmentB fragmentB1 = (FragmentB) fragmentB;

        fragmentB1.changeText(text);

        Intent i = new Intent(MainActivity.this,SecondActivity.class);
        i.putExtra("text",text);
    }
}
