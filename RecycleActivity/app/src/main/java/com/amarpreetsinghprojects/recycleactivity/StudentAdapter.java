package com.amarpreetsinghprojects.recycleactivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kulvi on 06/16/17.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    ArrayList<Student> studentArrayList;
    Context c;

    public StudentAdapter(ArrayList<Student> studentArrayList, Context c) {
        this.studentArrayList = studentArrayList;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create view objects and checks also if new view has to be ceated or not.

        LayoutInflater l = LayoutInflater.from(c);
        View v = l.inflate(R.layout.student_list_item,parent,false);
        ViewHolder vH = new ViewHolder(v);
        return vH;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // binds elements with view
        Student s = studentArrayList.get(position);
        holder.name.setText(s.getName());
        holder.age.setText(s.getAge());
        holder.course.setText(s.getCourse());

    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,age,course;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            age = (TextView) itemView.findViewById(R.id.age);
            course = (TextView) itemView.findViewById(R.id.course);
        }
    }


}
