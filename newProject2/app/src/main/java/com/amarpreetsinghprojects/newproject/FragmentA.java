package com.amarpreetsinghprojects.newproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kulvi on 06/25/17.
 */

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_a,container,false);

        final EditText editText = (EditText)v.findViewById(R.id.fragmentAETV);
        Button button = (Button)v.findViewById(R.id.fragment_a_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Communicate communicate = (Communicate) getActivity();
                communicate.changeText(editText.getText().toString());
            }
        });
        return v;
    }
}
