package com.example.demo.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "master_bmn", schema = "db_simak_bmn")
public class MasterBmnEntity {
    private BigDecimal id;
    private String kdBarang;
    private String namaBarang;
    private String merkBarang;
    private String tahunPembelian;
    private String keterangan;
    private String kondisi;
    private String createdBy;
    private Date createdDate;

    public MasterBmnEntity() {
    }

    public MasterBmnEntity(BigDecimal id, String kdBarang, String namaBarang, String merkBarang, String tahunPembelian, String keterangan, String kondisi, String createdBy, Date createdDate) {
        this.id = id;
        this.kdBarang = kdBarang;
        this.namaBarang = namaBarang;
        this.merkBarang = merkBarang;
        this.tahunPembelian = tahunPembelian;
        this.keterangan = keterangan;
        this.kondisi = kondisi;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Basic
    @Column(name = "KD_Barang", nullable = false, length = 10)
    public String getKdBarang() {
        return kdBarang;
    }

    public void setKdBarang(String kdBarang) {
        this.kdBarang = kdBarang;
    }

    @Basic
    @Column(name = "Nama_Barang", nullable = false, length = 45)
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    @Basic
    @Column(name = "Merk_Barang", nullable = false, length = 30)
    public String getMerkBarang() {
        return merkBarang;
    }

    public void setMerkBarang(String merkBarang) {
        this.merkBarang = merkBarang;
    }

    @Basic
    @Column(name = "Tahun_Pembelian", nullable = false)
    public String getTahunPembelian() {
        return tahunPembelian;
    }

    public void setTahunPembelian(String tahunPembelian) {
        this.tahunPembelian = tahunPembelian;
    }

    @Basic
    @Column(name = "Keterangan", nullable = true, length = 100)
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Basic
    @Column(name = "Kondisi", nullable = true, length = 10)
    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    @Basic
    @Column(name = "Created_By", nullable = false, length = 20)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "Created_Date", nullable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterBmnEntity that = (MasterBmnEntity) o;
        return id == that.id &&
                kdBarang == that.kdBarang &&
                tahunPembelian == that.tahunPembelian &&
                Objects.equals(namaBarang, that.namaBarang) &&
                Objects.equals(merkBarang, that.merkBarang) &&
                Objects.equals(keterangan, that.keterangan) &&
                Objects.equals(kondisi, that.kondisi) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kdBarang, namaBarang, merkBarang, tahunPembelian, keterangan, kondisi, createdBy, createdDate);
    }
}
