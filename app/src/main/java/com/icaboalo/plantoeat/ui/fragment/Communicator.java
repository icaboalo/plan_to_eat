package com.icaboalo.plantoeat.ui.fragment;

/**
 * Created by icaboalo on 10/25/2015.
 */
public interface Communicator {
    void respondStep(String description);
    void respondIngredient(String ingredientName, String ingredientQuantity);
}
