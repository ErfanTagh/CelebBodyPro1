package com.example.ideapad510.celebbodypro;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ideapad510.celebbodypro.HughJackman.HughFifth;
import com.example.ideapad510.celebbodypro.HughJackman.HughFourth;
import com.example.ideapad510.celebbodypro.HughJackman.HughOne;
import com.example.ideapad510.celebbodypro.HughJackman.HughThird;
import com.example.ideapad510.celebbodypro.HughJackman.HughTwo;
import com.example.ideapad510.celebbodypro.ZacFragment.ZacSecond;
import com.example.ideapad510.celebbodypro.ZacFragment.ZacThird;
import com.example.ideapad510.celebbodypro.ZacFragment.ZachFirst;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

public class zacActivity extends AppCompatActivity {


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

        t2.setText("");

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


                } else if (position == 1) {
                    Log.e("pageSelected111: ", position + "");
                    t1.setText("روز دوم");


                } else if (position == 2) {
                    Log.e("pageSelected222: ", position + "");
                    t1.setText("روز سوم");

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
                    return ZachFirst.newInstance("ThirdFragment", "Default");

                case 1:

                    Log.e("getItem: ", "In two");
                    return ZacSecond.newInstance("ThirdFragment", "Default");


                case 2:

                    Log.e("getItem: ", "In three");
                    return ZacThird.newInstance("ThirdFragment", "Default");


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
