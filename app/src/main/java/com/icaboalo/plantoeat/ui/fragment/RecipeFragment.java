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
import com.icaboalo.plantoeat.domain.Recipes;
import com.icaboalo.plantoeat.ui.adapter.RecipeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/17/2015.
 */
public class RecipeFragment extends Fragment implements RecipeRecyclerAdapter.MyRecipeViewHolder.MyViewHolderClick{

    @Bind(R.id.recipes_recycler_view)
    RecyclerView mRecipesRecycler;

    RecipeRecyclerAdapter recipeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setupRecyclerView();
    }

    List<Recipes> createRecipe(){
        List<Recipes> recipesList = new ArrayList<>();
        recipesList.add(new Recipes("Fajitas Mongolianas", "4"));
        return recipesList;
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecipesRecycler.setLayoutManager(linearLayoutManager);
        recipeAdapter = new RecipeRecyclerAdapter(createRecipe(), getActivity(), this);
        mRecipesRecycler.setAdapter(recipeAdapter);
    }

    @Override
    public void onMyClick(View item, int position) {

    }
}
