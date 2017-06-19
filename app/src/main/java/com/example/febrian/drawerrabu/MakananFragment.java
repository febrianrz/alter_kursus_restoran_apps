package com.example.febrian.drawerrabu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.febrian.drawerrabu.Adapter.RecylerMakananAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MakananFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recylerAdapter;
    private RecyclerView.LayoutManager recylerLayoutManager;
    private ArrayList<String> dataSet;

    public MakananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dataSet = new ArrayList<>();
        init();
        View rootView = inflater.inflate(R.layout.fragment_makanan, container, false);
        //deklarasikan recylerview
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyler_makanan);

        //buat ukurannya tetap
        recyclerView.setHasFixedSize(true);

        //gunakan linear layout manager
        recylerLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(recylerLayoutManager);

        //setting adapter
        recylerAdapter = new RecylerMakananAdapter(dataSet);
        recyclerView.setAdapter(recylerAdapter);
        return rootView;
    }

    private void init(){
        dataSet.add("Tester");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
        dataSet.add("Lagi");
    }
}
