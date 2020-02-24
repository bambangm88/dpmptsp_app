package com.example.dpmptsp_app.model;

import com.google.gson.annotations.SerializedName;


public class ResponseData {

    @SerializedName("success")
    String success;


    @SerializedName("nomor_surat")
    String nomor_surat;
    @SerializedName("nama_pemohon")
    String nama_pemohon;

    @SerializedName("lokasi_bangunan")
    String lokasi_bangunan;

    @SerializedName("no_sertifikat")
    String no_sertifikat;

    @SerializedName("status_tanah")
    String status_tanah;

    @SerializedName("luas_tanah")
    String luas_tanah;

    @SerializedName("peruntuk_bangunan")
    String peruntuk_bangunan;

    @SerializedName("ukuran")
    String ukuran;

    @SerializedName("retribusi")
    String retribusi;

    public String getNomor_surat() {
        return nomor_surat;
    }

    public void setNomor_surat(String nomor_surat) {
        this.nomor_surat = nomor_surat;
    }

    public String getNama_pemohon() {
        return nama_pemohon;
    }

    public void setNama_pemohon(String nama_pemohon) {
        this.nama_pemohon = nama_pemohon;
    }

    public String getLokasi_bangunan() {
        return lokasi_bangunan;
    }

    public void setLokasi_bangunan(String lokasi_bangunan) {
        this.lokasi_bangunan = lokasi_bangunan;
    }

    public String getNo_sertifikat() {
        return no_sertifikat;
    }

    public void setNo_sertifikat(String no_sertifikat) {
        this.no_sertifikat = no_sertifikat;
    }

    public String getStatus_tanah() {
        return status_tanah;
    }

    public void setStatus_tanah(String status_tanah) {
        this.status_tanah = status_tanah;
    }

    public String getLuas_tanah() {
        return luas_tanah;
    }

    public void setLuas_tanah(String luas_tanah) {
        this.luas_tanah = luas_tanah;
    }

    public String getPeruntuk_bangunan() {
        return peruntuk_bangunan;
    }

    public void setPeruntuk_bangunan(String peruntuk_bangunan) {
        this.peruntuk_bangunan = peruntuk_bangunan;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getRetribusi() {
        return retribusi;
    }

    public void setRetribusi(String retribusi) {
        this.retribusi = retribusi;
    }




    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }


    public ResponseData(String success, String username, String message, String nama, String foto , String harga, String id) {
        this.success = success;
    }


}
