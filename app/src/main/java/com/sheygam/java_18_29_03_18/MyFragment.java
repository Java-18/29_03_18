package com.sheygam.java_18_29_03_18;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by gregorysheygam on 29/03/2018.
 */

public class MyFragment extends Fragment {
    private int color;
    private int number;


    public static MyFragment newInstance(int number){
        Log.d("MY_TAG", "newInstance: ");
        MyFragment fragment = new MyFragment();
        Random rnd = new Random();
        fragment.color = Color.rgb(rnd.nextInt(256),
                rnd.nextInt(256),
                rnd.nextInt(256));
        fragment.number = number;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment,container,false);
        FrameLayout root = view.findViewById(R.id.fragment_wrapper);
        TextView title = view.findViewById(R.id.title_txt);
        root.setBackgroundColor(color);
        title.setText("Fragment " + number);
        return view;
    }
}
