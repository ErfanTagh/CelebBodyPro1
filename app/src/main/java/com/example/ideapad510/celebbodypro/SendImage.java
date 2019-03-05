package com.example.ideapad510.celebbodypro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SendImage {


    int image1,image2;

    Context c1;

    public SendImage(Context context,int image1,int image2) {


        c1=context;
        this.image1=image1;
        this.image2=image2;






    }

    public void sendToClass(){

        Intent intent=new Intent(c1,Main2Activity.class);
        Bundle bundle=new Bundle();


        bundle.putInt("p5",image1);
        bundle.putInt("p2",image2);

        intent.putExtras(bundle);
        c1.startActivity(intent);


    }


}
