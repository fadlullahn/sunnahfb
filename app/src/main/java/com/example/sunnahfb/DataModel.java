package com.example.sunnahfb;

public class DataModel {
    private String key;
    private String judul;
    private String deskripsi;
    private String kategori;

    public DataModel() {
    }

    public DataModel(String judul, String deskripsi, String kategori) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

