package com.example.ideapad510.celebbodypro.bradfragmentfolder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * {@link bradSecond.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link bradSecond#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bradSecond extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private List<Workout> workoutList;
    private RecyclerView recyclerView;
    private WorkoutAdapter mAdapter;

    private Context c1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public bradSecond() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bradSecond.
     */
    // TODO: Rename and change types and number of parameters
    public static bradSecond newInstance(String param1, String param2) {
        bradSecond fragment = new bradSecond();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("Destroy", "Destroyed222222");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("seconddd", "onCreate: " );
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
//color:#8A2BE2
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.recycler, container, false);

        c1=getActivity().getApplicationContext();

        Log.e( "onCreateView: ","bradActivity22" );



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


        Workout workout=new Workout(getString(R.string.pushup),R.drawable.pushup11,R.drawable.pushup111);
        workout.setSets("3-5 ست ، 8-15 تکرار");
        workoutList.add(workout);

        Workout workout1=new Workout(getString(R.string.ghayeghi),R.drawable.cable2,R.drawable.cable1);
        workout1.setSets("3-5 ست ، 8-15 تکرار");
        workoutList.add(workout1);


        Workout workout2=new Workout(getString(R.string.cablepullwide),R.drawable.widegrip1,R.drawable.widegrip2);
        workout2.setSets("3-5 ست ، 8-15 تکرار");
        workoutList.add(workout2);

        Workout workout3=new Workout(getString(R.string.tbar),R.drawable.tb1,R.drawable.tbar2);
        workout3.setSets("3-5 ست ، 8-15 تکرار");
        workoutList.add(workout3);

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
        Log.e("Bsec", "onAttach: " );

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("Bsec", "onDetatch: " );
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
