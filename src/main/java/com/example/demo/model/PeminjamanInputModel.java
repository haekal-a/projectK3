package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class PeminjamanInputModel {
    private BigDecimal idPeminjaman;
    private BigDecimal idBarang;
    private String namaPeminjam;
    private String nip;
    private String keperluan;
    private Date tanggalpinjam;
    private Date tanggaljatuhtempo;

    public BigDecimal getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(BigDecimal idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public BigDecimal getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(BigDecimal idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

    public Date getTanggalpinjam() {
        return tanggalpinjam;
    }

    public void setTanggalpinjam(Date tanggalpinjam) {
        this.tanggalpinjam = tanggalpinjam;
    }

    public Date getTanggaljatuhtempo() {
        return tanggaljatuhtempo;
    }

    public void setTanggaljatuhtempo(Date tanggaljatuhtempo) {
        this.tanggaljatuhtempo = tanggaljatuhtempo;
    }
}
