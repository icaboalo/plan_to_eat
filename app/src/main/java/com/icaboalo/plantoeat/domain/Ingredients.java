package com.icaboalo.plantoeat.domain;

/**
 * Created by icaboalo on 10/21/2015.
 */
public class Ingredients {

    public Ingredients(String ingredientName, String quantity) {
        mIngredientName = ingredientName;
        mQuantity = quantity;
    }

    String mIngredientName;
    String mQuantity;

    public String getIngredientName() {
        return mIngredientName;
    }

    public String getQuantity() {
        return mQuantity;
    }

    public void setIngredientName(String ingredientName) {
        mIngredientName = ingredientName;
    }

    public void setQuantity(String quantity) {
        mQuantity = quantity;
    }
}
