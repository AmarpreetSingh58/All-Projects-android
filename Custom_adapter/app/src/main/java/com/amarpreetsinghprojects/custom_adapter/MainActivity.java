package com.amarpreetsinghprojects.custom_adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentArrayList.add(new Student("Amar","20","Btech"));
        studentArrayList.add(new Student("Harsimran","17","Btech"));
        studentArrayList.add(new Student("avc","67","csw"));
        studentArrayList.add(new Student("sac","120","cSCc"));


        ListView studentListView = (ListView)findViewById(R.id.studentListView);
        StudentAdapter adapter = new StudentAdapter(studentArrayList,this);
        studentListView.setAdapter(adapter);
    }

    public class studentAdapter extends BaseAdapter{

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
            LayoutInflater l = getLayoutInflater();
            View v;
            if (convertView == null) {
                v = l.inflate(R.layout.lisr_single_student_item,
                        parent,
                        false);
            }
            else{
                v = convertView;
            }

            TextView name,age,course;
            name = (TextView)v.findViewById(R.id.name);
            course = (TextView)v.findViewById(R.id.course);
            age = (TextView)v.findViewById(R.id.age);

            Student s = studentArrayList.get(position);

            name.setText(s.getName());
            age.setText(s.getAge());
            course.setText(s.getCourse());
            return v;
        }
    }
}
