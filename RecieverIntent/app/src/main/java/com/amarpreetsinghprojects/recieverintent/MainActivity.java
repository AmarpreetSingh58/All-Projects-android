package com.amarpreetsinghprojects.recieverintent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    LinearLayout linearLayout;
    TextView textView;
    MyNewReciever newReciever;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        textView = (TextView)findViewById(R.id.textView);

         intentFilter = new IntentFilter();
        intentFilter.addAction("com.amarpreetsinghprojects.recieverintent");

        newReciever= new MyNewReciever();



        Button b = new Button(this);
        b.setText("CLick");
        b.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.amarpreetsinghprojects.recieverintent");
                intent.putExtra("KEY","Notice on Click");
                LocalBroadcastManager
                        .getInstance(getBaseContext())
                        .sendBroadcast(intent);
                sendBroadcast(intent);
            }
        });
        linearLayout.addView(b);

    }

    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver(newReciever,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(newReciever);
    }

    class MyNewReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            textView.setText(intent.getStringExtra("KEY"));
        }
    }
}
