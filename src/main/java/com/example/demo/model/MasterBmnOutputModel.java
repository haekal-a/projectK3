package com.example.demo.model;


import java.math.BigDecimal;
import java.util.Date;

public class MasterBmnOutputModel {

  private BigDecimal id;
  private String kdBarang;
  private String namaBarang;
  private String merkBarang;
  private String tahunPembelian;
  private String keterangan;
  private String kondisi;
  private String createdBy;
  private Date createdDate;


  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
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


  public String getTahunPembelian() {
    return tahunPembelian;
  }

  public void setTahunPembelian(String tahunPembelian) {
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


  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(java.sql.Date createdDate) {
    this.createdDate = createdDate;
  }

}
