package com.example.ideapad510.celebbodypro;

import android.content.Context;

public class Workout {

    private String name;
    private int firstImg,secondImg;


    private boolean isFave;

    public boolean isFave() {
        return isFave;
    }

    public void setFave(boolean fave) {
        isFave = fave;
    }

    private boolean isSuperset=false;

    public boolean isSuperset() {
        return isSuperset;
    }

    public void setSuperset(boolean superset) {
        isSuperset = superset;
    }

    private String sets;

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }


    public Workout(String name, int firstImg, int secondImg) {
        this.name = name;
        this.firstImg = firstImg;
        this.secondImg = secondImg;

    }

    public String getName() {
        return name;
    }


    public int getFirstImg() {
        return firstImg;
    }



    public int getSecondImg() {
        return secondImg;
    }








}
