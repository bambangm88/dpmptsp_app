package com.example.dpmptsp_app.model;

import com.google.gson.annotations.SerializedName;

public class RegisterMahasiswaModel {

    @SerializedName("success")
    String success;

    @SerializedName("message")
    String message;

    @SerializedName("id_mahasiswa")
    String id_mahasiswa;

    @SerializedName("nama_mahasiswa")
    String nama_mahasiswa;

    @SerializedName("nim")
    String nim;

    @SerializedName("password")
    String password;

    @SerializedName("saldo")
    String saldo;


    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }


    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId_mahasiswa() {
        return id_mahasiswa;
    }

    public void setId_mahasiswa(String id_mahasiswa) {
        this.id_mahasiswa = id_mahasiswa;
    }

    public String getNama_mahasiswa() {
        return nama_mahasiswa;
    }

    public void setNama_mahasiswa(String nama_mahasiswa) {
        this.nama_mahasiswa = nama_mahasiswa;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }






}
