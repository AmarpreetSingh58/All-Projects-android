package com.amarpreetsinghprojects.floatingwidgets;

import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Snackbar.make(findViewById(android.R.id.content),"Hello", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
    }
}
