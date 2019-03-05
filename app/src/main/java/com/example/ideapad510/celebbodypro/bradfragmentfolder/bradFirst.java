package com.example.ideapad510.celebbodypro.bradfragmentfolder;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.RelativeLayout;

import com.example.ideapad510.celebbodypro.R;
import com.example.ideapad510.celebbodypro.Workout;
import com.example.ideapad510.celebbodypro.WorkoutAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link bradFirst.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link bradFirst#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bradFirst extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RelativeLayout rel;
    RelativeLayout rel2;

    private List<Workout> workoutList;
    private RecyclerView recyclerView;
    private WorkoutAdapter mAdapter;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private Context c1;
    private String mParam2;


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.e("Destroy", "Destroyed11111");
    }

    SharedPreferences.Editor prefsEditor;

    private OnFragmentInteractionListener mListener;

    public bradFirst() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bradFirst.
     */
    // TODO: Rename and change types and number of parameters
    public static bradFirst newInstance(String param1, String param2) {
        bradFirst fragment = new bradFirst();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("firsttt", "onCreate: " );
        if (getArguments() != null) {


            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //color:"#4B0082"

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.recycler, container, false);


         c1=getActivity();

        workoutList=new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler1);

        mAdapter = new WorkoutAdapter(c1,workoutList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(c1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        Log.e( "onCreateView: ","bradActivity111" );


        preparewoirkoutdata();
      //  rel=(RelativeLayout) view.findViewById(R.id.id1);
      //  rel2=(RelativeLayout) view.findViewById(R.id.id2);

      //  rel.setOnClickListener(new View.OnClickListener() {
      //      @Override
       //     public void onClick(View v) {

           //     Log.e("onClick: ", "eeeeee" );

              //  Intent intent=new Intent(getActivity(),Main2Activity.class);
               // Bundle bundle=new Bundle();


               // bundle.putInt("p5",R.drawable.pushup111);
               // bundle.putInt("p2",R.drawable.pushup11);

               // intent.putExtras(bundle);
               // startActivity(intent);


            //    SendImage sendImage=new SendImage(getActivity().getApplicationContext(),R.drawable.pushup111,R.drawable.pushup11);
//
           //     sendImage.sendToClass();


                /*You've to create a frame layout or any other layout with id inside your activity layout and then use that id in java*/



     //       }
      //  });

    //    rel2.setOnClickListener(new View.OnClickListener() {
     //       @Override
    //        public void onClick(View v) {

            //    Intent intent=new Intent(getActivity(),Main2Activity.class);
             //   Bundle bundle=new Bundle();


              //  bundle.putInt("p5",R.drawable.smith11);
               // bundle.putInt("p2",R.drawable.smith21);

               // intent.putExtras(bundle);
               // startActivity(intent);

           //     SendImage sendImage=new SendImage(getActivity().getApplicationContext(),R.drawable.smith11,R.drawable.smith21);

            //    sendImage.sendToClass();







         //   }
      //  });





         return view;

    }

    private void preparewoirkoutdata() {


        Log.e( "preparewoirkoutdata: ","1111111" );
        Workout workout=new Workout(getString(R.string.pushup),R.drawable.pushup111,R.drawable.pushup11);
        workout.setSets("3-5 ست ، 8-15 تکرار");
        workoutList.add(workout);

        Workout workout1=new Workout(getString(R.string.brad12txt),R.drawable.smith11,R.drawable.smith21);
        workout1.setSets("3-5 ست ، 8-15 تکرار");
        workoutList.add(workout1);

        Workout workout2=new Workout(getString(R.string.brad13txt),R.drawable.smithincline,R.drawable.smithincline);
        workout2.setSets("3-5 ست ، 8-15 تکرار");
        workoutList.add(workout2);

        Workout workout3=new Workout(getString(R.string.brad14txt),R.drawable.chestfly1,R.drawable.chestfly2);
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
        Log.e("111111", "onAttach: " );

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.e( "111111: ","onDetach" );
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
