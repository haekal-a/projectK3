package com.example.demo.model;


import java.math.BigDecimal;
import java.util.Date;

public class PeminjamanOutputModel {

  private BigDecimal idPeminjaman;
  private BigDecimal idBarang;
  private String nip;
  private String namaPeminjam;
  private String keperluan;
  private Date tanggalPinjam;
  private Date tanggalKembali;
  private Date tanggalPersetujuan;
  private Date jatuhTempoPengembalian;
  private String createdBy;
  private String approvedBy;
  private Date createdDate;
  private String statusPeminjaman;
  private String alasanPenolakan;


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


  public String getNip() {
    return nip;
  }

  public void setNip(String nip) {
    this.nip = nip;
  }


  public String getNamaPeminjam() {
    return namaPeminjam;
  }

  public void setNamaPeminjam(String namaPeminjam) {
    this.namaPeminjam = namaPeminjam;
  }


  public String getKeperluan() {
    return keperluan;
  }

  public void setKeperluan(String keperluan) {
    this.keperluan = keperluan;
  }


  public Date getTanggalPinjam() {
    return tanggalPinjam;
  }

  public void setTanggalPinjam(Date tanggalPinjam) {
    this.tanggalPinjam = tanggalPinjam;
  }


  public Date getTanggalKembali() {
    return tanggalKembali;
  }

  public void setTanggalKembali(Date tanggalKembali) {
    this.tanggalKembali = tanggalKembali;
  }


  public Date getTanggalPersetujuan() {
    return tanggalPersetujuan;
  }

  public void setTanggalPersetujuan(Date tanggalPersetujuan) {
    this.tanggalPersetujuan = tanggalPersetujuan;
  }


  public Date getJatuhTempoPengembalian() {
    return jatuhTempoPengembalian;
  }

  public void setJatuhTempoPengembalian(Date jatuhTempoPengembalian) {
    this.jatuhTempoPengembalian = jatuhTempoPengembalian;
  }


  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public String getApprovedBy() {
    return approvedBy;
  }

  public void setApprovedBy(String approvedBy) {
    this.approvedBy = approvedBy;
  }


  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }


  public String getStatusPeminjaman() {
    return statusPeminjaman;
  }

  public void setStatusPeminjaman(String statusPeminjaman) {
    this.statusPeminjaman = statusPeminjaman;
  }


  public String getAlasanPenolakan() {
    return alasanPenolakan;
  }

  public void setAlasanPenolakan(String alasanPenolakan) {
    this.alasanPenolakan = alasanPenolakan;
  }

}
