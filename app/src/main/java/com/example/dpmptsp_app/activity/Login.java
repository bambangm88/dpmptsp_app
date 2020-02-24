package com.example.dpmptsp_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.dpmptsp_app.R;
import com.example.dpmptsp_app.api.ApiService;
import com.example.dpmptsp_app.api.Server;
import com.example.dpmptsp_app.model.RegisterMahasiswaModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class Login extends AppCompatActivity {


    EditText txtEmail,txtPass;
    Button btnLogin , btnRegister;


    ProgressDialog loading;

    Context mContext;
    ApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail =  findViewById(R.id.edtEmail);
        txtPass =  findViewById(R.id.edtPass);

        btnLogin = findViewById(R.id.btnLogin);


        mApiService = Server.getAPIService();
        mContext = this;




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = txtEmail.getText().toString();

                String pwd = txtPass.getText().toString();

                if ( email.equals("") ||  pwd.equals("") ){
                    Toast.makeText(mContext, "Silahkan isi field", Toast.LENGTH_SHORT).show();
                }else{
                    LoginMahasiswa(email,pwd);
                }





            }
        });



    }



    public void LoginMahasiswa( String email,  String password) {
        loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);

        mApiService.LoginMahasiswa(email,password).enqueue(new Callback<RegisterMahasiswaModel>() {
            @Override
            public void onResponse(Call<RegisterMahasiswaModel> call, Response<RegisterMahasiswaModel> response) {

                if (response.isSuccessful()){
                    RegisterMahasiswaModel responseData = response.body();

                    if(responseData.getSuccess().equals("1")){
                        loading.dismiss();

                        Toast.makeText(mContext, "Login Berhasil", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);


                    }else {
                        loading.cancel();
                        Toast.makeText(mContext, "Account Salah", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    loading.cancel();
                    Toast.makeText(mContext, "Cek koneksi internet anda", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterMahasiswaModel> call, Throwable t) {
                Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }




}
