package com.sheygam.java_18_29_03_18;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gregorysheygam on 29/03/2018.
 */

public class PagerFragment extends Fragment{
    private ViewPager myPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.activity_main,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myPager = view.findViewById(R.id.my_pager);
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager());
        myPager.setAdapter(adapter);
    }
}
