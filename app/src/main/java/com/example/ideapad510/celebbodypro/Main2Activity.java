package com.example.ideapad510.celebbodypro;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class Main2Activity extends AppCompatActivity {

    int p1,p2;

    private int animationCounter = 1;
    private Handler imageSwitcherHandler;
    ImageSwitcher img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle=getIntent().getExtras();
         p1=bundle.getInt("p5",0);
        Log.e( "onCreate: ",p1+"" );
         p2=bundle.getInt("p2",0);

        Log.e( "aaaaaa",p2+"" );
         img1=(ImageSwitcher) findViewById(R.id.image1);


        Animation in  = AnimationUtils.loadAnimation(this, R.anim.left_to_right_in);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.left_to_right_out);

        img1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;

            }
        });


        img1.setInAnimation(in);
        img1.setOutAnimation(out);






        imageSwitcherHandler = new Handler(Looper.getMainLooper());
        imageSwitcherHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++) {
                    case 1:
                        img1.setImageResource(p1);
                        break;
                    case 2:
                        img1.setImageResource(p2);
                        break;

                }
                animationCounter %= 3;
                if(animationCounter == 0 ) animationCounter = 1;

                imageSwitcherHandler.postDelayed(this, 1000);
            }
        });







    }
    public static void ImageViewAnimatedChange(Context c, final ImageView v, final Bitmap new_image) {
        final Animation anim_out = AnimationUtils.loadAnimation(c, android.R.anim.fade_out);
        final Animation anim_in  = AnimationUtils.loadAnimation(c, android.R.anim.fade_in);
        anim_out.setAnimationListener(new Animation.AnimationListener()
        {
            @Override public void onAnimationStart(Animation animation) {}
            @Override public void onAnimationRepeat(Animation animation) {}
            @Override public void onAnimationEnd(Animation animation)
            {
                v.setImageBitmap(new_image);
                anim_in.setAnimationListener(new Animation.AnimationListener() {
                    @Override public void onAnimationStart(Animation animation) {}
                    @Override public void onAnimationRepeat(Animation animation) {}
                    @Override public void onAnimationEnd(Animation animation) {}
                });
                v.startAnimation(anim_in);
            }
        });
        v.startAnimation(anim_out);
    }

}
