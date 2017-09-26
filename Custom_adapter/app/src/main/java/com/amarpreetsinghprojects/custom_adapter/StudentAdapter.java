package com.amarpreetsinghprojects.custom_adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.amarpreetsinghprojects.custom_adapter.R.id.age;

/**
 * Created by kulvi on 06/16/17.
 */

public class StudentAdapter extends BaseAdapter {


    ArrayList<Student> studentArrayList;
    Context c;
    public StudentAdapter(ArrayList<Student> arrayList, Context context) {
        this.studentArrayList = arrayList;
        this.c = context;


    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // getView is called array list length times with position refring to the current array index

        String TAG = "msg";
        Log.d(TAG, "getView: "+position);
        LayoutInflater l = LayoutInflater.from(c);
        View v;
        viewHolder viewHolder;
        if (convertView == null) {
            v = l.inflate(R.layout.lisr_single_student_item,
                    parent,
                    false);

            viewHolder = new viewHolder();
            viewHolder.age=(TextView)v.findViewById(age);
            viewHolder.name=(TextView)v.findViewById(R.id.name);
            viewHolder.course=(TextView)v.findViewById(R.id.course);
            v.setTag(viewHolder);
        }
        else{
            v = convertView;
            viewHolder = (viewHolder)v.getTag();
        }


        Student s = studentArrayList.get(position);

        viewHolder.name.setText(s.getName());
        viewHolder.age.setText(s.getAge());
        viewHolder.course.setText(s.getCourse());
        return v;
    }

    static class viewHolder{
        TextView name,age,course;
    }
}

