package com.example.dpmptsp_app.api;

import com.example.dpmptsp_app.model.RegisterMahasiswaModel;
import com.example.dpmptsp_app.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Gustiawan on 2/2/2019.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("cekSurat.php")
    Call<ResponseData> cekOriginalitas(@Field("noSurat") String id);



    @FormUrlEncoded
    @POST("login.php")
    Call<RegisterMahasiswaModel> LoginMahasiswa(@Field("email") String email,
                                                @Field("password") String password




    );

}
