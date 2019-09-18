package com.example.demo.model;


public class MasterBmnOutputModel {

  private long id;
  private String kdBarang;
  private String namaBarang;
  private String merkBarang;
  private long tahunPembelian;
  private String keterangan;
  private String kondisi;
  private String createdBy;
  private java.sql.Date createdDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getKdBarang() {
    return kdBarang;
  }

  public void setKdBarang(String kdBarang) {
    this.kdBarang = kdBarang;
  }


  public String getNamaBarang() {
    return namaBarang;
  }

  public void setNamaBarang(String namaBarang) {
    this.namaBarang = namaBarang;
  }


  public String getMerkBarang() {
    return merkBarang;
  }

  public void setMerkBarang(String merkBarang) {
    this.merkBarang = merkBarang;
  }


  public long getTahunPembelian() {
    return tahunPembelian;
  }

  public void setTahunPembelian(long tahunPembelian) {
    this.tahunPembelian = tahunPembelian;
  }


  public String getKeterangan() {
    return keterangan;
  }

  public void setKeterangan(String keterangan) {
    this.keterangan = keterangan;
  }


  public String getKondisi() {
    return kondisi;
  }

  public void setKondisi(String kondisi) {
    this.kondisi = kondisi;
  }


  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public java.sql.Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(java.sql.Date createdDate) {
    this.createdDate = createdDate;
  }

}
