package com.example.ideapad510.celebbodypro.chrisFragment;

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
 * {@link ShouldersChris.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShouldersChris#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShouldersChris extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<Workout> workoutList;
    private RecyclerView recyclerView;
    private WorkoutAdapter mAdapter;

    private Context c1;

    public ShouldersChris() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShouldersChris.
     */
    // TODO: Rename and change types and number of parameters
    public static ShouldersChris newInstance(String param1, String param2) {
        ShouldersChris fragment = new ShouldersChris();
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
        View view= inflater.inflate(R.layout.recycler, container, false);


        c1=getActivity().getApplicationContext();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler1);

        workoutList=new ArrayList<>();

        mAdapter = new WorkoutAdapter(c1,workoutList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        preparewoirkoutdata();


        return view;
    }

    private void preparewoirkoutdata() {



        Workout workout1=new Workout(getString(R.string.standingmilitarypress),R.drawable.standingmilitarypress1,R.drawable.standingmilitarypress2);
        workout1.setSets("7 ست ،10-8-6-5-4-3-3 تکرار");
        workoutList.add(workout1);


        Workout workout2=new Workout(getString(R.string.arnoldpress),R.drawable.arnold2,R.drawable.arnold1);
        workout2.setSets("4 ست ،12 تکرار");

        workoutList.add(workout2);

        Workout workout3=new Workout(getString(R.string.barbellshrug),R.drawable.barbellshrug1,R.drawable.barbellshrug2);
        workout3.setSets("4 ست ،20 تکرار");
        workoutList.add(workout3);

        Workout workout4=new Workout(getString(R.string.lateralraise),R.drawable.lateral1,R.drawable.lateral2);
        workout4.setSets("3 ست ،15 تکرار");

        workoutList.add(workout4);


        Workout workout5=new Workout(getString(R.string.frontraise),R.drawable.frontraise1,R.drawable.frontraise2);
        workout5.setSuperset(true);
        workout5.setSets("3 ست ،15 تکرار");
        workoutList.add(workout5);

        Workout workout6=new Workout(getString(R.string.dumbbellreardeltflye),R.drawable.seatedbentoverreardeltraise1,R.drawable.seatedbentover2);
        workout6.setSuperset(true);
        workout6.setSets("3 ست ،15 تکرار");

        workoutList.add(workout6);


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
