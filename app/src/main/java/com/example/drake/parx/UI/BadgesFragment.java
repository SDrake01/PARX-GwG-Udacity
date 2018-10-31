package com.example.drake.parx.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drake.parx.Adapters.MainBadgesAdapter;
import com.example.drake.parx.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.OnSuccessListener;

public class BadgesFragment extends Fragment {

    View view;
    private RecyclerView badgesRecyclerView;
    private static LinearLayoutManager badgesLayoutManager;
    public static MainBadgesAdapter badgesAdapter;
    SnapHelper helper;
    private static final int RC_ACHIEVEMENT_UI = 9003;

//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        view = inflater.inflate(R.layout.fragment_badges, container, false);
        badgesRecyclerView = view.findViewById(R.id.rv_fragment_badges_recyclerview);

        badgesLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        badgesRecyclerView.setLayoutManager(badgesLayoutManager);
        badgesAdapter = new MainBadgesAdapter(this.getActivity());
        badgesRecyclerView.setAdapter(badgesAdapter);
        helper = new LinearSnapHelper();
        helper.attachToRecyclerView(badgesRecyclerView);

        return view;
    }

}
