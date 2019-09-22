package com.example.demo.service;

import com.example.demo.domain.dbpenaridesa.PeminjamanEntity;
import com.example.demo.helper.ServiceHelper;
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
    private ServiceHelper serviceHelper;

    @Autowired
    public PeminjamanService(IPeminjamanRepo peminjamanRepo, IPeminjamanRepoCustom peminjamanRepoCustom, ServiceHelper serviceHelper) {
        this.peminjamanRepo = peminjamanRepo;
        this.peminjamanRepoCustom = peminjamanRepoCustom;
        this.serviceHelper = serviceHelper;
    }

    public void savePeminjaman(PeminjamanInputModel pim) {
        PeminjamanEntity pinjam = new PeminjamanEntity();
        pinjam.setCreatedDate(new Date());
        pinjam.setStatusPeminjaman("0");
        peminjaman(pim, pinjam);
    }

    public PeminjamanOutputModel getPeminjamanById(BigDecimal id) {
        PeminjamanOutputModel output = new PeminjamanOutputModel();
        PeminjamanEntity data = peminjamanRepo.getOne(id);
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
        return output;
    }

    public void editPeminjaman(PeminjamanInputModel pim) {
        PeminjamanEntity pinjam = peminjamanRepo.getOne(pim.getIdPeminjaman());
        peminjaman(pim, pinjam);
    }

    public List<PeminjamanOutputModel> getListPinjamBarangByNipAndStatusPeminjaman(String nip, String statusPeminjaman) {
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByNipAndStatusPeminjaman(nip, statusPeminjaman);
        return serviceHelper.getPeminjamanOutputModels(list);
    }

    public void deletePeminjaman(BigDecimal id) {
        PeminjamanEntity pinjam = peminjamanRepo.getOne(id);
        peminjamanRepo.delete(pinjam);
    }

    private void peminjaman(PeminjamanInputModel pim, PeminjamanEntity pinjam) {
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
