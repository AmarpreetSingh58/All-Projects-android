package com.amarpreetsinghprojects.newproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kulvi on 06/25/17.
 */

public class FragmentB extends Fragment {

    TextView textView;
    String text1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b,container,false);

        textView = (TextView)v.findViewById(R.id.fragmentBTV);

        if (savedInstanceState!= null && savedInstanceState.containsKey("text")){
            textView.setText(savedInstanceState.getString("text"));
            text1 = savedInstanceState.getString("text");
        }

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("text",text1);
    }



    public void changeText(String text){
        text1 = text;
        textView.setText(text);
    }
}
