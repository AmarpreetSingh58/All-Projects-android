package com.amarpreetsinghprojects.listview_assignment;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static com.amarpreetsinghprojects.listview_assignment.R.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        listView = (ListView)findViewById(id.listview);
        Button android_button = (Button)findViewById(id.android_button);
        Button hello_button = (Button)findViewById(id.hello_button);
        Button interest_button = (Button)findViewById(id.interest_button);
        Button reset_button = (Button)findViewById(id.reset_button);
        android_button.setOnClickListener(this);
        hello_button.setOnClickListener(this);
        interest_button.setOnClickListener(this);
        reset_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Resources res = getResources();
        switch (v.getId())
        {
            case R.id.android_button:
                ArrayAdapter<String> android_adapter = new ArrayAdapter<String>(this,
                        layout.android_listview,
                        id.android_list_item,
                        res.getStringArray(array.android_response));
                listView.setAdapter(android_adapter);
                break;
            case R.id.hello_button: ArrayAdapter<String> hello_adapter = new ArrayAdapter<String>(this,
                    layout.hello_listview,
                    id.hello_listview_item,
                    res.getStringArray(array.hello_response));
                listView.setAdapter(hello_adapter);
                break;
            case R.id.interest_button : ArrayAdapter<String > interest_adapter = new ArrayAdapter<String>(this,
                    layout.interest_listview,
                    id.interest_listview_item,
                    res.getStringArray(array.interest_response));
                listView.setAdapter(interest_adapter);
                break;
            case R.id.reset_button:ArrayAdapter<String> reset_adapter = new ArrayAdapter<String>(this,
                    layout.reset_listview,
                    id.reset_listview_item,
                    res.getStringArray(array.reset_array));
                listView.setAdapter(reset_adapter);
                break;
        }

    }
}
