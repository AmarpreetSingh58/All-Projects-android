package com.amarpreetsinghprojects.networkingexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kulvi on 07/02/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<User> users;
    Context c;

    public RecyclerViewAdapter(ArrayList<User> users, Context c) {
        this.users = users;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(c);
        View v = l.inflate(R.layout.recycler_view_single_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User u = users.get(position);
        holder.id.setText(u.getId());
        holder.userid.setText(u.getUserId());
        holder.title.setText(u.getTitle());
        holder.body.setText(u.getBody());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id,userid,title,body;

        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.idTV);
            userid = (TextView)itemView.findViewById(R.id.useridTV);
            title = (TextView)itemView.findViewById(R.id.titleTV);
            body = (TextView)itemView.findViewById(R.id.bodyTV);
        }
    }
}
