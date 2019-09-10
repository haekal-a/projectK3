package com.example.demo.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_masterbmn", schema = "db_bmn")
public class TbMasterbmnEntity {
    private int idMasterbmn;
    private String namaBarang;
    private String merkBarang;
    private Date tahunPembelian;
    private String keterangan;
    private String kondisi;
    private String createdBy;
    private Date createdDate;
    private TbKdbarangEntity tbKdbarangByKdBarang;

    public TbMasterbmnEntity() {
    }

    public TbMasterbmnEntity(int idMasterbmn, String namaBarang, String merkBarang, Date tahunPembelian, String keterangan, String kondisi, String createdBy, Date createdDate, TbKdbarangEntity tbKdbarangByKdBarang) {
        this.idMasterbmn = idMasterbmn;
        this.namaBarang = namaBarang;
        this.merkBarang = merkBarang;
        this.tahunPembelian = tahunPembelian;
        this.keterangan = keterangan;
        this.kondisi = kondisi;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.tbKdbarangByKdBarang = tbKdbarangByKdBarang;
    }

    @Id
    @Column(name = "id_masterbmn", nullable = false)
    public int getIdMasterbmn() {
        return idMasterbmn;
    }

    public void setIdMasterbmn(int idMasterbmn) {
        this.idMasterbmn = idMasterbmn;
    }

    @Basic
    @Column(name = "nama_barang", nullable = false, length = 45)
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    @Basic
    @Column(name = "merk_barang", nullable = false, length = 30)
    public String getMerkBarang() {
        return merkBarang;
    }

    public void setMerkBarang(String merkBarang) {
        this.merkBarang = merkBarang;
    }

    @Basic
    @Column(name = "tahun_pembelian", nullable = false)
    public Date getTahunPembelian() {
        return tahunPembelian;
    }

    public void setTahunPembelian(Date tahunPembelian) {
        this.tahunPembelian = tahunPembelian;
    }

    @Basic
    @Column(name = "keterangan", nullable = true, length = -1)
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Basic
    @Column(name = "kondisi", nullable = true, length = 10)
    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    @Basic
    @Column(name = "created_by", nullable = false, length = 20)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "created_date", nullable = false)
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
        TbMasterbmnEntity that = (TbMasterbmnEntity) o;
        return idMasterbmn == that.idMasterbmn &&
                Objects.equals(namaBarang, that.namaBarang) &&
                Objects.equals(merkBarang, that.merkBarang) &&
                Objects.equals(tahunPembelian, that.tahunPembelian) &&
                Objects.equals(keterangan, that.keterangan) &&
                Objects.equals(kondisi, that.kondisi) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMasterbmn, namaBarang, merkBarang, tahunPembelian, keterangan, kondisi, createdBy, createdDate);
    }

    @ManyToOne
    @JoinColumn(name = "kd_barang", referencedColumnName = "kd_barang", nullable = false)
    public TbKdbarangEntity getTbKdbarangByKdBarang() {
        return tbKdbarangByKdBarang;
    }

    public void setTbKdbarangByKdBarang(TbKdbarangEntity tbKdbarangByKdBarang) {
        this.tbKdbarangByKdBarang = tbKdbarangByKdBarang;
    }
}
