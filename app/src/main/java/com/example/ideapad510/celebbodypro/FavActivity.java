package com.example.ideapad510.celebbodypro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class FavActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private WorkoutAdapter mAdapter;

    SharedPreference sharedPreference;

    private List<Workout> workoutList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sharedPreference=new SharedPreference();




        workoutList=sharedPreference.getFavorites(FavActivity.this);

        recyclerView=(RecyclerView) findViewById(R.id.rec1);
        mAdapter = new WorkoutAdapter(FavActivity.this,workoutList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(FavActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



    }
}
