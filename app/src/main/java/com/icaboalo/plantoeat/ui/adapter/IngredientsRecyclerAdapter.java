package com.icaboalo.plantoeat.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by icaboalo on 10/20/2015.
 */
public class IngredientsRecyclerAdapter extends RecyclerView.Adapter<IngredientsRecyclerAdapter.MyIngredientsViewHolder> {


    @Override
    public MyIngredientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyIngredientsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyIngredientsViewHolder extends RecyclerView.ViewHolder{

        TextView mIngredientQuantity, mIngredientName;

        public MyIngredientsViewHolder(View itemView, int ingredientQuantityId, int ingredientNameId) {
            super(itemView);
            mIngredientQuantity = (TextView) itemView.findViewById(ingredientQuantityId);
            mIngredientName = (TextView) itemView.findViewById(ingredientNameId);
        }

        public void setIngredientQuantity(String ingredientQuantity) {
            mIngredientQuantity.setText(ingredientQuantity);
        }

        public void setIngredientName(String ingredientName) {
            mIngredientName.setText(ingredientName);
        }
    }
}
