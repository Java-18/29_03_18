package com.sheygam.java_18_29_03_18;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by gregorysheygam on 29/03/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int count = 10;
    public void setCount(int count){
        this.count = count;
        notifyDataSetChanged();
    }
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return count;
    }
}
