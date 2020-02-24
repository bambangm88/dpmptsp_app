package com.example.dpmptsp_app.activity;

import android.os.Bundle;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.dpmptsp_app.R;


public class DetailActivity extends AppCompatActivity {

    TextView nomor_surat,nama_pemohon,lokasi_bangunan,no_sertifikat,status_tanah,luas_tanah,peruntuk_bangunan,ukuran,retribusi ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //menerapkan tool bar sesuai id toolbar | ToolBarAtas adalah variabel buatan sndiri
        Toolbar ToolBarAtas2 = findViewById(R.id.toolbar_detail);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setSupportActionBar(ToolBarAtas2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nomor_surat = findViewById(R.id.nomor_surat);
        nama_pemohon = findViewById(R.id.nama);
        lokasi_bangunan =  findViewById(R.id.lokasi);
        no_sertifikat = findViewById(R.id.nomor_sertifikat);
        status_tanah = findViewById(R.id.statusTanah);
        luas_tanah = findViewById(R.id.luasTanah);
        peruntuk_bangunan = findViewById(R.id.peruntukBangunan);
        ukuran = findViewById(R.id.ukuran);
        retribusi = findViewById(R.id.retribusi);


        if(getIntent().getExtras()!=null){

            Bundle bundle = getIntent().getExtras();
            nomor_surat.setText("Nomor Surat : "+bundle.getString("nomor_surat"));
            nama_pemohon.setText("Nama Pemohon: "+bundle.getString("nama_pemohon"));
            lokasi_bangunan.setText("Lokasi Bangunan : "+bundle.getString("lokasi_bangunan"));
            no_sertifikat.setText("No Sertifikat : "+bundle.getString("no_sertifikat"));
            status_tanah.setText("Status Tanah : "+bundle.getString("status_tanah"));
            luas_tanah.setText("Luas Tanah : "+bundle.getString("luas_tanah"));
            peruntuk_bangunan.setText("Peruntuk Bangunan : "+bundle.getString("peruntuk_bangunan"));
            ukuran.setText("Ukuran : "+bundle.getString("ukuran"));
            retribusi.setText("Retribusi : "+bundle.getString("retribusi"));

        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
