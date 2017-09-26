package com.amarpreetsinghprojects.customwidget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.mainActivityTV);

       /* to check if key is present.
        if (intent.hasExtra("IntegerValue")){
            textView.setText("" + intent.getIntExtra("IntegerValue", 0));
        }*/

       if (intent.getAction().equals("android.appwidget.action.APPWIDGET_UPDATE")){
           textView.setText("" + intent.getIntExtra("IntegerValue", 0));
       }
    }
}
