package com.example.kulvi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activities extends AppCompatActivity {

    int count = 0;
    String TAG ="Message";
    EditText editTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        editTextView = (EditText) findViewById(R.id.editText1);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInastanceState) {
        super.onSaveInstanceState(savedInastanceState);
        savedInastanceState.putInt("count",count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
    }

    public void increment(View view){
        Log.d(TAG, "increment: running");
        count++;
        editTextView.setText(""+count);
    }

    public void decrement(View view){
        Log.d(TAG, "decrement: running");
        if(count>0){
            count--;
            editTextView.setText(""+count);
        }
        else {
            editTextView.setText("Sorry can't go below 0");
        }
    }

}
