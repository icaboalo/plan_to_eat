package com.icaboalo.plantoeat.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.EditText;

import com.icaboalo.historystoreapp.R;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class VUtil {

    public static String extractText(EditText editText){
        return editText.getText().toString();
    }

    public static void replaceFragment(Fragment fragment, FragmentManager fragmentManager) {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}
