package com.example.demo.model;

import java.math.BigDecimal;

public class PersetujuanInputModel {
    private BigDecimal idPeminjaman;
    private String alasanPenolakan;
    private String approvedBy;

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

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
}
