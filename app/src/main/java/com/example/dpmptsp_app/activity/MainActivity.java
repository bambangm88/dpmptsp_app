package com.example.dpmptsp_app.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.dpmptsp_app.R;
import com.example.dpmptsp_app.api.ApiService;
import com.example.dpmptsp_app.api.Server;
import com.example.dpmptsp_app.model.ResponseData;
import com.example.dpmptsp_app.pref.SesionManager;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 100;

    public static final int PERMISSION_REQUEST = 200;


    ApiService API;
    SesionManager sesion;
    Button btn_scan,btn_tentang,btn_petunjuk ;
    ProgressDialog pDialog;

    private IntentIntegrator intentIntegrator;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);

        }

        API = Server.getAPIService();

        sesion = new SesionManager(this);
        HashMap user= sesion.getUserDetails();

        btn_scan = findViewById(R.id.btn_scan);
        btn_petunjuk = findViewById(R.id.btn_petunjuk);
        btn_tentang = findViewById(R.id.btn_tentang);


        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentIntegrator = new IntentIntegrator(MainActivity.this);
                intentIntegrator.initiateScan();      //method to turn on

            }
        });



        btn_petunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent petunjuk = new Intent(MainActivity.this,petunjuk.class);
                startActivity(petunjuk);


            }
        });

        btn_tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent petunjuk = new Intent(MainActivity.this,tentang.class);
                startActivity(petunjuk);

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Hasil tidak ditemukan", Toast.LENGTH_SHORT).show();
            }else{

                try{

                    String id = result.getContents();
                    cekOri(id);
                }catch (Exception e){
                    e.printStackTrace();
                    // jika format encoded tidak sesuai maka hasil
                    // ditampilkan ke toast
                    Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }






    private void cekOri(String id) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Loading...");
        pDialog.show();

        API.cekOriginalitas(id).enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {

                if (response.isSuccessful()){
                    ResponseData responseData = response.body();

                    if(responseData.getSuccess().equals("1")){
                        pDialog.cancel();


                        Bundle bundle = new Bundle();
                        bundle.putString("nomor_surat", response.body().getNomor_surat());
                        bundle.putString("nama_pemohon", response.body().getNama_pemohon());
                        bundle.putString("lokasi_bangunan", response.body().getLokasi_bangunan());
                        bundle.putString("no_sertifikat", response.body().getNo_sertifikat());
                        bundle.putString("status_tanah", response.body().getStatus_tanah());
                        bundle.putString("luas_tanah", response.body().getLuas_tanah());
                        bundle.putString("peruntuk_bangunan", response.body().getPeruntuk_bangunan());
                        bundle.putString("ukuran", response.body().getUkuran());
                        bundle.putString("retribusi", response.body().getRetribusi());

                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }else {
                        pDialog.cancel();
                        Toast.makeText(MainActivity.this, "Data Surat Tidak Terdaftar", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    pDialog.cancel();
                    Toast.makeText(MainActivity.this, "Cek koneksi internet anda", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                pDialog.cancel();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }





}
