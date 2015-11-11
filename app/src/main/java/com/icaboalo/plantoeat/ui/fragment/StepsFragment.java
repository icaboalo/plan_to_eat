package com.icaboalo.plantoeat.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icaboalo.plantoeat.R;
import com.icaboalo.plantoeat.domain.Steps;
import com.icaboalo.plantoeat.ui.adapter.StepsRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/24/2015.
 */
public class StepsFragment extends Fragment {

    @Bind(R.id.step_recycler_view)
    RecyclerView mStepsRecycler;

    StepsRecyclerAdapter mStepsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_steps, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setupStepsRecycler();
    }

    private void setupStepsRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mStepsRecycler.setLayoutManager(linearLayoutManager);
        mStepsAdapter = new StepsRecyclerAdapter(getActivity(), createStep());
        mStepsRecycler.setAdapter(mStepsAdapter);
    }

    List<Steps> createStep(){
        List<Steps> stepsList = new ArrayList<>();
        return stepsList;
    }

    public void changeListData(String stepDescription){
        mStepsAdapter.addData(stepDescription);
    }
}