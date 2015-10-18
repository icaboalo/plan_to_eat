package com.icaboalo.plantoeat.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icaboalo.plantoeat.R;
import com.icaboalo.plantoeat.domain.Recipes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icaboalo on 10/17/2015.
 */
public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecipeRecyclerAdapter.MyRecipeViewHolder> {

    List<Recipes> mRecipesList = new ArrayList<>();
    Context mContext;
    LayoutInflater mInflater;
    MyRecipeViewHolder.MyViewHolderClick mClickListener;

    public RecipeRecyclerAdapter(List<Recipes> recipesList, Context context, MyRecipeViewHolder.MyViewHolderClick clickListener) {
        mRecipesList = recipesList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mClickListener = clickListener;
    }

    @Override
    public MyRecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_row_recipes_list, parent, false);
        MyRecipeViewHolder viewHolder = new MyRecipeViewHolder(view, R.id.recipe_name, R.id.recipe_servings,
                R.id.recipe_image, mClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecipeViewHolder holder, int position) {
        Recipes recipes = mRecipesList.get(position);
        holder.setRecipeName(recipes.getRecipeName());
        holder.setRecipeServings(recipes.getRecipeServing());
    }

    @Override
    public int getItemCount() {
        return mRecipesList.size();
    }

    public void setData(List<Recipes> newList){
        mRecipesList = newList;
    }

    public static class MyRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mRecipeName, mRecipeServings;
        ImageView mRecipeImage;
        MyViewHolderClick mMyViewHolderClick;

        public MyRecipeViewHolder(View itemView, int recipeNameId, int recipeServingsId, int recipeImageId,
                                  MyViewHolderClick clickListener) {
            super(itemView);
            mRecipeName = (TextView) itemView.findViewById(recipeNameId);
            mRecipeServings = (TextView) itemView.findViewById(recipeServingsId);
            mRecipeImage = (ImageView) itemView.findViewById(recipeImageId);
            mMyViewHolderClick = clickListener;
        }

        public void setRecipeName(String recipeName) {
            mRecipeName.setText(recipeName);
        }

        public void setRecipeServings(String recipeServings) {
            mRecipeServings.setText(recipeServings);
        }

        public void setRecipeImage(ImageView recipeImage) {
            mRecipeImage = recipeImage;
        }

        @Override
        public void onClick(View v) {
            mMyViewHolderClick.onMyClick(v, getAdapterPosition());
        }

        public interface MyViewHolderClick{
            void onMyClick(View item, int position);
        }
    }
}
