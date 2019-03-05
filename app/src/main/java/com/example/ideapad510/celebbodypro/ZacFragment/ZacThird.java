package com.example.ideapad510.celebbodypro.ZacFragment;

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
 * {@link ZacThird.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ZacThird#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ZacThird extends Fragment {
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

    public ZacThird() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HughOne.
     */
    // TODO: Rename and change types and number of parameters
    public static ZacThird newInstance(String param1, String param2) {
        ZacThird fragment = new ZacThird();
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


        Workout workout0=new Workout(getString(R.string.dumbbellsquatfrontraise),R.drawable.frontraise1,R.drawable.frontraise2);
        workout0.setSets("3 ست، 8 تا 12 تکرار");
        workoutList.add(workout0);
        Workout workout1=new Workout(getString(R.string.crossbodycableraise),R.drawable.deltoraise1,R.drawable.deltoraise2);
        workout1.setSets("3 ست، 8 تا 12 تکرار");
        workout1.setSuperset(true);
        workoutList.add(workout1);
        Workout workout2=new Workout(getString(R.string.dumbbellfloorpress),R.drawable.dumbellchestpress1,R.drawable.dumbellchestpress2);
        workout2.setSets("3 ست، 8 تا 12 تکرار");
        workoutList.add(workout2);
        Workout workout3=new Workout(getString(R.string.pushup),R.drawable.pushup11,R.drawable.pushup111);
        workout3.setSets("3 ست، 8 تا 12 تکرار");
        workout3.setSuperset(true);
        workoutList.add(workout3);
        Workout workout4=new Workout(getString(R.string.InclineDumbbellPress),R.drawable.inclinebechpress1,R.drawable.inclinebechpress2);
        workout4.setSets("3 ست، 8 تا 12 تکرار");
        workoutList.add(workout4);
        Workout workout5=new Workout(getString(R.string.dumbbelloverheadpress),R.drawable.standingshoulderpress1,R.drawable.standingshoulderpress2);
        workout5.setSets("3 ست، 8 تا 12 تکرار");
        workout5.setSuperset(true);
        workoutList.add(workout5);
        Workout workout6=new Workout(getString(R.string.chestcableflye),R.drawable.cablecrossover1,R.drawable.cablecrossover2);
        workout6.setSets("3 ست، 8 تا 12 تکرار");
        workoutList.add(workout6);
        Workout workout7=new Workout(getString(R.string.bosuplyopushup),R.drawable.plyo1,R.drawable.plyo2);
        workout7.setSets("3 ست، 8 تا 12 تکرار");
        workout7.setSuperset(true);
        workoutList.add(workout7);
        Workout workout8=new Workout(getString(R.string.singlearmpushdown),R.drawable.onearmpushdown11,R.drawable.onearmpushdown1);
        workout8.setSets("3 ست، 8 تا 12 تکرار هر دست");
        workoutList.add(workout8);
        Workout workout9=new Workout(getString(R.string.singlearmcurl),R.drawable.pcurl1,R.drawable.pcurl2);
        workout9.setSets("3 ست، 8 تا 12 تکرار هر دست");
        workout9.setSuperset(true);
        workoutList.add(workout9);

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
