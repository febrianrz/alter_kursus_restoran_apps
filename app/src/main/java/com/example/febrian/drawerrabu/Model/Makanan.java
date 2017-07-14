package com.example.febrian.drawerrabu.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by febrian on 07/07/2017.
 */

public class Makanan {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nama_menu")
    @Expose
    private String nama_menu;

    @SerializedName("harga")
    @Expose
    private int harga;

    @SerializedName("gambar")
    @Expose
    private String gambar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
