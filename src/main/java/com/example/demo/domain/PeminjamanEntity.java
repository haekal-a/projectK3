package com.example.demo.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "peminjaman", schema = "db_penari_desa", catalog = "")
public class PeminjamanEntity {
    private int idPeminjaman;
    private int idBarang;
    private String nip;
    private String namaPeminjam;
    private String keperluan;
    private Date tanggalPinjam;
    private Date tanggalKembali;
    private Date tanggalPersetujuan;
    private Date jatuhTempoPengembalian;
    private String createdBy;
    private String approvedBy;
    private Date createdDate;
    private String statusPeminjaman;
    private String alasanPenolakan;

    @Id
    @Column(name = "id_peminjaman", nullable = false)
    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    @Basic
    @Column(name = "id_barang", nullable = false)
    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    @Basic
    @Column(name = "nip", nullable = false, length = 18)
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Basic
    @Column(name = "nama_peminjam", nullable = false, length = 45)
    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    @Basic
    @Column(name = "keperluan", nullable = true, length = 100)
    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

    @Basic
    @Column(name = "tanggal_pinjam", nullable = false)
    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    @Basic
    @Column(name = "tanggal_kembali", nullable = false)
    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    @Basic
    @Column(name = "tanggal_persetujuan", nullable = false)
    public Date getTanggalPersetujuan() {
        return tanggalPersetujuan;
    }

    public void setTanggalPersetujuan(Date tanggalPersetujuan) {
        this.tanggalPersetujuan = tanggalPersetujuan;
    }

    @Basic
    @Column(name = "jatuh_tempo_pengembalian", nullable = false)
    public Date getJatuhTempoPengembalian() {
        return jatuhTempoPengembalian;
    }

    public void setJatuhTempoPengembalian(Date jatuhTempoPengembalian) {
        this.jatuhTempoPengembalian = jatuhTempoPengembalian;
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
    @Column(name = "approved_by", nullable = false, length = 20)
    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Basic
    @Column(name = "created_date", nullable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "Status_Peminjaman", nullable = false, length = 1)
    public String getStatusPeminjaman() {
        return statusPeminjaman;
    }

    public void setStatusPeminjaman(String statusPeminjaman) {
        this.statusPeminjaman = statusPeminjaman;
    }

    @Basic
    @Column(name = "Alasan_Penolakan", nullable = false, length = 150)
    public String getAlasanPenolakan() {
        return alasanPenolakan;
    }

    public void setAlasanPenolakan(String alasanPenolakan) {
        this.alasanPenolakan = alasanPenolakan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeminjamanEntity that = (PeminjamanEntity) o;
        return idPeminjaman == that.idPeminjaman &&
                idBarang == that.idBarang &&
                Objects.equals(nip, that.nip) &&
                Objects.equals(namaPeminjam, that.namaPeminjam) &&
                Objects.equals(keperluan, that.keperluan) &&
                Objects.equals(tanggalPinjam, that.tanggalPinjam) &&
                Objects.equals(tanggalKembali, that.tanggalKembali) &&
                Objects.equals(tanggalPersetujuan, that.tanggalPersetujuan) &&
                Objects.equals(jatuhTempoPengembalian, that.jatuhTempoPengembalian) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(approvedBy, that.approvedBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(statusPeminjaman, that.statusPeminjaman) &&
                Objects.equals(alasanPenolakan, that.alasanPenolakan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeminjaman, idBarang, nip, namaPeminjam, keperluan, tanggalPinjam, tanggalKembali, tanggalPersetujuan, jatuhTempoPengembalian, createdBy, approvedBy, createdDate, statusPeminjaman, alasanPenolakan);
    }
}
