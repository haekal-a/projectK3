package com.example.demo.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_peminjaman", schema = "db_bmn")
public class TbPeminjamanEntity {
    private int idPeminjaman;
    private String namaPeminjam;
    private Object keperluan;
    private Date tanggalPinjam;
    private Date tanggalKembali;
    private Date tanggalPersetujuan;
    private Date jatuhTempoPengembalian;
    private String createdBy;
    private String approvedBy;
    private Date createdDate;
    private TbMasterbmnEntity tbMasterbmnByIdMasterbmn;
    private TbPegawaiEntity tbPegawaiByNip;

    public TbPeminjamanEntity() {
    }

    public TbPeminjamanEntity(int idPeminjaman, String namaPeminjam, Object keperluan, Date tanggalPinjam, Date tanggalKembali, Date tanggalPersetujuan, Date jatuhTempoPengembalian, String createdBy, String approvedBy, Date createdDate, TbMasterbmnEntity tbMasterbmnByIdMasterbmn, TbPegawaiEntity tbPegawaiByNip) {
        this.idPeminjaman = idPeminjaman;
        this.namaPeminjam = namaPeminjam;
        this.keperluan = keperluan;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.tanggalPersetujuan = tanggalPersetujuan;
        this.jatuhTempoPengembalian = jatuhTempoPengembalian;
        this.createdBy = createdBy;
        this.approvedBy = approvedBy;
        this.createdDate = createdDate;
        this.tbMasterbmnByIdMasterbmn = tbMasterbmnByIdMasterbmn;
        this.tbPegawaiByNip = tbPegawaiByNip;
    }

    @Id
    @Column(name = "id_peminjaman", nullable = false)
    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
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
    @Column(name = "keperluan", nullable = true, length = -1)
    public Object getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(Object keperluan) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbPeminjamanEntity that = (TbPeminjamanEntity) o;
        return idPeminjaman == that.idPeminjaman &&
                Objects.equals(namaPeminjam, that.namaPeminjam) &&
                Objects.equals(keperluan, that.keperluan) &&
                Objects.equals(tanggalPinjam, that.tanggalPinjam) &&
                Objects.equals(tanggalKembali, that.tanggalKembali) &&
                Objects.equals(tanggalPersetujuan, that.tanggalPersetujuan) &&
                Objects.equals(jatuhTempoPengembalian, that.jatuhTempoPengembalian) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(approvedBy, that.approvedBy) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeminjaman, namaPeminjam, keperluan, tanggalPinjam, tanggalKembali, tanggalPersetujuan, jatuhTempoPengembalian, createdBy, approvedBy, createdDate);
    }

    @ManyToOne
    @JoinColumn(name = "id_masterbmn", referencedColumnName = "id_masterbmn", nullable = false)
    public TbMasterbmnEntity getTbMasterbmnByIdMasterbmn() {
        return tbMasterbmnByIdMasterbmn;
    }

    public void setTbMasterbmnByIdMasterbmn(TbMasterbmnEntity tbMasterbmnByIdMasterbmn) {
        this.tbMasterbmnByIdMasterbmn = tbMasterbmnByIdMasterbmn;
    }

    @ManyToOne
    @JoinColumn(name = "nip", referencedColumnName = "nip", nullable = false)
    public TbPegawaiEntity getTbPegawaiByNip() {
        return tbPegawaiByNip;
    }

    public void setTbPegawaiByNip(TbPegawaiEntity tbPegawaiByNip) {
        this.tbPegawaiByNip = tbPegawaiByNip;
    }
}
