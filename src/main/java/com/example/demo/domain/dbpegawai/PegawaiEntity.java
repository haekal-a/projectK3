package com.example.demo.domain.dbpegawai;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pegawai")
public class PegawaiEntity {
    private String nip;
    private String namaPegawai;
    private String subBagian;
    private String jabatan;
    private String alamat;
    private String noTelepon;
    private String alamatEmail;
    private String seksi;

    public PegawaiEntity() {
    }

    public PegawaiEntity(String nip, String namaPegawai, String subBagian, String jabatan, String alamat, String noTelepon, String alamatEmail, String seksi) {
        this.nip = nip;
        this.namaPegawai = namaPegawai;
        this.subBagian = subBagian;
        this.jabatan = jabatan;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.alamatEmail = alamatEmail;
        this.seksi = seksi;
    }

    @Id
    @Column(name = "NIP", nullable = false, length = 18)
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Column(name = "Nama_Pegawai", nullable = false, length = 45)
    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    @Column(name = "SubBagian", nullable = false, length = 30)
    public String getSubBagian() {
        return subBagian;
    }

    public void setSubBagian(String subBagian) {
        this.subBagian = subBagian;
    }

    @Column(name = "Jabatan", nullable = false, length = 30)
    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Column(name = "Alamat", nullable = false, length = 50)
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Column(name = "No_Telepon", nullable = false, length = 15)
    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    @Column(name = "Alamat_Email", nullable = false, length = 50)
    public String getAlamatEmail() {
        return alamatEmail;
    }

    public void setAlamatEmail(String alamatEmail) {
        this.alamatEmail = alamatEmail;
    }

    @Column(name = "Seksi", nullable = false, length = 30)
    public String getSeksi() {
        return seksi;
    }

    public void setSeksi(String seksi) {
        this.seksi = seksi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PegawaiEntity that = (PegawaiEntity) o;
        return Objects.equals(nip, that.nip) &&
                Objects.equals(namaPegawai, that.namaPegawai) &&
                Objects.equals(subBagian, that.subBagian) &&
                Objects.equals(jabatan, that.jabatan) &&
                Objects.equals(alamat, that.alamat) &&
                Objects.equals(noTelepon, that.noTelepon) &&
                Objects.equals(alamatEmail, that.alamatEmail) &&
                Objects.equals(seksi, that.seksi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nip, namaPegawai, subBagian, jabatan, alamat, noTelepon, alamatEmail, seksi);
    }
}
