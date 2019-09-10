package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_sts_barang", schema = "db_bmn")
public class TbStsBarangEntity {
    private int idStatus;
    private int stsBarang;
    private TbMasterbmnEntity tbMasterbmnByIdMasterbmn;

    public TbStsBarangEntity() {
    }

    public TbStsBarangEntity(int idStatus, int stsBarang, TbMasterbmnEntity tbMasterbmnByIdMasterbmn) {
        this.idStatus = idStatus;
        this.stsBarang = stsBarang;
        this.tbMasterbmnByIdMasterbmn = tbMasterbmnByIdMasterbmn;
    }

    @Id
    @Column(name = "id_status", nullable = false)
    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    @Basic
    @Column(name = "sts_barang", nullable = false)
    public int getStsBarang() {
        return stsBarang;
    }

    public void setStsBarang(int stsBarang) {
        this.stsBarang = stsBarang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbStsBarangEntity that = (TbStsBarangEntity) o;
        return idStatus == that.idStatus &&
                stsBarang == that.stsBarang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStatus, stsBarang);
    }

    @ManyToOne
    @JoinColumn(name = "id_masterbmn", referencedColumnName = "id_masterbmn", nullable = false)
    public TbMasterbmnEntity getTbMasterbmnByIdMasterbmn() {
        return tbMasterbmnByIdMasterbmn;
    }

    public void setTbMasterbmnByIdMasterbmn(TbMasterbmnEntity tbMasterbmnByIdMasterbmn) {
        this.tbMasterbmnByIdMasterbmn = tbMasterbmnByIdMasterbmn;
    }
}
