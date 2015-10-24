package com.icaboalo.plantoeat.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icaboalo.plantoeat.R;
import com.icaboalo.plantoeat.domain.Ingredients;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icaboalo on 10/20/2015.
 */
public class IngredientsRecyclerAdapter extends RecyclerView.Adapter<IngredientsRecyclerAdapter.MyIngredientsViewHolder> {

    List<Ingredients> mIngredientsList = new ArrayList<>();
    Context mContext;
    LayoutInflater mInflater;

    public IngredientsRecyclerAdapter(Context context, List<Ingredients> ingredientsList) {
        mContext = context;
        mIngredientsList = ingredientsList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyIngredientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_row_ingredients_list, parent, false);
        MyIngredientsViewHolder viewHolder = new MyIngredientsViewHolder(view, R.id.ingredient_quantity, R.id.ingredient_name);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyIngredientsViewHolder holder, int position) {
        Ingredients ingredients = mIngredientsList.get(position);
        holder.setIngredientName(ingredients.getIngredientName());
        holder.setIngredientQuantity(ingredients.getQuantity());
    }

    @Override
    public int getItemCount() {
        return mIngredientsList.size();
    }

    public void setData(List<Ingredients> newList){
        mIngredientsList = newList;
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
