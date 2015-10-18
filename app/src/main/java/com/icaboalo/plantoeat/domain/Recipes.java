package com.icaboalo.plantoeat.domain;

/**
 * Created by icaboalo on 10/17/2015.
 */
public class Recipes {

    public Recipes(String recipeName, String recipeServing) {
        this.recipeName = recipeName;
        this.recipeServing = recipeServing;
    }

    String recipeName;

    String recipeServing;

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeServing() {
        return recipeServing;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRecipeServing(String recipeServing) {
        this.recipeServing = recipeServing;
    }
}
