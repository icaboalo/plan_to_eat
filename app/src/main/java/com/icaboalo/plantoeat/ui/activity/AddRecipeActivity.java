package com.icaboalo.plantoeat.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.icaboalo.plantoeat.R;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddRecipeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG_ADD_INGREDIENT = "addIngredient";
    public static final String TAG_ADD_STEP = "addStep";

    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Bind(R.id.numberPicker)
    NumberPicker mNumberPicker;

    FloatingActionMenu mFloatingActionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNumberPicker.setMaxValue(10);
        mNumberPicker.setMinValue(0);
        mNumberPicker.setWrapSelectorWheel(false);

        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int number = mNumberPicker.getValue();
                Toast.makeText(AddRecipeActivity.this, newVal + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupFloatingActionButton();
    }

    private void setupFloatingActionButton() {

//        action button
        ImageView icon = new ImageView(this);
        icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_white_24dp));
        FloatingActionButton mFloatingActionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();

//        sub actions
        SubActionButton.Builder subActionBuilder = new SubActionButton.Builder(this);
        ImageView addIngredientIcon = new ImageView(this);
        SubActionButton addIngredientButton = subActionBuilder
                .setContentView(addIngredientIcon)
                .build();

        ImageView addStepIcon = new ImageView(this);
        SubActionButton addStepButton = subActionBuilder
                .setContentView(addStepIcon)
                .build();

//        tags to determine onClick
        addIngredientButton.setTag(TAG_ADD_INGREDIENT);
        addStepButton.setTag(TAG_ADD_STEP);

        addIngredientButton.setOnClickListener(this);
        addStepButton.setOnClickListener(this);

//        floating menu
        mFloatingActionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(addIngredientButton)
                .addSubActionView(addStepButton)
                .attachTo(mFloatingActionButton)
                .build();
    }

    @Override
    public void onClick(View v) {

//        FloatingActionMenu items
        switch (v.getTag().toString()){
            case TAG_ADD_INGREDIENT:
                Toast.makeText(AddRecipeActivity.this, TAG_ADD_INGREDIENT, Toast.LENGTH_SHORT).show();
                mFloatingActionMenu.close(true);
                break;
            case TAG_ADD_STEP:
                Toast.makeText(AddRecipeActivity.this, TAG_ADD_STEP, Toast.LENGTH_SHORT).show();
                mFloatingActionMenu.close(true);
                break;
        }
    }
}
