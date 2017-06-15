package com.example.febrian.drawerrabu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ServerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
        /** setting menu title di action bar **/
        getSupportActionBar().setTitle("Pengaturan");

        /** menampilkan back button di action barnya,
         * jangan lupa cek manifestnya juga
         * tambahkan meta-data untuk halaman yang dituju setelah back button
         **/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
