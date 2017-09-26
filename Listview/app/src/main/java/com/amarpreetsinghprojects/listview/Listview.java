package com.amarpreetsinghprojects.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Listview extends AppCompatActivity {

    String[] test = {"abc","bcd","dcv","hascv","scahv","sns","sachv","svcsjn","acfsv","DWAJSV","dsbcd","asdcjd","adshcb","aedbc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = (ListView) findViewById(R.id.list_textview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.simple_textview,
                R.id.list_textview,
                test);
        listView.setAdapter(adapter);
    }
}
