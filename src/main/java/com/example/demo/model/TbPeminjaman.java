package com.example.demo.model;


public class TbPeminjaman {

  private long idPeminjaman;
  private long idMasterbmn;
  private String nip;
  private String namaPeminjam;
  private String keperluan;
  private java.sql.Date tanggalPinjam;
  private java.sql.Date tanggalKembali;
  private java.sql.Date tanggalPersetujuan;
  private java.sql.Date jatuhTempoPengembalian;
  private String createdBy;
  private String approvedBy;
  private java.sql.Date createdDate;


  public long getIdPeminjaman() {
    return idPeminjaman;
  }

  public void setIdPeminjaman(long idPeminjaman) {
    this.idPeminjaman = idPeminjaman;
  }


  public long getIdMasterbmn() {
    return idMasterbmn;
  }

  public void setIdMasterbmn(long idMasterbmn) {
    this.idMasterbmn = idMasterbmn;
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


  public java.sql.Date getTanggalPinjam() {
    return tanggalPinjam;
  }

  public void setTanggalPinjam(java.sql.Date tanggalPinjam) {
    this.tanggalPinjam = tanggalPinjam;
  }


  public java.sql.Date getTanggalKembali() {
    return tanggalKembali;
  }

  public void setTanggalKembali(java.sql.Date tanggalKembali) {
    this.tanggalKembali = tanggalKembali;
  }


  public java.sql.Date getTanggalPersetujuan() {
    return tanggalPersetujuan;
  }

  public void setTanggalPersetujuan(java.sql.Date tanggalPersetujuan) {
    this.tanggalPersetujuan = tanggalPersetujuan;
  }


  public java.sql.Date getJatuhTempoPengembalian() {
    return jatuhTempoPengembalian;
  }

  public void setJatuhTempoPengembalian(java.sql.Date jatuhTempoPengembalian) {
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


  public java.sql.Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(java.sql.Date createdDate) {
    this.createdDate = createdDate;
  }

}
