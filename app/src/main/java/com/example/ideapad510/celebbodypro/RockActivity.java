package com.example.ideapad510.celebbodypro;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ideapad510.celebbodypro.RockFragment.ArmsRock;
import com.example.ideapad510.celebbodypro.RockFragment.ChestRock;
import com.example.ideapad510.celebbodypro.RockFragment.RockBack;
import com.example.ideapad510.celebbodypro.RockFragment.RockLegs;
import com.example.ideapad510.celebbodypro.RockFragment.ShouldersRock;
import com.example.ideapad510.celebbodypro.slyfragmnet.slyFirst;
import com.example.ideapad510.celebbodypro.slyfragmnet.slySecond;
import com.example.ideapad510.celebbodypro.slyfragmnet.slyThird;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

public class RockActivity extends FragmentActivity {


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
                    t2.setText("پا");


                } else if (position == 1) {
                    Log.e("pageSelected111: ", position + "");


                    t1.setText("روز دوم");
                    t2.setText("پشت و زیربغل");


                } else if (position == 2) {
                    Log.e("pageSelected222: ", position + "");
                    t1.setText("روز سوم");
                    t2.setText("سرشانه");


                } else if (position == 3) {
                    Log.e("pageSelected222: ", position + "");
                    t1.setText("روز چهارم");
                    t2.setText("دست ها و شکم");


                } else if (position == 4) {
                    Log.e("pageSelected222: ", position + "");
                    t1.setText("روز پنجم");
                    t2.setText("سینه");

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
                    return RockLegs.newInstance("ChrisLegs", "Default");

                case 1:

                    Log.e("getItem: ", "In two");
                    return RockBack.newInstance("ThirdFragment", "Default");


                case 2:

                    Log.e("getItem: ", "In three");
                    return ShouldersRock.newInstance("ThirdFragment", "Default");


                case 3:

                    Log.e("getItem: ", "In three");
                    return ArmsRock.newInstance("ThirdFragment", "Default");

                case 4:

                    Log.e("getItem: ", "In three");

                    return ChestRock.newInstance("ThirdFragment", "Default");


                default:
                    return null;


            }
        }

        @Override
        public int getCount() {

            return 5;


        }
    }


}
