package com.example.ideapad510.celebbodypro;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ideapad510.celebbodypro.bradfragmentfolder.bradFifth;
import com.example.ideapad510.celebbodypro.bradfragmentfolder.bradFirst;
import com.example.ideapad510.celebbodypro.bradfragmentfolder.bradFourth;
import com.example.ideapad510.celebbodypro.bradfragmentfolder.bradSecond;
import com.example.ideapad510.celebbodypro.bradfragmentfolder.bradThird;
import com.example.ideapad510.celebbodypro.slyfragmnet.slyFirst;
import com.example.ideapad510.celebbodypro.slyfragmnet.slySecond;
import com.example.ideapad510.celebbodypro.slyfragmnet.slyThird;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

public class SlyActivity extends FragmentActivity {


    public TextView t1, t2;
    ViewPager pager;
    PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brad);

        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);

        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/bnazbold.TTF");
        t1.setTypeface(type);
        t2.setTypeface(type);

        t2.setText("جلو بازو");

        pager = (ViewPager) findViewById(R.id.pager);
        pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setAnimationType(AnimationType.WORM);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), getApplicationContext()));

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("pageAdapter: ", "Scrolled");
            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    Log.e("pageSelected0000: ", position + "");
                    t1.setText("روز اول");
                    t2.setText("جلو بازو");

                } else if (position == 1) {
                    Log.e("pageSelected111: ", position + "");

                    t1.setText("روز دوم");
                    t2.setText("ساعد");


                } else if (position == 2) {
                    Log.e("pageSelected222: ", position + "");
                    t1.setText("روز سوم");
                    t2.setText("پشت بازو");

                }

            }


            @Override
            public void onPageScrollStateChanged(int state) {

                Log.e("pageAdapter: ", "ScrolledChanged");

            }
        });


    }


    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        Context cx;

        public MyPagerAdapter(FragmentManager fm, Context cx) {


            super(fm);
            this.cx = cx;


        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {


                case 0:
                    return slyFirst.newInstance("ThirdFragment", "Default");


                case 1:

                    Log.e("getItem: ", "In two");

                    return slySecond.newInstance("ThirdFragment", "Default");


                case 2:

                    Log.e("getItem: ", "In three");


                    return slyThird.newInstance("ThirdFragment", "Default");


                default:
                    return null;


            }
        }

        @Override
        public int getCount() {


            return 3;


        }
    }


}
