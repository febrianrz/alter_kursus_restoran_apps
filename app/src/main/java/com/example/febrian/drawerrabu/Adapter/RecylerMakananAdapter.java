package com.example.febrian.drawerrabu.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.febrian.drawerrabu.Model.Makanan;
import com.example.febrian.drawerrabu.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by febrian on 15/06/2017.
 */

public class RecylerMakananAdapter extends RecyclerView.Adapter<RecylerMakananAdapter.ViewHolder> {
    private List<Makanan> arrData;
    private Context context;

    public RecylerMakananAdapter(Context context, List<Makanan> arrData){
        this.arrData = arrData;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvJudul, tvHarga;
        public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            tvJudul = (TextView) itemView.findViewById(R.id.textNama);
            tvHarga = (TextView) itemView.findViewById(R.id.textHarga);
            imageView = (ImageView) itemView.findViewById(R.id.imageView2);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyler_makanan,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //mengambil dataset dari array dan menempatkannya sesuai posisinya
        Makanan transaksiData = arrData.get(position);
        holder.tvJudul.setText(transaksiData.getNama_menu());
        holder.tvHarga.setText(transaksiData.getHarga()+"");

        Picasso.with(context).load(transaksiData.getGambar())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }

    public Bitmap getBitmapfromUrl(String imageUrl)
    {
        try
        {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }
}
