package com.example.demo.model;


import java.math.BigDecimal;

public class StatusBarangOutputModel {

  private BigDecimal idBarang;
  private String stsBarang;
  private BigDecimal id;
  private String kondisi;


  public BigDecimal getIdBarang() {
    return idBarang;
  }

  public void setIdBarang(BigDecimal idBarang) {
    this.idBarang = idBarang;
  }


  public String getStsBarang() {
    return stsBarang;
  }

  public void setStsBarang(String stsBarang) {
    this.stsBarang = stsBarang;
  }


  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public String getKondisi() {
    return kondisi;
  }

  public void setKondisi(String kondisi) {
    this.kondisi = kondisi;
  }
}
