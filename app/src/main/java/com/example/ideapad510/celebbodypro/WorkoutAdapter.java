package com.example.ideapad510.celebbodypro;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.MyViewHolder> {

    private List<Workout> workoutList;
    private WorkoutFeed workoutFeed;
    SharedPreference sharedPreference;


    Context context;

    public WorkoutAdapter(Context context,List<Workout> workoutList1) {
            this.workoutList = workoutList1;
        this.context=context;
        sharedPreference=new SharedPreference();


    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_lay, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Workout workout=workoutList.get(position);
        holder.title.setText(workout.getName());
        if (workout.getSets()!=null) {
            holder.title2.setText(workout.getSets());
        }

        if (workout.isSuperset()){

            holder.title3.setVisibility(View.VISIBLE);
        }



        if (checkFavoriteItem(workout)) {

            holder.imageViewFav.setTag("red");
        } else {
            holder.imageViewFav.setTag("grey");
        }

        Log.e("onBindViewHolder: eeeee",workout.getName());
        //holder.imageView1.setImageResource(workout.getFirstImg());
        Glide.with(context).load(workout.getFirstImg()).into(holder.imageView1);




        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SendImage sendImage=new SendImage(context,workout.getFirstImg(),workout.getSecondImg());
                sendImage.sendToClass();

            }
        });


        holder.imageViewFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tag = holder.imageViewFav.getTag().toString();
                if (tag.equalsIgnoreCase("grey")) {
                    sharedPreference.addFavorite(context, workout);
                    Toast.makeText(context,
                            "به لیست اضافه شد",
                            Toast.LENGTH_SHORT).show();

                    holder.imageViewFav.setTag("red");

                } else {
                    sharedPreference.removeFavorite(context, workout);
                    holder.imageViewFav.setTag("grey");
                    Toast.makeText(context,
                            "از لیست حذف شد",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }





    @Override
    public int getItemCount() {
        return workoutList.size();
    }


    public boolean checkFavoriteItem(Workout checkProduct) {
        boolean check = false;
        List<Workout> favorites = sharedPreference.getFavorites(context);
        if (favorites != null) {
            for (Workout product : favorites) {
                if (product.equals(checkProduct)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView title2;
        public ImageView imageView1;
        private TextView title3;
        private LinearLayout linearLayout;

        private ImageView imageViewFav;

        public Context appContext;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.texttitle);
            title2 = (TextView) view.findViewById(R.id.texttitle1);
            imageView1=(ImageView) view.findViewById(R.id.image1);
            title3=(TextView) view.findViewById(R.id.texttitle2);
            linearLayout=(LinearLayout) view.findViewById(R.id.lin1);

            imageViewFav=(ImageView) view.findViewById(R.id.id1);





            appContext=(Context) view.getContext();

        }
    }

}
