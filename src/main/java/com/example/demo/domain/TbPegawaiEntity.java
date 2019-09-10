package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_pegawai", schema = "db_bmn")
public class TbPegawaiEntity {
    private String nip;
    private String kdPegawai;
    private String namaPegawai;
    private String seksi;
    private String jabatan;
    private String alamat;

    public TbPegawaiEntity() {

    }

    public TbPegawaiEntity(String nip, String kdPegawai, String namaPegawai, String seksi, String jabatan, String alamat) {
        this.nip = nip;
        this.kdPegawai = kdPegawai;
        this.namaPegawai = namaPegawai;
        this.seksi = seksi;
        this.jabatan = jabatan;
        this.alamat = alamat;
    }

    @Id
    @Column(name = "nip", nullable = false, length = 18)
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Basic
    @Column(name = "kd_pegawai", nullable = false, length = 5)
    public String getKdPegawai() {
        return kdPegawai;
    }

    public void setKdPegawai(String kdPegawai) {
        this.kdPegawai = kdPegawai;
    }

    @Basic
    @Column(name = "nama_pegawai", nullable = false, length = 45)
    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    @Basic
    @Column(name = "seksi", nullable = false, length = 30)
    public String getSeksi() {
        return seksi;
    }

    public void setSeksi(String seksi) {
        this.seksi = seksi;
    }

    @Basic
    @Column(name = "jabatan", nullable = false, length = 30)
    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Basic
    @Column(name = "alamat", nullable = true, length = 50)
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbPegawaiEntity that = (TbPegawaiEntity) o;
        return Objects.equals(nip, that.nip) &&
                Objects.equals(kdPegawai, that.kdPegawai) &&
                Objects.equals(namaPegawai, that.namaPegawai) &&
                Objects.equals(seksi, that.seksi) &&
                Objects.equals(jabatan, that.jabatan) &&
                Objects.equals(alamat, that.alamat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nip, kdPegawai, namaPegawai, seksi, jabatan, alamat);
    }
}
