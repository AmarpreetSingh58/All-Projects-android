package com.amarpreetsinghprojects.recycleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("sad","15","accas"));
        studentArrayList.add(new Student("sad","15","accas"));
        studentArrayList.add(new Student("sad","15","accas"));
        studentArrayList.add(new Student("sad","15","accas"));
        studentArrayList.add(new Student("sad","15","accas"));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        StudentAdapter adapter = new StudentAdapter(studentArrayList,this);
        recyclerView.setAdapter(adapter);
    }
}
