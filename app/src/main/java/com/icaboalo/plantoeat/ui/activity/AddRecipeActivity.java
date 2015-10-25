package com.icaboalo.plantoeat.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.icaboalo.plantoeat.R;
import com.icaboalo.plantoeat.domain.ModelFramentPager;
import com.icaboalo.plantoeat.ui.adapter.IngredientsRecyclerAdapter;
import com.icaboalo.plantoeat.ui.adapter.StepsRecyclerAdapter;
import com.icaboalo.plantoeat.ui.adapter.ViewPagerAdapter;
import com.icaboalo.plantoeat.ui.fragment.AddIngredientFragment;
import com.icaboalo.plantoeat.ui.fragment.AddIngredientsDialog;
import com.icaboalo.plantoeat.ui.fragment.AddRecipeFragment;
import com.icaboalo.plantoeat.ui.fragment.AddStepsFragment;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddRecipeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG_ADD_INGREDIENT = "addIngredient";
    public static final String TAG_ADD_STEP = "addStep";

    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    FloatingActionMenu mFloatingActionMenu;

    IngredientsRecyclerAdapter mIngredientsAdapter;

    StepsRecyclerAdapter mStepsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupFloatingActionButton();
        setupViewPager();
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

    public void setupViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), createPager());
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    List<ModelFramentPager> createPager() {
        List<ModelFramentPager> pagerList = new ArrayList<>();
        pagerList.add(new ModelFramentPager(new AddRecipeFragment(), "Recipe"));
        pagerList.add(new ModelFramentPager(new AddIngredientFragment(), "Ingredients"));
        pagerList.add(new ModelFramentPager(new AddStepsFragment(), "Steps"));
        return pagerList;
    }

    @Override
    public void onClick(View v) {

//        FloatingActionMenu items
        switch (v.getTag().toString()) {
            case TAG_ADD_INGREDIENT:
                Toast.makeText(AddRecipeActivity.this, TAG_ADD_INGREDIENT, Toast.LENGTH_SHORT).show();
                showDialog();
                mFloatingActionMenu.close(true);
                break;
            case TAG_ADD_STEP:
                Toast.makeText(AddRecipeActivity.this, TAG_ADD_STEP, Toast.LENGTH_SHORT).show();
                mFloatingActionMenu.close(true);
                break;
        }
    }

    private void showDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddIngredientsDialog placeDialogFragment = new AddIngredientsDialog().newInstance("Add Place");
        placeDialogFragment.show(fragmentManager, "add_ingredient");
    }
}
