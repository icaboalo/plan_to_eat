package com.icaboalo.plantoeat.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.icaboalo.plantoeat.database.constant.RecipeDataBaseConstants;

/**
 * Created by icaboalo on 11/11/2015.
 */
public class RecipesOpenHelper extends SQLiteOpenHelper{


    public RecipesOpenHelper(Context context) {
        super(context, RecipeDataBaseConstants.DATABASE_NAME, null, RecipeDataBaseConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(RecipeDataBaseConstants.CREATE_TABLE_RECIPES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + RecipeDataBaseConstants.TABLE_RECIPES);
        onCreate(db);
    }
}
