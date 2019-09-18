package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "status_barang", schema = "db_penari_desa", catalog = "")
public class StatusBarangEntity {
    private int stsBarang;
    private int id;

    @Basic
    @Column(name = "sts_barang", nullable = false)
    public int getStsBarang() {
        return stsBarang;
    }

    public void setStsBarang(int stsBarang) {
        this.stsBarang = stsBarang;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusBarangEntity that = (StatusBarangEntity) o;
        return stsBarang == that.stsBarang &&
                id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stsBarang, id);
    }
}
