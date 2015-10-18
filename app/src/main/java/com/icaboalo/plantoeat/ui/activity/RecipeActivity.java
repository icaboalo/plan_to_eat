package com.icaboalo.plantoeat.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.icaboalo.plantoeat.R;
import com.icaboalo.plantoeat.domain.ModelFramentPager;
import com.icaboalo.plantoeat.ui.adapter.ViewPagerAdapter;
import com.icaboalo.plantoeat.ui.fragment.RecipeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecipeActivity extends AppCompatActivity {

    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Bind(R.id.container)
    ViewPager mPager;

    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;

    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mCreatePager());

        // Set up the ViewPager with the sections adapter.
        mPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mPager);
    }

    @OnClick(R.id.add_recipe_button)
    void addRecipe(){
        Intent goToAddActivity = new Intent(this, AddRecipeActivity.class);
        startActivity(goToAddActivity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    List<ModelFramentPager> mCreatePager(){
        List<ModelFramentPager> pagerList = new ArrayList<>();
        pagerList.add(new ModelFramentPager(new RecipeFragment(), "section 1"));
        return pagerList;
    }
}
