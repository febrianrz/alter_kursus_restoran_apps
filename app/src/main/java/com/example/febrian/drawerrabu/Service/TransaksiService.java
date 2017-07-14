package com.example.febrian.drawerrabu.Service;

import com.example.febrian.drawerrabu.Model.Makanan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by febrian on 07/07/2017.
 */

public interface TransaksiService {

    @GET("api/get_makanan")
    Call<List<Makanan>> getMakanan();

    @GET("api/get_minuman")
    Call<List<Makanan>> getMinuman();

}
