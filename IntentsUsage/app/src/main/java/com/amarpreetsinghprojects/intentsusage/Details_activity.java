package com.amarpreetsinghprojects.intentsusage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by kulvi on 06/23/17.
 */

public class Details_activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();


        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(i.getDataString());// in getInt we have to give a default value
    }
}
