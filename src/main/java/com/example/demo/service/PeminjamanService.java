package com.example.demo.service;

import com.example.demo.domain.dbpenaridesa.PeminjamanEntity;
import com.example.demo.model.PeminjamanInputModel;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class PeminjamanService {

    private IPeminjamanRepo peminjamanRepo;

    @Autowired
    public PeminjamanService (IPeminjamanRepo peminjamanRepo){
        this.peminjamanRepo = peminjamanRepo;
    }

    public void savePeminjaman (PeminjamanInputModel pim){
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

    public PeminjamanOutputModel getPeminjaman(BigDecimal id) {
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
}
