package com.sheygam.java_18_29_03_18;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager myPager;
    private PagerAdapter adapter;
    private Button prevBtn, nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPager = findViewById(R.id.my_pager);
        prevBtn = findViewById(R.id.prev_btn);
        nextBtn = findViewById(R.id.next_btn);
        adapter = new PagerAdapter(getSupportFragmentManager());
        myPager.setAdapter(adapter);
        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        myPager.addOnPageChangeListener(listener);
        myPager.setOffscreenPageLimit(4);
    }

    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            Log.d("TAG1", "onPageScrolled() called with: position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
        }

        @Override
        public void onPageSelected(int position) {
            Log.d("MY_TAG", "onPageSelected() called with: position = [" + position + "]");
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case ViewPager.SCROLL_STATE_DRAGGING:
                    Log.d("MY_TAG", "onPageScrollStateChanged: DRAGGING");
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    Log.d("MY_TAG", "onPageScrollStateChanged: SETTLING");
                    break;
                case ViewPager.SCROLL_STATE_IDLE:
                    Log.d("MY_TAG", "onPageScrollStateChanged: IDLE");
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.prev_btn) {
//            int current = myPager.getCurrentItem();
//            if(current > 0) {
//                myPager.setCurrentItem(current-1);
//            }
            myPager.setCurrentItem(0, false);
        } else if (v.getId() == R.id.next_btn) {
            int current = myPager.getCurrentItem();
            if(current == adapter.getCount() - 2){
                adapter.setCount(adapter.getCount()*2);
            }
            if (current < adapter.getCount() - 1) {
                myPager.setCurrentItem(current + 1);
            }
        }
    }
}
