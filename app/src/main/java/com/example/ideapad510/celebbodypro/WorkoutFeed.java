package com.example.ideapad510.celebbodypro;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class WorkoutFeed {


    private List<Workout> workoutFeed;
    private int _itemcount = 0;



    public WorkoutFeed() {
        workoutFeed = new Vector<Workout>(0);
    }

    public void addWorkoout(Workout workout){

        workoutFeed.add(workout);
    }



    public void removeItem(int position) {
        workoutFeed.remove(position);
        _itemcount--;
    }

    public Workout getItem(int location) {
        return workoutFeed.get(location);
    }

    public int getItemCount() {
        return _itemcount;
    }





}
