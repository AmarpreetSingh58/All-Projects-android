package com.amarpreetsinghprojects.custom_adapter1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kulvi on 06/16/17.
 */

public class ElementAdapter extends BaseAdapter {

    ArrayList<Elements> elementsArrayList;
    Context c;
    public ElementAdapter(ArrayList<Elements> arrayList, Context context) {
        elementsArrayList = arrayList;
        c = context;
    }

    @Override
    public int getCount() {
        return elementsArrayList.size();
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
        LayoutInflater l = LayoutInflater.from(c);

        View v;
        viewHolder viewHolder;

        if (convertView==null)
        {
            v = l.inflate(R.layout.element_list_view,parent,false);
            viewHolder = new viewHolder();
            viewHolder.textView1 = (TextView)v.findViewById(R.id.textview1);
            viewHolder.textView2 = (TextView)v.findViewById(R.id.textview2);
            viewHolder.button = (Button)v.findViewById(R.id.button);
            v.setTag(viewHolder);

        }
        else
        {
            v = convertView;
            viewHolder = (viewHolder)v.getTag();
        }

        Elements e = elementsArrayList.get(position);
        viewHolder.textView1.setText(e.text1);
        viewHolder.textView2.setText(e.text2);
        viewHolder.button.setText(e.buttonText);
        return v;
    }

    static class viewHolder{
        TextView textView1,textView2;
        Button button;
    }
}
