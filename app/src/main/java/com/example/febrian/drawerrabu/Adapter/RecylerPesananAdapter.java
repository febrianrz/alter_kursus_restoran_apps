package com.example.febrian.drawerrabu.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.febrian.drawerrabu.R;

import java.util.ArrayList;

/**
 * Created by febrian on 19/06/2017.
 */

public class RecylerPesananAdapter extends RecyclerView.Adapter<RecylerPesananAdapter.ViewHolder>{
    private ArrayList<String> arrData;

    public RecylerPesananAdapter(ArrayList<String> arrData){
        this.arrData = arrData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvJudul, tvHarga;
        public ViewHolder(View itemView) {
            super(itemView);
            tvJudul = (TextView) itemView.findViewById(R.id.textNama);
            tvHarga = (TextView) itemView.findViewById(R.id.textHarga);
        }
    }

    @Override
    public RecylerPesananAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyler_pesanan_card,parent,false);
        RecylerPesananAdapter.ViewHolder vh = new RecylerPesananAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecylerPesananAdapter.ViewHolder holder, int position) {
        //mengambil dataset dari array dan menempatkannya sesuai posisinya
        holder.tvJudul.setText("Nasi Goreng");
        holder.tvHarga.setText("Rp120.000");
    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }
}
