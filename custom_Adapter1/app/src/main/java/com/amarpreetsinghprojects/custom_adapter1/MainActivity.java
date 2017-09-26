package com.amarpreetsinghprojects.custom_adapter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Elements> elementsArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementsArrayList.add(new Elements("HI","There","!..."));
        elementsArrayList.add(new Elements("Hello","There","!..."));
        elementsArrayList.add(new Elements("HI","how","r u"));
        elementsArrayList.add(new Elements("i","am","good"));
        elementsArrayList.add(new Elements("what","bout","!..."));
        elementsArrayList.add(new Elements("....!","You","!..."));

        ListView listView = (ListView)findViewById(R.id.eleement_listView);
        ElementAdapter adapter = new ElementAdapter(elementsArrayList,this);
        listView.setAdapter(adapter);

    }
}
