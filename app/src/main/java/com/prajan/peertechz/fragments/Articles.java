package com.prajan.peertechz.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prajan.peertechz.R;
import com.prajan.peertechz.adapter.ArticlesVerticalAdapter;
import com.prajan.peertechz.model.ArticlesModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Articles.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Articles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Articles extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private GridLayoutManager lLayout, lLayout2;
    int spanCount = 1;
    private OnFragmentInteractionListener mListener;

    public Articles() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Articles.
     */
    // TODO: Rename and change types and number of parameters
    public static Articles newInstance(String param1, String param2) {
        Articles fragment = new Articles();
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
        View view = inflater.inflate(R.layout.fragment_articles, container, false);


        //verticall Layout
        List<ArticlesModel> rowListItem = getAllVerticalItemList();
        lLayout2 = new GridLayoutManager(getContext(), 1);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_vertically);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lLayout2);

        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.line_divider));
        recyclerView.addItemDecoration(divider);

        ArticlesVerticalAdapter msgAdapter = new ArticlesVerticalAdapter(getContext(), rowListItem);
        recyclerView.setAdapter(msgAdapter);
        return view;
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
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
    private List<ArticlesModel> getAllVerticalItemList(){

        List<ArticlesModel> vallItems = new ArrayList<ArticlesModel>();
        vallItems.add(new ArticlesModel("Aortic Arch Morphometry and its clinical implication –A computed tomography study",
                "Author(s): Hema Nagpal*, PK Sharma, Jyoti Chopra and Rajni Patel",R.drawable.editpaper));
        vallItems.add(new ArticlesModel("The role of general practitioner in the study of adverse drug reactions epidemiology in ambulatory care setting.",
                "Author(s): Jose Luis Turabian*",R.drawable.editpaper));
        vallItems.add(new ArticlesModel("A comparative morphometric study of the superfi cial and juxtamedullary nephrons during the postnatal development in spontaneously hypertensive rats"
                ,"Author(s): Stancho Stanchev*, Alexandar Iliev, Georgi Kotov, Lina Malinova and Boycho Landzhov",R.drawable.editpaper));
        vallItems.add(new ArticlesModel("Protective and curative effects of Boerhaavia diff usa L. against fl uoride induced renal oxidative stress and antioxidant enzymes in rats",
                "Author(s): Shashi A* and Jawant Kaur",R.drawable.editpaper));
        vallItems.add(new ArticlesModel("Boerhaavia diffusa L. Supplementation Attenuates Fluoride Induced Testicular Impairments in rats",
                "Author(s): Shashi A, Khan I",R.drawable.editpaper));


        return vallItems;
    }
}
