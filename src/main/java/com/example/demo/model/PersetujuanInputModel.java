package com.example.demo.model;

import java.math.BigDecimal;

public class PersetujuanInputModel {
    private BigDecimal idPeminjaman;
    private String alasanPenolakan;

    public BigDecimal getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(BigDecimal idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getAlasanPenolakan() {
        return alasanPenolakan;
    }

    public void setAlasanPenolakan(String alasanPenolakan) {
        this.alasanPenolakan = alasanPenolakan;
    }
}
