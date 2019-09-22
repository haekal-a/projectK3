package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class PengembalianInputModel {

    private BigDecimal idPeminjaman;
    private Date tanggalKembali;
    private String kondisi;

    public BigDecimal getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(BigDecimal idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

}
