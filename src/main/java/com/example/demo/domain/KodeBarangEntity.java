package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "kode_barang", schema = "db_simak_bmn")
public class KodeBarangEntity {
    private String kdBarang;
    private String jenisBarang;
    private String keterangan;

    public KodeBarangEntity() {
    }

    public KodeBarangEntity(String kdBarang, String jenisBarang, String keterangan) {
        this.kdBarang = kdBarang;
        this.jenisBarang = jenisBarang;
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
    @Column(name = "jenis_barang", nullable = false, length = 45)
    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    @Basic
    @Column(name = "keterangan", nullable = true, length = 100)
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
        KodeBarangEntity that = (KodeBarangEntity) o;
        return Objects.equals(kdBarang, that.kdBarang) &&
                Objects.equals(jenisBarang, that.jenisBarang) &&
                Objects.equals(keterangan, that.keterangan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kdBarang, jenisBarang, keterangan);
    }
}
