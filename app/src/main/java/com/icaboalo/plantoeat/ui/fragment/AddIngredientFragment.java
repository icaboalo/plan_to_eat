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
public class AddIngredientFragment extends Fragment {

    @Bind(R.id.ingredient_recycler_view)
    RecyclerView mIngredientRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_ingredient_list, container, false);
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
        IngredientsRecyclerAdapter ingredientsAdapter = new IngredientsRecyclerAdapter(getContext(), createIngredient());
        mIngredientRecycler.setAdapter(ingredientsAdapter);
    }

    List<Ingredients> createIngredient() {
        List<Ingredients> ingredientsList = new ArrayList<>();
        ingredientsList.add(new Ingredients("Salt", "2 sps"));
        ingredientsList.add(new Ingredients("Salt", "2 sps"));
        return ingredientsList;
    }
}
