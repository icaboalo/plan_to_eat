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
import com.icaboalo.plantoeat.domain.Ingredients;
import com.icaboalo.plantoeat.ui.adapter.IngredientsRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/24/2015.
 */
public class IngredientsFragment extends Fragment{

    @Bind(R.id.ingredient_recycler_view)
    RecyclerView mIngredientRecycler;

    IngredientsRecyclerAdapter mIngredientsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ingredient_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setupIngredientRecycler();
    }

    private void setupIngredientRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mIngredientRecycler.setLayoutManager(linearLayoutManager);
        mIngredientsAdapter = new IngredientsRecyclerAdapter(getActivity(), createIngredient());
        mIngredientRecycler.setAdapter(mIngredientsAdapter);
    }

    List<Ingredients> createIngredient() {
        List<Ingredients> ingredientsList = new ArrayList<>();
        return ingredientsList;
    }

    public void changeListData(String ingredientName, String ingredientQuantity){
        mIngredientsAdapter.addData(ingredientName, ingredientQuantity);
    }
}
