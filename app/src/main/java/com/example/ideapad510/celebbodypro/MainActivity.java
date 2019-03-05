package com.example.ideapad510.celebbodypro;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    LinearLayout bradLay,chrisLay ;
    LinearLayout rockLay, slyLay,hughLay , zacEfron ;
    TextView bradText,chrisText;
    TextView rockText, slyText , zacText;


    WorkoutFeed _feed=new WorkoutFeed();

    ImageView img1,img2,img3,img4,img5,img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bradLay = (LinearLayout) findViewById(R.id.bradlay);
        rockLay = (LinearLayout) findViewById(R.id.rocklay);
        slyLay = (LinearLayout) findViewById(R.id.slylay);
        chrisLay= (LinearLayout) findViewById(R.id.chrislay);
        hughLay= (LinearLayout) findViewById(R.id.hughlay);
        zacEfron=(LinearLayout) findViewById(R.id.zaclay);

        img1=(ImageView) findViewById(R.id.bradImg);
        Glide.with(getApplicationContext()).load(R.drawable.bradbody).apply(new RequestOptions().centerCrop()).into(img1);
        img2=(ImageView) findViewById(R.id.ZacImg);
        Glide.with(getApplicationContext()).load(R.drawable.zack2wall).apply(new RequestOptions().centerCrop()).into(img2);
        img3=(ImageView) findViewById(R.id.RockImg);
        Glide.with(getApplicationContext()).load(R.drawable.rockwallpaper).apply(new RequestOptions().centerCrop()).into(img3);
        img4=(ImageView) findViewById(R.id.SlyImg);
        Glide.with(getApplicationContext()).load(R.drawable.sly).apply(new RequestOptions().centerCrop()).into(img4);
        img5=(ImageView) findViewById(R.id.ChrisImg);
        Glide.with(getApplicationContext()).load(R.drawable.cwall6).apply(new RequestOptions().centerCrop()).into(img5);
        img6=(ImageView) findViewById(R.id.HughImg);
        Glide.with(getApplicationContext()).load(R.drawable.hughwall).apply(new RequestOptions().centerCrop()).into(img6);


        zacText=(TextView) findViewById(R.id.zactext);
        bradText = (TextView) findViewById(R.id.bradtext);
        rockText = (TextView) findViewById(R.id.rocktext);
        slyText = (TextView) findViewById(R.id.slytext);
        chrisText = (TextView) findViewById(R.id.christext);


        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/bnazbold.TTF");

        bradText.setTypeface(type);
        rockText.setTypeface(type);
        slyText.setTypeface(type);
        zacText.setTypeface(type);

        zacEfron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, zacActivity.class);
                startActivity(intent);
            }
        });



        bradLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, BradActivity.class);
                startActivity(intent);
                // startActivity(new Intent(MainActivity.this,BradActivity.class));
            }
        });

        rockLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   Intent intent = new Intent(MainActivity.this, RockActivity.class);
               // startActivity(intent);

          //      DialogFragment newFragment = PaymentDialog.newInstance(
               //         5);
             //   newFragment.show(getSupportFragmentManager(), "dialog");



                Intent intent = new Intent(MainActivity.this, FavActivity.class);
                startActivity(intent);







            }
        });


        slyLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SlyActivity.class);
                startActivity(intent);

            }
        });

        chrisLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChrisActivity.class);
                startActivity(intent);
            }
        });


        hughLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HughActivity.class);
                startActivity(intent);
            }
        });



    }
}
