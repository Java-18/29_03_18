package com.sheygam.java_18_29_03_18;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gregorysheygam on 29/03/2018.
 */

public class EmptyFragment extends Fragment implements View.OnClickListener {
    private int count;
    private Button nextBtn;
    private TextView countTxt;
    public static EmptyFragment newInstance(int count){
        EmptyFragment emptyFragment = new EmptyFragment();
        emptyFragment.count = count;
        return emptyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.empty_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nextBtn = view.findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(this);
        countTxt = view.findViewById(R.id.count_txt);
        countTxt.setText(String.valueOf(count));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next_btn){
            if(count != 3){
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.root,  EmptyFragment.newInstance(count+1))
                        .addToBackStack(null)
                        .commit();

            }else{
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.root,new PagerFragment())
                        .addToBackStack(null)
                        .commit();

            }
        }
    }
}
