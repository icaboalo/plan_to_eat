package com.icaboalo.plantoeat.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.icaboalo.plantoeat.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/23/2015.
 */
public class AddRecipeFragment extends Fragment {

    @Bind(R.id.numberPicker)
    NumberPicker mNumberPicker;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_recipe, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setupNumberPicker();
    }

    private void setupNumberPicker() {
        mNumberPicker.setMaxValue(10);
        mNumberPicker.setMinValue(0);
        mNumberPicker.setWrapSelectorWheel(false);

        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int number = mNumberPicker.getValue();
                Toast.makeText(getActivity(), newVal + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
