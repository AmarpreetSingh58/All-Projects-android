package com.amarpreetsinghprojects.courtcounter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by kulvi on 06/25/17.
 */

public class TeamAFragment extends Fragment {

    ArrayList<TeamDetails> teamDetailsArrayList;

    public static TeamAFragment newInstance(ArrayList<TeamDetails> teamarrayList) {

        Bundle args = new Bundle();
        args.putSerializable("KEY",teamarrayList);

        TeamAFragment fragment = new TeamAFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        teamDetailsArrayList = (ArrayList<TeamDetails>) getArguments().getSerializable("KEY");


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
