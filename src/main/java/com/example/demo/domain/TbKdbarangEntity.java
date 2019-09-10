package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_kdbarang", schema = "db_bmn")
public class TbKdbarangEntity {
    private String kdBarang;
    private String namaBarang;
    private String keterangan;

    public TbKdbarangEntity() {
    }

    public TbKdbarangEntity(String kdBarang, String namaBarang, String keterangan) {
        this.kdBarang = kdBarang;
        this.namaBarang = namaBarang;
        this.keterangan = keterangan;
    }

    @Id
    @Column(name = "kd_barang", nullable = false, length = 10)
    public String getKdBarang() {
        return kdBarang;
    }

    public void setKdBarang(String kdBarang) {
        this.kdBarang = kdBarang;
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
    @Column(name = "keterangan", nullable = true, length = -1)
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbKdbarangEntity that = (TbKdbarangEntity) o;
        return Objects.equals(kdBarang, that.kdBarang) &&
                Objects.equals(namaBarang, that.namaBarang) &&
                Objects.equals(keterangan, that.keterangan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kdBarang, namaBarang, keterangan);
    }
}
