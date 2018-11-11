package com.example.drake.parx.UI;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BadgesFragment extends Fragment {

    View view;
    private static LinearLayoutManager badgesLayoutManager;
    public static MainBadgesAdapter badgesAdapter;
    SnapHelper helper;
    private static final int RC_ACHIEVEMENT_UI = 9003;
    // Annotate views for use with Butterknife
    @BindView(R.id.rv_fragment_badges_recyclerview) RecyclerView badgesRecyclerView;
    private Unbinder badgesUnbinder;

//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        view = inflater.inflate(R.layout.fragment_badges, container, false);
        badgesUnbinder = ButterKnife.bind(this, view);

        badgesLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        badgesRecyclerView.setLayoutManager(badgesLayoutManager);
        badgesAdapter = new MainBadgesAdapter(this.getActivity());
        badgesRecyclerView.setAdapter(badgesAdapter);
        helper = new LinearSnapHelper();
        helper.attachToRecyclerView(badgesRecyclerView);

        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        badgesUnbinder.unbind();
    }

}
