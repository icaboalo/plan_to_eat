package com.icaboalo.plantoeat.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.icaboalo.plantoeat.R;

/**
 * Created by icaboalo on 10/23/2015.
 */
public class AddIngredientsDialog extends DialogFragment {

    public static AddIngredientsDialog newInstance(String title) {
        AddIngredientsDialog fragment = new AddIngredientsDialog();
        Bundle args = new Bundle();
        args.putString("Add Place", title);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Add Ingredient");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_ingredient, null);
        alertDialog.setView(view);
        return alertDialog.create();
    }
}
