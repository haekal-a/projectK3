package com.example.demo.service;

import com.example.demo.domain.dbpenaridesa.PeminjamanEntity;
import com.example.demo.domain.dbpenaridesa.StatusBarangEntity;
import com.example.demo.helper.ServiceHelper;
import com.example.demo.model.PeminjamanOutputModel;
import com.example.demo.model.PersetujuanInputModel;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepo;
import com.example.demo.repo.dbpenaridesa.IPeminjamanRepoCustom;
import com.example.demo.repo.dbpenaridesa.IStatusBarangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PersetujuanService {

    private ServiceHelper serviceHelper;
    private IPeminjamanRepoCustom peminjamanRepoCustom;
    private IPeminjamanRepo peminjamanRepo;
    private IStatusBarangRepo statusBarangRepo;

    @Autowired
    PersetujuanService(ServiceHelper serviceHelper, IPeminjamanRepoCustom peminjamanRepoCustom, IPeminjamanRepo peminjamanRepo, IStatusBarangRepo statusBarangRepo) {
        this.serviceHelper = serviceHelper;
        this.peminjamanRepoCustom = peminjamanRepoCustom;
        this.peminjamanRepo = peminjamanRepo;
        this.statusBarangRepo = statusBarangRepo;
    }

    public List<PeminjamanOutputModel> getListPinjamBarangStatusPeminjaman(String statusPeminjaman) {
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByStatusPeminjaman(statusPeminjaman);
        List<PeminjamanOutputModel> output = new ArrayList<>();
        for (Object[] data : list) {
            output.add(serviceHelper.getPeminjamanOutputModel(data));
        }
        return output;
    }

    public void saveSetuju(PersetujuanInputModel pim) throws Exception {
        PeminjamanEntity pinjam = peminjamanRepo.getOne(pim.getIdPeminjaman());
        StatusBarangEntity status = statusBarangRepo.getStatusBarangByIdBarang(pinjam.getIdBarang());

        // cek barang tersedia atau tidak
        if (status.getStsBarang().equals("0")) throw new Exception("Barang sudah dipinjam orang lain");

        // jika setuju
        status.setStsBarang("0");
        statusBarangRepo.save(status);

        pinjam.setApprovedBy(pim.getApprovedBy());
        pinjam.setTanggalPersetujuan(new Date());
        pinjam.setStatusPeminjaman("1");
        peminjamanRepo.save(pinjam);
    }

    public void saveTolak(BigDecimal idPeminjaman, String alasanPenolakan) {
        PeminjamanEntity pinjam = peminjamanRepo.getOne(idPeminjaman);
        pinjam.setStatusPeminjaman("2");
        pinjam.setAlasanPenolakan(alasanPenolakan);
        peminjamanRepo.save(pinjam);
    }
}
