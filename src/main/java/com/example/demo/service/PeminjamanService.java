package com.example.demo.service;

import com.example.demo.domain.dbpenaridesa.PeminjamanEntity;
import com.example.demo.model.PeminjamanInputModel;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepo;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PeminjamanService {

    private IPeminjamanRepo peminjamanRepo;
    private IPeminjamanRepoCustom peminjamanRepoCustom;

    @Autowired
    public PeminjamanService(IPeminjamanRepo peminjamanRepo, IPeminjamanRepoCustom peminjamanRepoCustom) {
        this.peminjamanRepo = peminjamanRepo;
        this.peminjamanRepoCustom = peminjamanRepoCustom;
    }

    public void savePeminjaman(PeminjamanInputModel pim) {
        PeminjamanEntity pinjam = new PeminjamanEntity();
        pinjam.setIdBarang(pim.getIdBarang());
        pinjam.setNip(pim.getNip());
        pinjam.setNamaPeminjam(pim.getNamaPeminjam());
        pinjam.setKeperluan(pim.getKeperluan());
        pinjam.setTanggalPinjam(pim.getTanggalpinjam());
        pinjam.setJatuhTempoPengembalian(pim.getTanggaljatuhtempo());
        pinjam.setCreatedBy(pim.getNip());
        pinjam.setCreatedDate(new Date());
        pinjam.setStatusPeminjaman("0");
        peminjamanRepo.save(pinjam);
    }

    public PeminjamanOutputModel getPeminjamanById(BigDecimal id) {
        PeminjamanOutputModel output = new PeminjamanOutputModel();
        PeminjamanEntity data = peminjamanRepo.getOne(id);
        if (data != null){
            output.setIdPeminjaman(data.getIdPeminjaman());
            output.setIdBarang(data.getIdBarang());
            output.setNip(data.getNip());
            output.setNamaPeminjam(data.getNamaPeminjam());
            output.setKeperluan(data.getKeperluan());
            output.setTanggalPinjam(data.getTanggalPinjam());
            output.setTanggalKembali(data.getTanggalKembali());
            output.setTanggalPersetujuan(data.getTanggalPersetujuan());
            output.setJatuhTempoPengembalian(data.getJatuhTempoPengembalian());
            output.setCreatedBy(data.getCreatedBy());
            output.setApprovedBy(data.getApprovedBy());
            output.setCreatedDate(data.getCreatedDate());
            output.setStatusPeminjaman(data.getStatusPeminjaman());
            output.setAlasanPenolakan(data.getAlasanPenolakan());
        }
        return output;
    }

    public void editPeminjaman(PeminjamanInputModel pim) {
        PeminjamanEntity pinjam = peminjamanRepo.getOne(pim.getIdPeminjaman());
        pinjam.setIdPeminjaman(pim.getIdPeminjaman());
        pinjam.setIdBarang(pim.getIdBarang());
        pinjam.setNip(pim.getNip());
        pinjam.setNamaPeminjam(pim.getNamaPeminjam());
        pinjam.setKeperluan(pim.getKeperluan());
        pinjam.setTanggalPinjam(pim.getTanggalpinjam());
        pinjam.setJatuhTempoPengembalian(pim.getTanggaljatuhtempo());
        pinjam.setCreatedBy(pim.getNip());
        peminjamanRepo.save(pinjam);
    }

    public List<PeminjamanOutputModel> getListPinjamBarangByNipAndStatusPeminjaman(String nip, String statusPeminjaman) {
        List<PeminjamanOutputModel> output = new ArrayList<>();
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByNipAndStatusPeminjaman(nip, statusPeminjaman);
        for (Object[] data : list) {
            PeminjamanOutputModel pom = new PeminjamanOutputModel();
            pom.setIdPeminjaman(new BigDecimal((Integer) data[0]));
            pom.setIdBarang(new BigDecimal((Integer) data[1]));
            pom.setNip((String) data[2]);
            pom.setNamaPeminjam((String) data[3]);
            pom.setKeperluan((String) data[4]);
            pom.setTanggalPinjam((Date) data[5]);
            pom.setTanggalKembali((Date) data[6]);
            pom.setTanggalPersetujuan((Date) data[7]);
            pom.setJatuhTempoPengembalian((Date) data[8]);
            pom.setCreatedBy((String) data[9]);
            pom.setApprovedBy((String) data[10]);
            pom.setCreatedDate((Date) data[11]);
            pom.setStatusPeminjaman(String.valueOf(data[12]));
            pom.setAlasanPenolakan((String) data[13]);
            pom.setJenisBarang((String) data[14]);
            pom.setNamaBarang((String) data[15]);
            pom.setMerkBarang((String) data[16]);
            pom.setKeterangan((String) data[17]);
            pom.setKondisi(String.valueOf(data[18]));
            output.add(pom);
        }
        return output;
    }

    public void deletePeminjaman(BigDecimal id) {
        PeminjamanEntity pinjam = peminjamanRepo.getOne(id);
        peminjamanRepo.delete(pinjam);
    }
}
