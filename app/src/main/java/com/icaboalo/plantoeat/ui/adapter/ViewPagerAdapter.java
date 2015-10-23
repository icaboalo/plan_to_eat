package com.icaboalo.plantoeat.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.icaboalo.plantoeat.domain.ModelFramentPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icaboalo on 10/17/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<ModelFramentPager> mPagerList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, List<ModelFramentPager> pagerList) {
        super(fm);
        mPagerList = pagerList;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return mPagerList.get(position).getPager();
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return mPagerList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerList.get(position).getTitle();
    }
}
