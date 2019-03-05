package com.example.ideapad510.celebbodypro;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class favouriteList extends Fragment {


    SharedPreference sharedPreference;
    List<Workout> favorites;


    Activity activity;;
    WorkoutAdapter workoutAdapter;

    private RecyclerView recyclerView;


    public favouriteList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container,
                false);
        // Get favorite items from SharedPreferences.
        sharedPreference = new SharedPreference();
        favorites = sharedPreference.getFavorites(activity);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler1);


        if (favorites == null) {
            showAlert(getResources().getString(R.string.no_favorites_items),
                    getResources().getString(R.string.no_favorites_msg));
        } else {

            if (favorites.size() == 0) {
                showAlert(
                        getResources().getString(R.string.no_favorites_items),
                        getResources().getString(R.string.no_favorites_msg));
            }








            if (favorites != null) {
                workoutAdapter = new WorkoutAdapter(activity, favorites);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(workoutAdapter);

            }
        }
        return view;
    }

    public void showAlert(String title, String message) {
        if (activity != null && !activity.isFinishing()) {
            AlertDialog alertDialog = new AlertDialog.Builder(activity)
                    .create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
            alertDialog.setCancelable(false);

            // setting OK Button
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            // activity.finish();
                            getFragmentManager().popBackStackImmediate();
                        }
                    });
            alertDialog.show();
        }
    }

}
