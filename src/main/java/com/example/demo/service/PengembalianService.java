package com.example.demo.service;

import com.example.demo.domain.dbpenaridesa.PeminjamanEntity;
import com.example.demo.domain.dbpenaridesa.StatusBarangEntity;
import com.example.demo.helper.ServiceHelper;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.model.PengembalianInputModel;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepo;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepoCustom;
import com.example.demo.repo.dbpenaridesa.IStatusBarangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PengembalianService {

    private IPeminjamanRepo peminjamanRepo;
    private IPeminjamanRepoCustom peminjamanRepoCustom;
    private ServiceHelper serviceHelper;
    private IStatusBarangRepo statusBarangRepo;

    @Autowired
    public PengembalianService(IPeminjamanRepo peminjamanRepo, IPeminjamanRepoCustom peminjamanRepoCustom, ServiceHelper serviceHelper, IStatusBarangRepo statusBarangRepo) {
        this.peminjamanRepo = peminjamanRepo;
        this.peminjamanRepoCustom = peminjamanRepoCustom;
        this.serviceHelper = serviceHelper;
        this.statusBarangRepo = statusBarangRepo;
    }

    public List<PeminjamanOutputModel> getListPinjamBarangStatusPeminjaman(String statusPeminjaman) {
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByStatusPeminjaman(statusPeminjaman);
        return serviceHelper.getPeminjamanOutputModels(list);
    }

    public void savePengembalian(PengembalianInputModel pim) {
        PeminjamanEntity pinjam = peminjamanRepo.getOne(pim.getIdPeminjaman());
        StatusBarangEntity status = statusBarangRepo.getStatusBarangByIdBarang(pinjam.getIdBarang());

        pinjam.setTanggalKembali(pim.getTanggalKembali());
        pinjam.setStatusPeminjaman("3");
        peminjamanRepo.save(pinjam);

        status.setStsBarang("1");
        status.setKondisi(pim.getKondisi());
        statusBarangRepo.save(status);
    }
}
