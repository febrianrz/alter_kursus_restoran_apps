package com.example.febrian.drawerrabu;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.febrian.drawerrabu.Adapter.RecylerMakananAdapter;
import com.example.febrian.drawerrabu.Model.Makanan;
import com.example.febrian.drawerrabu.Service.TransaksiService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MakananFragment extends Fragment implements Callback<List<Makanan>> {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recylerAdapter;
    private RecyclerView.LayoutManager recylerLayoutManager;
    private ArrayList<String> dataSet;
    private List<Makanan> transaksiDatas = new ArrayList<>();
    private String[] minuman;
    private ProgressDialog progressDialog;

    public MakananFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_makanan, container, false);
        //deklarasikan recylerview
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyler_makanan);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading ...");
        progressDialog.show();
        init();
        return rootView;
    }

    private void init(){
        /**
         * Ambil dari API
         */
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://other.alterindonesia.com/restoran/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TransaksiService transaksiService = retrofit.create(TransaksiService.class);
        Call<List<Makanan>> getTransaksiCall = transaksiService.getMakanan();
        getTransaksiCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Makanan>> call, Response<List<Makanan>> response) {
        progressDialog.hide();
        for (Makanan makanan : response.body()) {
            transaksiDatas.add(makanan);
        }
        //buat ukurannya tetap
        recyclerView.setHasFixedSize(true);
        //gunakan linear layout manager
        recylerLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(recylerLayoutManager);
        //setting adapter
        recylerAdapter = new RecylerMakananAdapter(getContext(),transaksiDatas);
        recyclerView.setAdapter(recylerAdapter);
    }

    @Override
    public void onFailure(Call<List<Makanan>> call, Throwable t) {
        Toast.makeText(getContext(),"Gagal menarik data",Toast.LENGTH_LONG).show();
    }
}
