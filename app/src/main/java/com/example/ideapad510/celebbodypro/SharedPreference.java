package com.example.ideapad510.celebbodypro;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.gson.Gson;

public class SharedPreference {

    public static final String PREFS_NAME = "prefs";
    public static final String FAVORITES = "Product_Favorite";

    private Context context;


    public SharedPreference() {
        super();


    }

    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, List<Workout> favorites) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences("prefs",
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.apply();
    }

    public void addFavorite(Context context, Workout product) {
        List<Workout> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<>();
        favorites.add(product);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Workout product) {
        ArrayList<Workout> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(product);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<Workout> getFavorites(Context context) {
        SharedPreferences settings;
        List<Workout> favorites;

        settings = context.getSharedPreferences("prefs",
                Context.MODE_PRIVATE);



        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Workout[] favoriteItems = gson.fromJson(jsonFavorites,
                    Workout[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Workout>(favorites);
        } else
            return null;

        return (ArrayList<Workout>) favorites;
    }
}