package com.amarpreetsinghprojects.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView t = (TextView)findViewById(R.id.textView);
        Button b = (Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i<3; i++){
                            t.setText("dISplay");
                        }
                    }
                });
                thread.start();
            }
        });

        t.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },3000);
        )


    }
}
