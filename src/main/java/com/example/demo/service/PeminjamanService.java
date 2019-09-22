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
        Object[] data = peminjamanRepoCustom.getPinjamBarangByIdPeminjaman(id);
        return serviceHelper.getPeminjamanOutputModel(data);
    }

    public void editPeminjaman(PeminjamanInputModel pim) {
        PeminjamanEntity pinjam = peminjamanRepo.getOne(pim.getIdPeminjaman());
        peminjaman(pim, pinjam);
    }

    public List<PeminjamanOutputModel> getListPinjamBarangByNipAndStatusPeminjaman(String nip, String statusPeminjaman) {
        List<Object[]> list = peminjamanRepoCustom.getListPinjamBarangByNipAndStatusPeminjaman(nip, statusPeminjaman);
        List<PeminjamanOutputModel> output = new ArrayList<>();
        for (Object[] data : list) {
            output.add(serviceHelper.getPeminjamanOutputModel(data));
        }
        return output;
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
