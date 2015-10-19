package com.icaboalo.plantoeat.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.icaboalo.plantoeat.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddRecipeActivity extends AppCompatActivity {

    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Bind(R.id.numberPicker)
    NumberPicker mNumberPicker;

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

}
