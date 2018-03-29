package com.sheygam.java_18_29_03_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root,EmptyFragment.newInstance(1))
                .commit();
    }
}
