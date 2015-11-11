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

import com.icaboalo.plantoeat.R;
import com.icaboalo.plantoeat.util.VUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/24/2015.
 */
public class AddStepDialog extends DialogFragment{

    @Bind(R.id.step_description_input)
    EditText mStepDescriptionInput;

    Communicator mCommunicator;

    public static AddStepDialog newInstance(String title) {
        AddStepDialog fragment = new AddStepDialog();
        Bundle args = new Bundle();
        args.putString("Add Place", title);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_step, null);
        alertDialog.setView(view);
        ButterKnife.bind(this, view);
        alertDialog.setTitle("Add Step");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mCommunicator.respondStep(VUtil.extractText(mStepDescriptionInput));
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

    public void setCommunicator(Communicator communicator) {
        mCommunicator = communicator;
    }
}
