package com.example.ideapad510.celebbodypro.slyfragmnet;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ideapad510.celebbodypro.R;
import com.example.ideapad510.celebbodypro.Workout;
import com.example.ideapad510.celebbodypro.WorkoutAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link slyFirst.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link slyFirst#newInstance} factory method to
 * create an instance of this fragment.
 */
public class slyFirst extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Workout> workoutList;
    private RecyclerView recyclerView;
    private WorkoutAdapter mAdapter;

    private Context c1;


    private OnFragmentInteractionListener mListener;

    public slyFirst() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment slyFirst.
     */
    // TODO: Rename and change types and number of parameters
    public static slyFirst newInstance(String param1, String param2) {
        slyFirst fragment = new slyFirst();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.recycler, container, false);


        c1=getActivity();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler1);

        workoutList=new ArrayList<>();

        mAdapter = new WorkoutAdapter(c1,workoutList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(c1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        preparewoirkoutdata();


        return view;
    }

    private void preparewoirkoutdata() {


        Workout workout=new Workout(getString(R.string.underhandgriplatpulldown),R.drawable.underhandpulldown1,R.drawable.underhandpulldown2);
        workout.setSets("10 تا 15 تکرار");
        workoutList.add(workout);

        Workout workout1=new Workout(getString(R.string.barbellcurlclosegrip),R.drawable.barbelcurl1,R.drawable.barbellcurl2);
        workout1.setSets("تکرار تا حد ناتوانی");
        workout1.setSuperset(true);
        workoutList.add(workout1);

        Workout workout2=new Workout(getString(R.string.barbellcurlwidegrip),R.drawable.barbelcurl1,R.drawable.barbellcurl2);
        workout2.setSets("6 تا 8 تکرار");
        workout2.setSuperset(true);
        workoutList.add(workout2);

        Workout workout3=new Workout(getString(R.string.hammercurl),R.drawable.hammer1,R.drawable.hammer2);
        workout3.setSets("10 تا 12 تکرار هر دست");
        workout3.setSuperset(true);
        workoutList.add(workout3);

        Workout workout4=new Workout(getString(R.string.highcablecurl),R.drawable.highcablerow1,R.drawable.highcablerow2);
        workout4.setSets("10 تا 12 تکرار");
        workout4.setSuperset(true);
        workoutList.add(workout4);

        Workout workout5=new Workout(getString(R.string.reversebarbellcurl),R.drawable.reversebarbellcurl1,R.drawable.reversebarbellcurl2);
        workout5.setSets("10 تا 12 تکرار هر طرف");
        workout5.setSuperset(true);
        workoutList.add(workout5);


        mAdapter.notifyDataSetChanged();


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
