package com.icaboalo.plantoeat.ui.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.icaboalo.plantoeat.R;
import com.icaboalo.plantoeat.util.VUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/23/2015.
 */
public class AddIngredientDialog extends DialogFragment {

    @Bind(R.id.ingredient_name_input)
    EditText mIngredientName;

    @Bind(R.id.ingredient_quantity_picker)
    NumberPicker mIngredientQuantityPicker;

    @Bind(R.id.ingredient_uom_spinner)
    Spinner mIngredientUomSpinner;

    Communicator mCommunicator;

    public static AddIngredientDialog newInstance(String title) {
        AddIngredientDialog fragment = new AddIngredientDialog();
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
        ButterKnife.bind(this, view);
        alertDialog.setView(view);
        setupNumberPicker();
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String ingredientName = VUtil.extractText(mIngredientName);
                String[] ingredientUomArray = getResources().getStringArray(R.array.uom);
                int ingredientUomArrayPosition = mIngredientUomSpinner.getSelectedItemPosition();
                String ingredientUom = ingredientUomArray[ingredientUomArrayPosition];
                String ingredientQuantity = mIngredientQuantityPicker.getValue() + ingredientUom;
                Toast.makeText(getActivity(), ingredientQuantity + " " +ingredientName, Toast.LENGTH_SHORT).show();
                mCommunicator.respondIngredient(ingredientName, ingredientQuantity);
                dialog.dismiss();
            }
        });
        alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return alertDialog.create();
    }

    public void setupNumberPicker(){
        mIngredientQuantityPicker.setMaxValue(10);
        mIngredientQuantityPicker.setWrapSelectorWheel(false);
    }

    public void setCommunicator(Communicator communicator) {
        mCommunicator = communicator;
    }
}
