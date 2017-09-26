package com.amarpreetsinghprojects.portfolio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button call = (Button)findViewById(R.id.call_button);
        ImageButton fb = (ImageButton)findViewById(R.id.fb);
        call.setOnClickListener(this);
        fb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        switch(v.getId()){

            case R.id.call_button:
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:8447950098"));
                startActivity(i);
                break;
            case R.id.fb: i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.facebook.com"));
                startActivity(i);
                break;
        }
    }
}
