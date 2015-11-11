package com.icaboalo.plantoeat.database.constant;

/**
 * Created by icaboalo on 11/11/2015.
 */
public class RecipeDataBaseConstants {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "recipes.db";

    public static final String TABLE_RECIPES = "recipes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_RECIPE_NAME = "recipe_name";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_SERVINGS = "servings";
    public static final String COLUMN_INGREDIENTS = "ingredients";
    public static final String COLUMN_STEPS = "steps";

    public static final String CREATE_TABLE_RECIPES =
            "CREATE TABLE " + TABLE_RECIPES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_RECIPE_NAME + " TEXT, " +
                    COLUMN_CATEGORY + " TEXT, " +
                    COLUMN_SERVINGS + " TEXT, " +
                    COLUMN_INGREDIENTS + "TEXT, " +
                    COLUMN_STEPS + "TEXT);";
}
