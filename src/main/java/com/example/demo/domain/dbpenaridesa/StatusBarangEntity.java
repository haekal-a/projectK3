package com.example.demo.domain.dbpenaridesa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "status_barang", schema = "db_penari_desa")
public class StatusBarangEntity {
    private BigDecimal id;
    private BigDecimal idBarang;
    private String stsBarang;
    private String kondisi;

    public StatusBarangEntity() {
    }

    public StatusBarangEntity(BigDecimal id, BigDecimal idBarang, String stsBarang, String kondisi) {
        this.id = id;
        this.idBarang = idBarang;
        this.stsBarang = stsBarang;
        this.kondisi = kondisi;
    }

    @Id
    @Column(name = "id", nullable = false)
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_barang", nullable = false)
    public BigDecimal getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(BigDecimal idBarang) {
        this.idBarang = idBarang;
    }

    @Basic
    @Column(name = "sts_barang", nullable = false, length = 1)
    public String getStsBarang() {
        return stsBarang;
    }

    public void setStsBarang(String stsBarang) {
        this.stsBarang = stsBarang;
    }

    @Basic
    @Column(name = "kondisi", nullable = false, length = 1)
            public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusBarangEntity that = (StatusBarangEntity) o;
        return id == that.id &&
                idBarang == that.idBarang &&
                stsBarang == that.stsBarang &&
                kondisi == that.kondisi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idBarang, stsBarang, kondisi);
    }
}
